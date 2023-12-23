import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
  public static void main(String arg[]) {
    List<Student> studentList = insertData();

    System.out.println("HI");
  }

  public static List<Student> insertData(){
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
}
