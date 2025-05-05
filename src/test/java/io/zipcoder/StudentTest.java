package io.zipcoder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    String expectedFirstName = "";
    String expectedLastName = "";
    Double[] examScores = {};
    Student student = new Student();


    @Before
    public void setUp() throws Exception {
        String expectedFirstName = "";
        String expectedLastName = "";
        Double[] examScores = {};
        Student student = new Student();
    }

    // @After
    //public void tearDown() throws Exception {
    //   return null;
    // }

    @Test
    public void setFirstNameTest() {
        //Given
        Student student = new Student();
        String expected = "April";
        //When
        student.setFirstName(expected);
        String actual = student.getFirstName();
        //Then
        Assert.assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);
    }

    @Test
    public void getFirstName() {
        //Given
        String expected = "Jill";
        //When
        student.getFirstName();
        String actual = student.getFirstName();
        //Then
        Assert.assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);
    }


    @Test
    public void getLastName() {
        Student student = new Student();
        String expected = "Jordan";

        // When
        student.getLastName();
        String actual = student.getLastName();

        // Then
        assertEquals(expected, actual);
    }


    @Test
    public void setLastName() {
        //Given
        Student student = new Student();
        String expected = "April";
        //When
        student.setLastName(expected);
        String actual = student.getLastName();
        //Then
        Assert.assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);
    }

    @Test
    public void getExamScores() {
        //Given
        Student student = new Student();
        Double expected = 55.00;
        //When
        student.getExamScores();
        ArrayList<Double> actual = student.getExamScores();
        //Then
        Assert.assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);
    }

    @Test
    public void addExamScore() {
        //Give
       String firstName = "Geg";
       String lastName = "Geggy";
       Double[] examScores = {100.};
       Student student = new Student();

       addExamScore();

       ArrayList<Double> actual = student.getExamScores();
       Assert.assertEquals("Exam: ", actual);
    }

    @Test
    public void setExamScores() {
        Student student = new Student();
        student.setExamScores(1, 100.);
        ArrayList<Double> actual = student.getExamScores();
        Assert.assertEquals("Exam 1: 100.00", actual);
    }

    @Test
    public void getAverageExamScore() {
        Student student = new Student();
        Double[] actual = {100., 75., 95., 100.};
        double expected = 92.5;
        Assert.assertEquals(expected, actual);

    }
}




