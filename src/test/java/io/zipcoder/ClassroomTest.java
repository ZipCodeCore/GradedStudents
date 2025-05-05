package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ClassroomTest {

    @Test
        public void TestClassroom() {
        Classroom classroom = new Classroom(20);
        Integer expected = 20;
        Integer actual = classroom.students.length;
        Assert.assertEquals(expected, actual);
    }

    @Test
        public void TestGetAverageExamScore() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one",s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);
    }
    @Test
    public void TestgetStudentByScore(){
        Double [] s1Scores = {2.0,99.,1.,};
        Double [] s2Scores = {50.,49.,0.};
        Double [] s3Scores = {100.,100.,100.};
        Student s1 = new Student("Student","One",s1Scores);
        Student s2 = new Student("Student", "Two",s2Scores);
        Student s3 = new Student("Student", "Three", s3Scores);

        Student []students = {s1,s2,s3};
        Classroom classroom = new Classroom(students);

        Student [] expected = {s3,s1,s2};
        Student [] actual = classroom.getStudentByScore();

//        Student [] studentsDescending = classroom.getStudentByScore();
//        for(int i = 0; i < studentsDescending.length;i++){
//            System.out.println(studentsDescending[i]);
//        }
        Assert.assertEquals(expected,actual);
    }
    //Test further
    @Test
    public void TestGetGradeBook(){
//        Double [] s1Scores = {2.0,99.,1.,};
        Double[] s1Scores = {0.};
        Student s1 = new Student("Student","One",s1Scores);

        Student []students = {s1};
        Classroom classroom = new Classroom(students);

        Map<Character, Student> gradeMap = classroom.getGradeBook();

        for(int i =0; i < gradeMap.size();i++){
            System.out.println(gradeMap.get('F'));
        }
    }

}
