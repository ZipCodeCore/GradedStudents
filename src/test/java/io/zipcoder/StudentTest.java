package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getFirstName(){
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);

        String expected = "Hope";
        String actual = student.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstName() {
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);

        student.setFirstName("Hope");
        String expected = "Hope";
        String actual = student.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);

        String expected = "Full";
        String actual = student.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastName() {
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);

        student.setLastName("Full");
        String expected = "Full";
        String actual = student.getLastName();
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void testAddExamScore(){
        //Given
        Double[] testScores = {98.5, 100.0};
        Student student = new Student("Hope", "Full", testScores);

        double testScore = 98.5;
        //When

        student.addExamScore(testScore);
        int expected = 3;
        int actual = student.getNumberOfExamsTaken();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetExamScores(){
        //Given
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);

        //When
        String output = student.getExamScores();
        String expected = "\tExam 1 -> 98.5\n\tExam 2 -> 100.0\n\tExam 3 -> 98.5\n";
        String actual = student.getExamScores();

        //Then
        System.out.println(output);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetExamScore(){
        //Given
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);

        int examNumber = 1;
        double newScore = 150.0;

        //When
        student.setExamScore(1, 150.0);
        String output = student.getExamScores();
        String expected = "\tExam 1 -> 150.0\n\tExam 2 -> 100.0\n\tExam 3 -> 98.5\n";
        String actual = student.getExamScores();
        //Then
        System.out.println(output);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetAverageExamScore(){
        //Given
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);


        //When
        Double expected = 99.0;


        //Then
        Double actual = student.getAverageExamScore();
        Assert.assertEquals(expected, actual, 0.01);

    }

    @Test
    public void testToString(){
        //Given
        Double[] testScores = {98.5, 100.0, 98.5};
        Student student = new Student("Hope", "Full", testScores);

        //When
        //Then
        String expected = "Student Name: Hope Full\n> Average Score: 99.0\n> Exam Scores:\n" +
                "\tExam 1 -> 98.5\n" +
                                "\tExam 2 -> 100.0\n" +
                                "\tExam 3 -> 98.5\n";
        String actual = student.toString();
        Assert.assertEquals(expected, actual);
    }


}
