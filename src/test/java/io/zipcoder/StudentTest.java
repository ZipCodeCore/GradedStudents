package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;


public class StudentTest {


    @Test
    public void testDefaultConstructor() {
        // Given
        String expectedFirstName = "Tom";
        String expectedLastName = "Fantana";
        Double[] expectedDouble = {55.2, 64.5, 56.5};
        Student student = new Student(expectedFirstName, expectedLastName, expectedDouble);

        // When
        String actualFirstName = student.getFirstName();
        String actualLastName =  student.getLastName();
        Double[] actualDouble =  student.getTestScores();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedDouble, actualDouble);
    }

    @Test
    public void getNumberOfExamsTakenTest(){
        // Given
        String expectedFirstName = "Tom";
        String expectedLastName = "Fantana";
        Double[] expectedDouble = {55.2, 64.5, 56.5};
        int expectedDoubleLength = 3;
        Student student = new Student(expectedFirstName, expectedLastName, expectedDouble);

        // When
        int actualDoubleLength = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expectedDoubleLength, actualDoubleLength);
    }

    @Test
    public void getExamScoresTest(){
        // Given
        String expectedFirstName = "Tom";
        String expectedLastName = "Fantana";
        Double[] expectedDouble = {55.2, 64.5, 56.5};
        String expectedGetExamScores = "Exam 1 -> 55.2\nExam 2 -> 64.5\nExam 3 -> 56.5";
        Student student = new Student(expectedFirstName, expectedLastName, expectedDouble);

        // When
        String actualGetExamScores = student.getExamScores();

        // Then
        Assert.assertEquals(expectedGetExamScores, actualGetExamScores);
    }

    @Test
    public void addExamScoreTest() {
        // Given
        String expectedFirstName = "Tom";
        String expectedLastName = "Fantana";
        Double[] expectedDouble = {44.5};
        Student student = new Student(expectedFirstName, expectedLastName, expectedDouble);

        // When
        student.addExamScore(50.0);
        System.out.println(student.getExamScores());
        String actualAddExamScore = student.getExamScores();
        String expectedAddExamScore = "Exam 1 -> 44.5\nExam 2 -> 50.0";

        // Then
        Assert.assertEquals(expectedAddExamScore, actualAddExamScore);
    }

    @Test
    public void setExamScoreTest() {
        // : Given
        String expectedFirstName = "Tom";
        String expectedLastName = "Fantana";
        Double[] expectedDouble = {44.5};
        Student student = new Student(expectedFirstName, expectedLastName, expectedDouble);

        // When
        student.setExamScore(1, 150.0);
        String actualExamScoreTest = student.getExamScores();
        String expectedSetExamScoreTest = "Exam 1 -> 150.0";

        // Then
        Assert.assertEquals(expectedSetExamScoreTest, actualExamScoreTest);
    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        String expectedFirstName = "Tom";
        String expectedLastName = "Fantana";
        Double[] expectedDouble = {100.0, 150.0, 250.0};
        Student student = new Student(expectedFirstName, expectedLastName, expectedDouble);

        // When
        String actualGetAverageExamScoreTest = student.getAverageExamScore();
        String expectedGetAverageExamScoreTest = "166.67";

        // Then
        Assert.assertEquals(expectedGetAverageExamScoreTest, actualGetAverageExamScoreTest);
    }

    @Test
    public void toStringTest(){
        //Given
        String firstName = "Tom";
        String lastName = "Fantana";
        Double[] examScores = {100.0, 150.0, 250.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String actualToStringTest = student.toString();
        String expectedToStringTest= "Student Name: Tom Fantana\n> Average Score: 166.67\n> Exam Scores:\nExam 1 -> 100.0\nExam 2 -> 150.0\nExam 3 -> 250.0";

        // Then
        Assert.assertEquals(expectedToStringTest, actualToStringTest);
        }

    }


