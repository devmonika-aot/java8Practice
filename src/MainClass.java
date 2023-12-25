import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {
  public static void main(String arg[]) {
    List<StudentComparable> studentComparableList = insertStudentComparable();
    List<Student> studentList = insertStudentData();

    // Notes: Comparable Implementation
    Collections.sort(studentComparableList);// It will call the compareTo method of Comparable
    studentComparableList.forEach(System.out::println);

    System.out.println("*********************************");
    // Comparator is Function Interface which has only one abstract method compare().
    Collections.sort(studentList,(o1,o2)-> (int) (o1.getMarks()-o2.getMarks()));
    studentList.forEach(System.out::println);
  }

  public static List<Student> insertStudentData(){
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1,"Sumit",868.00, LocalDate.now().minusDays(5)));
    studentList.add(new Student(2,"Suvash",768.00, LocalDate.now().minusDays(10)));
    studentList.add(new Student(3,"Sikha",968.00, LocalDate.now().minusMonths(2)));
    studentList.add(new Student(4,"Monika",468.00, LocalDate.now().minusYears(3)));
    studentList.add(new Student(5,"Pankaj",928.00, LocalDate.now().minusYears(6)));
    studentList.add(new Student(6,"Arun",728.00, LocalDate.now()));
    studentList.add(new Student(7,"Monika",868.00, LocalDate.now().minusYears(6)));
    studentList.add(new Student(8,"Pankaj",628.00, LocalDate.now().minusYears(12)));
    return  studentList;
  }

  public static List<StudentComparable> insertStudentComparable(){
    List<StudentComparable> studentList = new ArrayList<>();
    studentList.add(new StudentComparable(1,"Sumit",868.00, LocalDate.now().minusDays(5)));
    studentList.add(new StudentComparable(2,"Suvash",768.00, LocalDate.now().minusDays(10)));
    studentList.add(new StudentComparable(3,"Sikha",968.00, LocalDate.now().minusMonths(2)));
    studentList.add(new StudentComparable(4,"Monika",468.00, LocalDate.now().minusYears(3)));
    studentList.add(new StudentComparable(5,"Pankaj",928.00, LocalDate.now().minusYears(6)));
    studentList.add(new StudentComparable(6,"Arun",728.00, LocalDate.now()));
    studentList.add(new StudentComparable(7,"Monika",868.00, LocalDate.now().minusYears(6)));
    studentList.add(new StudentComparable(8,"Pankaj",628.00, LocalDate.now().minusYears(12)));
    return  studentList;
  }
}