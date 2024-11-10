package seedu.address.ui;

import javafx.beans.property.ObjectProperty;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import seedu.address.model.student.Student;
import seedu.address.model.tut.TutDate;

/**
 * A UI component that displays detailed information about a {@code Student}.
 */
public class StudentProfile extends UiPart<Region> {

    private static final String FXML = "StudentProfile.fxml";

    private static Student student;

    @FXML
    private Label nameLabel;
    @FXML
    private Label studentIdLabel;
    @FXML
    private Label tutorialIdLabel;
    @FXML
    private FlowPane attendanceFlowPane;
    /**
     * Listener for attendance dates that updates the attendance display when dates change.
     */
    private final SetChangeListener<TutDate> attendanceDateListener = change -> {
        updateAttendanceFlowPane();
    };
    /**
     * Creates a {@code StudentProfile} to display the details of a student.
     */
    public StudentProfile() {
        super(FXML);
    }

    /**
     * Updates the profile with the details of the given {@code Student}.
     * @param student The student whose details should be displayed.
     */
    public void setStudent(Student student) {
        if (this.student != null) {
            // Remove the listener from the previous student's attendance dates
            this.student.getPresentDates().getDates().removeListener(attendanceDateListener);
        }
        if (student == null) {
            clearProfile();
            return;
        }
        this.student = student;

        nameLabel.setText(student.getName().fullName);
        studentIdLabel.setText(student.getStudentId().value);
        tutorialIdLabel.setText(student.getTutorialId().toString());

        attendanceFlowPane.getChildren().clear();
        student.getPresentDates().getDates().forEach(date -> {
            Label dateLabel = new Label(date.toString());
            dateLabel.getStyleClass().add("attendance-date-label");
            attendanceFlowPane.getChildren().add(dateLabel);
        });

        student.getPresentDates().getDates().addListener(attendanceDateListener);
    }

    /**
     * Clears the profile details.
     */
    private void clearProfile() {
        nameLabel.setText("");
        studentIdLabel.setText("");
        tutorialIdLabel.setText("");
        attendanceFlowPane.getChildren().clear();
    }

    /**
     * Checks if the current student selected equals the specified student.
     * @param otherStudent The other student to be compared.
     * @return A boolean value representing whether the current student selected equals the specified student.
     */
    public static boolean isSameStudent(Student otherStudent) {
        if (otherStudent == null) {
            return false;
        }
        return otherStudent.equals(student);
    }
    /**
     * Binds this profile to the selected student property in MainWindow.
     * When the selected student changes, this profile will update to show the new student's details.
     *
     * @param selectedStudentProperty the property in MainWindow that holds the selected student.
     */
    public void bindToSelectedStudent(ObjectProperty<Student> selectedStudentProperty) {
        selectedStudentProperty.addListener((observable, oldStudent, newStudent) -> {
            setStudent(newStudent);
        });
    }
    private void updateAttendanceFlowPane() {
        attendanceFlowPane.getChildren().clear();
        student.getPresentDates().getDates().forEach(date -> {
            Label dateLabel = new Label(date.toString());
            dateLabel.getStyleClass().add("attendance-date-label");
            attendanceFlowPane.getChildren().add(dateLabel);
        });
    }
}
