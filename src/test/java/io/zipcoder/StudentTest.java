package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void studentConstructorTest() {
        // Given
        String givenFirstName = "Leon";
        String givenLastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        // When
        String expectedFirstName = student.getFirstName();
        String expectedLastName = student.getLastName();
        //ArrayList<Double> output = student.getExamScores();

        // Then
        Assert.assertEquals(expectedFirstName, givenFirstName);
        Assert.assertEquals(expectedLastName, givenLastName);
    }

    @Test
    public void getStudentExamScoresTest() {
        // Given
        String givenFirstName = "Leon";
        String givenLastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        // When
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(output, Arrays.toString(examScores));
    }

    @Test
    public void addExamScoreTest() {
        // Given
        String givenFirstName = "Leon";
        String givenLastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(givenFirstName, givenLastName, examScores);

        // When
        student.addExamScore(100.0);

        String output = student.getExamScores();

        // Then
        Assert.assertEquals(output, "[100.0]");
    }

    @Test
    public void setExamScoreTest() {
        // Given
        String givenFirstName = "Leon";
        String givenLastName = "Hunter";
        Double[] examScores = {100.0};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        // When
        student.setExamScore(1,150.0);
        //student.addExamScore(150);

        String expectedOutput = student.getExamScores();


        // Then
        Assert.assertEquals(expectedOutput, "[150.0]");
    }

}