package io.zipcoder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class StudentTest {

    private Student studentTest;

    @Before
    public void setUp(){


    }
    @Test
    public void testGetExamScores(){
        ArrayList<Double>examScores=new ArrayList<Double>();
        Student studentTest = new Student("Mark","John",examScores);
        examScores.add(100.0);
        examScores.add(95.0);
        examScores.add(123.0);
        examScores.add(96.0);
        String expected = "Exam Scores:\n" +
                "Exam 1 -> 100.0\n"+
                "Exam 2 -> 95.0\n"+
                "Exam 3 -> 123.0\n"+
                "Exam 4 -> 96.0\n";
        String actual = studentTest.getExamScores();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testAddExamScores(){
        String firstName = "Mathew";
        String lastName = "Thomas";
        ArrayList<Double>examScores = new ArrayList<>();
        Student studentTest = new Student(firstName,lastName,examScores);

        studentTest.addExamScores(100.0);
        String expected = "Exam Scores:\n"+
                "Exam 1 -> 100.0\n";
        String actual = studentTest.getExamScores();
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void setExamScoreTest(){
        String firstName = "Mathew";
        String lastName = "Thomas";
        ArrayList<Double>examScores = new ArrayList<>();
        Student studentTest = new Student(firstName,lastName,examScores);

        studentTest.addExamScores(100.0);
        studentTest.setExamScores(1,150.0);

        String expected = "Exam Scores:\n"+
                "Exam 1 -> 150.0\n";
        String actual =studentTest.getExamScores();
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void testGetAverageExamScore(){
        String firstName = "Mathew";
        String lastName = "Thomas";
        ArrayList<Double>examScores = new ArrayList<>();
        Student studentTest = new Student(firstName,lastName,examScores);

        studentTest.addExamScores(100.0);
        studentTest.addExamScores(150.0);
        studentTest.addExamScores(250.0);
        studentTest.addExamScores(0.0);
        Double expected = 125.0;
        Double actual = studentTest.getAverageScoreForAStudent(examScores);
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testToString(){
        String firstName = "Steve";
        String lastName = "Micheal";
        ArrayList<Double>examScores = new ArrayList<>();
        Student studentTest = new Student(firstName,lastName,examScores);

        studentTest.addExamScores(100.0);
        studentTest.addExamScores(150.0);
        studentTest.addExamScores(250.0);
        studentTest.addExamScores(0.0);
        String expected = "Student Name: Steve Micheal\n" +
        "> Average Score: 125.0\n"+
                "> Exam Scores:\n"+
                    "Exam 1 -> 100.0\n"+
                    "Exam 2 -> 150.0\n"+
                    "Exam 3 -> 250.0\n"+
                    "Exam 4 -> 0.0\n";
        String actual = studentTest.toString();
        Assert.assertEquals(expected,actual);


    }




}