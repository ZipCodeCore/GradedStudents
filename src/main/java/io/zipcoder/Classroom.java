package io.zipcoder;

import java.util.*;

public class Classroom {

    Student[] students;
    int studentLimit;

    public Classroom(int studentLimit){
        students = new Student[studentLimit];
    }

    public Classroom(Student[] student){
        this.students = student;
    }

    public Classroom() {
        this.students =  new Student[30];
    }

    public Student[] getStudents(){
        return students;
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for (Student student : students) {
            sum += student.getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
        }
    }

    public Student[] removeStudent(String firstName, String lastName) {
        List<Student> studentList =  new ArrayList<>(Arrays.asList(students));
        for (Student student : students) { //each student in students array
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                studentList.remove(student); //if names match then remove student
            }
                return studentList.toArray(new Student[studentList.size()]);
        }
        return new Student[studentLimit];
    }

    public Student[] getStudentsByScore() {
    List<Student> studentList = new ArrayList<Student>(Arrays.asList(students));

        Comparator<Student> examScore = Comparator.comparing(Student::getAverageExamScore);
        Comparator<Student> studentName = Comparator.comparing(Student::getFullName);
        return null;
    }



//    public getGradeBook() {
//
//    }
}


