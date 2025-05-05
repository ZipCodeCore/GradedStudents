package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    Student testStudent;


    @Before
    public void setup() {
        Double[] testScores = {98.5, 80.0, 92.5};
        testStudent = new Student("Peter", "Pan", testScores);
    }


    @Test
    public void getFirstNameTest() {
        String expected = "Peter";
        String actual = testStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstNameTest() {
        testStudent.setFirstName("Pedro");
        String expected = "Pedro";
        String actual = testStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastNameTest() {
        String expected = "Pan";
        String actual = testStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastNameTest() {
        testStudent.setLastName("Panning");
        String expected = "Panning";
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
        String expected = "\tExam 1 -> 98.5\n\tExam 2 -> 80.0\n\tExam 3 -> 92.5\n";
        String actual = testStudent.getExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest() {
        double examScore = 88.0;
        testStudent.addExamScore(examScore);
        int expected = 4;
        int actual = testStudent.getNumberOfExamsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest() {
        int examNumber = 2;
        double newScore = 86.0;
        testStudent.setExamScore(examNumber, newScore);
        String expected = "\tExam 1 -> 98.5\n\tExam 2 -> 86.0\n\tExam 3 -> 92.5\n";
        String actual = testStudent.getExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScore() {
        Double expected = 90.33;
        Double actual = testStudent.getAverageExamScore();
        Assert.assertEquals(expected, actual, 0.01);
    }

    @Test
    public void getTotalExamScoreTest() {
        double expected = 271;
        double actual = testStudent.getTotalExamScore();
        Assert.assertEquals(expected, actual, 0.005);
    }

    @Test
    public void getCountOfExamsTest() {
        int expected = 3;
        int actual = testStudent.getCountOfExams();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        String expected = "Student Name: Peter Pan\n> Average Score: 90.33\n> Exam Scores:\n" +
                "\tExam 1 -> 98.5\n" +
                "\tExam 2 -> 80.0\n" +
                "\tExam 3 -> 92.5\n";
        String actual = testStudent.toString();
        Assert.assertEquals(expected, actual);
    }


}