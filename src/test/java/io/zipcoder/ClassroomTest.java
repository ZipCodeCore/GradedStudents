package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class ClassroomTest {

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("John", "Song", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void  getAverageExamScoreTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Double expected = 125.0;
        Double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void  removeStudentTest() {
        // : Given
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Double[] examScores1 = {90.0, 50.0, 70.0, 100.0};
        Double[] examScores2 = {50.0, 60.0, 30.0, 40.0};
        Student student = new Student("John", "Song", examScores);
        Student student1 = new Student ("Billy", "Bob", examScores1);
        Student student2 = new Student ("Water", "Bottle", examScores2);
        Student[] students = {student, student1, student2};


        // When
        Classroom classRoom = new Classroom(students);
        classRoom.removeStudent("Water", "Bottle");

        // Then
        Student actual = students[2];
        Assert.assertNull(actual);
    }

    @Test
    public void  getStudentsByScoreTest() {
     // : Given
        Classroom classroom = new Classroom();
        Double[] examScores = {100.0, 60.0, 80.0, 70.0};
        Double[] examScores1 = {90.0, 50.0, 70.0, 90.0};
        Double[] examScores2 = {70.0, 80.0, 50.0, 30.0};

     // : When
        Student student = new Student("John", "Song", examScores);
        Student student1 = new Student("Leon", "Hunter", examScores1);
        Student student2 = new Student("Billy", "Bob", examScores2);


        Student[] expected = {student, student1, student2};
        Student[] actual = classroom.getStudentsByScore();


    // : Then
        Assert.assertArrayEquals(expected, actual);

    }

}
