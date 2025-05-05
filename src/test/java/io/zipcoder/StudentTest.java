package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {


    ArrayList<Double> examScores = new ArrayList<Double>();
    Student student = new Student("Sarah","Blanding", examScores);

    @Test
    public void testConstructor() {
        //Given
        String expectedFirstName = "Sarah";
        String expectedLastName = "Blanding";
        examScores.add(200.0);
        //Then
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void testGetFirstName() {
        String expectedFirstName = "Sarah";
        String actualFirstName = student.getFirstName();
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void testGetLastName() {
        String expectedLastName = "Blanding";
        String actualLastName = student.getLastName();
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void testGetNumberOfExamsTaken() {
        int expectedNumberOfExams = 2;
        examScores.add(100.0);
        examScores.add(99.0);
        int actualNumberOfExams = student.getNumberOfExamsTaken();
        Assert.assertEquals(expectedNumberOfExams, actualNumberOfExams);
    }

    @Test
    public void testGetExamScores() {
        String expectedExamScores = "Exam Scores:\n\tExam 1 -> 150\n\tExam 2 -> 200\n\tExam 3 -> 175";
        examScores.add(150.0);
        examScores.add(200.0);
        examScores.add(175.0);
        String actualExamScores = student.getExamScores();
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }


    @Test
    public void testAddExamScores() {
        student.addExamScore(150.0);
        String output = student.getExamScores();
        System.out.println(output);
    }

    @Test
    public void testSetExamScores() {
        //Given
        ArrayList<Double> exam = new ArrayList<>(Arrays.asList(150.0));
        Student student2 = new Student("Ben", "Messick", exam);
        String originalTestScore = student2.getExamScores();
        //When
        student2.setExamScore(1,130.0);
        String changedTestScore = student2.getExamScores();
        //Then
        System.out.println(originalTestScore + "\n" + changedTestScore);
    }

    @Test
    public void testAccessTotalExamScores() {
        //Given
        double expectedTotal = 150.0 + 100.0 + 50.0 + 100.0;
        //When
        ArrayList<Double> exam = new ArrayList<>(Arrays.asList(150.0, 100.0, 50.0, 100.0));
        Student student = new Student("Ben", "Messick", exam);
        //Then
        double actualTotal = student.accessTotalExamsScore();

        Assert.assertEquals(expectedTotal, actualTotal, 0.0);
    }


    @Test
    public void testGetAverageExamScore() {
        //Given
        long expectedAverage = 100;
        //When
        ArrayList<Double> exam = new ArrayList<>(Arrays.asList(150.0, 100.0, 50.0, 100.0));
        Student student = new Student("Ben", "Messick", exam);
        //Then
        long actualAverage = student.getAverageExamScore();

        Assert.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void testToString() {
        //Given
        ArrayList<Double> exam = new ArrayList<>(Arrays.asList(150.0, 100.0, 50.0, 100.0));
        Student student2 = new Student("Ben", "Messick", exam);
        //When
        String output = student2.toString() + student.toString();
        //Then
        System.out.println(output);
    }
}