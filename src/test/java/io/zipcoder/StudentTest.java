package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    private Student testStudent;
    private String firstName;
    private String lastName;
    @Before
    public void Setup() {
        // Given
        firstName = "Leon";
        lastName = "Hunter";
        Double[] testScores = {100.00, 212.00, 125.0, 70.00};

        // When
        testStudent = new Student(firstName, lastName, testScores);
    }

    @Test
    public void testGetExamScores() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void testAddExamScore() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void testSetExamScore() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0,170.0};
        Student student = new Student(firstName, lastName, examScores);


        // When
        student.setExamScore(0, 150.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void testGetAverageExamScore() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        double expected = 125.0;
        double actual = student.getAverageExamScore();
        // Then
        Assert.assertEquals(expected, actual, 0.01);

    }
    @Test
        public void testToString(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }
}