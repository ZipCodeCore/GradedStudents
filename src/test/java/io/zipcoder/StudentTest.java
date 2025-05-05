package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void StudentTest() {
        String expectedFirstName = "Johnny";
        String expectedLastName = "Tokhi";
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(100.0, 90.0));

        Student actualStudent = new Student(expectedFirstName, expectedLastName, scores);

        Assert.assertEquals(expectedFirstName, actualStudent.getFirstName());
        Assert.assertEquals(expectedLastName, actualStudent.getLastName());
    }

    @Test
    public void StudentTest2() {
        String expectedFirstName = "Johnny";
        String expectedLastName = "Tokhi";
        Double[] scores = {10.0, 20.0};

        Student actualStudent = new Student(expectedFirstName, expectedLastName, scores);

        Assert.assertEquals(expectedFirstName, actualStudent.getFirstName());
        Assert.assertEquals(expectedLastName, actualStudent.getLastName());
    }

    @Test
    public void numberOfExamsTakenTest() {
        String expectedFirstName = "Johnny";
        String expectedLastName = "Tokhi";
        ArrayList<Double> scores = new ArrayList<>(Arrays.asList(100.0, 90.0));

        Student actualStudent = new Student(expectedFirstName, expectedLastName, scores);

        Assert.assertEquals(2, actualStudent.getNumberOfExamsTaken());
    }

    @Test  //this test copied in from README
    public void getExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, examScores);
        // added this for the test
        String expected = " Exam Scores:\n" +
                " \tExam 1 -> 100\n" +
                " \tExam 2 -> 95\n" +
                " \tExam 3 -> 123\n" +
                " \tExam 4 -> 96";

        // When
        String output = student.getExamScores();

        // Then //Only made assert line
        Assert.assertEquals(expected, output);
    }

    @Test  //this test copied in from README
    public void addExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);
        // added this for the test
        String expected = " Exam Scores:\n" +
                " \tExam 1 -> 100";

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(expected, output);

    }

    @Test //this test copied in from README
    public void setExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);
        // added expected for the test
        String expected = " Exam Scores:\n" +
                " \tExam 1 -> 150";

        // When
        student.setExamScore(0, 150.0);
        String output = student.getExamScores();

        // Then // Only made assert line
        Assert.assertEquals(expected, output);
    }

    @Test //this test copied in from README
    public void getAverageExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList( 100.0, 150.0, 250.0, 0.0 ));
        Student student = new Student(firstName, lastName, examScores);
        Double expected = 125.0;

        // When
        Double output = student.getAverageExamScore();

        // Then // Only made assert line
        Assert.assertEquals(expected, output);

    }

    @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList( 100.0, 150.0, 250.0, 0.0 ));
        Student student = new Student(firstName, lastName, examScores);
        // added this for the test
        String expected = "Student Name: Leon Hunter\n" +
                "> Average Score: 125.0\n" +
                "> Exam Scores:\n" +
                " \tExam 1 -> 100\n" +
                " \tExam 2 -> 150\n" +
                " \tExam 3 -> 250\n" +
                " \tExam 4 -> 0";

        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }


}