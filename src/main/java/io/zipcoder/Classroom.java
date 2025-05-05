package io.zipcoder;

import java.util.*;

public class Classroom {

    private Student[] students;

    //Constructors
    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this(30);
    }


    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        double classTotalScore = 0;
        double numberOfStudents = students.length;

        for (int i = 0; i < students.length; i++)
            classTotalScore += students[i].getAverageExamScore();

        return (classTotalScore / numberOfStudents);
    }

    public String addStudent(Student student) {

        for (int index = 0; index < students.length; index++) {
            if (students[index] == null) {
                students[index] = student;

                return student.toString();
            }
        }

        return "Classroom is full";
    }

    public boolean removeStudent(String firstName, String lasName) {

        for (int index = 0; index < students.length; index++) {
            Student student = students[index];

            if (student.getFirstName().contains(firstName) &&
                    student.getLastName().contains(lasName)) {

                students[index] = null;
                return true;
            }
        }

        return false;
    }

    public List getStudentByScore(double score) {
        List<Student> studentScore = new ArrayList<>();

        for (Student student : getStudents()) {
            if (student.getExamScores().contains(String.valueOf(score)))
                studentScore.add(student);
        }

        Collections.sort(studentScore, new NameComparator());

        return studentScore;
    }

}