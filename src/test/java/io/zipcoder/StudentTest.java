package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getFirstName(){
        //given
        String expectedFirst = "Sarah";
        Student sarah = new Student(expectedFirst, "Last name", new Double[] {99.0, 100.0}, "");
        //when
        String retrievedFirst = sarah.getFirstName();
        //then
        Assert.assertEquals(expectedFirst, retrievedFirst);
    }

    @Test
    public void getExamScoresTest(){
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores, "");
        // When
        String output = student.getExamScores();
        // Then
        System.out.println(output);
        //Exam Scores:
        //	Exam 1 -> 100
        //	Exam 2 -> 95
        //	Exam 3 -> 123
        //	Exam 4 -> 96
    }

    @Test
    public void addExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores, "");

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }
    @Test
    public void setExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores, "");

        // When
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
        //150 expected
    }
    @Test
    public void getAvgExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores, "");

        // When
        Double output = student.getAverageExamScore();

        // Then
        Assert.assertEquals(125.0,output,0);
        System.out.println(output);
    }

    @Test
    public void toStringTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores, "");

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }
}