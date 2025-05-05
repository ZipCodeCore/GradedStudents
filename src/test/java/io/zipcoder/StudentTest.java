package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {



    @Test
    public void setFirstNameTest1()
    {
        Student student = new Student("James", "Madison");
        String actual = student.getFirstName();
        String expected = "James";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setFirstNameTest2 ()
    {

        Double [] testScores = {100.0, 68.0, 87.0, 91.0};
        Student student = new Student("James", "Madison", testScores);
        String actual = student.getFirstName();
        String expected = "James";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setLastName1()
    {
        Student student = new Student("Mike", "Tyson");
        String actual = student.getLastName();
        String expected = "Tyson";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public  void setLastName2()
    {
        Double [] testScores = {87.0, 90.0, 87.0, 78.0, 92.0};
        Student student = new Student("Mike","Tyson", testScores);
        String actual = student.getLastName();
        String expected = "Tyson";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setExamScores()
    {
        Double [] testScores = {100.0};
        Student student = new Student("James","Madison", testScores);

        student.setExamScore(1, 94.0);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n\t\tExam 1 -> 100\n\t\tExam 2 -> 94";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getAverageExamScoresTest()
    {
        Double [] testScores = {86.0, 91.0, 75.0, 98.0};
        Student student = new Student("James", "Madison", testScores);

        double actual = student.getAverageExamScore();
        double expected = 87.5;

        Assert.assertEquals(expected, actual, .001);
    }

    @Test
    public void overrideToStringTest()
    {
        Double [] testScores = {87.0, 98.0, 77.0, 94.0};
        Student student = new Student("James", "Madison", testScores);

        String expected = "Studnet Name: James Madison\n> Average Score 89\n> Exam Scores:\n\tExam 1 -> 87\n\tExam 2 -> 98\n\tExam 3 -> 77\n\tExam 4 -> 94\n";
        String actual = student.toString();
    }










}