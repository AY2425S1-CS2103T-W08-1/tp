package seedu.address.model.tut;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;
import seedu.address.model.student.TutorialClass;


/**
 * Represents a Tutorial in the address book.
 * Guarantees: details are present and not null
 */
public class Tut {

    // Constraints messages for name and ID
    public static final String MESSAGE_NAME_CONSTRAINTS = "Tutorial names should only contain alphanumeric"
            + " characters and spaces, "
            + "and it should not be blank.";
    public static final String MESSAGE_ID_CONSTRAINTS = TutorialClass.MESSAGE_CONSTRAINTS;

    // Example validation regex for tutorial name (customize as needed)
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";
    private final List<Student> students = new ArrayList<>();

    // TODO: Insert TutDate
    private final HashMap<Date, TutDate> tutDates = new HashMap<>();
    private final String tutName;
    private final TutorialClass tutorialClass;
    /**
     * Constructs a {@code Tut}.
     *
     * @param tutName A valid tutorial name.
     */
    public Tut(String tutName, TutorialClass tutorialClass) {
        requireNonNull(tutorialClass);
        requireNonNull(tutName);
        checkArgument(isValidName(tutName), MESSAGE_NAME_CONSTRAINTS);
        this.tutName = tutName;
        this.tutorialClass = tutorialClass;
    }
    /**
     * Constructs a {@code Tut}.
     *
     * @param tutName A valid tutorial name.
     */
    public Tut(String tutName, String tutClass) {
        requireNonNull(tutClass);
        requireNonNull(tutName);
        checkArgument(isValidName(tutName), MESSAGE_NAME_CONSTRAINTS);
        this.tutorialClass = new TutorialClass(tutClass);
        this.tutName = tutName;
    }

    /**
     * * Adds student to the tutorial
     **/
    public void add(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
        }
    }
    public List<Student> getStudents() {
        return this.students;
    }

    public boolean setAttendance(Date date, StudentId target) {
        requireNonNull(date);
        requireNonNull(target);
        if (tutDates.containsKey(date)) {
            return students.stream()
                    .filter(s -> s.getStudentId().equals(target))
                    .findFirst()
                    .map(student -> {
                        student.setAttendance(tutDates.get(date));
                        tutDates.get(date).add(target);
                        return true;
                    }).orElse(false);

        }
        TutDate tutDate = new TutDate(date);
        return students.stream()
                .filter(s -> s.getStudentId().equals(target))
                .findFirst()
                .map(student -> {
                    student.setAttendance(tutDate);
                    tutDate.add(target);
                    return true;
                })
                .orElse(false);
    }

    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getTutName() {
        return this.tutName;
    }
    Student get(Name name) {
        return students.stream()
                .filter(student -> student.getName().equals(name))
                .findFirst()
                .orElse(null); // Returns null if no student is found
    }

    public TutorialClass getTutorialClass() {
        return tutorialClass;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tut)) {
            return false;
        }

        Tut otherTutorial = (Tut) other;
        return tutorialClass.equals(otherTutorial.tutorialClass)
                && tutName.equals(otherTutorial.tutName)
                && students.equals(otherTutorial.students);
    }
    @Override
    public String toString() {
        return tutName + ": Tutorial " + tutorialClass;
    }
}
