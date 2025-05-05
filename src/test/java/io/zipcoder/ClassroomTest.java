package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void testGetAverageExamScore() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }
    @Test
    public void testAddStudent(){
        // : Given
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

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
    public void testRemoveStudent() {
        Double[] examScores = { 100.0, 150.0, 250.0};
        Double[] examScores1 = { 100.0, 110.0, 250.0};
        Double[] examScores2 = { 100.0, 150.0, 290.0};
        Student student = new Student("Leon", "Hunter", examScores);
        Student student1 = new Student("Dolio", "Durant", examScores1);
        Student student2 = new Student("Kris", "Hunger", examScores2);
         String firstName="Dolio";
         String lastName="Durant";
        Student[] students = new Student[]{student,student1,student2};
        Classroom classroom = new Classroom(students);

         classroom.removeStudent(firstName, lastName);
         Student[] expected = classroom.getStudents();
         Assert.assertEquals(student, expected[0]);
         Assert.assertEquals(student2, expected[1]);

    }

    @Test
    public void getStudentsByScoreTest() {
        Double[] scores1 = new Double[]{45.0, 50.0, 55.0};
        Double[] scores2 = new Double[]{60.0, 65.0};
        Double[] scores3 = new Double[]{70.0, 70.0};
        Student student1 = new Student("Leon", "Hunter", scores1);
        Student student2 = new Student("Dolio", "Durant", scores2);
        Student student3 = new Student("Kris", "Hunger", scores3);
        Student[] newStudents = {student1, student2, student3};
        Classroom classroom = new Classroom(newStudents);

    }
    @Test
    public void getGradebookTest() {

        Double[] examScores1 = new Double[] {99.0,97.0,95.0};
        Double[] examScores2 = new Double[] {70.0,75.0,79.0};
        Student student = new Student("Leon", "Hunter", examScores1 );
        Student student1 = new Student("Kris", "Hunger", examScores2 );
        Student[] newStudents = {student, student1};
        Classroom classroom = new Classroom(newStudents);

        Map<Student,String> gradebook = classroom.getGradeBook();

        Assert.assertEquals(gradebook.get(student),"A");
        Assert.assertEquals(gradebook.get(student1),"C");


    }
}