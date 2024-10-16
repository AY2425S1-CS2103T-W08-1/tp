package seedu.address.model.tut;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;

import seedu.address.model.tut.exceptions.DuplicateTutorialException;
import seedu.address.model.tut.exceptions.TutNoFoundException;

/**
 * Represents a tutorial list with a title, due date, and completion statuses for students.
 */
public class TutorialList {

    private final ArrayList<Tutorial> tutorials;

    /**
     * Constructs an empty TutorialList.
     */
    public TutorialList() {
        this.tutorials = new ArrayList<>();
    }

    /**
     * Constructs a tutorial list with specified tutorials.
     *
     * @param tutorials The tutorials in the list.
     */
    public TutorialList(ArrayList<Tutorial> tutorials) {
        requireNonNull(tutorials);
        this.tutorials = tutorials;
    }

    /**
     * Adds a tutorial to the list.
     *
     * @param tutorial The tutorial to be added.
     */
    public void addTutorial(Tutorial tutorial) {
        if (hasTutorial(tutorial)) {
            throw new DuplicateTutorialException();
        }

        tutorials.add(tutorial);
    }

    /**
     * Check if the list contains a specified tutorial.
     *
     * @param tutorial The tutorial to check for.
     * @return True if the list contains the tutorial, false otherwise.
     */
    public boolean hasTutorial(Tutorial tutorial) {
        return this.tutorials.contains(tutorial);
    }

    public ArrayList<Tutorial> getTutorials() {
        return this.tutorials;
    }

    /**
     * Deletes the specified tutorial from the tutorial list.
     * The tutorial must exist in the list.
     *
     * @param tutorial The tutorial to be deleted.
     * @throws TutNoFoundException if the tutorial does not exist in the list.
     */
    public void deleteTutorial(Tutorial tutorial) {
        if (!hasTutorial(tutorial)) {
            throw new TutNoFoundException();
        }
        this.tutorials.remove(tutorial);
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TutorialList)) {
            return false;
        }
        TutorialList otherList = (TutorialList) other;
        return this.tutorials.equals(otherList.tutorials);
    }
}
