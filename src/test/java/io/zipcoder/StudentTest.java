package io.zipcoder;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;


public class StudentTest {

    public Student dummyStudent = new Student("John", "Smith", new Double[]{65.00, 76.00, 100.00});


    @Test
    public void testGetFirstName() {
        // Given
        String expected = "John";

        // When
        Student dummyStudent = new Student("John", "Smith", new Double[]{65.00, 75.00, 100.00});

        // Then
        String actual = dummyStudent.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName() {
        // Given
        Student dummyStudent = new Student();
        String expected = "John";

        // When
        dummyStudent.setFirstName(expected);
        String actual = dummyStudent.getFirstName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLastName() {
        // Given
        String expected = "Smith";

        // When
        Student dummyStudent = new Student("John", "Smith", new Double[]{65.00, 75.00, 100.00});

        // Then
        String actual = dummyStudent.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetLastName() {
        // Given
        Student dummyStudent = new Student();
        String expected = "Smith";

        // When
        dummyStudent.setLastName(expected);
        String actual = dummyStudent.getLastName();

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetNumberOfExamsTaken() {
        // Given
        Integer expected = 3;

        // When
        Student dummyStudent = new Student("John", "Smith", new Double[]{65.00, 75.00, 100.00});

        // Then
        Integer actual = dummyStudent.getNumberOfExamsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testShowExamScores() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScoresArr = {100.0, 95.0, 123.0, 96.0};
        Student dummyStudent = new Student(firstName, lastName, examScoresArr);

        // When
        String output = dummyStudent.getExamScores();

        // Then
        System.out.println(output);
    }


    @Test
    public void testAddExamScores() {
        // : Given
        int expected = 1;
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScoresArr = {};
        Student dummyStudent = new Student(firstName, lastName, examScoresArr);

        // When
        dummyStudent.addExamScore(100.0);
        String output = dummyStudent.getExamScores();

        //Then
        System.out.println(output);

    }

    @Test
    public void testSetExamScores() {
        //Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScoresArr = {100.0, 95.0, 123.0, 96.0};
        Student dummyStudent = new Student(firstName, lastName, examScoresArr);

        // When
        dummyStudent.setExamScores(2, 100.0);
        String output = dummyStudent.getExamScores();

        // Then
        System.out.println(output);
    }

    @Test
    public void testGetExamAverage() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        double output = student.getAverageExamScore();

        // Then
        System.out.println(output);

    }


    @Test
    public void testToString() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.toString();

        // Then
        System.out.println(output);
    }
}
