package io.zipcoder;
import org.junit.Assert;
import org.junit.Test;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    @Test
    public void getFirstName() {
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);

        String expected = "Leon";
        String actual = student.getFirstName();

        Assert.assertEquals(expected, actual);
        System.out.println(actual);
    }

    @Test
    public void getLastName() {
        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);

        String expected = "Hunter";
        String actual = student.getLastName();

        Assert.assertEquals(expected, actual);
        System.out.println(actual);
    }



    @Test
    public void getExamScoresTest() {

        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);
        String expected ="Exam Scores:\n" +
                " \tExam 1 -> 100.0\n" +
                " \tExam 2 -> 95.0\n" +
                " \tExam 3 -> 123.0\n" +
                " \tExam 4 -> 96.0\n";

        String actual = student.getExamScores();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void addExamScoreTest(){

        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);
        String expected ="Exam Scores:\n" +
                " \tExam 1 -> 100.0\n" +
                " \tExam 2 -> 95.0\n" +
                " \tExam 3 -> 123.0\n" +
                " \tExam 4 -> 96.0\n" +
                " \tExam 5 -> 100.0\n";

        student.addExamScore(100.0);
        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest(){

        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);
        String expected ="Exam Scores:\n" +
                " \tExam 1 -> 150.0\n" +
                " \tExam 2 -> 95.0\n" +
                " \tExam 3 -> 123.0\n" +
                " \tExam 4 -> 96.0\n";

        student.setExamScores(0, 150.0);
        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
        System.out.print(actual);
    }

    @Test
    public void getAverageExamScoreTest(){

        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);
        Double expected = 103.5;

        Double actual = student.getAverageExamScore();

        Assert.assertEquals(expected, actual);
        System.out.print(actual);
    }

    @Test
    public void toStringTest(){

        String firstName = "Leon";
        String lastName = "Hunter";
        ArrayList<Double> examScores = new ArrayList<Double>(Arrays.asList(100.0, 95.0, 123.0, 96.0));
        Student student = new Student(firstName, lastName, examScores);
        String expected ="Student Name: Leon Hunter\n" +
                "> Average Score: 103.5\n" +
                "> Exam Scores:\n" +
                " \tExam 1 -> 100.0\n" +
                " \tExam 2 -> 95.0\n" +
                " \tExam 3 -> 123.0\n" +
                " \tExam 4 -> 96.0\n";

        String actual = student.toString();

        Assert.assertEquals(expected, actual);
        System.out.print(actual);
    }
}