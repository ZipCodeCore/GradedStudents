package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void studentConstructor(){
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        //WHEN
        String expectedName = student.getFirstName();

        //THEN
        Assert.assertEquals(expectedName, firstName);
    }

    @Test
    public void getStudentNameTest (){
        //GIVEN
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        //WHEN
        String nom = student.getFirstName();
        String expected = "Leon";

        //THEN
        Assert.assertEquals(expected, nom);
        //System.out.println(nom);
    }

    @Test
    public void StudenLatNameTest (){
        //GIVEN
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        //WHEN
        String actualLasName = student.getLastName();

        //WHEN
        Assert.assertEquals(actualLasName, lastName);
    }

    @Test
    public void getAverageExamScoreTest (){
        //GIVEN
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 98.0, 78.0, 80.0, 80.0 };
        Student student = new Student(firstName, lastName, examScores);

        //WHEN
        double expected = 84;
        double actua = student.getAverageExamScore();

        //THEN
        Assert.assertEquals(expected, actua, 0.001);
    }


    @Test
    public void getnumberOfExamsTakenTest (){
        //GIVEN
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        //WHEN
        int expected = 4;
        int actual = student.getNumberOfExamsTaken();

        //THEN
        Assert.assertEquals(expected, actual);
}


}