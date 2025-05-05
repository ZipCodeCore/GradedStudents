package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;


public class StudentTest {

    @Test
    public void getExamScoresTest() {
        //Given
        String firstName = "Joe";
        String lastName = "Schmo";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        //When
        Student student = new Student(firstName, lastName, examScores);
        String actual = student.getExamScores();
        //Then
        String expected = "Exam Scores:\n" + "Exam 1: 100.0\n" + "Exam 2: 95.0\n" + "Exam 3: 123.0\n" + "Exam 4: 96.0\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest() {
        String firstName = "Dave";
        String lastName = "Mernher";
        Double[] examScores = {};

        Student student = new Student(firstName, lastName, examScores);
        student.addExamScore(100.0);

        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" + "Exam 1: 100.0\n";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest() {
        String firstName = "Mae";
        String lastName = "Lee";
        Double[] examScores = {100.0};

        Student student = new Student(firstName, lastName, examScores);
        student.setExamScore(0, 150.0);

        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" + "Exam 1: 150.0\n";

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAverageExamScoreTest() {
        String firstName = "Lillia";
        String lastName = "Karmak";
        Double[] examScores = {100.0, 150.0, 250.0};
        Student student = new Student(firstName, lastName, examScores);

        double actual = student.getAverageExamScore();
        double expected = 166.0;

        Assert.assertEquals(expected, actual, 0.1);
    }

    @Test
    public void toStringTest() {
        String firstName = "Ciaran";
        String lastName = "Andrews";
        Double[] examScores = {100.0, 150.0, 250.0};
        Student student = new Student(firstName, lastName, examScores);

        String actual = student.toString();
        String expected = "Student Name: " + firstName + " " + lastName + "\n" + "Average Score: 166.0\n" + "Exam Scores:\n" + "Exam 1: 100.0\n" + "Exam 2: 150.0\n" + "Exam 3: 250.0\n";

        Assert.assertEquals(expected, actual);
    }

}