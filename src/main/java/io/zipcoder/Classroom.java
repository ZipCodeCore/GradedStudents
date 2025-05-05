package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;

public class Classroom {
    private Student[] students;

    public Classroom(){
        this.students = new Student[30];
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom (Student[] students){
        this.students = students;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScores(){
        double count = 0.0;
        double sumOfScores = 0.0;
        for(int i = 0; i < students.length; i++) {
            if (!(students[i] == null)) {
                sumOfScores += students[i].getAverageExamScore();
                count++;
        }

    }
        double average = Math.round(sumOfScores/count);
        return average;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }

    }

    public void removeStudent(String firstName, String lastName) {

        for (int i = 0; i < students.length; i++) {
            if (students[i].getFirstName().equals(firstName) && students[i].getLastName().equals(lastName)) {
                students[i] = null;
                this.sortArrayAfterRemoveStudent();
                break;
            }
        }
    }

    public void sortArrayAfterRemoveStudent() {

        Student[] sortedStudents = Arrays.copyOf(this.students, this.students.length);

        int counter = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (students[i] != null) {
                sortedStudents[counter] = students[i];
                counter++;
            }
        }



    sortedStudents[students.length - 1] = null;
    this.students = sortedStudents;
    }


    public Student[] getStudentsByScore() {

        Arrays.sort(this.students, sortScoreAndLastName);

        return this.students;
    }


    public static Comparator<Student> sortScoreAndLastName = new Comparator<Student>() {
    @Override
    public int compare(Student student1, Student student2) {

        if (student1.getAverageExamScore() == student2.getAverageExamScore()) {
            return student1.getLastName().compareTo(student2.getLastName());
        }else if (student1.getAverageExamScore() < student2.getAverageExamScore()) {
            return 1;
        } else {
            return -1;
        }
    }

    };

    public String getGradeBook() {
        return null;
        }

//    public double getAverageExamScores() {
//        return null;
//    }
}
