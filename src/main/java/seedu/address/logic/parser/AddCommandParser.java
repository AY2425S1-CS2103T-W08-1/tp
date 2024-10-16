package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENTID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIALCLASS;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.Name;
import seedu.address.model.student.Student;
import seedu.address.model.student.StudentId;
import seedu.address.model.student.TutorialClass;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME,
                        PREFIX_STUDENTID, PREFIX_TUTORIALCLASS);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_STUDENTID, PREFIX_TUTORIALCLASS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME, PREFIX_STUDENTID, PREFIX_TUTORIALCLASS);
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        StudentId studentId = argMultimap.getValue(PREFIX_STUDENTID).isPresent()
                ? ParserUtil.parseStudentId(argMultimap.getValue(PREFIX_STUDENTID).get())
                : new StudentId("1001");
        TutorialClass tutorialClass = argMultimap.getValue(PREFIX_TUTORIALCLASS).isPresent()
                ? ParserUtil.parseTutorialClass(argMultimap.getValue(PREFIX_TUTORIALCLASS).get())
                : new TutorialClass("1001");
        System.out.println(tutorialClass);
        System.out.println(studentId);
        Student student = new Student(name, studentId, tutorialClass, null);
        return new AddCommand(student, tutorialClass);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
