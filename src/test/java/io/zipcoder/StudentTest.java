package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;



public class StudentTest {
    Student student;

    @Before

    public void setStudent() {
        Double[] testScores = {89.5, 100.0, 93.5};
        student = new Student("Luke", "Williams", testScores);
    }


    @Test
    public void firstNameTest() {
        // Given
        //Student student = new Student();
        String expected = "Luke";

        // When
        student.setFirstName(expected);
        String actual = student.getFirstName();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void lastNameTest() {
        // Given
        //Student student = new Student();
        String expected = "Williams";

        // When
        student.setLastName(expected);
        String actual = student.getLastName();

        // Then
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void getNumberOfExamsTakenTest() {
        // Given
        //Student student = new Student();
        int expected = 3;

        // When
        //student.addExamScore(expected);
        int actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getExamScoresTest() {
        // Given
        //Student student = new Student();
        String expected = "Exam Scores:\n\tExam 1 -> 89.5\n\tExam 2 -> 100.0\n\tExam 3 -> 93.5";

        // When
        //student.addExamScore(expected);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void addExamScoreTest() {
        // Given
        //Student student = new Student();
        String expected = "Exam Scores:\n\tExam 1 -> 89.5\n\tExam 2 -> 100.0\n\tExam 3 -> 93.5\n\tExam 4 -> 91.0";
        student.addExamScore(91.0);
        // When
        //student.addExamScore(expected);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void setExamScoreTest() {
        // Given
        //Student student = new Student();
        String expected = "Exam Scores:\n\tExam 1 -> 65.5\n\tExam 2 -> 100.0\n\tExam 3 -> 93.5";
        student.setExamScore(1, 65.5);
        // When
        //student.addExamScore(expected);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getAverageExamScoresTest() {
        double expected = 94.0;
        double actual = student.getAverageExamScore();

        Assert.assertEquals(expected, actual, .01);
    }

    @Test
    public void toStringTest() {
        // Given
        //Student student = new Student();
        String expected = "Student Name: Luke Williams\n> Average Score: 94.0\n> Exam Scores:\n\tExam 1 -> 89.5\n\tExam 2 -> 100.0\n\tExam 3 -> 93.5\n";

        // When
        //student.addExamScore(expected);
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);

    }
}