import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    Scanner reader = new Scanner(System.in);

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
        LocalDateTime bDate = birthDateTime();
        System.out.println("Birth Date and Time: " + bDate);

        // Output the day of the week (Sunday-Saturday) that you were born.
        DayOfWeek bday = birthday();
        System.out.println("BirthDay Day: " + bday);

        // Output the number of days you've been alive.
        long daysLived = howManyDaysLived();
        System.out.println("Days Lived So Far... " + daysLived + "Days.");

        // Output the number of days between two dates.
        LocalDate date1 = LocalDate.of(2018, Month.MAY, 26);
        LocalDate date2 = LocalDate.of(2018, Month.JUNE, 1);
        long daysBetween = numOfDaysBetween(date1, date2);
        System.out.println("There are " + daysBetween + " days between " + date1 + " and " + date2);


        //TODO Given two dates, output the earlier..
        LocalDate earlyDate = earlierDate(date1, date2);
        //TODO Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        //TODO Store data from the file into an ArrayList of LocalDateTime objects.
        //TODO Output the number of stored dates in the year [Y].
        //TODO Count the number of stored dates in the current year.
        //TODO Count the number of duplicates.
        //TODO Sort the dates in chronological order.
        //TODO Count the number of duplicates in a sorted list without using a Java Set.
        //TODO Count the number of evening (after 6pm) dates.
        //TODO Count the number of dates in each of the individual 12 months without using a Java Map.
        //TODO Count the number of dates in each of the individual 12 months using a Java Map.
        //TODO Determine the index of the latest LocalDateTime.
        //TODO Determine the indexes of the elements that have the earliest starting time, regardless of date.
        //TODO Output a date in the format "January 1st, 2018".


    }

    private static LocalDate earlierDate(LocalDate date1, LocalDate date2) {
        date1.compareTo(date2);
        date1.isBefore(date2);
        date2.isAfter(date1);

        return null;
    }

    private static long numOfDaysBetween(LocalDate date1, LocalDate date2) {
        long d1 = date1.toEpochDay();
        long d2 = date2.toEpochDay();

        return d2 - d1;
    }

    private static long howManyDaysLived() {
        long date = LocalDate.now().toEpochDay();
        long bday = LocalDate.of(1997, Month.SEPTEMBER, 16).toEpochDay();

        return date - bday;
    }


    private static DayOfWeek birthday() {

        return LocalDateTime.of(1997, Month.SEPTEMBER, 16, 12, 35).getDayOfWeek()
        ;
    }

    private static LocalDateTime birthDateTime() {

        return LocalDateTime.of(1997, Month.SEPTEMBER, 16, 12, 35);

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
