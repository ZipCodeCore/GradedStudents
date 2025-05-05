package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void getFirstName() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);

        String actual = student.getFirstName();
        String expected = "Jim";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstName() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);
        student.setFirstName("Gum");
        String actual = student.getFirstName();
        String expected = "Gum";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);

        String actual = student.getLastName();
        String expected = "Bo";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastName() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);
        student.setLastName("Bobo");
        String actual = student.getLastName();
        String expected = "Bobo";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTestScores() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);
        ArrayList actual = student.getTestScores();
        Double expected = 150.0;
        Assert.assertEquals(actual.get(1),expected);
    }

    @Test
    public void getNumberOfTestsTaken() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);
        int actual = student.getNumberOfTestsTaken();
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScores() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);
         String actual = student.getExamScores();
    }

    @Test
    public void addExamScore() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);
        int actual = student.getNumberOfTestsTaken()+1;
        student.addExamScore(100.0);
        int expected = student.getNumberOfTestsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScore() {
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Jim", "Bo", examScores);
        Double actual = student.getAverageExamScore();
        Double expected = 125.0;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void toStingTest() {
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Jim", "Bo", examScores);
        String actual = student.toString();
        String expected = "'''\n" +
                "Student Name: Jim Bo\n" +
                "Exam 01 --> 100.0\n" +
                "Exam 11 --> 150.0\n" +
                "Exam 21 --> 250.0\n" +
                "Exam 31 --> 0.0\n" +
                "\n" +
                "125.0\n" +
                "'''";
        Assert.assertEquals(expected, actual);
    }
}