package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ClassroomTestTest {

    Classroom testClassroom;
    Student[] testStudent;

   @Before
    public void setUp()  {
    Student testS1 = new Student("Luke", "Horowitz", new Double[]{100.0, 100.0, 100.0});
    Student testS2 = new Student("Kate", "Horowitz", new Double[]{95.5, 95.5, 95.5});
    Student testS3 = new Student("Jonathan", "Louis", new Double[]{87.0, 87.0, 87.0});
    Student testS4 = new Student("Rebecca", "Michelle", new Double[]{77.0, 77.0, 77.0});
    Student testS5 = new Student("David", "Michael", new Double[]{65.0, 65.0, 65.0});
    Student testS6 = new Student("Uncle", "Bob", new Double[]{100.0, 100.0, 100.0});
    Student testS7 = new Student("Silly", "Sarah", new Double[]{97.0, 97.0, 97.0});
    Student testS8 = new Student("Naughty", "Nathan", new Double[]{82.0, 82.0, 82.0});
    Student testS9 = new Student("Killer", "Kyle", new Double[]{91.0, 91.0, 91.0});
    Student testS10 = new Student("Boozed", "Betty", new Double[]{61.0, 61.0, 61.0});

    testStudent = new Student[] {testS1,testS2,testS3,testS4,testS5,testS6,testS7,testS8,testS9,testS10};
    testClassroom = new Classroom(testStudent);
    }

    @Test

   public void maxStudentsConstructorTest() {
       int maxNumberOfStudents = 20;
       Classroom testClassroom = new Classroom(maxNumberOfStudents);
       int expected = 20;
       int actual = testClassroom.students.length;

       Assert.assertEquals(expected, actual);

   }
   @Test

   public void studentsArrayConstructorTest () {
       Double[] testScores = {98.0, 54.0, 100.0};
       Student student1 = new Student("Clark", "Griswald", testScores);

       Student[] testStudents = {student1};
       Classroom testClassroom = new Classroom(testStudents);

       int expected = 1;
       int actual = testClassroom.students.length;

       Assert.assertEquals(expected, actual);

   }

    @Test

    public void clasroomDefaultConstructorTest() {

        Classroom testClassroom = new Classroom();
        int expected = 30;
        int actual = testClassroom.students.length;

        Assert.assertEquals(expected, actual);

    }


    @Test
    public void getStudentTest() {
        Double[] testScores = {98.0, 54.0, 40.0};
        Student student1 = new Student("Clark", "Griswald", testScores);

        Student[] testStudents = {student1};
        Classroom testClassroom = new Classroom(testStudents);

        Student[] expected = testStudents;
        Student[] actual = testClassroom.getStudents();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void getAverageExamScoreTest() {
        Double[] testScores = {98.0, 54.0, 40.0};
        Student student1 = new Student("Clark", "Griswald", testScores);
        Double[] testScores1 = {93.0, 74.0, 90.0};
        Student student2 = new Student("Rusty", "Nails", testScores1);

        Student[] testStudents = {student1, student2};
        Classroom testClassroom = new Classroom(testStudents);

        Double expected = 75.0;
        Double actual = testClassroom.getAverageExamScores();
        Assert.assertEquals(expected, actual,.1);
   }

    @Test
    public void addStudentTest() {
        int maxNumberOfStudents = 1;
        Classroom testClassroom = new Classroom(maxNumberOfStudents);
        Double[] testScores = {98.0, 54.0, 40.0};
        Student student1 = new Student("Clark", "Smith", testScores);

        testClassroom.addStudent(student1);

        String expected = "[Student Name: Clark Smith\n> Average Score: 64.0\n> Exam Scores:\n\tExam 1 -> 98.0\n\tExam 2 -> 54.0\n\tExam 3 -> 40.0]";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void removeStudentTest() {

        Classroom testClassroom = new Classroom(2);
        Double[] testScores = {98.0, 54.0, 40.0};
        Student student1 = new Student("Clark", "Smith", testScores);
        Double[] testScores2 = {98.0, 54.0, 40.0};
        Student student2 = new Student("Rusty", "Smith", testScores);
        testClassroom.addStudent(student1);
        testClassroom.addStudent(student2);
        testClassroom.removeStudent("Clark", "Smith");
        testClassroom.sortArrayWithNullValuesToEnd();


        String expected = "[Student Name: Rusty Smith\n> Average Score: 64.0\n> Exam Scores:\n\tExam 1 -> 98.0\n\tExam 2 -> 54.0\n\tExam 3 -> 40.0\n" + ", null]";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentByGradesTest() {

        Classroom testClassroom = new Classroom(3);
        Double[] testScores = {98.0, 98.0, 98.0};
        Student student1 = new Student("Clark", "Zues", testScores);
        Double[] testScores2 = {98.0, 98.0, 98.0};
        Student student2 = new Student("Rusty", "Smith", testScores2);
        Double[] testScores3 = {65.0, 65.0, 65.0};
        Student student3 = new Student("David", "Adams", testScores3);
        testClassroom.addStudent(student1);
        testClassroom.addStudent(student2);
        testClassroom.addStudent(student3);



        String expected = "[Student Name: Rusty Smith\n> Average Score: 98.0\n> Exam Scores:\n\tExam 1 -> 98.0\n\tExam 2 -> 98.0\n\tExam 3 -> 98.0\n, Student Name: Clark Zues\n> Average Score: 98.0\n> Exam Scores:\n\tExam 1 -> 98.0\n\tExam 2 -> 98.0\n\tExam 3 -> 98.0\n, Student Name: David Adams\n> Average Score: 65.0\n> Exam Scores:\n\tExam 1 -> 65.0\n\tExam 2 -> 65.0\n\tExam 3 -> 65.0\n]";
        String actual = Arrays.toString(testClassroom.getStudentsByScore());
        Assert.assertEquals(expected, actual);

    }

    public void getGradeBookTest() {

       testClassroom.getStudentsByScore();


    }

}



