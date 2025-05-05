package io.zipcoder;

import java.util.*;
import java.util.stream.Collectors;

public class Classroom {
    int maxNumberOfStudents;
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public  Classroom(Student... students) {

        this.students = students;
    }

    public Classroom() {

        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double sum =0.0;
        for(Student student : students){
            sum += student.getAverageExamScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student student){
        for(int i =0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
//        Student[] studentArray = new Student[students.length];
//        for(int i = 0; i < students.length; i++) {
//            if(students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName));
//                this.students[i] = null;
                ArrayList<Student> list = new ArrayList<>(Arrays.asList(students));
                for(int i =0; i < list.size(); i++){
                    Student student = list.get(i);
                    if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                        list.remove(student);
                        list.add(null);
                    }

        }
            this.students = list.toArray(new Student[0]);
    }



    public Student[] getStudentsByScore(){
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        return null;
    }



}
