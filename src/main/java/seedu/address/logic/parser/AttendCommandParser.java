package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ATTENDANCEDATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_STUDENTID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIALCLASS;

import java.util.Date;
import java.util.stream.Stream;

import seedu.address.logic.commands.AttendCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.StudentId;
import seedu.address.model.student.TutorialClass;

/**
 * Parses input arguments and creates a new AttendCommand object.
 */
public class AttendCommandParser implements Parser<AttendCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AttendCommand
     * and returns an AttendCommand object for execution.
     * @param args The input arguments string to parse.
     * @return AttendCommand object based on parsed arguments.
     * @throws ParseException if the user input does not conform to the expected format.
     */
    public AttendCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_STUDENTID, PREFIX_TUTORIALCLASS, PREFIX_ATTENDANCEDATE);

        if (!arePrefixesPresent(argMultimap, PREFIX_STUDENTID, PREFIX_TUTORIALCLASS)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AttendCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_STUDENTID, PREFIX_TUTORIALCLASS, PREFIX_ATTENDANCEDATE);
        StudentId studentId = ParserUtil.parseStudentId(argMultimap.getValue(PREFIX_STUDENTID).get());
        TutorialClass tutorialClass = ParserUtil.parseTutorialClass(argMultimap.getValue(PREFIX_TUTORIALCLASS).get());
        Date tutDate = argMultimap.getValue(PREFIX_ATTENDANCEDATE).isPresent()
                ? ParserUtil.parseDate(argMultimap.getValue(PREFIX_ATTENDANCEDATE).get()) : new Date();
        return new AttendCommand(studentId, tutorialClass, tutDate);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
