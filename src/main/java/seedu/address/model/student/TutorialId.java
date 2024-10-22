package seedu.address.model.student;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents an abstract TutorialClass.
 * A TutorialClass can either be an existing class with a specific class code or a "None" type.
 */
public abstract class TutorialId {

    public static final String MESSAGE_CONSTRAINTS =
                "Tutorial class should be numeric and typically represents a class code.";
    public static final String VALIDATION_REGEX = "0|[1-9]\\d+"; // Numeric, can be extended to specific format

    /**
     * Checks if the provided string is a valid tutorial class.
     *
     * @param test The string to be checked.
     * @return True if the string is valid; otherwise false.
     */
    public static boolean isValidTutorialClass(String test) {
        return test.matches(VALIDATION_REGEX); // Simple numeric validation
    }

    private static TutorialId exist(String value) {
        return new TutorialId.Exist(value);
    }

    /**
     * Returns an instance representing no tutorial class.
     *
     * @return A None type of TutorialClass.
     */
    public static TutorialId none() {
        return None.none();
    }

    /**
     * Creates an instance of an existing tutorial class.
     *
     * @param value The string value representing the class code.
     * @return A new TutorialClass object.
     */
    public static TutorialId of(String value) {
        requireNonNull(value);
        if (value.equals("-1")) {
            return TutorialId.none();
        }
        return TutorialId.exist(value);
    }

    private static final class None extends TutorialId {
        private static final None none = new None();
        private final String value = "-1";
        public static None none() {
            return none;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    private static final class Exist extends TutorialId {
        private final String value;

        @JsonCreator
        public Exist(@JsonProperty("tutorialClass") String tutorialClass) {
            requireNonNull(tutorialClass);
            checkArgument(isValidTutorialClass(tutorialClass));
            this.value = tutorialClass;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            if (other instanceof Exist) {
                Exist exist = (Exist) other;

                if (this.value == exist.value) {
                    return true;
                }

                if (this.value == null || exist.value == null) {
                    return false;
                }
                return value.equals(exist.value);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }
}
