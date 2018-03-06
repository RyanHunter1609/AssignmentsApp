
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
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


        //Given two dates, output the earlier..
        boolean earlyDate = earlierDate(date1, date2);
        System.out.println("Is " + date1 + " Earlier Than " + date2 + "? " + earlyDate);

        //TODO Create a file with 100 random "month/day/year  hour:minutes" (in that format) on each line.
        fileWithRandomDateTime();


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

    private static void fileWithRandomDateTime() throws FileNotFoundException {
        LocalDateTime today = LocalDateTime.now();
//        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd  HH:mm");
        // write data to a file
        File outfile = new File("randomdatetime.txt");
        if (outfile.exists()) {
            System.out.println("Oh no, you're going to overwrite the data in the file!");
        } else {
            try (PrintWriter pw = new PrintWriter(outfile)) {
                System.out.println("This is being written to stdout.");
                pw.println(today.format(formatter) + 100);
            } catch (FileNotFoundException e) {
            }
        }
        // read data from a file
        File infile = new File("randomdatetime.txt");
        if (!infile.exists()) {
            System.out.println("Oh no, you can't read from a file that doesn't exist!");
        } else {
            try (Scanner sc = new Scanner(infile)) {
                while (sc.hasNext()) {
                    int age = sc.nextInt();
                }
            }
        }

    }

    private static boolean earlierDate(LocalDate date1, LocalDate date2) {
        if (date1 == date2) {
            return false;
        }
        if (date1.isBefore(date2)) {
            return true;
        }
        return true;
    }

    private static long numOfDaysBetween(LocalDate date1, LocalDate date2) {
        long d1 = date1.toEpochDay();
        long d2 = date2.toEpochDay();
        long daysBetween;

        if (date1.isBefore(date2)) {
            daysBetween = d2 - d1;
        } else {
            daysBetween = d1 - d2;
        }


        return daysBetween;
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
