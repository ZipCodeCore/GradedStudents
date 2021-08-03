package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetFirstName() {
        String firstName = "Rex";
        String lastName = "Casio";
        Double[] testScores = {70.0, 80.0, 90.0};

        Student student = new Student(firstName,lastName,testScores);
        //student.setFirstName();
        String actual = student.getFirstName();

        Assert.assertEquals(firstName, actual);
    }

    @Test
    public void testGetLastName() {
        String firstName = "Rex";
        String lastName = "Casio";
        Double[] examScores = {70.0, 80.0, 90.0};

        Student student = new Student(firstName,lastName,examScores);
        String actual = student.getLastName();

        Assert.assertEquals(firstName, actual);
    }

    @Test
    public void testGetFullName() {
        String firstName = "Rex";
        String lastName = "Casio";
        Double[] examScores = {70.0, 80.0, 90.0};

        Student student = new Student(firstName,lastName,examScores);
        String expected = "Rex Casio";
        String actual = student.getFirstName() + " " +student.getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestGetExamsScores() {
        String firstName = "Rex";
        String lastName = "Casio";
        Double[] examScores = {70.0, 80.0, 90.0};

        Student student = new Student(firstName,lastName,examScores);
        String expected = "Exam Scores: \n" +
                "\tExam 1 -> 70.0\n" +
                "\tExam 2 -> 80.0\n" +
                "\tExam 3 -> 90.0\n";
        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestGetAverageExamScore() {
        String firstName = "Rex";
        String lastName = "Casio";
        Double[] examScores = {70.0, 80.0, 90.0};

        Student student = new Student(firstName, lastName, examScores);
        Double expected = 80.0;
        Double actual = student.getAverageExamScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void TestStringOverride() {
        String firstName = "Rex";
        String lastName = "Casio";
        Double[] examScores = {70.0, 80.0, 90.0};

        Student student = new Student(firstName, lastName, examScores);
        String expected = "Student Name: Rex Casio\n" +
                "> Average Score: 80.0\n" +
                "> Exam Scores: \n" +
                "\tExam 1 -> 70.0\n" +
                "\tExam 2 -> 80.0\n" +
                "\tExam 3 -> 90.0\n";
        String actual = student.toString();

        Assert.assertEquals(expected, actual);
    }
}