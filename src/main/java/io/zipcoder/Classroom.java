package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

public class Classroom extends Student{

    Student[] students;


    public Classroom(int maxNumberOfStudents){this.students = new Student[maxNumberOfStudents];}
    public Classroom(Student[] students){this.students = students;}
    public Classroom(){ this.students = new Student[30]; }

    public Student[] getStudents() {
        return students;
     }

    public Double getAverageExamScore() {
        double total = 0;
        for (int i = 0; i < students.length; i++) {
            total += students[i].getAverageExamScore();
        }
        return total / students.length;
    }
  public Student[] addStudent(Student student){
        List<Student> studentList = Arrays.asList(students);
        studentList.add(student);
        return (Student[]) studentList.toArray();
  }

  public Student[] removeStudent(String firstName, String lastName){
      List<Student> studentList = Arrays.asList(students);
      for(int i =0; i < students.length; i++){
            if(students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                studentList.remove(i);
            }
        }
        return (Student[])studentList.toArray();
  }
  public Student[] getStudentByScore(){
      StudentSorter itemSorter = new StudentSorter(students);
      Comparator<Student> comparator =  new ScoreComparator();
      return itemSorter.sort(comparator);
  }
//******Correct this to meet requirements ******
  public Map getGradeBook(){
        Map<Character, Student> gradeBook= new HashMap<>();
        Student[] sortedStudents =getStudentByScore();
        for(int i =0; i < sortedStudents.length; i++){
            if(sortedStudents[i].getAverageExamScore() <=50){
                gradeBook.put('F',sortedStudents[i]);
            }else if(sortedStudents[i].getAverageExamScore() <=60) {
                gradeBook.put('E', sortedStudents[i]);
            }else if(sortedStudents[i].getAverageExamScore() <=65) {
                gradeBook.put('D', sortedStudents[i]);
            }else if(sortedStudents[i].getAverageExamScore() <=70) {
                gradeBook.put('C', sortedStudents[i]);
            }else if(sortedStudents[i].getAverageExamScore() <=90) {
                gradeBook.put('B', sortedStudents[i]);
            } else {
                gradeBook.put('A', sortedStudents[i]);
            }
        }
        return gradeBook;
  }
}
