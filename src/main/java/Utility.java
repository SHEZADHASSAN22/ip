import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utility {
    private DateTimeFormatter inputFormat;
    private DateTimeFormatter outputFormat;

    public Utility() {
        inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        outputFormat = DateTimeFormatter.ofPattern("dd MM yyyy | HHmm");

    }

    /**
     * Converts a date from String class to LocalDateTime class
     * @param str The String representation of a date
     * @return LocalDateTime representation of the date.
     */
    public LocalDateTime stringToDate(String str) {
        return (LocalDateTime.parse(str, inputFormat));
    }


    public String dateToString(LocalDateTime dateTime) {
        return dateTime.format(outputFormat);
    }

    /**
     * Seperates the date and task from the users input.
     * @param taskIndex Beginning index of the task in the given String.
     * @param dateIndex Beginning index of the date in the given String.
     * @param userInput String of task containing task and date.
     * @return Array with task at index 0 and date at index 1.
     */
    public String[] sepDateFromTask(int dateIndex, int taskIndex, String userInput) {
        String task;
        String date;
        if(dateIndex > 0) {
            task = userInput.substring(taskIndex, dateIndex - 1);
            date = userInput.substring(dateIndex + 4);
        }else {
            task = userInput.substring(taskIndex);
            date = "?";
        }
        return new String[] {task, date};
    }
}