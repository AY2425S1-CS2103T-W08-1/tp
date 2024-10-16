package seedu.address.model.tut;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TutUtil.TUTORIAL_CLASS;
import static seedu.address.testutil.TutUtil.TUTORIAL_SAMPLE;
import static seedu.address.testutil.TutUtil.TUT_DATE;
import static seedu.address.testutil.TutUtil.TUT_NAME;
import static seedu.address.testutil.TypicalStudents.ALICE;

import java.util.Date;

import org.junit.jupiter.api.Test;

import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;
import seedu.address.model.student.TutorialClass;
import seedu.address.testutil.StudentBuilder;

public class TutorialTest {

    @Test
    public void constructor_nullName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tutorial(null, TUTORIAL_CLASS));
        assertThrows(NullPointerException.class, () -> new Tutorial(new TutName(TUT_NAME), (TutorialClass) null));

    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Tutorial(new TutName(""), TUTORIAL_CLASS));
    }
    @Test
    public void constructor_nullTutorialClass_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tutorial(new TutName(TUT_NAME), (TutorialClass) null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTutName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tutorial(new TutName(""), TUTORIAL_CLASS));
    }

    @Test
    public void successAddStudentToTutorial() {
        Student aliceCopy = new StudentBuilder(ALICE).build();
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        tutorial.add(aliceCopy);
        assertEquals(aliceCopy, tutorial.get(ALICE.getName()));
    }

    @Test
    public void checkEquals_sameInstance() {
        Tutorial sameTutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        assertEquals(sameTutorial, sameTutorial);
    }

    @Test
    public void checkEquals_differentInstance() {
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        Tutorial otherTutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        assertEquals(tutorial, otherTutorial);
    }

    @Test
    public void checkEquals_differentObjects() {
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        Object notATut = new Object();
        assertNotEquals(tutorial, notATut);
    }

    @Test
    public void checkToString() {
        assertEquals(TUTORIAL_SAMPLE.toString(), TUT_NAME + ": Tutorial " + TUTORIAL_CLASS);
    }

    @Test
    public void addStudent_duplicateStudent_noAdd() {
        // Adding the same student twice should not add a duplicate
        Student aliceCopy = new StudentBuilder(ALICE).build();
        TUTORIAL_SAMPLE.add(aliceCopy);
        int initialSize = TUTORIAL_SAMPLE.getStudents().size();

        // Try adding again
        TUTORIAL_SAMPLE.add(aliceCopy);
        assertEquals(TUTORIAL_SAMPLE.getStudents().size(), initialSize);
    }

    @Test
    public void markAttendance_newTutorialDate_success() {
        Student alice = new StudentBuilder(ALICE).build();
        TUTORIAL_SAMPLE.add(alice);

        TUTORIAL_SAMPLE.markAttendance(alice, TUT_DATE);
        assertTrue(TUTORIAL_SAMPLE.tutorialDateInList(TUT_DATE));
        assertTrue(TUT_DATE.getStudentIDs().contains(alice.getStudentId()));
    }

    @Test
    public void markAttendance_existingTutorialDate_success() {
        Student alice = new StudentBuilder(ALICE).build();
        TUTORIAL_SAMPLE.add(alice);
        TUTORIAL_SAMPLE.addTutorialDate(TUT_DATE);

        TUTORIAL_SAMPLE.markAttendance(alice, TUT_DATE);
        assertTrue(TUTORIAL_SAMPLE.tutorialDateInList(TUT_DATE));
        assertTrue(TUT_DATE.getStudentIDs().contains(alice.getStudentId()));
    }

    @Test
    public void markAttendance_studentNotInTutorial_addsStudent() {
        Student newStudent = new StudentBuilder().withName("Bob").build();

        TUTORIAL_SAMPLE.markAttendance(newStudent, TUT_DATE);
        assertTrue(TUTORIAL_SAMPLE.getStudents().contains(newStudent));
        assertTrue(TUT_DATE.getStudentIDs().contains(newStudent.getStudentId()));
    }

    @Test
    public void addTutorialDate_duplicateDate_noAdd() {
        TUTORIAL_SAMPLE.addTutorialDate(TUT_DATE);
        int initialSize = TUTORIAL_SAMPLE.getTutDates().size();

        TUTORIAL_SAMPLE.addTutorialDate(TUT_DATE);
        assertEquals(TUTORIAL_SAMPLE.getTutDates().size(), initialSize);
    }

    @Test
    public void tutorialDateInList_returnsCorrectly() {
        TUTORIAL_SAMPLE.addTutorialDate(TUT_DATE);
        assertTrue(TUTORIAL_SAMPLE.tutorialDateInList(TUT_DATE));
    }

    @Test
    public void getTutorialDate_returnsCorrectDate() {
        TUTORIAL_SAMPLE.addTutorialDate(TUT_DATE);
        assertEquals(TUTORIAL_SAMPLE.getTutorialDate(TUT_DATE.getDate()), TUT_DATE);
    }

    @Test
    public void getTutorialDates() {
        TUTORIAL_SAMPLE.addTutorialDate(TUT_DATE);
        assertTrue(TUTORIAL_SAMPLE.getTutDates().contains(TUT_DATE));
    }

    @Test
    public void getTutorialClass() {
        assertTrue(TUTORIAL_SAMPLE.getTutorialClass().equals(TUTORIAL_CLASS));
    }

    @Test
    public void setAttendance_success() {
        Student aliceCopy = new StudentBuilder(ALICE).build();
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        tutorial.add(aliceCopy);
        Date date = new Date();
        StudentId aliceId = aliceCopy.getStudentId();
        boolean result = tutorial.setAttendance(date, aliceId);
        assertTrue(result);
    }

    @Test
    public void setAttendance_studentNotInTut_false() {
        Student aliceCopy = new StudentBuilder(ALICE).build();
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        Date date = new Date();
        StudentId aliceId = aliceCopy.getStudentId();
        boolean result = tutorial.setAttendance(date, aliceId);
        assertFalse(result);
    }

    @Test
    public void setAttendance_nullDate_throwsNullPointerException() {
        Student aliceCopy = new StudentBuilder(ALICE).build();
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        tutorial.add(aliceCopy);
        StudentId aliceId = aliceCopy.getStudentId();
        assertThrows(NullPointerException.class, () -> tutorial.setAttendance(null, aliceId));
    }

    @Test
    public void setAttendance_nullStudentId_throwsNullPointerException() {
        Tutorial tutorial = new Tutorial(new TutName(TUT_NAME), TUTORIAL_CLASS);
        Date date = new Date();
        assertThrows(NullPointerException.class, () -> tutorial.setAttendance(date, null));
    }
}
