import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainClass {
  public static void main(String arg[]) {
    List<Student> studentList = insertData();
    // Java 8 DateTime
    extractDateAndTime();
    timeDifferenceBetweenCountriesCalculation();
    parsingDateAndString();

    //Optional
    // to handle null value more efficiently
    String value = "SUMIT";// try with String value = null as well.
    // here value can be non null or null
    Optional<String> value1 = Optional.ofNullable(value);
    // If the value is null, It will return default value instead of throwing NullPointerException
    String finalValue = value1.orElse("MANDAL");
    System.out.println("finalValue "+ finalValue);
  }

  private static void parsingDateAndString() {

    LocalDateTime localDateTime = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String timeInString = localDateTime.format(dateTimeFormatter);
    LocalDateTime timeInDateFormat = LocalDateTime.parse(timeInString, dateTimeFormatter);
    System.out.println(
        " timeInString " + timeInString + " + " + timeInDateFormat + " timeInDateFormat ");
    // Date and Time manipulation on LocalDateTime
    LocalDateTime localDateTimeTemp = localDateTime.plusDays(3).minusMonths(4).plusYears(10);
    System.out.println("localDateTimeTemp " + localDateTimeTemp);
  }

  private static void timeDifferenceBetweenCountriesCalculation() {

    ZoneId zoneIdUS = ZoneId.of("America/Los_Angeles");
    ZonedDateTime zonedDateTimeUS = ZonedDateTime.now(zoneIdUS);

    ZoneId zoneIdIndia = ZoneId.of("Asia/Kolkata");
    ZonedDateTime zonedDateTimeIndia = ZonedDateTime.now(zoneIdIndia);

    Duration duration =
        Duration.between(zonedDateTimeUS.toInstant(), zonedDateTimeIndia.toInstant());
    System.out.println("DurationBetween " + duration);

    // To get difference in Year, day and time we can use Period

    Period between =
        Period.between(zonedDateTimeIndia.toLocalDate(), zonedDateTimeUS.toLocalDate());
    System.out.println("PeriodBetween " + between.getDays());
  }

  private static void extractDateAndTime() {
    // Fetch Year, Month , Days of the month and Hour, Minutes and Second
    LocalDate localDate = LocalDate.now();
    String localDateBreakDown =
        "Year number "
            + localDate.getYear()
            + " Month Number "
            + localDate.getMonthValue()
            + " Days of Month "
            + localDate.getDayOfMonth();
    System.out.println(localDateBreakDown);

    LocalTime localTime = LocalTime.now();
    String localTimeBreakdown =
        "Hour "
            + localTime.getHour()
            + " Minutes "
            + localTime.getMinute()
            + " Second "
            + localTime.getSecond();
    System.out.println(localTimeBreakdown);

    LocalDateTime localDateTime = LocalDateTime.now();
    String localDateTimeBreakDown =
        "YEAR "
            + localDateTime.getYear()
            + " MONTH "
            + localDateTime.getMonth()
            + " DAYS OF MONTH "
            + localDateTime.getDayOfMonth()
            + " HOURS "
            + localDateTime.getHour()
            + " MINUTES "
            + localDateTime.getMinute()
            + " SECOND "
            + localDateTime.getSecond();
    System.out.println(localDateTimeBreakDown);
  }

  public static List<Student> insertData() {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1, "Sumit", 868.00, LocalDate.now().minusDays(5)));
    studentList.add(new Student(2, "Suvash", 768.00, LocalDate.now().minusDays(10)));
    studentList.add(new Student(3, "Sikha", 968.00, LocalDate.now().minusMonths(2)));
    studentList.add(new Student(4, "Monika", 468.00, LocalDate.now().minusYears(3)));
    studentList.add(new Student(5, "Pankaj", 928.00, LocalDate.now().minusYears(6)));
    studentList.add(new Student(6, "Arun", 728.00, LocalDate.now()));
    studentList.add(new Student(7, "Monika", 868.00, LocalDate.now().minusYears(6)));
    studentList.add(new Student(8, "Pankaj", 628.00, LocalDate.now().minusYears(12)));
    return studentList;
  }
}
