package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    @Test
    public void getExamScoreTest(){
        //given
        Double[] examScores = {91.5,89.0,98.1,100.0};
        Student student = new Student("Raymond","Fitzgerald", examScores );

        //when
       String output = "Exam " + 1 + " score: " + 91.5 + "\n" +
                       "Exam " + 2 + " score: " + 89.0 + "\n" +
                       "Exam " + 3 + " score: " + 98.1 + "\n" +
                       "Exam " + 4 + " score: " + 100.0 + "\n";
        //then
        Assert.assertEquals(output, student.getExamScores());
    }
    @Test
    public void addExamTest(){
        //given
        Double[] examScore = {};
        Student student = new Student("Raymond", "Fitzgerald", examScore);

        //when
        student.addExamScore(95.0);
        String expected = "Exam " + 1 + " score: " + 95.0 + "\n";

        //then
        Assert.assertEquals(expected, student.getExamScores());
    }
    @Test
    public void setExamScoreTest(){
        //given
        Double[] examScores = {100.0};
        Student student = new Student("Raymond", "Fitzgerald", examScores);

        //when
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        //then
        System.out.println(output);
    }
    @Test
    public void getAverageTestScoreTest(){
        //given
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Raymond", "Fitzgerald", examScores);

        //when
        Double output = student.getAverageTestScores();
        Double expected = 125.0;

        //then
        Assert.assertEquals(output,expected);
    }
    @Test
    public void toStringTest() {
        // : Given
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Raymond", "Fitzgerald", examScores);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }
}