

import java.time.LocalDate;


public class StudentComparable implements  Comparable<StudentComparable>{

  private int id;

  private String name;
  private Double marks;
  private LocalDate dob;

  public StudentComparable(int id, String name, Double marks, LocalDate dob) {
    this.id = id;
    this.name = name;
    this.marks = marks;
    this.dob = dob;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getMarks() {
    return marks;
  }

  public void setMarks(Double marks) {
    this.marks = marks;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", marks=" + marks +
            ", dob=" + dob +
            '}';
  }

  @Override
  public int compareTo(StudentComparable o) {
    return this.getMarks().compareTo(o.getMarks());
  }
}
