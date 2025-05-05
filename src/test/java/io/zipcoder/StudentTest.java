package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;



public class StudentTest {

    @Test
    public void constructor1Test() {
        Student student1 = new Student("Thomas", "Jefferson");

        String expected = "Thomas Jefferson";
        String actual = student1.getFullName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructor2Test() {
        ArrayList examScores = new ArrayList();
        Student student1 = new Student("Thomas", "Jefferson", examScores);

        String expected = "Thomas Jefferson";
        String actual = student1.getFullName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFirstNameTest() {
        Student student1 = new Student("Tyrion", "Lannister");

        String expected = "Tyrion";
        String actual  = student1.getFirstName();

        Assert.assertEquals(expected, actual);
    }

   @Test
   public void setFirstNameTest() {
       Student student1 = new Student("Tyrion", "Lannister");

       String expected = "Tyrion";
       student1.setFirstName(expected);
       String actual = student1.getFirstName();

       Assert.assertEquals(expected, actual);
   }

    @Test
    public void getLastNameTest() {
        Student student1 = new Student("Tyrion", "Lannister");

        String expected = "Lannister";
        String actual = student1.getLastName();

        Assert.assertEquals(expected, actual);
    }

   @Test
    public void setLastNameTest() {
        Student student1 = new Student("Tyrion", "Lannister");

        String expected = "Lannister";
        student1.setLastName(expected);
        String actual = student1.getLastName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getFullNameTest() {
        Student student1 = new Student("Thomas", "Jefferson");

        String expected = "Thomas Jefferson";
        String actual = student1.getFullName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTakenTest() {
        Student student1 = new Student("Tyrion", "Lannister");

        student1.addExamScore(95.00);
        student1.addExamScore(78);

        ArrayList<Double> examScoresTest = new ArrayList<>();

        examScoresTest.add(95.00);
        examScoresTest.add(78.00);

        int expected = examScoresTest.size();
        int actual = student1.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest() {

        Student student1 = new Student("Tyrion", "Lannister");
        student1.addExamScore(45.00);
        student1.addExamScore(100);

        String expected =
                "\tExam 1: 45.0" +
                "\n\tExam 2: 100.0\n";

        String actual = student1.getExamScores();

        Assert.assertEquals(expected, actual);

    }


    @Test
    public void addExamScoreTest() {
        Student student1 = new Student("Tyrion", "Lannister");

        student1.addExamScore(45.00);

        int expected = 1;
        int actual = student1.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        Student student1 = new Student("Tyrion", "Lannister");
        student1.addExamScore(45.00);
        student1.addExamScore(100);

        double expected = 72.5;
        double actual = student1.getAverageExamScore();

        Assert.assertEquals(expected, actual, 2);
    }


    @Test
    public void toStringTest() {
        Student student1 = new Student("Tyrion", "Lannister");
        student1.addExamScore(45.00);
        student1.addExamScore(100);

        String expected = "\nStudent Name: Tyrion Lannister" +
                        "\n > Average Score: 72.5" +
                        "\n > Exam Scores:" +
                        "\n\tExam 1: 45.0" +
                        "\n\tExam 2: 100.0\n";

        String actual = student1.toString();

        Assert.assertEquals(expected, actual);

    }



}