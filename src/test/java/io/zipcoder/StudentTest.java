package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class StudentTest {

    @Test
    public void testStudentConstructor() {
        // Given

        String expectedFirstName =  "";
        String expectedLastName = "";
        Double[] expectedTestScores = new Double[0];

        // When
        Student student = new Student(expectedFirstName, expectedLastName, expectedTestScores);

        // Then

        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();
        Double[] actualTestScores = student.getTestScores();

        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedTestScores, actualTestScores);

    }

    @Test
    public void getExamsScoresTest() {
        String firstName = "Niall";
        String lastName = "Horan";
        Double[] examScores = { 93.00, 92.0, 56.0, 88.00 };

        Student student = new Student(firstName, lastName, examScores);

        String expected = ("Exam Scores: \n\t Exam 1 -> 93\n\t Exam 2 -> 92\n\t Exam 3 -> 56\n\t Exam 4 -> 88");
        String actual = student.getExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamsScoreTest(){
        String firstName = "Scott";
        String lastName = "Weiland";
        Double[] examScores = {};
        Student student = new Student(firstName, lastName, examScores);

        student.addExamScore(100.00);

        String expected =("Exam Scores: \n\t Exam 1 -> 100");
        String actual = student.getExamScores();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScore() {
        String firstName = "Kwame";
        String lastName = "Harris";
        Double[] examScores = {95.0};
        Student student = new Student(firstName, lastName, examScores);

        student.setExamScores(1, 150.0);
        String expected = ("Exam Scores:\n\t Exam " + examNumber + " -> " + newScore);
        String actual = student.getExamScores();

        System.out.println(expected, actual);

    }

}