package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

// Some tests on visually verified (no assert equals)

public class StudentTest {

    @Test
    public void getFirstNameTest() {
        // Given
        String firstName = "Jawnski";
        Double[] examScores = {69.0};
        Student student = new Student("", firstName, "Jawner", examScores);

        // When
        String result = student.getFirstName();

        // Then
        Assert.assertEquals(result, firstName);
    }

    @Test
    public void getLastNameTest() {
        // Given
        String lastName = "Jawneroon";
        Double[] examScores = {69.1};
        Student student = new Student("", "Jawnskir", lastName, examScores);

        // When
        String result = student.getLastName();

        // Then
        Assert.assertEquals(result,lastName);
    }

    @Test
    public void setFirstNameTest() {
        // Given
        String firstName = "";
        Double[] examScores = {69.0};
        Student student = new Student("", firstName, "Jawner", examScores);

        // When
        student.setFirstName("Jawnerino");
        String result = student.getFirstName();

        // Then
        System.out.println(result);
    }

    @Test
    public void setLastNameTest() {
        // Given
        String lastName = "";
        Double[] examScores = {69.6};
        Student student = new Student("", "Jalapeno", lastName, examScores);

        // When
        student.setLastName("Calzone");
        String result = student.getLastName();

        // Then
        System.out.println(result);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        // Given
        Double[] examScores = {40.5, 13.4, 1324.1, 134.1, 664.4};

        // When
        Student student = new Student("" , "Kyle", "Sinclair", examScores);
        Integer result = student.getNumberOfExamsTaken();

        // Then
        System.out.println(result);
    }

    @Test
    public void getExamScoresTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 95.0, 123.0, 96.0};
        Student student = new Student("", firstName, lastName, examScores);

        // When
        String result = student.getExamScores();

        // Then
        System.out.println(result); // No need for Assert - User visually checks
    }

    @Test
    public void addExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student("", firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void setExamScoreTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 96.0};
        Student student = new Student("", firstName, lastName, examScores);

        // When
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void getAverageExamScore() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("", firstName, lastName, examScores);

        // When
        Double output = student.getAverageExamScore();

        // Then
        System.out.println(output);
    }

    @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("", firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }
}