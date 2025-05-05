package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void testDefaultConstructor() {
        // Given
        String expectedfirstName = "Rose";
        String expectedlastName  = "Petal";
        // ArrayList<Double> examScore =  new ArrayList<>();
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        String examScoresStr = "Exam Scores:\n" +
                "\tExam 1 -> 100\n"  +
                "\tExam 2 -> 95\n" +
                "\tExam 3 -> 123\n" +
                "\tExam 4 -> 96\n";

        // When
        Student student = new Student(expectedfirstName,expectedlastName, examScores);

        // Then
        String actualFirstName = student.getFirstName();
        String actualLastName = student.getLastName();
        String actualScore = student.getExamScores();

        Assert.assertEquals(expectedfirstName, actualFirstName);
        Assert.assertEquals(expectedlastName, actualLastName);
        Assert.assertEquals(examScoresStr, actualScore);
    }

    @Test
    public void addExamScoreTest(){
        String expectedFirstName = "Leon";
        String expectedLastName = "Hunter";
        Double[] expectedExamScores = { };
        Student student = new Student(expectedFirstName,expectedLastName, expectedExamScores);
        student.addExamScore(100.0);
        String actual = student.getExamScores();
        System.out.println(actual);
        String expected="Exam Scores:\n"+"\tExam 1 -> 100\n";
        System.out.println(expected);
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void setExamScoreTest(){
        String expectedFirstName = "Leon";
        String expectedLastName = "Hunter";
        Double[] expectedExamScores = { 100.0,50.0,23.0};
        Student student = new Student(expectedFirstName,expectedLastName,expectedExamScores);
        student.setExamScore(2, 150.0);
        String actual = student.getExamScores();
        System.out.println(actual);
        String expected="Exam Scores:\n"+"\tExam 1 -> 100\n"+"\tExam 2 -> 150\n"+"\tExam 3 -> 23\n";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getExamScoreTest(){
        String firstName="Lad";
        String lastName="Drummand";
        Double[] examScores = { 100.0,95.0,123.0,96.0};
        Student student = new Student(firstName,lastName,examScores);
        String actual=student.getExamScores();
        System.out.println(actual);
        String expected="Exam Scores:\n"+"\tExam 1 -> 100\n"+"\tExam 2 -> 95\n"+"\tExam 3 -> 123\n"+"\tExam 4 -> 96\n";
        System.out.println(expected);
        Assert.assertEquals(expected,actual);


    }
    @Test
    public void getAverageExamScoreTest(){
        String expectedFirstName = "Leon";
        String expectedLastName = "Hunter";
        Double[] expectedExamScores = { 100.0, 150.0, 250.0,0.0 };
        Student student = new Student(expectedFirstName, expectedLastName,expectedExamScores);
        int expected=125;
        int actual = student.averageExamScore();
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void toStringTest() {
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = {100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        String actual = student.toString();
        String expected="Student Name: Leon Hunter\n"+"> Average Score: 125\n"+"> Exam Scores:\n"
                +"\tExam 1 -> 100\n"+"\tExam 2 -> 150\n"+"\tExam 3 -> 250\n"+"\tExam 4 -> 0\n";
        Assert.assertEquals(expected,actual);
    }

}