package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {

    @Test
    public void testConstructorWithFirstNameAndLastNameAndExamScores(){
        String expectedFirstName = "Bo";
        String expectedLastName = "Lee";
        ArrayList<Double> expectedExamScore = new ArrayList<>();
        expectedExamScore.add(96.0);
        expectedExamScore.add(99.0);
        expectedExamScore.add(100.0);

        String expectedExam = "Exam Scores: \n" +
                "     Exam 1 -> 96.0\n" +
                "     Exam 2 -> 99.0\n" +
                "     Exam 3 -> 100.0\n" ;

        Student student = new Student(expectedFirstName, expectedLastName, expectedExamScore);
        String actualFirstName =  student.getFirstName();
        String actualLastName = student.getLastName();
        String actualExamScore = student.getExamScores();


        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedExam, actualExamScore);
    }

    @Test
    public void testGetExamScores() {
        ArrayList<Double> examScore = new ArrayList<>();
        Student student = new Student("Salle", "Sue", examScore);
        examScore.add(90.0);
        examScore.add(89.0);
        examScore.add(78.0);

        String actual = student.getExamScores();
        String expected = "Exam Scores: \n" +
                "     Exam 1 -> 90.0\n" +
                "     Exam 2 -> 89.0\n" +
                "     Exam 3 -> 78.0\n" ;

        Assert.assertEquals(expected, actual);
    }
    @Test
     public void testAddExamScore() {
        ArrayList<Double> examScore= new ArrayList<>();
        Student student = new Student("Salle", "Sue", examScore);
        Assert.assertEquals(true, student.addExamScore(96.0));
    }

    @Test
    public void testSetExamScores() {
        ArrayList<Double> examScore = new ArrayList<>();
        Student student = new Student("Salle", "Sue", examScore);
        examScore.add(78.0);
        student.setExamScores(0,130.0);

        String actualExam = student.getExamScores();
        String expectedExam = "Exam Scores: \n" +
                "     Exam 1 -> 130.0\n" ;
        Assert.assertEquals(expectedExam, actualExam);
    }

    @Test
    public void testGetAverageExamScore() {
        ArrayList<Double> examScore = new ArrayList<>();
        Student student = new Student("Salle", "Sue", examScore);
        examScore.add(90.0);
        examScore.add(89.0);
        examScore.add(78.0);

        double actualExamScoreAverage = student.getAverageExamScore();
        double expectedExamScoreAverage = 85.0;

        Assert.assertEquals(expectedExamScoreAverage,actualExamScoreAverage, .01);
    }

    @Test
    public void testToString() {
        ArrayList<Double> examScore = new ArrayList<>();
        Student student = new Student("Salle", "Hunter", examScore);
        examScore.add(90.0);
        examScore.add(89.0);
        examScore.add(78.0);

        String actualToString = student.toString();
        String expectedToString = " Student Name: Salle Hunter\n" +
                " > Average Score: 85.0\n" +
                " > Exam Scores: \n" +
                "     Exam 1 -> 90.0\n" +
                "     Exam 2 -> 89.0\n" +
                "     Exam 3 -> 78.0\n" +
                "\n";
        Assert.assertEquals(expectedToString,actualToString);
    }




}