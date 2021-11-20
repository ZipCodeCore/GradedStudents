package io.zipcoder;

import org.junit.Test;

public class StudentTest {

    @Test
    public void testGetExamScores(){
        //given
        String firstName = "Leon";
        String lastName ="Hunter";
        Double[] examScore = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName,lastName,examScore);
        //when
        String output = student.getExamScores();
        //Then
        System.out.println(output);
    }

    @Test
    public void testAddExamScores() {

        //given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScore = { };
        Student student = new Student(firstName, lastName, examScore);
        //when
        student.addExamScore(100.0);
        String output = student.getExamScores();
        //Then
        System.out.println(output);
    }

    @Test
    public void testSetExamScores(){
        //given
        String firstName = "Leon";
        String lastName ="Hunter";
        Double[] examScore = {100.0};
        Student student = new Student(firstName,lastName,examScore);
        //when
        student.setExamScores(0,150.0);
        String output = student.getExamScores();
        //Then
        System.out.println(output);
    }

    @Test
    public void testGetAverageExamScores(){
        //given
        String firstName = "Leon";
        String lastName ="Hunter";
        Double[] examScore = {100.0,150.0,250.0,0.0};
        Student student = new Student(firstName,lastName,examScore);
        //when
        Double output = student.getAverageScore();
        //Then
        System.out.println(output);

    }

    @Test
    public void testToString(){
        //given
        String firstName = "Leon";
        String lastName ="Hunter";
        Double[] examScore = {100.0,150.0,250.0,0.0};
        Student student = new Student(firstName,lastName,examScore);
        //when
        String output = student.toString();
        //Then
        System.out.println(output);

    }



}