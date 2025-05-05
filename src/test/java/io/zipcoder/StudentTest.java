package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    Student testStudent;

    @Before
    public void setPersonUp(){

        Double[] testScores = {98.0, 92.0, 96.0};
        testStudent = new Student("Joe", "Hendricks", testScores);

    }

    @Test
    public void SetFirstNameTest1() {
        // Given
        String firstName = "Bob";

        // When
        testStudent.setFirstName(firstName);
        String expected = "Bob";
        String actual = testStudent.getFirstName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void SetFirstNameTest2() {
        // Given
        String firstName = "Charlie";

        // When
        testStudent.setFirstName(firstName);
        String expected = "Bob";
        String actual = testStudent.getFirstName();

        // Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void SetLastNameTest1() {
        // Given
        String lastName = "Clooney";

        // When
        testStudent.setLastName(lastName);
        String expected = "Clooney";
        String actual = testStudent.getLastName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void SetLastNameTest2() {
        // Given
        String lastName = "Clooney";

        // When
        testStudent.setLastName(lastName);
        String expected = "Bernevda";
        String actual = testStudent.getLastName();

        // Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void GetNumberOfExamsTakenTest() {
        // Given
        Double[] testScores = {98.0, 92.0, 96.0, 87.0};
        Student testStudent = new Student("Jason", "Vorhees", testScores);

        // When
        int expected = 4;
        int actual = testStudent.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetNumberOfExamsTakenTest2() {
        // Given
        Double[] testScores = {98.0, 92.0};
        Student testStudent = new Student("Jason", "Vorhees", testScores);

        // When
        int expected = 4;
        int actual = testStudent.getNumberOfExamsTaken();

        // Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void GetExamScoresTest1() {
        //Given
        Double[] testScores = {98.0, 92.0, 96.0};
        Student testStudent = new Student("Joe", "Hendricks", testScores);

        //When
        String expected = "Exam Scores:\n\t\tExam 1 -> 98.0\n\t\tExam 2 -> 92.0\n\t\tExam 3 -> 96.0\n";
        String actual = testStudent.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetExamScoresTest2() {
        //Given
        Double[] testScores = {98.0, 92.0};
        Student testStudent = new Student("Joe", "Hendricks", testScores);

        //When
        String expected = "Exam Scores:\n\t\tExam 1 -> 98.0\n\t\tExam 2 -> 92.0\n\t\tExam 3 -> 96.0\n";
        String actual = testStudent.getExamScores();

        //Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void addExamScore1() {
        //Given
        testStudent.addExamScore(99.0);

        //When
        String expected = "Exam Scores:\n" +
                "\t\tExam 1 -> 98.0\n" +
                "\t\tExam 2 -> 92.0\n" +
                "\t\tExam 3 -> 96.0\n" +
                "\t\tExam 4 -> 99.0\n";
        String actual = testStudent.getExamScores();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addExamScore2() {
        //Given
        testStudent.addExamScore(99.0);

        //When
        String expected = "Exam Scores:\n" +
                "\t\tExam 1 -> 98.0\n" +
                "\t\tExam 2 -> 92.0\n" +
                "\t\tExam 3 -> 96.0\n";
        String actual = testStudent.getExamScores();

        //Then
        Assert.assertNotEquals(expected, actual);

    }

    @Test
    public void setExamScoreTest1() {
        // Given
        testStudent.setExamScore(1, 92.0);

        // When
        String expected = "Exam Scores:\n\t\tExam 1 -> 92.0\n\t\tExam 2 -> 92.0\n\t\tExam 3 -> 96.0\n";;
        String actual = testStudent.getExamScores();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest2() {
        // Given
        testStudent.setExamScore(1, 92.0);

        // When
        String expected = "Exam Scores:\n\t\tExam 1 -> 98.0\n\t\tExam 2 -> 92.0\n\t\tExam 3 -> 96.0\n";;
        String actual = testStudent.getExamScores();

        // Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void GetAverageExamScoreTest1() {
        //Given
        Double[] testScores = {98.0, 92.0, 96.0};
        Student testStudent = new Student("Joe", "Hendricks", testScores);

        // When
        double expected = 95.0;
        double actual = testStudent.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual, .01);
    }

    @Test
    public void GetAverageExamScoreTest2() {
        //Given
        Double[] testScores = {98.0, 92.0, 88.0};
        Student testStudent = new Student("Joe", "Hendricks", testScores);

        // When
        double expected = 95.0;
        double actual = testStudent.getAverageExamScore();

        // Then
        Assert.assertNotEquals(expected, actual, .01);
    }

    @Test
    public void toStringTest1() {
        //Given
        Double[] testScores = {98.0, 92.0, 88.0};
        Student testStudent = new Student("Joe", "Hendricks", testScores);

        String expected = "Student Name: Joe Hendricks\n" +
                "> Average Score: 93.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 98.0\n" +
                "\t\tExam 2 -> 92.0\n" +
                "\t\tExam 3 -> 88.0\n";

        // When
        String actual = testStudent.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest2() {
        //Given
        Double[] testScores = {98.0, 92.0, 88.0, 85.0, 91.0};
        Student testStudent = new Student("Joe", "Hendricks", testScores);

        String expected = "Student Name: Joe Hendricks\n" +
                "> Average Score: 93.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 98.0\n" +
                "\t\tExam 2 -> 92.0\n" +
                "\t\tExam 3 -> 88.0\n";

        // When
        String actual = testStudent.toString();

        // Then
        Assert.assertNotEquals(expected, actual);
    }
}



