package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void ClassroomMaxStudentsTest1() {
        //Given
        int maxNumberOfStudents = 25;
        Classroom testClassroom = new Classroom(maxNumberOfStudents);

        //When
        int expected = 25;
        int actual = testClassroom.getStudents().length;

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void ClassroomMaxStudentsTest2() {
        //Given
        int maxNumberOfStudents = 25;
        Classroom testClassroom = new Classroom(maxNumberOfStudents);

        //When
        int expected = 20;
        int actual = testClassroom.getStudents().length;

        //Then
        Assert.assertNotEquals(expected, actual);

    }

    @Test
    public void ClassroomStudentsArrayTest1() {
        //Given
        Double[] testScores1 = {88.0, 75.0, 91.0};
        Double[] testScores2 = {55.0, 77.0, 82.0};
        Student student1 = new Student("Bobby", "Rickit", testScores1);
        Student student2 = new Student("Sarah", "Jones", testScores2);
        Student[] testStudents = {student1, student2};
        Classroom testClassroom = new Classroom(testStudents);

        //When
        int expected = 2;
        int actual = testClassroom.getStudents().length;

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ClassroomStudentsArrayTest2() {
        //Given
        Double[] testScores1 = {88.0, 75.0, 91.0};
        Double[] testScores2 = {55.0, 77.0, 82.0};
        Student student1 = new Student("Bobby", "Rickit", testScores1);
        Student student2 = new Student("Sarah", "Jones", testScores2);
        Student[] testStudents = {student1, student2};
        Classroom testClassroom = new Classroom(testStudents);

        //When
        int expected = 1;
        int actual = testClassroom.getStudents().length;

        //Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void ClassroomNullaryTest1() {
        //Given
        Classroom testClassroom = new Classroom();

        //When
        int expected = 30;
        int actual = testClassroom.getStudents().length;

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ClassroomNullaryTest2() {
        //Given
        Classroom testClassroom = new Classroom();

        //When
        int expected = 15;
        int actual = testClassroom.getStudents().length;

        //Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getStudentsTest1() {
        //Given
        Double[] testScores1 = {88.0, 75.0, 91.0};
        Student student1 = new Student("Bobby", "Rickit", testScores1);
        Student[] testStudents = {student1};
        Classroom testClassroom = new Classroom(testStudents);

        //When
        String expected = "[Student Name: Bobby Rickit\n" +
                "> Average Score: 85.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 88.0\n" +
                "\t\tExam 2 -> 75.0\n" +
                "\t\tExam 3 -> 91.0\n" +
                "]";
        String actual = Arrays.toString(testClassroom.getStudents());

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsTest2() {
        //Given
        Double[] testScores1 = {88.0, 75.0, 91.0};
        Student student1 = new Student("Frank", "Thomas", testScores1);
        Student[] testStudents = {student1};
        Classroom testClassroom = new Classroom(testStudents);

        //When
        String expected = "[Student Name: Bobby Rickit\n" +
                "> Average Score: 85.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 88.0\n" +
                "\t\tExam 2 -> 75.0\n" +
                "\t\tExam 3 -> 91.0\n" +
                "]";
        String actual = Arrays.toString(testClassroom.getStudents());

        //Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void getAverageExamScoreTest1() {
        //Given
        Double[] s1Scores = {100.0, 90.00};
        Double[] s2Scores = {97.00, 88.00};
        Student s1 = new Student("Ben", "Jeeves", s1Scores);
        Student s2 = new Student("Billy", "Blanks", s2Scores);

        Student[] students = {s1, s2};
        Classroom testClassroom = new Classroom(students);

        //When
        double expected = 94.0;
        double actual = testClassroom.getAverageExamScores();

        //Then
        Assert.assertEquals(expected, actual, .01);

    }

    @Test
    public void getAverageExamScoreTest2() {
        //Given
        Double[] s1Scores = {100.0, 90.0, 88.0};
        Double[] s2Scores = {97.0, 88.0, 99.0, 90.0};
        Student s1 = new Student("Ben", "Jeeves", s1Scores);
        Student s2 = new Student("Billy", "Blanks", s2Scores);

        Student[] students = {s1, s2};
        Classroom testClassroom = new Classroom(students);

        //When
        double expected = 94.0;
        double actual = testClassroom.getAverageExamScores();

        //Then
        Assert.assertNotEquals(expected, actual, .01);

    }

    @Test
    public void addStudentTest1() {
        //Given
        int maxNumberofStudents = 1;
        Classroom testClassroom = new Classroom(maxNumberofStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student1 = new Student("Charles", "Bean", examScores);

        //When
        testClassroom.addStudent(student1);

        //Then
        String expected = "[Student Name: Charles Bean\n" +
                "> Average Score: 125.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 100.0\n" +
                "\t\tExam 2 -> 150.0\n" +
                "\t\tExam 3 -> 250.0\n" +
                "\t\tExam 4 -> 0.0\n" +
                "]";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest2() {

        //Given
        int maxNumberofStudents = 1;
        Classroom testClassroom = new Classroom(maxNumberofStudents);
        Double[] examScores = {100.0, 150.0, 250.0};
        Student student1 = new Student("Charles", "Bean", examScores);

        //When
        testClassroom.addStudent(student1);

        //Then
        String expected = "";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void removeStudentTest1(){
        //Given
        int maxNumberofStudents = 3;
        Classroom testClassroom = new Classroom(maxNumberofStudents);
        Double[] examScores1 = {100.0, 95.0, 73.0};
        Double[] examScores2 = {88.0, 92.0, 99.0};
        Double[] examScores3 = {87.0, 80.0, 95.0};
        Student student1 = new Student("Charles", "Bean", examScores1);
        Student student2 = new Student("Vince", "Price", examScores2);
        Student student3 = new Student("Kidman", "Stevens", examScores3);

        //When
        testClassroom.addStudent(student1);
        testClassroom.addStudent(student2);
        testClassroom.addStudent(student3);
        testClassroom.removeStudent("Charles", "Bean");

        //Then
        String expected = "[Student Name: Vince Price\n" +
                "> Average Score: 93.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 88.0\n" +
                "\t\tExam 2 -> 92.0\n" +
                "\t\tExam 3 -> 99.0\n" +
                ", Student Name: Kidman Stevens\n" +
                "> Average Score: 87.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 87.0\n" +
                "\t\tExam 2 -> 80.0\n" +
                "\t\tExam 3 -> 95.0\n" +
                ", null]";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeStudentTest2(){
        //Given
        int maxNumberofStudents = 3;
        Classroom testClassroom = new Classroom(maxNumberofStudents);
        Double[] examScores1 = {100.0, 95.0, 73.0};
        Double[] examScores2 = {88.0, 92.0, 99.0};
        Double[] examScores3 = {87.0, 80.0, 95.0};
        Student student1 = new Student("Charles", "Bean", examScores1);
        Student student2 = new Student("Vince", "Price", examScores2);
        Student student3 = new Student("Kidman", "Stevens", examScores3);

        //When
        testClassroom.addStudent(student1);
        testClassroom.addStudent(student2);
        testClassroom.addStudent(student3);
        testClassroom.removeStudent("Charles", "Bean");

        //Then
        String expected = "[Student Name: Vince Price\n" +
                "> Average Score: 93.0\n" +
                "> Exam Scores:\n" +
                "\t\tExam 1 -> 88.0\n" +
                "\t\tExam 2 -> 92.0\n" +
                "\t\tExam 3 -> 99.0\n" +
                ", null]";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void sortArrayAfterRemoveStudent(){
        //Given
        Double[] examScores1 = {94.0, 95.0, 96.0};
        Double[] examScores2 = {75.0, 89.0, 91.0};
        Student student1 = new Student ("Betty", "Bop", examScores1);
        Student student2 = new Student("Bill", "Burr", examScores2);
        Student [] studentsArray = {student1, null, student2};
        Classroom testClassroom = new Classroom (studentsArray);


        //When
        testClassroom.sortArrayAfterRemoveStudent();
        Student [] expected = {student1, student2, null};
        Student [] actual = testClassroom.getStudents();
        //Then

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStudentsByScore() {
        //Given
        Double[] examScores1 = {75.0, 89.0, 91.0};
        Double[] examScores2 = {75.0, 89.0, 91.0};
        Double[] examScores3 = {94.0, 95.0, 96.0};
        Double[] examScores4 = {60.0, 50.0, 55.0};
        Student student1 = new Student("Betty", "Bop", examScores1);
        Student student2 = new Student("Bill", "Burr", examScores2);
        Student student3 = new Student("Zeke", "Blanket", examScores3);
        Student student4 = new Student("Jake", "Zibbles", examScores4);

        Student[] studentsArray = {student1,student2, student3, student4};
        Classroom testClassroom = new Classroom(studentsArray);

        Student[] expected = {student3, student1, student2, student4ls};
        System.out.println(Arrays.toString(expected));
        Student[] actual = testClassroom.getStudentsByScore();
        System.out.println(Arrays.toString(actual));

        Assert.assertEquals(expected, actual);
    }

    @Test
        public void sortScoreAndLastNameTest() {
        int maxNumberOfStudents = 2;
        Classroom testClassroom = new Classroom(maxNumberOfStudents);
        Double[] s1Scores = {95.0, 95.0};
        Double[] s2Scores = {95.0, 95.0};
        Student student1 = new Student("Charlie", "Chews", s1Scores);
        Student student2 = new Student("Becky", "Barley", s2Scores);

        int expected = 1;
        int actual = testClassroom.sortScoreAndLastName.compare(student1, student2);

        Assert.assertEquals(expected, actual);
    }

        @Test
        public void getGradeBookTest1 () {
            //Given
            int maxNumberofStudents = 3;
            Classroom testClassroom = new Classroom(maxNumberofStudents);

            //When
            String expected = null;
            String actual = testClassroom.getGradeBook();

            //Then
            Assert.assertEquals(expected, actual);
        }
    }



