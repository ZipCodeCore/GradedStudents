package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;


public class ClassroomTest {
    @Test
    public void testGetAvergeExamScore() {
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(84.00, 92.00));
        ArrayList<Double> s2Scores = new ArrayList<Double>(Arrays.asList(96.0, 100.00));

        Student s1 = new Student("Kai", "Shields", s1Scores);
        Student s2 = new Student("Kendra", "Ng", s2Scores);

        Double expectedAverage = 93.0;
        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        Double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expectedAverage, actual);
    }

    @Test
    public void testAddStudent() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 85.0, 76.0, 0.0));
        Student student = new Student("Kai", "Shields", examScores);

        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
    }

    @Test
    public void testRemoveStudent() {
        Integer maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(89.0, 100.0, 50.0));
        Student s1 = new Student("Kai", "Shields", s2Scores);
        classroom.addStudent(s1);

        Integer actual = classroom.getStudents().length;

        classroom.removeStudent("Kai", "Shields");

        Assert.assertEquals(maxNumberOfStudents, actual);
    }

    @Test
    public void testGetStudentsByScore() {
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 93.0));
        ArrayList<Double> s2Scores = new ArrayList<Double>(Arrays.asList(78.0, 85.0));
        Student s1 = new Student("Kendra", "Ng", s2Scores);
        Student s2 = new Student("Kai", "Shields", s1Scores);
        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);
        classroom.addStudent(s1);
        classroom.addStudent(s2);

        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        classroom.getStudentsByScore();
        Student[] postEnrollment = classroom.getStudents();

        String postEnrollmentAsString = Arrays.toString(postEnrollment);
    }

    @Test
    public void testGetGradeBook() {
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(70.0, 100.0));
        ArrayList<Double> s2Scores = new ArrayList<Double>(Arrays.asList(94.0, 85.0));
        ArrayList<Double> s3Scores = new ArrayList<Double>(Arrays.asList(62.0, 96.0));

        Student s1 = new Student("Kai", "Shields", s1Scores);
        Student s2 = new Student("Kendra", "Ng", s2Scores);
        Student s3 = new Student("Val", "Fraiger", s3Scores);

        Student[] students = {s1, s2, s3};
        Classroom classroom = new Classroom(students);

        Map gradeBook = classroom.getGradeBook();
    }

}
