package io.zipcoder;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testSetFirstName() {
        //given
        String firstName = "Stewart";
        String lastName = "Little";
        Double[] examScores = {90.0, 85.0, 99.0};
        Student newStudent = new Student(firstName, lastName, examScores);
        //when
        String actual = newStudent.getFirstName();
        //then
        Assert.assertEquals(firstName, actual);
    }

    @Test
    public void testSetLastName() {
        //given
        String firstName = "Stewart";
        String lastName = "Little";
        Double[] examScores = {90.0, 85.0, 99.0};
        Student newStudent = new Student(firstName, lastName, examScores);
        //when
        String actual = newStudent.getLastName();
        //then
        Assert.assertEquals(lastName, actual);
    }


    @Test
    public void testGetExamScores() {
        //given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student(firstName, lastName, testScores);
        //when
        String expected = "100.0 | 95.0 | 123.0 | 96.0 | ";
        String actual = student.getExamScores();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        //given
        String firstName = "Sasha";
        String lastName = "Braus";
        Double[] testScores = {90.0, 70.0, 80.0, 80.0};
        Student student = new Student(firstName, lastName, testScores);
        //when
        double expected = 80.0;
        double actual = student.getAverageTestScore();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToStringOverride() {
        //given
        String firstName = "Levi";
        String lastName = "Ackerman";
        Double[] testScores = {90.0, 80.0, 70.0};
        Student newStudent = new Student(firstName, lastName, testScores);
        //when
        String expected = "Student Name: Levi Ackerman\nAverage Score: 80.0\nExam Scores: 90.0 | 80.0 | 70.0 | ";
        String actual = newStudent.toString();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetFullName() {
        //given
        String firstName = "Reina";
        String lastName = "Collier";
        Double[] testScores = {90.0, 80.0, 70.0};
        Student newStudent = new Student(firstName, lastName, testScores);
        String expected = "Reina Collier";
        //when
        String actual = newStudent.getFullName();
        //then
        Assert.assertEquals(expected, actual);
    }

}