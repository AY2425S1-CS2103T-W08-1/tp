package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.assignment.Assignment;
import seedu.address.model.assignment.AssignmentList;
import seedu.address.model.assignment.exceptions.AssignmentNotFoundException;
import seedu.address.model.student.Student;
import seedu.address.model.student.TutorialClass;
import seedu.address.model.tut.Tut;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Student> PREDICATE_SHOW_ALL_STUDENTS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a student with the same identity as {@code student} exists in the address book.
     */
    boolean hasStudent(Student student);

    /**
     * Deletes the given student.
     * The student must exist in the address book.
     */
    void deleteStudent(Student target);

    /**
     * Adds the given student.
     * {@code student} must not already exist in the address book.
     */
    void addStudent(Student student);

    /**
     * Replaces the given student {@code target} with {@code editedStudent}.
     * {@code target} must exist in the address book.
     * The student identity of {@code editedStudent} must not be the same as another
     * existing student in the address book.
     */
    void setStudent(Student target, Student editedStudent);

    /** Returns an unmodifiable view of the filtered student list */
    ObservableList<Student> getFilteredStudentList();

    /**
     * Updates the filter of the filtered student list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudentList(Predicate<Student> predicate);

    boolean hasTutorial(Tut tutorial);
    void addTutorial(Tut toAdd);


    /** Returns the AssignmentList */
    AssignmentList getAssignmentList();

    /**
     * Returns true if an assignment with the specified name exists.
     */
    boolean hasAssignment(Assignment assignment);

    /**
     * Adds the given assignment.
     * {@code assignment} must not already exist in the assignment list.
     */
    void addAssignment(Assignment assignment);


    /**
     * Deletes the specified assignment.
     * The assignment must exist in the assignment list.
     */
    void deleteAssignment(Assignment assignment);

    /**
     * check the completion statuses of the specified assignment.
     *
     * @param assignment Assignment to be checked.
     * @return String representing the completion statuses.
     */
    String checkAssignment(Assignment assignment) throws AssignmentNotFoundException;

    /**
     * Sets the status of assignment of the given student to a specified boolean value.
     *
     * @param assignment The assignment to be marked or unmarked.
     * @param targetStudent The target student that completes or not completes the assignment.
     * @param newStatus New boolean value of the status.
     * @throws AssignmentNotFoundException If the assignment is not found.
     */
    void setAssignmentStatus(Assignment assignment, Student targetStudent, boolean newStatus)
            throws AssignmentNotFoundException;

    /**
     * Lists all current assignments.
     *
     * @return String of all current assignments.
     */
    String listAssignments();

    /**
     * Delete the specified tutorial class.
     * The tutorial class must exist in the tutorial list.
     *
     * @param tutorialClass The tutorial class to be deleted.
     */
    void deleteTutorial(TutorialClass tutorialClass);

    /**
     * Returns true if a tutorial class exists in the tutorial list.
     */
    boolean hasTutorialClass(TutorialClass tutorialClass);
}
