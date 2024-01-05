import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

public class MainClass {
  public static void main(String arg[]) {
    List<Student> studentList = insertData(); // insert data to POJO
    createStream(); // Different way of creating Stream
    // intermidateOperation(studentList); // Intermediate operation in Stream
    terminalOperation(studentList);
  }

  private static void terminalOperation(List<Student> studentList) {

    // Foreach Operation
    studentList.stream()
        .filter(e -> e.getName().startsWith("S"))
        .forEach(
            e -> {
              int i = 10;
              if (!e.getName().isEmpty()) {
                System.out.println(e);
              } else {
                System.out.println("SUMIT MANDAL");
              }
            });

    // reduce Operation
    String reduceString =
        studentList.stream().map(e -> e.getName()).reduce("", (s1, s2) -> s1 + s2);
    System.out.println("reduceString " + reduceString);
    Integer reduceInteger = studentList.stream().map(e -> e.getId()).reduce(0, (s1, s2) -> s1 + s2);
    System.out.println("reduceInteger " + reduceInteger);

    // collect Operation
    // 1.toList
    List<String> collectList =
        studentList.stream().map(e -> e.getName()).collect(Collectors.toList());
    // 2.toSet
    Set<String> collectSet = studentList.stream().map(e -> e.getName()).collect(Collectors.toSet());
    // 3.toMap()
    Map<Integer, String> collectMap =
        studentList.stream()
            .filter(e -> e.getName().startsWith("S"))
            .collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
    collectMap.forEach((K, V) -> System.out.println("Key " + K + " Value " + V));
    // 4.groupingBy()
    Map<Integer, List<Student>> collectGroupingByDB =
        studentList.stream().collect(groupingBy(e -> e.getDob().getYear()));
    collectGroupingByDB.forEach((K, V) -> System.out.println("Key " + K + " Value " + V));
    // grouping by more than one field
    Map<Integer, Map<String, List<Student>>> collectGroupingByMoreThanOneField =
        studentList.stream()
            .collect(groupingBy(e -> e.getDob().getYear(), groupingBy(Student::getName)));
    collectGroupingByMoreThanOneField.forEach(
        (K, V) -> System.out.println("Key " + K + " Value " + V));
    // performing aggregator method like summingInt, averagingInt, maxBy , minBy on grouping by
    Map<Integer, Double> collectAggregator =
        studentList.stream()
            .collect(groupingBy(e -> e.getDob().getYear(), averagingInt(Student::getId)));
    collectAggregator.forEach((K, V) -> System.out.println("Key " + K + " Value " + V));
    // word count program
    Map<Integer, Long> collectWordCount =
        studentList.stream()
            .map(e -> e.getDob().getYear())
            .collect(groupingBy(Function.identity(), counting())); // we can use summingInt(e ->  1)
    collectWordCount.forEach((K, V) -> System.out.println("Key " + K + " Value " + V));
    //min and max of grouping
    Map<String, Optional<Student>> collectByMax = studentList.stream().collect(groupingBy(Student::getName, maxBy(Comparator.comparingInt(e -> e.getDob().getYear()))));
    collectByMax.forEach((K, V) -> System.out.println("Key " + K + " Value " + V));

    //5. Count
    long countTotalList = studentList.stream().count();
    System.out.println("countTotalList "+ countTotalList);

    //6 min & max
    Optional<Student> maxMarks = studentList.stream().max(Comparator.comparing(Student::getMarks));
    System.out.println("maxMarks "+maxMarks);

    //Similarly we have
    //  1. anyMatch(Predicate<T> predicate),
    //  2. allMatch(Predicate<T> predicate),
    //  3. noneMatch(Predicate<T> predicate)
    //  4. findFirst()
    //  5. findAny()
  }

  private static void intermidateOperation(List<Student> students) {
    // Map
    Stream<Double> mapStream = students.stream().map(e -> e.getMarks());
    System.out.println("mapStream " + mapStream.toList());

    // Filter and Diff BW Stream and List
    Stream<Student> filterStream = students.stream().filter(e -> e.getName().startsWith("S"));
    List<Student> filterList =
        students.stream().filter(e -> e.getName().startsWith("S")).collect(Collectors.toList());
    System.out.println("filterStream " + filterStream.toList());
    System.out.println("filterList " + filterList);

    // flat map
    List<List<Integer>> listStream = students.stream().map(e -> e.getRollList()).toList();
    System.out.println("listStream " + listStream);
    List<Integer> objectStream = students.stream().flatMap(e -> e.getRollList().stream()).toList();
    System.out.println("objectStream " + objectStream);

    // distinct Operation
    // If we get requirement to perform operation on objveft data [[],[],[]], we can use flatmap.
    // e.g List pout all the unique roll list associated with the students
    System.out.println("objectStream " + objectStream.stream().distinct().toList());

    // sorted() Operation
    List<String> sortedNames = students.stream().map(e -> e.getName()).sorted().toList();
    sortedNames.forEach(System.out::print);

    // limit Operation
    List<String> limitBy3 = students.stream().map(e -> e.getName()).sorted().limit(3).toList();
    System.out.println("\nlimitBy3");
    limitBy3.forEach(System.out::print);

    // skip Operation
    List<String> skipBy4 = students.stream().map(e -> e.getName()).sorted().skip(4).toList();
    System.out.println("\nskipBy4");
    skipBy4.forEach(System.out::print);
  }

  public static List<Student> insertData() {
    List<Student> studentList = new ArrayList<>();
    List<Integer> rollList = Arrays.asList(10, 20, 30, 40, 50);
    studentList.add(new Student(1, "Sumit", 868.00, LocalDate.now().minusDays(5), rollList));
    studentList.add(new Student(2, "Suvash", 768.00, LocalDate.now().minusDays(10), rollList));
    studentList.add(new Student(3, "Sikha", 968.00, LocalDate.now().minusMonths(2), rollList));
    studentList.add(new Student(4, "Monika", 468.00, LocalDate.now().minusYears(3), rollList));
    studentList.add(new Student(5, "Pankaj", 928.00, LocalDate.now().minusYears(6), rollList));
    studentList.add(new Student(6, "Arun", 728.00, LocalDate.now(), rollList));
    studentList.add(new Student(7, "Monika", 868.00, LocalDate.now().minusYears(6), rollList));
    studentList.add(new Student(8, "Pankaj", 628.00, LocalDate.now().minusYears(12), rollList));
    return studentList;
  }

  public static void createStream() {
    int arr[] = {10, 20, 30, 40, 50};
    String str[] = {"SUMIT", "AMIT", "SACHIN", "BADAL", "SURAJ"};
    Stream<int[]> stream1 = Arrays.asList(arr).stream();
    Stream<String> stream2 = Stream.of(str);
    Stream<String> stream3 =
        Stream.<String>builder().add("ABC").add("XYZ").add("PQR").add("EYX").build();
  }
}
