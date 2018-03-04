import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n\nHello, AssignmentsApp!\n");

        // Output the current date-time.
        LocalDateTime currentDate = currentDateTime();
        System.out.println("Current Date and Time: " + currentDate);

        // Output tomorrow's date using a formatter.
        String tomorrowDate = tomorrowDate();
        System.out.println("Tomorrow's Date: " + tomorrowDate);

        //Add 5 weeks to today's LocalDateTime.
        LocalDateTime weeksAdded = weeksAddedToCurrent(currentDate);
        System.out.println("Five Weeks From " + currentDate + ":\t" + weeksAdded);

        // Initialize a LocalDateTime object to your birth date and the time 12:35 PM.
        LocalDateTime bDate = birthDateTime(currentDate);
        System.out.println("Birth Date and Time: " + bDate);
        //TODO Output the day of the week (Sunday-Saturday) that you were born.
        //TODO Output the number of days you've been alive.
        //TODO Output the number of days between two dates.
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO
        //TODO


    }

    private static LocalDateTime birthDateTime(LocalDateTime currentDate) {
         currentDate = LocalDateTime.of(1997, Month.SEPTEMBER, 16, 12, 35);

        return currentDate;
    }

    private static LocalDateTime weeksAddedToCurrent(LocalDateTime currentDate) {
        return currentDate.plusWeeks(5);
    }

    private static String tomorrowDate() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        return today.plusDays(1).format(formatter);
    }

    private static LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }
}
