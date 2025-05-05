package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class StudentTest {
    @Test
    public void testGetFirstName(){
        Student s = new Student("Bob", "Bobert", null);
        String expected = "Bob";
        String actual = s.getFirstName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetLastName(){
        Student s = new Student("Bob", "Bobert", null);
        String expected = "Bobert";
        String actual = s.getLastName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetExamScores(){
        String firstName = "Kai";
        String lastName = "Shields";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(80.0, 87.0, 100.0));
        Student s = new Student(firstName, lastName, examScores);

        String expected ="Exam Scores:\n" +
                " \tExam 1 -> 80.0\n" +
                " \tExam 2 -> 87.0\n" +
                " \tExam 3 -> 100.0\n";
        String actual = s.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddExamScore(){
        String firstName = "Kai";
        String lastName = "Shields";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(80.0, 87.0, 100.0));
        Student student = new Student(firstName, lastName, examScores);
        String expected ="Exam Scores:\n" +
                " \tExam 1 -> 80.0\n" +
                " \tExam 2 -> 87.0\n" +
                " \tExam 3 -> 100.0\n" +
                " \tExam 4 -> 90.0\n";

        student.addExamScore(90.0);
        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetExamScore(){
        String firstName = "Kai";
        String lastName = "Shields";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(80.0, 87.0, 100.0, 90.0));
        Student student = new Student(firstName, lastName, examScores);
        String expected ="Exam Scores:\n" +
                " \tExam 1 -> 70.0\n" +
                " \tExam 2 -> 87.0\n" +
                " \tExam 3 -> 100.0\n" +
                " \tExam 4 -> 90.0\n";

        student.setExamScores(0, 70.0);
        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAverageExamScore(){
        String firstName = "Kai";
        String lastName = "Shields";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(80.0, 87.0, 100.0, 90.0));
        Student student = new Student(firstName, lastName, examScores);
        Double expected = 89.25;

        Double actual = student.getAverageExamScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testToString(){
        String firstName = "Kai";
        String lastName = "Shields";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(80.0, 87.0, 100.0, 90.0));
        Student student = new Student(firstName, lastName, examScores);
        String expected ="Student: Kai Shields" +
                ", Average Scores: 89.25" +
                "Exam Scores:\n" +
                " \tExam 1 -> 80.0\n" +
                " \tExam 2 -> 87.0\n" +
                " \tExam 3 -> 100.0\n" +
                " \tExam 4 -> 90.0\n";
        String actual = student.toString();
        Assert.assertEquals(expected, actual);
    }

}