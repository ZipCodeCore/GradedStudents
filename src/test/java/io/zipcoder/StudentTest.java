package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Luis J. Romero on 2/16/2018
 *
 * Restrictions - Ensure unit positive and negative unit tests exist per feature of the application
 */

public class StudentTest {

    private Student student;

    @Before
    public void setup() {
        //this.student = new Student();
    }

    @Test
    public void StudentDefaultConstructorPositiveTest() {

        // Given
        String expectedFirstName = "";
        String expectedLastName = "";
        Double[] expectedDoubleArray = null;
        this.student = new Student();

        // When
        String actualFirstName = this.student.getFirstName();
        String actualLastName = this.student.getLastName();
        ArrayList<Double> actualDoubleArray = this.student.getExamScoresArrayList();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedDoubleArray, actualDoubleArray);
    }

    @Test
    public void StudentFirstNameLastNameTestScoresConstructorPositiveTest() {

        // Given
        String expectedFirstName = "Adam";
        String expectedLastName = "Anderson";
        //Double[] expectedDoubleArray = new Double[0];
        Double[] expectedDoubleArray = { 1.0, 2.0, 3.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);

        // When
        String actualFirstName = this.student.getFirstName();
        String actualLastName = this.student.getLastName();
        ArrayList<Double> actualDoubleArrayList = this.student.getExamScoresArrayList();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedDoubleArrayList, actualDoubleArrayList);
    }

    /**
     * I'm writing positive tests first, and then will do negative tests at the end
     * (because I'm not as comfortable writing negative tests right now)
     */
//    public void StudentFirstNameLastNameTestScoresConstructorNegativeTest() {
//
//        // Given
//        int expectedFirstName = 1;
//        //int expectedLastName = 2;
//        String expectedLastName = "";
//        //Double[] expectedDoubleArray = new Double[0];
//        Double[] expectedDoubleArray = { 1.0, 2.0, 3.0 };
//        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
//        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);
//
//        // When
//        String actualFirstName = this.student.getFirstName();
//        String actualLastName = this.student.getLastName();
//        ArrayList<Double> actualDoubleArrayList = this.student.getExamScores();
//
//        // Then
//        Assert.assertNotEquals(expectedFirstName, actualFirstName);
//        Assert.assertEquals(expectedLastName, actualLastName);
//        Assert.assertEquals(expectedDoubleArrayList, actualDoubleArrayList);
//    }

    @Test
    public void setFirstNamePositiveTest() {

        // Given
        String expectedFirstName = "Adam";
        this.student = new Student();
        this.student.setFirstName(expectedFirstName);

        // When
        String actualFirstName = this.student.getFirstName();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void setLastNamePositiveTest() {

        // Given
        String expectedLastName = "Anderson";
        this.student = new Student();
        this.student.setLastName(expectedLastName);

        // When
        String actualLastName = this.student.getLastName();

        // Then
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void getNumberOfExamsTakenPositiveTest() {
        // Given
        String expectedFirstName = "Adam";
        String expectedLastName = "Anderson";
        int expectedNumberOfExamsTaken = 3;
        Double[] expectedDoubleArray = { 1.0, 2.0, 3.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);

        // When
        int actualNumberOfExamsTaken = this.student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expectedNumberOfExamsTaken, actualNumberOfExamsTaken);
    }

    @Test
    public void getExamScoresPositiveTest() {
        // Given
        String expectedFirstName = "Bob";
        String expectedLastName = "Berkshire";
        String expectedExamScores = "Exam Scores:\n" +
                                    " \tExam 1 -> 100.0\n" +
                                    " \tExam 2 -> 95.0\n" +
                                    " \tExam 3 -> 123.0\n" +
                                    " \tExam 4 -> 96.0";
        Double[] expectedDoubleArray = { 100.0, 95.0, 123.0, 96.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);

        // When
        String actualExamScores = this.student.getExamScores();

        // Then
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void addExamScorePositiveTest() {
        // Given
        String expectedFirstName = "Bob";
        String expectedLastName = "Berkshire";
        Double[] expectedDoubleArray = { 100.0, 95.0, 123.0, 96.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);
        double expectedAddedNumber = 50.0;

        // When
        this.student.addExamScore(expectedAddedNumber);
        double actualAddedScore = this.student.getExamScoresArrayList().get(4);

        // Then
        Assert.assertEquals(expectedAddedNumber, actualAddedScore, 0.001);
        Assert.assertEquals(expectedAddedNumber, actualAddedScore, 0.001);
    }

    @Test
    public void setExamScorePositiveTest() {
        // Given
        String expectedFirstName = "Bob";
        String expectedLastName = "Berkshire";
        Double[] expectedDoubleArray = { 100.0, 95.0, 123.0, 96.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);
        int expectedExamNumber = 1;
        int expectedIndexOfExamNumber = expectedExamNumber - 1;
        double expectedNewScore = 50.0;

        // When
        this.student.setExamScore(expectedExamNumber, expectedNewScore);
        double actualNewScore = this.student.getExamScoresArrayList().get(expectedIndexOfExamNumber);

        // Then
        Assert.assertEquals(expectedNewScore, actualNewScore, 0.001);
        //System.out.println(this.student.getExamScoresArrayList().toString());
    }

    @Test
    public void getStudentAverageExamScore() {
        // Given
        String expectedFirstName = "Bob";
        String expectedLastName = "Berkshire";
        Double[] expectedDoubleArray = { 100.0, 95.0, 123.0, 96.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);
        double expectedAverageExamScore = 103.5;

        // When
        double actualAverageExamScore = this.student.getStudentAverageExamScore();

        // Then
        Assert.assertEquals(expectedAverageExamScore, actualAverageExamScore, 0.001);
        //System.out.println(this.student.getExamScoresArrayList().toString());
    }

    @Test
    public void toStringOverridePositiveTest() {
        // Given
        String expectedFirstName = "Bob";
        String expectedLastName = "Berkshire";
        Double[] expectedDoubleArray = { 100.0, 95.0, 123.0, 96.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);
        double expectedAverageExamScore = 103.5;
        String expectedFinalToString = " Student Name: Bob Berkshire\n" +
                                       " > Average Score: 103.5\n" +
                                       " > Exam Scores:\n" +
                                       " \tExam 1 -> 100.0\n" +
                                       " \tExam 2 -> 95.0\n" +
                                       " \tExam 3 -> 123.0\n" +
                                       " \tExam 4 -> 96.0";

        // When
        String actualFinalToString = this.student.toString();

        // Then
        Assert.assertEquals(expectedFinalToString, actualFinalToString);
        //System.out.println(actualFinalToString);
    }

    @Test
    public void getLetterGradePositiveTest() {
        // Given
        String expectedFirstName = "Adam";
        String expectedLastName = "Anderson";
        //Double[] expectedDoubleArray = new Double[0];
        Double[] expectedDoubleArray = { 1.0, 2.0, 3.0 };
        ArrayList<Double> expectedDoubleArrayList = new ArrayList<Double>(Arrays.asList(expectedDoubleArray));
        this.student = new Student(expectedFirstName, expectedLastName, expectedDoubleArray);

        double expectedAverageExamScore = 2.0;
        String expectedLetterGrade = "F";

        // When
        String actualFirstName = this.student.getFirstName();
        String actualLastName = this.student.getLastName();
        double actualAverageExamScore = this.student.getStudentAverageExamScore();
        String actualLetterGrade = this.student.getLetterGrade();

        // Then
        Assert.assertEquals(expectedAverageExamScore, actualAverageExamScore, 0.001);
        Assert.assertEquals(expectedLetterGrade, actualLetterGrade);

    }

}