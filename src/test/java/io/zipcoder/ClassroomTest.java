package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void getAverageExamScoreTest() {
        // Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);


        // When
        double output = classroom.getClassAverageExamScore();

        // Then
        Assert.assertEquals(output,classroom.getClassAverageExamScore(), 0.00);
    }

    @Test
    public void addStudentTest() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudentArray();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudentArray();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void getStudentsByScoreTest() {
        // Given  // What do i need to make
        String givenFirstName1 = "Leon";
        String givenLastName1 = "Hunter";
        Double[] examScores1 = {100.0, 95.0, 123.0, 96.0};
        Student student1 = new Student(givenFirstName1, givenLastName1, examScores1);

        String givenFirstName2 = "Leon";
        String givenLastName2 = "Gamer";
        Double[] examScores2 = {100.0, 95.0, 123.0, 96.0};
        Student student2 = new Student(givenFirstName2, givenLastName2, examScores2);

        String givenFirstName3 = "Sammy";
        String givenLastName3 = "Sheen";
        Double[] examScores3 = {98.0, 95.0, 103.0, 90.0};
        Student student3 = new Student(givenFirstName3, givenLastName3, examScores3);

        Classroom classroom = new Classroom(student1, student2, student3);
        Student[] expected = {student2, student1, student3};


        // When  // Getting the actual
        Student[] actual = classroom.getStudentsByScore();


        // Then  // Test expected against actual
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeStudentTest() {
        // Given
        Double[] examScores1 = {85.0, 90.0, 95.0};
        Double[] examScores2 = {88.0, 90.0, 100.0};
        Double[] examScores3 = {80.0, 97.0, 85.0};
        Student student1 = new Student("Frank", "Kelp", examScores1);
        Student student2 = new Student("Sarah", "Blanco", examScores2);
        Student student3 = new Student("James", "Bond", examScores3);
        Student[] students = {student1, student2, student3};

        // When
        Classroom testRoom = new Classroom();
        testRoom.addStudent(student1);
        testRoom.addStudent(student2);
        testRoom.addStudent(student3);
        testRoom.removeStudent("James", "Bond");

        // Then

        System.out.println((Arrays.toString(testRoom.getStudentArray())));
        Student actual = testRoom.getStudentArray()[2];
        Assert.assertNull(actual);
    }

    @Test
    public void getGradeBookTest() {
        // Given
        Double[] examScores1 = {85.0, 90.0, 95.0};
        Double[] examScores2 = {88.0, 90.0, 90.0};
        Double[] examScores3 = {80.0, 97.0, 85.0};
        Student student1 = new Student("Frank", "Kelp", examScores1);
        Student student2 = new Student("Sarah", "Blanco", examScores2);
        Student student3 = new Student("James", "Bond", examScores3);
        Student[] students = {student1, student2, student3};

        // When
        Classroom testRoom = new Classroom(student1,student2, student3);


        // Then
        System.out.println(testRoom.getGradeBook());
    }

}
