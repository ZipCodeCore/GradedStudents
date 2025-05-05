package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {
    private Student testStudent;
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;


    @Before
    public void setUp(){
        testScores = new ArrayList<>();
        testStudent = new Student(firstName, lastName, testScores);

    }

    @Test
    public void testSetFirstName(){
        String expected = "Arnold";
        testStudent.setFirstName(expected);
        String actual = testStudent.getFirstName();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSetLastName(){
        String expected = "Schwarma";
        testStudent.setLastName(expected);
        String actual = testStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetTotalExams(){
        testScores.add(85.0);
        testScores.add(92.0);
        testScores.add(100.0);
        Integer expected = 3;
        testStudent.setTotalExamsTaken(expected);
        Integer actual = testStudent.getTotalExamsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintTestScores(){
        testScores.add(85.0);
        testScores.add(92.0);
        testScores.add(100.0);
        String expected = "Exam Scores: \n\tExam 1 --> 85.0\n\tExam 2 --> 92.0\n\tExam 3 --> 100.0\n";
        String actual = testStudent.printTestScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddTestScores(){
        testScores.add(85.0);
        testScores.add(92.0);
        testScores.add(100.0);
        Double examScore = 70.0;
        String expected = "Exam Scores: \n\tExam 1 --> 85.0\n\tExam 2 --> 92.0\n\tExam 3 --> 100.0\n\tExam 4 --> 70.0\n";
        testStudent.addExamScore(examScore);
        String actual = testStudent.printTestScores();
        Assert.assertTrue(expected.equals(actual));

    }

    @Test
    public void testSetExamScore(){
        testScores.add(85.0);

        String expected = "Exam Scores: \n\tExam 1 --> 150.0\n";
        testStudent.setExamScore(1, 150);
        String actual = testStudent.printTestScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore(){
        testScores.add(85.0);
        testScores.add(92.0);
        testScores.add(100.0);
        testScores.add(75.0);
        Double expected = 88.0;

        Double actual = testStudent.getAverageExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testStudentToString(){
        testStudent.setFirstName("Arnold");
        testStudent.setLastName("Schwarzenegger");
        testScores.add(85.0);
        testScores.add(92.0);
        testScores.add(100.0);
        testStudent.getAverageExamScores();
        testStudent.printTestScores();

        String actual = testStudent.toString();
        System.out.println(actual);


    }
}