package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {
    @Test
    public void getStudents() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1, s2};
        Classroom classroom = new Classroom(students);
    }

    @Test
    public void getAverageExamScores() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1, s2};
        Classroom classroom = new Classroom(students);
    }

    @Test
    public void addStudentTest() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(student);
        int postEnrollment = classroom.getNumberOfStudents();

        Assert.assertEquals(1, postEnrollment);


    }

    @Test
    public void removeStudentTest() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(student);
        int expected = classroom.getNumberOfStudents();
        classroom.removeStudent("Leon","Hunter");
        int actual = classroom.getNumberOfStudents();

        Assert.assertEquals(expected-1,actual);
    }
}

