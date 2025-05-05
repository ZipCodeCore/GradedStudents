package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getFirstNameTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        String actualFirstName = student.getFirstName();

        //then
        Assert.assertEquals(givenFirstName, actualFirstName);
    }

    @Test
    public void setFirstNameTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);
        String expected = "Jamie";

        //when
        student.setFirstName(expected);
        String actualFirstName = student.getFirstName();

        //then
        Assert.assertEquals(expected, actualFirstName);
    }
    @Test
    public void getLastNameTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        String actualLastName = student.getLastName();

        //then
        Assert.assertEquals(givenLastName, actualLastName);
    }

    @Test
    public void setLastNameTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);
        String expected = "Lewis";

        //when
        student.setLastName(expected);
        String actualLastName = student.getLastName();

        //then
        Assert.assertEquals(expected, actualLastName);
    }

    @Test
    public void getNumOfExamsTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        int numberOfExams = student.getNumberOfExamsTaken();

        //then
        Assert.assertEquals(3, numberOfExams );
    }

    @Test
    public void printScoresTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        String output = student.getExamScores();

        //then
        System.out.println(output);
    }

    @Test
    public void addScoresTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        student.addExamScore(100.0);
        String output = student.getExamScores();

        //then
        System.out.println(output);
    }

    @Test
    public void setScoresTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        student.addExamScore(100.0);
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        //then
        System.out.println(output);
    }

    @Test
    public void printAverageTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        double output = student.getAverageExamScore();

        //then
        System.out.printf("%.1f", output);
    }

    @Test
    public void overrideToStringTest(){
        //given
        String givenFirstName = "Sean";
        String givenLastName = "John";
        Double[] examScores = {82.0, 81.0, 68.5};
        Student student = new Student(givenFirstName, givenLastName, examScores);

        //when
        String expected = student.toString();

        //then
        System.out.println(expected);
    }
}