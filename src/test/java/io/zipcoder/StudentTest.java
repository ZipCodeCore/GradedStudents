package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void constructorTest() {
        // Given
        String expectedFirstName = "Zach";
        String expectedLastName = "Kitto";
        Double[] expectedExamScores = new Double[]{95.0, 84.0, 78.0, 82.0};

        // When
        Student student = new Student(expectedFirstName, expectedLastName, expectedExamScores);
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();
        Double[] actualExamScores = student.examScores.toArray(new Double[0]);

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void addExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double expectedScore = 100.0;
        student.addExamScore(expectedScore);
        Double actualScore = student.examScores.get(0);

        // Then
        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void setExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        Double newExpectedScore = 150.0;
        student.setExamScore(0, newExpectedScore);
        Double newActualScore = student.examScores.get(0);

        // Then
        Assert.assertEquals(newExpectedScore, newActualScore);
    }
}