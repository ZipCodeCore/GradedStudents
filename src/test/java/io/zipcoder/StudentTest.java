package io.zipcoder;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void testGetNotFirstName() {
        String first = "Lyon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);

        String actual = leonHunter.getFirstName();
        Assert.assertNotEquals("first", actual);

    }

    @Test
    public void testGetFirstName() {
        String first = "Lyon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);

        String actual = leonHunter.getFirstName();
        //System.out.println(actual);
        Assert.assertEquals("Lyon", actual);

    }

    @Test
    public void testSetNotFirstName() {
        String first = "Lyon";
        String last = "Hunter";
        Double[] scores = {100.0, 95.0, 123.0, 96.0};

        Student leonHunter = new Student(first, last, scores);
        leonHunter.setFirstName("Leon");

        String actual = leonHunter.firstName;
        Assert.assertNotEquals("Lyon", actual);

    }

    @Test
    public void testSetFirstName() {
        String first = "Lyon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);
        leonHunter.setFirstName("Leon");

        String actual = leonHunter.firstName;
        //System.out.println(actual);
        Assert.assertEquals("Leon", actual);

    }

    @Test
    public void testGetNotLastName() {
        String first = "Leon";
        String last = "Hynter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);

        String actual = leonHunter.getLastName();
        Assert.assertNotEquals("last", actual);

    }

    @Test
    public void testGetLastName() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);

        String actual = leonHunter.getLastName();
        //System.out.println(actual);
        Assert.assertEquals("Hunter", actual);

    }

    @Test
    public void testSetNotLastName() {
        String first = "Leon";
        String last = "Hynter";
        Double[] scores = {100.0, 95.0, 123.0, 96.0};

        Student leonHunter = new Student(first, last, scores);
        leonHunter.setLastName("Hunter");

        String actual = leonHunter.lastName;
        Assert.assertNotEquals("Hynter", actual);

    }

    @Test
    public void testSetLastName() {
        String first = "Lyon";
        String last = "Hynter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);
        leonHunter.setLastName("Hunter");

        String actual = leonHunter.lastName;
        //System.out.println(actual);
        Assert.assertEquals("Hunter", actual);

    }

    @Test
    public void testGetNotExamScores() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);

        Double[] unexpected = scores;
        ArrayList<Double> actual = leonHunter.examScores;

        Assert.assertNotEquals(unexpected,actual);

    }

    @Test
    public void testGetExamScores() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);

        ArrayList<Double> expected = new ArrayList<>(Arrays.asList(scores));
        ArrayList<Double> actual = leonHunter.examScores;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testGetNotNumberOfExamsTaken() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);
        int actual = leonHunter.getNumberOfExamsTaken();

        Assert.assertFalse(actual <= 1);

    }

    @Test
    public void testGetNumberOfExamsTaken() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);
        int actual = leonHunter.getNumberOfExamsTaken();

        Assert.assertEquals(4,actual);

    }

    @Test
    public void testGetExamsTaken() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0, 95.0, 123.0, 96.0 };

        Student leonHunter = new Student(first, last, scores);
        String actual = leonHunter.getExamsTaken();

        System.out.println("\nTest Of getExamsTaken() Method \n");
        System.out.println(actual);
        //This empirically worked as both a negative and a positive unit test

    }

    @Test
    public void testTakeExamNegative() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = {};

        Student leonHunter = new Student(first, last, scores);

        leonHunter.takeExam(100.0);
        ArrayList<Double> unexpected = new ArrayList<Double> (Arrays.asList(scores));
        ArrayList<Double> actual = leonHunter.getExamScores();

        Assert.assertNotEquals(unexpected,actual);
    }

    @Test
    public void testTakeExam() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = {};

        Student leonHunter = new Student(first, last, scores);

        leonHunter.takeExam(100.0);
        ArrayList<Double> expected = new ArrayList<Double>(){{add(100.0);}};
        ArrayList<Double> actual = leonHunter.getExamScores();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testTakeExamSysOut() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = {};

        Student leonHunter = new Student(first, last, scores);

        leonHunter.takeExam(100.0);
        String actual = leonHunter.getExamsTaken();

        System.out.println("\nTest Of takeExam() Method \n");
        System.out.println(actual);
    }

    @Test
    public void testSetExamNegative() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0 };

        Student leonHunter = new Student(first, last, scores);

        leonHunter.setExamScore(1, 150.0);
        ArrayList<Double> unexpected = new ArrayList<Double> (Arrays.asList(scores));
        ArrayList<Double> actual = leonHunter.getExamScores();

        Assert.assertNotEquals(unexpected,actual);
    }

    @Test
    public void testSetExam() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = { 100.0 };

        Student leonHunter = new Student(first, last, scores);

        leonHunter.setExamScore(1, 150.0);
        ArrayList<Double> expected = new ArrayList<Double> (Arrays.asList(150.0));
        ArrayList<Double> actual = leonHunter.getExamScores();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAverageExamScoreNegative() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = {100.0, 150.0, 250.0, 0.0};

        Student leonHunter = new Student(first, last, scores);

        Double unexpected = 0.0;
        Double actual = leonHunter.getAverageExamScore();

        Assert.assertNotEquals(unexpected, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = {100.0, 150.0, 250.0, 0.0};

        Student leonHunter = new Student(first, last, scores);

        Double expected = 125.0;
        Double actual = leonHunter.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        String first = "Leon";
        String last = "Hunter";
        Double[] scores = {100.0, 150.0, 250.0, 0.0};

        Student leonHunter = new Student(first, last, scores);

        System.out.println("\n Test toString() method \n");
        System.out.println(leonHunter.toString());
    }
}