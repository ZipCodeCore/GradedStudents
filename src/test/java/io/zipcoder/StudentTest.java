package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class StudentTest {
    private Student testStudent;
    private String firstName;
    private String lastName;

    @Before
    public void Setup() {
        // Given
        firstName = "Baron";
        lastName = "Trump";
        Double[] testScores = {65.00, 75.00, 96.50, 100.00};

        // When
        testStudent = new Student(firstName, lastName, testScores);
    }

    @Test
    public void testStudentConstructor() {
        String expectedFirstName = "Baron";
        String expectedLastName = "Trump";
        String expectedTestScores = "Exam Scores: \n" +
                "\tExam 1 -> 65.0\n" +
                "\tExam 2 -> 75.0\n" +
                "\tExam 3 -> 96.5\n" +
                "\tExam 4 -> 100.0";
        // Then
        String actualFirstName = testStudent.getFirstName();
        String actualLastName = testStudent.getLastName();
        String actualTestScores = testStudent.getExamScores();

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedTestScores, actualTestScores);

    }

    @Test
    public void getExamsScoresTest() {

        String firstName = "Nialls";
        String lastName = "Harrns";
        Double[] testScores = {93.00, 92.0, 56.0, 88.00};

        Student student = new Student(firstName, lastName, testScores);

        String expected = student.getExamScores();
        String actual = "Exam Scores: \n\tExam 1 -> 93.0\n\t" +
                "Exam 2 -> 92.0\n\tExam 3 -> 56.0\n\tExam 4 -> 88.0";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest() {
        // : Given
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(85.0);
        String actual = student.getExamScores();
        String expected = "Exam Scores: \n\tExam 1 -> 85.0";
        // Then
        Assert.assertEquals(expected, actual);
    }

    // : Given
    @Test
    public void setExamScores() {


        Double[] examScores = {100.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScore(1, 150.0);
        String actual = student.getExamScores();
        String expected = "Exam Scores: \n\tExam 1 -> 150.0";
        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAverageExamScore() {

        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        double actual = student.getAverageExamScore();
        double expected = 125.0;
        // Then
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void toStringTest() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String actual = student.toString();
        String expected = "Student Name: Baron Trump\n" +
                " > Average Score: 125.0\n" +
                " > Exam Scores: \n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 150.0\n" +
                "\tExam 3 -> 250.0\n" +
                "\tExam 4 -> 0.0";
        // Then
        Assert.assertEquals(expected, actual);
    }
}