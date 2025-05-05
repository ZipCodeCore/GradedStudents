package io.zipcoder;

import java.util.Arrays;

public class Classroom {

    Student[] students;



    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }


    public Student[] getStudents() {
        return this.students;

    }

    public Double getAverageExamScores() {

        double total = 0;
        for (Student student : this.students) {
            total += student.getAverageExamScore();
        }

        return total / students.length;

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
                break;
            }
        }

    }

    public void sortArrayWithNullValuesToEnd() {

        Student[] tempStudentArray = Arrays.copyOf(this.students, this.students.length);

        int remaining = 0;
         for (int i = 0; i < this.students.length; i++) {
           if (this.students[i] != null) {
            tempStudentArray[remaining] = this.students[i];
            remaining++;
            }
         }
            tempStudentArray[tempStudentArray.length - 1] = null;
            this.students = tempStudentArray;

    }

    public Student[] getStudentsByScore() {
        Arrays.sort(students);
        return students;
    }

    public String getGradeBook() {
        return null;
    }


}
