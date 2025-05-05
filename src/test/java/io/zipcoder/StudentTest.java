package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentTest {

    @Test
    public void getNumberOfExamsTakenTest() {
        Student student = new Student("Sandy", "Pham", new Double[]{40.0, 50.0});
        Assert.assertEquals(2, (int) student.getNumberOfExamsTaken());
    }

    @Test
    public void getNumberOfExamTakenNoneTest() {
        Student student = new Student("Sandy", "Pham", null);
        Assert.assertEquals(0, (int) student.getNumberOfExamsTaken());
    }

    @Test
    public void addExamScoreTest() {
        Student student = new Student("Sandy", "Pham", new Double[]{80.0, 90.0});
        student.addExamScore(66.0);
        System.out.println(student.toString());
        Assert.assertEquals(66.0, student.getExamScore(3), 0.0001);
    }

    @Test
    public void addExamScoreNullTest() {
        Student student = new Student("Phamdy", "Sand", new Double[] {});
        student.addExamScore(80.0);
        Assert.assertEquals(80.0, student.getExamScore(1), 0.0001);
    }

    @Test
    public void setExamScoresTest() {
        Student student = new Student("Sandy", "Pham", new Double[] {80.0, 90.0});
        student.setExamScores(1, 66.0);
        System.out.println(student.toString());
        Assert.assertEquals(66.0, student.getExamScore(1), 0.0001);
    }

    @Test
    public void getAverageExamScoreTest(){
        Student student = new Student("Sandy", "Pham", new Double [] {25.0,35.0,45.0});
        System.out.println(student.toString());
        Assert.assertEquals(35.0, student.getAverageExamScore(), 0.0001);
    }
}