package io.zipcoder;


import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class StudentTest {

    Student stinkyPete;

    @Before
    public void setup(){
        String studentFirstName = "Stinky";
        String studentLastName = "Pete";
        Double[] studentTestScores = {45.67, 92.34, 100.00};
        stinkyPete = new Student(studentFirstName, studentLastName, studentTestScores);
    }

    @Test
    public void getFirstNameTest() {
        //Given
        //Student stinkyPete

        //When
        String expected = "Stinky";
        String actual = stinkyPete.getFirstName();

        //Then
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void getLastNameTest() {
        //Given
        //Student stinkyPete

        //When
        String expected = "Pete";
        String actual = stinkyPete.getLastName();

        //Then
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void setFirstNameTest() {
        //Given
        stinkyPete.setFirstName("Smelly");

        //When
        String expected = "Smelly";
        String actual = stinkyPete.getFirstName();

        //Then
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void setLastNameTest() {
        //Given
        stinkyPete.setLastName("Peter");

        //When
        String expected = "Peter";
        String actual = stinkyPete.getLastName();

        //Then
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        //Given
        //Student stinkyPete

        //When
        int expected = 3;
        int actual = stinkyPete.getNumberOfExamsTaken();

        //Then
        Assert.assertTrue(actual == expected);
    }

    @Test
    public void getExamScoresTest(){
        //Given
        //Student stinkyPete

        //When
        String expected =
                "Exam Scores:\n"+
                "\tExam 1 => 46\n" +
                "\tExam 2 => 92\n" +
                "\tExam 3 => 100\n";
        String actual = stinkyPete.getExamScores();

        //Then
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void addExamScoreTest() {
        //Given
        stinkyPete.addExamScore(98.45);

        //When
        String expected =
                "Exam Scores:\n"+
                "\tExam 1 => 46\n" +
                "\tExam 2 => 92\n" +
                "\tExam 3 => 100\n" +
                "\tExam 4 => 98\n";
        String actual = stinkyPete.getExamScores();

        //Then
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void setExamScoreTest() {
        //Given
        stinkyPete.setExamScore(1, 98.45);

        //When
        String expected =
                "Exam Scores:\n"+
                "\tExam 1 => 98\n" +
                "\tExam 2 => 92\n" +
                "\tExam 3 => 100\n";

        String actual = stinkyPete.getExamScores();

        //Then
        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void getAverageExamScoreTest() {
        //Given
        //Student stinkyPete

        //When
        int expected = 79;

        double actual = stinkyPete.getAverageExamScore();

        //Then
        Assert.assertTrue(actual == expected);
    }

    @Test
    public void toStringTest() {
        //Given
        //Student stinkyPete

        //When
        String expected =
                "Student Name: Stinky Pete\n"+
                "Average Score = 79.0\n"+
                "Exam Scores:\n"+
                "\tExam 1 => 46\n" +
                "\tExam 2 => 92\n" +
                "\tExam 3 => 100\n";

        String actual = stinkyPete.toString();

        //Then
        Assert.assertEquals(actual,expected);
    }


}