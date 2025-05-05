package io.zipcoder;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public Student[] students;
    private Integer maxNumberOfStudents;

    public Classroom(Integer maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
        this.maxNumberOfStudents = maxNumberOfStudents;

    }

    public Classroom(Student[]students) {
        this.students = students;

    }

    public Classroom() {
        this.students = new Student[30];

    }

    public Student[] getStudents() {
        List<Student> studentList = new ArrayList<>();
        for (Student student: students) {
            if (student != null)
                studentList.add(student);
        }
           return studentList.toArray(new Student[studentList.size()]);

    }

    public double getAverageExamScores() {
        double avgScore = 0;
        double summ = 0;
        for (int i = 0; i < students.length; i++) {
            summ += students[i].getAverageExamScore();
            avgScore = summ / students.length;

        }
        return avgScore;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
            i++;
        }
    }

        public int getNumberOfStudents () {
            int count = 0;
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && students[i].getFirstName().length() > 0) {
                    count++;

                }
            }
            return count;
        }

        public void removeStudent(String firstName, String lastName) {


            List<Student> studentList = new ArrayList<>();
            for (int i = 0; i < students.length; i++) {
                studentList.add(students[i]);
            }
            for (Student i : getStudents()) {
                if (i.getFirstName().equals(firstName) && (i.getLastName().equals(lastName))) {
                    studentList.remove(i);
                }
            }
            students = studentList.toArray(new Student[0]);
        }





        public String getGradeBook(){

        return null;
        }
    }






