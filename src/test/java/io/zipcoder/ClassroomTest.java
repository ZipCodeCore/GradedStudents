package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double actual = classroom.getAverageExamScore();
        double expected = 125.0;
        // Then
        Assert.assertEquals(expected, actual, .01);
    }

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        // When
        Student preEnrollment = classroom.getStudents()[0];

        classroom.addStudent(student);
        Student postEnrollment = classroom.getStudents()[0];

        // Then
        Assert.assertNull(preEnrollment);
        Assert.assertNotNull(postEnrollment);
        Assert.assertEquals("Leon", postEnrollment.getFirstName());
    }

    @Test
    public void removeStudentTest() {
        // : Given
        int maxNumberOfStudents = 10;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student2 = new Student("Deon", "Punter", examScores);

        classroom.addStudent(student);
        classroom.addStudent(student2);
        // When
        String preRemoval = classroom.getStudents()[0].getFirstName();
        classroom.removeStudent(student.getFirstName(), student.getLastName());

        String postRemoval = classroom.getStudents()[0].getFirstName();

        // Then

        Assert.assertEquals("Deon", postRemoval);
    }

    @Test
    public void getStudentsByScoreTest() {
        int maxNumberOfStudents = 10;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores2 = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores3 = { 10.0, 15.0, 25.0, 10.0 };
        Double[] examScores4 = { 10.0, 15.0, 5.0, 0.0 };
        Student student = new Student("Leon", "Punter", examScores);
        Student student2 = new Student("Deon", "Hunter", examScores2);
        Student student3 = new Student("Teon", "Shunter", examScores3);
        Student student4 = new Student("Peon", "Bunter", examScores4);
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);

        Student[] sorted = classroom.getStudentsByScore();
        String actual = sorted[0].getFirstName();
        String expected = "Deon";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest() {
        int maxNumberOfStudents = 10;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores2 = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores3 = { 10.0, 15.0, 25.0, 10.0 };
        Double[] examScores4 = { 10.0, 15.0, 5.0, 0.0 };
        Student student = new Student("Leon", "Punter", examScores);
        Student student2 = new Student("Deon", "Hunter", examScores2);
        Student student3 = new Student("Teon", "Shunter", examScores3);
        Student student4 = new Student("Peon", "Bunter", examScores4);
        Student student5 = new Student("Zeon", "Puniter", examScores);
        Student student6 = new Student("Weon", "Hilunter", examScores2);
        Student student7 = new Student("Qeon", "Shlunter", examScores3);
        Student student8 = new Student("Eeon", "Blunter", examScores4);
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);
        classroom.addStudent(student5);
        classroom.addStudent(student6);
        classroom.addStudent(student7);
        classroom.addStudent(student8);

    }
}