package seedu.address.logic.commands;

import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_STUDENTS;

/**
 * Lists all students in the address book to the user.
 */
public class ListAssignmentCommand extends Command {

    public static final String COMMAND_WORD = "listAsg";

    public static final String MESSAGE_SUCCESS = "All current assignments: ";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        String assignmentList = model.listAssignments();
        return new CommandResult(MESSAGE_SUCCESS + "\n" + assignmentList);
    }
}
