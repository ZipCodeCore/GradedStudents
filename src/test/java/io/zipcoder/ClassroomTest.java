package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ClassroomTest {

    Classroom testClassroom;
    Student markyMaple;
    Student rickyRipple;
    Student dannyDoughnuts;
    Student terriTapeworm;
    Student mikeyMink;
    Student daveyDustbowl;
    Student timmyTuna;
    Student tommyToggle;
    Student joeyJoystick;
    Student robbyRaisin;
    Student[] aTestStudentArray;


    @Before
    public void setup() {
        markyMaple = new Student("Marky", "Maple", new Double[]{92.5, 88.0, 90.0});
        rickyRipple = new Student("Ricky", "Ripple", new Double[]{75.0, 68.0, 84.5});
        dannyDoughnuts = new Student("Danny", "Doughnuts", new Double[]{88.5, 86.0, 92.0});
        terriTapeworm = new Student("Terri", "Tapeworm", new Double[]{92.5, 88.0, 90.0});
        mikeyMink = new Student("Mikey", "Mink", new Double[]{64.5, 70.5, 78.0});
        daveyDustbowl = new Student("Davey", "Dustbowl", new Double[]{64.5, 70.5, 78.0});
        timmyTuna = new Student("Timmy", "Tuna", new Double[]{60.5, 70.0, 80.0});
        tommyToggle = new Student("Tommy", "Toggle", new Double[]{94.0, 88.0, 80.5});
        joeyJoystick = new Student("Joey", "Joystick", new Double[]{88.0, 83.5, 89.0});
        robbyRaisin = new Student("Robby", "Raisin", new Double[]{97.5, 93.5, 90.0});

        aTestStudentArray = new Student[]{markyMaple, rickyRipple, dannyDoughnuts, terriTapeworm, mikeyMink,
                daveyDustbowl, timmyTuna, tommyToggle, joeyJoystick, robbyRaisin};

        testClassroom = new Classroom(aTestStudentArray);
    }

    @Test
    public void defaultConstructorTest() {
        Classroom constructorClassroom = new Classroom();
        int expectedSize = 30;
        int actualSize = constructorClassroom.students.length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void constructorWithMaxSizeTest() {
        int maxNumberOfStudents = 15;
        Classroom constructorClassroom = new Classroom(maxNumberOfStudents);
        int expectedSize = 15;
        int actualSize = constructorClassroom.students.length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void constructorGivenArray() {
        Student[] testStudents = {};
        Classroom constructorClassroom = new Classroom(testStudents);
        int expectedSize = 0;
        int actualSize = constructorClassroom.students.length;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getStudentsTest() {
        Student[] expected = aTestStudentArray;
        Student[] actual = testClassroom.getStudents();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getClassTotalExamScoreTest() {
        double expected = 2475.5;
        double actual = testClassroom.getClassTotalExamScore();
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void getClassTotalCountOfExams() {
        int expected = 30;
        int actual = testClassroom.getClassTotalCountOfExams();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getClassAverageExamScoreTest() {
        double expected = 82.52;
        double actual = testClassroom.getClassAverageExamScore();
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void addStudentTest1() {
        int maxNumberOfStudents = 3;
        Classroom aDifferentTestClassroom = new Classroom(maxNumberOfStudents);
        aDifferentTestClassroom.addStudent("Newkid", "Ontheblock", new Double[]{84.0});
        String expected = "[Student Name: Newkid Ontheblock\n" +
                "> Average Score: 84.0\n" +
                "> Exam Scores:\n\tExam 1 -> 84.0\n, null, null]";
        String actual = Arrays.toString(aDifferentTestClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest2() {
        int maxNumberOfStudents = 1;
        Classroom aDifferentTestClassroom = new Classroom(maxNumberOfStudents);
        aDifferentTestClassroom.addStudent("Newkid", "Ontheblock", new Double[]{84.0});
        String expected = "[Student Name: Newkid Ontheblock\n" +
                "> Average Score: 84.0\n" +
                "> Exam Scores:\n\tExam 1 -> 84.0\n]";
        String actual = Arrays.toString(aDifferentTestClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest3() {
        Student russRussell;
        Student[] anotherTestStudentArray;

        russRussell = new Student("Russ", "Russell", new Double[]{88.0, 83.5, 89.0});
        anotherTestStudentArray = new Student[]{russRussell};

        Classroom aDifferentTestClassroom = new Classroom(anotherTestStudentArray);
        aDifferentTestClassroom.addStudent("Phil", "Phillips", new Double[]{66.0});

        String expected = "[Student Name: Russ Russell\n" +
                "> Average Score: 86.83\n" +
                "> Exam Scores:\n\tExam 1 -> 88.0\n\tExam 2 -> 83.5\n\tExam 3 -> 89.0\n" +
                ", Student Name: Phil Phillips\n" +
                "> Average Score: 66.0\n> Exam Scores:\n\tExam 1 -> 66.0\n]";
        String actual = Arrays.toString(aDifferentTestClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeStudentTest() {
        int maxNumberOfStudents = 2;
        Classroom aDifferentTestClassroom = new Classroom(maxNumberOfStudents);
        aDifferentTestClassroom.addStudent("Marky", "Maple", new Double[]{92.5, 88.0, 90.0});
        aDifferentTestClassroom.addStudent("Danny", "Doughnuts", new Double[]{88.5, 86.0, 92.0});
        aDifferentTestClassroom.addStudent("Timmy", "Tuna", new Double[]{60.5, 70.0, 80.0});
        aDifferentTestClassroom.removeStudent("Danny", "Doughnuts");
        String expected = "[Student Name: Marky Maple\n" +
                "> Average Score: 90.17\n" +
                "> Exam Scores:\n\tExam 1 -> 92.5\n\tExam 2 -> 88.0\n\tExam 3 -> 90.0\n" +
                ", Student Name: Timmy Tuna\n" +
                "> Average Score: 70.17\n" +
                "> Exam Scores:\n\tExam 1 -> 60.5\n\tExam 2 -> 70.0\n\tExam 3 -> 80.0\n" +
                ", null]";
        String actual = Arrays.toString(aDifferentTestClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest() {
        int maxNumberOfStudents = 2;
        Classroom aDifferentTestClassroom = new Classroom(maxNumberOfStudents);
        aDifferentTestClassroom.addStudent("Danny", "Doughnuts", new Double[]{88.5, 86.0, 92.0});
        aDifferentTestClassroom.addStudent("Marky", "Maple", new Double[]{92.5, 88.0, 90.0});
        aDifferentTestClassroom.addStudent("Timmy", "Tuna", new Double[]{60.5, 70.0, 80.0});
        aDifferentTestClassroom.addStudent("Benny", "Burrito", new Double[]{88.83});

        String expected = "[Student Name: Marky Maple\n" +
                "> Average Score: 90.17\n" +
                "> Exam Scores:\n\tExam 1 -> 92.5\n\tExam 2 -> 88.0\n\tExam 3 -> 90.0\n" +
                ", Student Name: Benny Burrito\n" +
                "> Average Score: 88.83\n" +
                "> Exam Scores:\n\tExam 1 -> 88.83\n" +
                ", Student Name: Danny Doughnuts\n" +
                "> Average Score: 88.83\n" +
                "> Exam Scores:\n\tExam 1 -> 88.5\n\tExam 2 -> 86.0\n\tExam 3 -> 92.0\n" +
                ", Student Name: Timmy Tuna\n" +
                "> Average Score: 70.17\n" +
                "> Exam Scores:\n\tExam 1 -> 60.5\n\tExam 2 -> 70.0\n\tExam 3 -> 80.0\n" +
                "]";
        String actual = Arrays.toString(aDifferentTestClassroom.getStudentsByScore());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emptySeatTest1() {
        int maxNumberOfStudents = 1;
        Classroom aDifferentTestClassroom = new Classroom(maxNumberOfStudents);
        Assert.assertTrue(aDifferentTestClassroom.isThereAnEmptySeat());
    }

    @Test
    public void emptySeatTest2() {
        Student russRussell;
        Student[] anotherTestStudentArray;
        russRussell = new Student("Russ", "Russell", new Double[]{88.0, 83.5, 89.0});
        anotherTestStudentArray = new Student[]{russRussell};
        Classroom aDifferentTestClassroom = new Classroom(anotherTestStudentArray);
        Assert.assertFalse(aDifferentTestClassroom.isThereAnEmptySeat());
    }

    @Test
    public void sortNullValuesToEndTest() {
        Student russRussell;
        Student philPhillips;
        Student[] anotherTestStudentArray;
        russRussell = new Student("Russ", "Russell", new Double[]{83.5});
        philPhillips = new Student("Phil", "Phillips", new Double[]{88.0});
        anotherTestStudentArray = new Student[]{russRussell, null, philPhillips};
        Classroom aDifferentTestClassroom = new Classroom(anotherTestStudentArray);
        aDifferentTestClassroom.sortNullValuesToEnd();
        String expected = "[Student Name: Russ Russell\n" +
                "> Average Score: 83.5\n" +
                "> Exam Scores:\n\tExam 1 -> 83.5\n" +
                ", Student Name: Phil Phillips\n" +
                "> Average Score: 88.0\n" +
                "> Exam Scores:\n\tExam 1 -> 88.0\n" +
                ", null]";
        String actual = Arrays.toString(aDifferentTestClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest1() {
        testClassroom.getGradeBook();
        String expected = "A";
        String actual = testClassroom.gradeBook.get(robbyRaisin);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest2() {
        testClassroom.getGradeBook();
        String expected = "C";
        String actual = testClassroom.gradeBook.get(tommyToggle);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest3() {
        testClassroom.getGradeBook();
        String expected = "F";
        String actual = testClassroom.gradeBook.get(timmyTuna);
        Assert.assertEquals(expected, actual);
    }

}