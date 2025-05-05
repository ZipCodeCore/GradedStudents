package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void testGetStudents(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] cohort = {s1,s2};
        Classroom testClass = new Classroom(cohort);

        ArrayList<Student> expected = new ArrayList<>(Arrays.asList(cohort));
        ArrayList<Student> actual = testClass.getStudents();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetNotStudents(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] cohort = {s1,s2};
        Classroom testClass = new Classroom(cohort);

        Student[] unexpected = {s1,s2};
        ArrayList<Student> actual = testClass.getStudents();

        Assert.assertNotEquals(unexpected,actual);
    }

    @Test
    public void testGetAverageExamScore(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] cohort = {s1,s2};
        Classroom testClass = new Classroom(cohort);

        Double expected = 125.0;
        Double actual = testClass.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNotAverageExamScore(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 26.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] cohort = {s1,s2};
        Classroom testClass = new Classroom(cohort);

        Double unexpected = 125.0;
        Double actual = testClass.getAverageExamScore();

        Assert.assertNotEquals(unexpected, actual);
    }

    @Test
    public void addStudentPositiveTest(){
        Classroom classroom = new Classroom(10);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student s1 = new Student("Leon", "Hunter", examScores);

        Integer preEnrollmentsize = classroom.getStudents().size();
        classroom.addStudent(s1);
        ArrayList postEnrollment = classroom.getStudents();

        Integer[] expected = {0,1};
        Integer[] actual = {preEnrollmentsize, postEnrollment.size()};

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void addStudentNegativeTest(){
        Classroom classroom = new Classroom(10);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student s1 = new Student("Leon", "Hunter", examScores);

        Integer preEnrollmentsize = classroom.getStudents().size();
        classroom.addStudent(s1);
        ArrayList postEnrollment = classroom.getStudents();

        Integer[] expected = {0,0};
        Integer[] actual = {preEnrollmentsize, postEnrollment.size()};

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void removeStudentPositiveTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("one", "one", s1Scores);
        Student s2 = new Student("two", "two", s2Scores);

        Student[] cohort = {s1,s2};
        Classroom testClass = new Classroom(cohort);

        testClass.removeStudent("one","one");

        Assert.assertEquals(1,testClass.students.size());

    }

    @Test
    public void removeStudentNegativeTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("one", "one", s1Scores);
        Student s2 = new Student("two", "two", s2Scores);

        Student[] cohort = {s1,s2};
        Classroom testClass = new Classroom(cohort);

        testClass.removeStudent("one","one");

        Assert.assertNotEquals(2,testClass.students.size());
    }

    @Test
    public void getStudentsByScoreTest(){
        Double[] scores1 = {1.0};
        Double[] scores2 = {2.0};
        Double[] scores3 = {3.0};
        Double[] scores4 = {4.0};
        Double[] scores5 = {5.0};
        Double[] scores6 = {6.0};

        Student s1 = new Student("1","1",scores1);
        Student s2 = new Student("2","2",scores2);
        Student s3 = new Student("3","3",scores3);
        Student s4 = new Student("4","4",scores4);
        Student s5 = new Student("5","5",scores5);
        Student s6 = new Student("6","6",scores6);

        Student[] cohort = {s4,s3,s2,s1,s6,s5};
        Student[] expected = {s1,s2,s3,s4,s5,s6};
        Classroom cohortSorted = new Classroom(cohort);
        Student[] actual = cohortSorted.getStudentsByScore();

        Assert.assertEquals(actual,expected);

    }


}
