package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void testAverageExamScores(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void testAddStudent(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

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
    public void testGetStudentsByExamScore(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0, 123.0 };
        Double[] s2Scores = { 100.0, 150.0, 123.0 };
        Double[] s3Scores = { 145.3, 55.2, 400.1, 300.5};

        Student s1 = new Student("student", "Yep", s1Scores);
        Student s2 = new Student("student", "Two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);

        Student[] students = {s1,s2,s3};
        Student[] expected = {s3, s1, s2};
        Classroom classroom = new Classroom(students);

        Student[] actual = classroom.getStudentsByScore();
        Map<Student, Character> gradeBook = classroom.getGradeBook();
        Assert.assertArrayEquals(actual, expected);

    }
}
