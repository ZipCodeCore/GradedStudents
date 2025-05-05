package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Classroom {
    private Student[] students;

    public Classroom(int classroomSize) {
        this.students = new Student[classroomSize];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public String getStudents() {
        return Arrays.toString(this.students);
    }

    public Double getAverageExamScore() {
        Double examScoreTotal = 0.0;
        for (Student student: this.students) {
            examScoreTotal += student.getAverageExamScore();
        }
        return examScoreTotal / this.students.length;
    }

    public void addStudent(Student student) {
        ArrayList<Student> studentsArrayList = new ArrayList<>(Arrays.asList(this.students));
        studentsArrayList.add(student);
        this.students = studentsArrayList.toArray(this.students);
    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> studentsArrayList = new ArrayList<>(Arrays.asList(this.students));
        int count = 0;
        for (Student student: this.students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                studentsArrayList.remove(count);
            }
            count++;
        }
        this.students = studentsArrayList.toArray(this.students);
    }

    public String getStudentsByScore() {
        ArrayList<Student> studentsArrayList = new ArrayList<>(Arrays.asList(this.students));
        Collections.sort(studentsArrayList, Student.AverageTestScoreComparator.thenComparing(Student::getLastName));

        return Arrays.toString(studentsArrayList.toArray(this.students));
    }

    public String getGradeBook() {
        setGradeBook();
        StringBuilder studentNamesAndGrades = new StringBuilder();
        for (Student student: this.students) {
            studentNamesAndGrades.append(student.getFirstName() + " " + student.getLastName() + " = "
                    + student.getCurveGrade() + "\n");

        }


        return studentNamesAndGrades.toString();
    }

    public void setGradeBook() {
        setPercentileForAllStudents();
        for (Student student: this.students) {
            if (student.getPercentile() <= 10){
                student.setCurveGrade("A");
            } else if (student.getPercentile() > 10 && student.getPercentile() < 30) {
                student.setCurveGrade("B");
            } else if (student.getPercentile() >=30 && student.getPercentile() <= 50) {
                student.setCurveGrade("C");
            } else if (student.getPercentile() > 50 && student.getPercentile() < 90) {
                student.setCurveGrade("D");
            } else {
                student.setCurveGrade("F");
            }
        }
    }

    public void setPercentileForAllStudents() {
        getStudentsByScore();
        double currentPercentile = 100 / this.students.length;
        double staticPercentile = currentPercentile;

        for (Student student: this.students) {
            student.setPercentile(currentPercentile);
            currentPercentile+= staticPercentile;
        }

    }

}
