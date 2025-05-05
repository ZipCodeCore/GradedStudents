package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void studentConstructorTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String expectedFirstNaME = student.getFirstName();
        String expectedLastName = student.getLastName();




        // Then
        Assert.assertEquals(expectedFirstNaME, firstName);
        Assert.assertEquals(expectedLastName, lastName);



    }

    @Test
    public void studentSetConstructorTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setFirstName("John");
        student.setLastName("Song");
        String expectedFirstNaME = "John";
        String expectedLastName = "Song";
        String actual = student.getFirstName();
        String actual2 = student.getLastName();

        // Then
        Assert.assertEquals(expectedFirstNaME, actual);
        Assert.assertEquals(expectedLastName, actual2);
    }

    @Test
    public void getExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String expectedExamScore = "Exam Scores: \n" + "\tExam 1 -> 100.0\n" + "\tExam 2 -> 95.0\n" +
                                        "\tExam 3 -> 123.0\n";

        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expectedExamScore, actual);


    }

    @Test
    public void setExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScore(1, 95.0);
        String expectedExamScore = "Exam Scores: \n" + "\tExam 1 -> 100.0\n" + "\tExam 2 -> 95.0\n" +
                "\tExam 3 -> 123.0\n";

        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expectedExamScore, actual);
    }

        @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {90.0, 90.0, 90.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String expected = "Student: Leon Hunter\n" +
		"> Average Score: 90.0\n" + "> Exam Scores: \n" + "\tExam 1 -> 90.0\n" + "\tExam 2 -> 90.0\n" +  "\tExam 3 -> 90.0\n";
        String actual = student.toString();



        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {90.0, 90.0, 90.0, 90.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        Integer expected = 4;
        Integer actual = student.getNumberOfExamsTaken();


        // Then
        Assert.assertEquals(expected, actual);
    }

}