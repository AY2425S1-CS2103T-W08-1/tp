package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TutUtil.TUTORIAL_CLASS;
import static seedu.address.testutil.TutUtil.TUTORIAL_SAMPLE;
import static seedu.address.testutil.TutUtil.TUT_DATE;
import static seedu.address.testutil.TutUtil.TUT_NAME;
import static seedu.address.testutil.TypicalStudents.ALICE;

import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tut.TutName;
import seedu.address.model.tut.Tutorial;

/**
 * Test class for JsonAdaptedTut.
 */
public class JsonAdaptedTutorialTest {

    private static final String INVALID_TUT_NAME = "";
    private static final String VALID_TUT_NAME = TUTORIAL_SAMPLE.getTutName().tutName;
    private static final String VALID_TUTORIAL_CLASS = TUTORIAL_SAMPLE.getTutorialClass().toString();

    private static final JsonAdaptedStudent VALID_STUDENT = new JsonAdaptedStudent(ALICE);
    private static final JsonAdaptedTutDate VALID_TUT_DATE = new JsonAdaptedTutDate(TUT_DATE);

    @Test
    public void toModelType_validTutDetails_returnsTut() throws Exception {
        // Using TUT_SAMPLE from TutUtil
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        JsonAdaptedTut tut = new JsonAdaptedTut(tutorial);
        System.out.println(tut.toModelType());
        System.out.println(tutorial);
        assertTrue(tutorial.equals(tut.toModelType()));
    }

    @Test
    public void toModelType_invalidTutName_throwsIllegalValueException() {
        // Creating a JsonAdaptedTut with invalid tutorial name
        JsonAdaptedTut tut = new JsonAdaptedTut(
                INVALID_TUT_NAME, TUTORIAL_SAMPLE.getTutorialClass().value,
                List.of(VALID_STUDENT),
                List.of(VALID_TUT_DATE)
        );
        String expectedMessage = Tutorial.MESSAGE_NAME_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, tut::toModelType);
    }

    @Test
    public void toModelType_nullTutName_throwsIllegalValueException() {
        // Creating a JsonAdaptedTut with null tutorial name
        JsonAdaptedTut tut = new JsonAdaptedTut(
                null, TUTORIAL_SAMPLE.getTutorialClass().value,
                List.of(VALID_STUDENT),
                List.of(VALID_TUT_DATE)
        );
        String expectedMessage = String.format(JsonAdaptedTut.MISSING_FIELD_MESSAGE_FORMAT, "tutName");
        assertThrows(IllegalValueException.class, expectedMessage, tut::toModelType);
    }

    @Test
    public void toModelType_invalidTutorialClass_throwsIllegalValueException() {
        // Creating a JsonAdaptedTut with invalid tutorial class
        JsonAdaptedTut tut = new JsonAdaptedTut(
                VALID_TUT_NAME, null,
                List.of(VALID_STUDENT),
                List.of(VALID_TUT_DATE)
        );
        String expectedMessage = String.format(JsonAdaptedTut.MISSING_FIELD_MESSAGE_FORMAT, "tutorialClass");
        assertThrows(IllegalValueException.class, expectedMessage, tut::toModelType);
    }
}
