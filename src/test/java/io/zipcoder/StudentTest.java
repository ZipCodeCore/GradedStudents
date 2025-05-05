package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentTest {

    @Test
    public void TestStudentConstructor(){
        String expectedName = "Bilbo";
        String expectedLastName = "Baggins";
        Double [] testScores = {10.,15.};

        Student someStudent = new Student("Bilbo", "Baggins", testScores);

        String actualName = someStudent.getFirstName();
        String actualLastName = someStudent.getLastName();

        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedLastName,actualLastName);
    }
    @Test
    public void TestStudentName(){
        String expectedName = "Bilbo";
        String expectedLastName = "Baggins";
        Double [] testScores = {10.,15.};

        Student someStudent = new Student(null, null, testScores);

        someStudent.setFirstName("Bilbo");
        someStudent.setLastName("Baggins");


        String actualName = someStudent.getFirstName();
        String actualLastName = someStudent.getLastName();

        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedLastName,actualLastName);
    }
    @Test
    public void TestGetExamScore() {
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores ={1.3,1.2};
        Student student = new Student(firstName, lastName, examScores);
        String output = student.getExamScores();

        System.out.println(output);
    }

    @Test
    public void setExamScores() {
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {1.3,99.};
        Student student = new Student(firstName, lastName, examScores);

        String output = student.getExamScores();

        System.out.println(output);
    }

    @Test
    public void testToString() {
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {1.3,99.};
        Student student = new Student(firstName, lastName, examScores);

        System.out.println(student.toString());
    }
}