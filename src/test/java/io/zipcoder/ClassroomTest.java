package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void getStudentsTest () {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("", "student", "one", s1Scores);
        Student s2 = new Student("", "student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        String output = String.valueOf(classroom.getStudents());

        // Then
        System.out.println(output);
    }

    @Test
    public void getAverageExamScoreTest () { // needs some work
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 275.0, 25.0 };

        Student s1 = new Student("", "student", "one", s1Scores);
        Student s2 = new Student("", "student", "two", s2Scores);

        Student[] student = {s1,s2};
        Classroom classroom = new Classroom(student);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void addStudentTest () {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("", "Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest () {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("", "Leon", "Hunter", examScores);

        // When
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();
        classroom.removeStudent("Leon", "Hunter");
        Student[] afterRemoval = classroom.getStudents();

        // Then
        String afterRemovalThing = Arrays.toString(afterRemoval);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        System.out.println(postEnrollmentAsString);
        System.out.println(afterRemovalThing);
    }

    @Test
    public void sortingByScoreTest () {
        // "Cannot find local variable 'classroom' " from debugger with break on 92

        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Double[] examScores1 = {50.0, 75.0 , 125.0, 0.0};
        Double[] examScores2 = {200.0, 300.0 , 400.0, 50.0};
        Double[] examScores3 = {50.0, 75.0 , 125.0, 0.0};
        Double[] examScores4 = {0.0, 0.0};
        Double[] examScores5 = {1000.0};
        Student s = new Student("", "Leon", "Hunter", examScores);
        Student s1 = new Student("", "Eric", "Weenermier", examScores1);
        Student s2 = new Student("", "Kyle", "Calzone", examScores2);
        Student s3 = new Student("", "Cal", "Weenermier", examScores3);
        Student s4 = new Student("", "Ryan", "Coffee", examScores4);
        Student s5 = new Student("", "Front", "Runner", examScores5);

        // When
        Student[] student = {s, s1, s2, s3};
        Classroom classroom69 = new Classroom(student);
        Student[] postEnrollment = classroom69.getStudents();
        classroom69.getStudentsByScore();
        Student[] afterSorting = classroom69.getStudents();

        // Then
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        System.out.println(postEnrollmentAsString);
        System.out.println(Arrays.toString(afterSorting));
    }

    @Test
    public void getGradeBookTest () {                         // avg
        // Given
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};     // 125.0
        Double[] examScores1 = {50.0, 75.0 , 125.0, 0.0};     // 62.5
        Double[] examScores2 = {200.0, 300.0 , 400.0, 50.0};  // 237.5
        Double[] examScores3 = {50.0, 75.0 , 125.0, 0.0};     // 62.5
        Double[] examScores4 = {0.0, 0.0};                    // 0.0
        Double[] examScores5 = {1000.0};                      // 1000.0
        Student s = new Student("", "Leon", "Hunter", examScores);
        Student s1 = new Student("", "Eric", "Weenermier", examScores1);
        Student s2 = new Student("", "Kyle", "Calzone", examScores2);
        Student s3 = new Student("", "Cal", "Weenermier", examScores3);
        Student s4 = new Student("", "Ryan", "Coffee", examScores4);
        Student s5 = new Student("", "Front", "Runner", examScores5);
        Student[] student = {s, s1, s2, s3, s4, s5};

        // When
        Classroom classroom69 = new Classroom(student);
        Student[] actual = classroom69.getGradeBook();
        Student[] expected = {s5, s2, s, s1, s3, s4};

        // Then
        Assert.assertEquals(expected, actual);
    }
}
