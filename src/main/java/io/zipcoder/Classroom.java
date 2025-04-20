package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classroom {
    private Student[] student;
    private Integer maxNumberOfStudents;

    public Classroom(Integer maxNumberOfStudents){
        this.student = new Student[maxNumberOfStudents];
    }
    public Classroom(Student[] student){
        this.student = student;
    }
    public Classroom(){
        this.student = new Student[30];
    }
    public Student[] getStudents() {
        return student;
    }
    public Double getAverageExamScore(){
      Double sumScore = 0.0;
        for (Student thisStudent : student) {
            sumScore += thisStudent.getAverageTestScores();
        }
        return sumScore/student.length;
    }
    public void  addStudent(Student newStudent) {
        for (int i = 0; i < student.length - 1; i++) {
            if (student[i] == null) {
                student[i] = newStudent;
            }

        }

    }
    public void removeStudent(String firstName, String lastName){
       ArrayList<Student> newArrayList = new ArrayList<>(Arrays.asList(student));
        for (int i = 0; i < student.length; i++) {
            if(student[i].getFirstName().equals(firstName) && student[i].getLastName().equals(lastName)){
            }
        }
        student = newArrayList.toArray(new Student[0]);
    }
    public void getStudentByScore(){
        Arrays.sort(student);
    }
    public void getGradeBook(){
        
    }
}
