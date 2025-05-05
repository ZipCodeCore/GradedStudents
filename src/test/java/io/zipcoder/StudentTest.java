package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {
    private ArrayList<Double> testScores;
    private Student testStudent;

    @Before
    public void setUp() {
        testScores = new ArrayList<>();
        testScores.add(1.0);
        testScores.add(2.0);
        testScores.add(3.0);
        testStudent = new Student("Steve", "Stevenson", testScores);
    }

    @Test
    public void firstNameSetAndGetTest() {
        String expected = "Frank";
        testStudent.setFirstName(expected);
        String actual = testStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lastNameSetandGetTest() {
        String expected = "Franklin";
        testStudent.setLastName(expected);
        String actual = testStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        int expected = 3;
        int actual = testStudent.getNumberOfExamsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest() {
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n";
        String actual = testStudent.getExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest() {
        testStudent.addExamScore(4.0);
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n" +
                "\tExam 4 -> 4.0\n";
        String actual = testStudent.getExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest() {
        testStudent.setExamScore(1, 4.0);
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 4.0\n" +
                "\tExam 3 -> 3.0\n";
        String actual = testStudent.getExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScore() {
        double expected = 2.0;
        double actual = testStudent.getAverageExamScore();
        Assert.assertEquals(expected, actual, .001);
    }

    @Test
    public void toStringTest() {
        String expected = "Student Name: Steve Stevenson\n" +
                "> Average Score: 2.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n";
        String actual = testStudent.toString();
        Assert.assertEquals(expected, actual);
    }


}