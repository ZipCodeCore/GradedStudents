package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentTest {

    Student student;
    ArrayList<Double> testScores = new ArrayList<>();

    @Before
    public void setUp() {

    }

    @Test
    public void testSetFirstName() {
        Student student = new Student("Scooby", "Doo", testScores);

        String expectedFirstName = "Scooby";
        String lastName = "Doo";
        testScores.add(111.11);
        testScores.add(66.09);
        testScores.add(105.05);

        student.setFirstName(expectedFirstName);
        String actualName = student.getFirstName();

        Assert.assertEquals(expectedFirstName, actualName);
    }

    @Test
    public void testSetLastName() {
        Student student = new Student("Bruce", "Wayne", testScores);

        String firstName = "Bruce";
        String expectedlastName = "Wayne";
        testScores.add(200.00);
        testScores.add(139.00);
        testScores.add(80.40);

        student.setLastName(expectedlastName);
        String actualName = student.getLastName();

        Assert.assertEquals(expectedlastName, actualName);
    }

    @Test
    public void testGetFirstName() {
        Student student = new Student("Clark", "Kent", testScores);

        String expectedFirstName = "Clark";
        String lastName = "Kent";
        testScores.add(170.07);
        testScores.add(145.00);
        testScores.add(90.65);

        String actualName = student.getFirstName();

        Assert.assertEquals(expectedFirstName, actualName);
    }

    @Test
    public void testGetLastName() {
        Student student = new Student("Nancy", "Drew", testScores);

        String firstName = "Nancy";
        String expectedLastName = "Drew";
        testScores.add(100.4);
        testScores.add(160.10);
        testScores.add(114.78);

        String actualName = student.getLastName();

        Assert.assertEquals(expectedLastName, actualName);
    }

    @Test
    public void testGetNumberOfExamsTaken() {
        Student student = new Student("Fred", "Flinstone", testScores);

        String firstName = "Fred";
        String lastName = "Flinstone";
        testScores.add(60.03);
        testScores.add(177.9);
        testScores.add(152.33);
        testScores.add(73.82);
        int expected = 4;

        int actual = student.getNumberOfExamsTaken();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetExamScores() {
        Student student = new Student("Fred", "Flinstone", testScores);

        String firstName = "Fred";
        String lastName = "Flinstone";
        testScores.add(60.03);
        testScores.add(177.9);
        testScores.add(152.33);
        testScores.add(73.82);
        String expected = "Exam 1-> 60.03\n" + "Exam 2-> 177.9\n" + "Exam 3-> 152.33\n" + "Exam 4-> 73.82\n";

        String actual = student.getExamScores();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAddExamScores() {
        Student student = new Student("Jimmy", "Neutron", testScores);

        String firstName = "Jimmy";
        String lastName = "Neutron";

        testScores.add(187.0);
        testScores.add(100.00);

        Double expected = 100.00;

        Double actual = student.addExamScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetExamScores() {
        Student student = new Student("Jimmy", "Neutron", testScores);

        String firstName = "Jimmy";
        String lastName = "Neutron";

        testScores.add(187.0);
        testScores.set(0, 100.00);

        Double expected = 100.00;

        Double actual = student.setExamScores();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAverageOfExams() {
        Student student = new Student("Incredible", "Hulk", testScores);

        String firstName = "Incredible";
        String lastName = "Hulk";

        testScores.add(187.0);
        testScores.add(100.00);

        Double expected = 143.50;

        Double actual = student.averageOfExams();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testToFormattedString() {
        Student student = new Student("Bruce", "Wayne", testScores);
        String expectedFirstName = "Bruce";
        String lastName = "Wayne";
        testScores.add(89.2);
        testScores.add(180.5);

        String expected = "Student Name: Bruce Wayne\n" + "Average -> " + student.averageOfExams() + "\n" + student.getExamScores();

        String actual = student.toFormattedString();
        Assert.assertEquals(expected, actual);

    }
//    @Test
//    public void testSortByAverages() {
//        ArrayList<Double> testScores1 = new ArrayList<>();
//        ArrayList<Double> testScores2 = new ArrayList<>();
//        Student student = new Student("Incredible", "Hulk", testScores1);
//        Student student2 = new Student("Iron", "Man", testScores2);
//
//        String firstName1 = "Incredible";
//        String lastName1 = "Hulk";
//
//        testScores1.add(187.0);
//
//        String firstName2 = "Iron";
//        String lastName2 = "Man";
//        testScores2.add(84.99);
//
//        String expected = "";
//
//        String actual = student.sortByAverages();
//        Assert.assertEquals(expected, actual);

//    }
}