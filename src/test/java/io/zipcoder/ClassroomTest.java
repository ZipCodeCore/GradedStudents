package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.TreeMap;

public class ClassroomTest {

    @Test
    public void getAverageExamScoreTest(){
        // Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students ={s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double actualAverageExamScore = classroom.getAverageExamScore();
        double expectedAverageExamScore = 125.00;

        // Then
        System.out.println(classroom.getAverageExamScore());
        Assert.assertEquals(actualAverageExamScore, expectedAverageExamScore, 0.1);
    }

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberofStudents=1;
        Double[] examScores = {100.0, 150.0, 250.0};
        Student student = new Student("Tom", "Fantana", examScores);
        Student[] students=new Student[maxNumberofStudents];
        Classroom classroom=new Classroom(students);

        // When
        classroom.addStudent(student);
        String expectedAddedStudent = "[Student Name: Tom Fantana\n> Average Score: 166.67\n> Exam Scores:\nExam 1 -> 100.0\nExam 2 -> 150.0\nExam 3 -> 250.0]";

        String actualAddedStudent = Arrays.toString(classroom.getStudents());

        // Then
        Assert.assertEquals(expectedAddedStudent, actualAddedStudent);
    }

    @Test
    public void removeStudentTest(){
        // : Given
        Double[] examScores1 = {100.0, 150.0, 250.0};
        Double[] examScores2 ={100.0, 50.0, 25.0};
        Student student1 = new Student("Tom", "Fantana", examScores1);
        Student student2 = new Student("Bob", "Smith", examScores2);
        Student[] students={student1, student2};
        Classroom classroom=new Classroom(students);

        // When
        classroom.removeStudent("Bob", "Smith");
        String expectedRemoveStudent = "[Student Name: Tom Fantana\n> Average Score: 166.67\n> Exam Scores:\nExam 1 -> 100.0\nExam 2 -> 150.0\nExam 3 -> 250.0, null]";
        String actualRemoveStudent = Arrays.toString(classroom.getStudents());

        // Then
        //System.out.println(classroom.getStudent(0));
        Assert.assertEquals(expectedRemoveStudent, actualRemoveStudent);
    }

    @Test
    public void getStudentByScoreTest(){
        // : Given
        Double[] examScores1 = {100.0, 150.0, 250.0};
        Double[] examScores2 ={100.0, 50.0, 25.0};
        Student student1 = new Student("Tom", "Fantana", examScores1);
        Student student2 = new Student("Bob", "Smith", examScores2);
        Student[] students={student1, student2};
        Classroom classroom=new Classroom(students);

        // When

        Student [] expectedArray ={student1, student2};
        Student[] actualArray = classroom.getStudentsByScore();

        // Then

        Assert.assertEquals(expectedArray, actualArray);

    }
    @Test
    public void getGradeBookTest(){
        // : Given
        Double[] examScores1 = {100.0, 100.0, 80.0};
        Double[] examScores2 ={20.0, 50.0, 25.0};
        Double[] examScores3 = {90.0, 50.0, 25.0};;
        Double[] examScores4 = {70.0, 50.0, 50.0};
        Double[] examScores5 ={90.0, 60.0, 25.0};
        Double[] examScores6 = {10.0, 20.0, 25.0};;
        Double[] examScores7 = {5.0, 100.0, 60.0};
        Double[] examScores8 ={96.0, 45.0, 25.0};
        Double[] examScores9 = {1.0, 5.0, 5.0};
        Double[] examScores10 ={35.0, 30.0, 30.0};
        Student student1 = new Student("Tom", "Fantana", examScores1);
        Student student2 = new Student("Bob", "Smith", examScores2);
        Student student3 = new Student("Frank", "Hopkins", examScores3);
        Student student4 = new Student("Tim", "Matthews", examScores4);
        Student student5 = new Student("John", "Farr", examScores5);
        Student student6 = new Student("Bill", "Ceil", examScores6);
        Student student7 = new Student("Tony", "Perry", examScores7);
        Student student8 = new Student("Fred", "McCormick", examScores8);
        Student student9 = new Student("Greg", "Red", examScores9);
        Student student10 = new Student("Sam", "Dela", examScores10);
        Student[] students={student1, student2, student3, student4, student5, student6, student7, student8, student9, student10};
        Classroom classroom=new Classroom(students);

        // When

        String expectedAStudent="A";
        String actualAStudent= classroom.getGradeBook().get(student1);

        // Then

        Assert.assertEquals(expectedAStudent, actualAStudent);

    }
    @Test
    public void getGradeBookTestForBStudent(){
        // : Given
        Double[] examScores1 = {100.0, 100.0, 80.0};
        Double[] examScores2 ={20.0, 50.0, 25.0};
        Double[] examScores3 = {90.0, 50.0, 25.0};;
        Double[] examScores4 = {70.0, 50.0, 50.0};
        Double[] examScores5 ={90.0, 60.0, 85.0};
        Double[] examScores6 = {10.0, 20.0, 25.0};;
        Double[] examScores7 = {5.0, 100.0, 60.0};
        Double[] examScores8 ={96.0, 45.0, 25.0};
        Double[] examScores9 = {1.0, 5.0, 5.0};
        Double[] examScores10 ={35.0, 30.0, 30.0};
        Student student1 = new Student("Tom", "Fantana", examScores1);
        Student student2 = new Student("Bob", "Smith", examScores2);
        Student student3 = new Student("Frank", "Hopkins", examScores3);
        Student student4 = new Student("Tim", "Matthews", examScores4);
        Student student5 = new Student("John", "Farr", examScores5);
        Student student6 = new Student("Bill", "Ceil", examScores6);
        Student student7 = new Student("Tony", "Perry", examScores7);
        Student student8 = new Student("Fred", "McCormick", examScores8);
        Student student9 = new Student("Greg", "Red", examScores9);
        Student student10 = new Student("Sam", "Dela", examScores10);
        Student[] students={student1, student2, student3, student4, student5, student6, student7, student8, student9, student10};
        Classroom classroom=new Classroom(students);

        // When

        String expectedAStudent="B";
        String actualAStudent= classroom.getGradeBook().get(student5);

        // Then

        Assert.assertEquals(expectedAStudent, actualAStudent);

    }


}
