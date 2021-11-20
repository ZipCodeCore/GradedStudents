package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {

    @Test
    public void testGetAverageExamScore(){
        //given
        Double[] s1Scores = {100.0 , 150.0};
        Double[] s2Scores = {250.0,25.0};

        Student s1 = new Student("student","one",s1Scores);
        Student s2 = new Student("student","Two",s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        //When
        Double output = classroom.getAverageScore();

        //Then
        System.out.println(output);

    }

    @Test

    public void testAddStudent() {
        //given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(1);
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Leon", "Hunter", examScores);

        //When
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        //Then
        String postEnrollmentAsString = Arrays.toString(preEnrollment);
        System.out.println("----------------");
        System.out.println("preEnrollmentAsString");
        System.out.println("----------------");
        System.out.println("postEnrollmentAsString");
    }


    @Test

    public void testGetStudentByScore(){
        Double[] examScore1 = new Double[]{45.0, 50.0, 55.0};
        Double[] examScore2 = new Double[]{99.0, 65.0,99.0};
        Double[] examScore3 = new Double[]{10.0, 10.0,20.2};
        Student student1 = new Student("Leon","Hunter",examScore1);
        Student student2 = new Student("Dolio","Durant",examScore2);
        Student student3 = new Student("Kris","Younger",examScore3);

        //When
        Student[] students = new Student[]{student1, student2 , student3};
        Classroom classroom = new Classroom(students);


        //Then
        Student[] expected= classroom.getStudentByScore();
        Assert.assertEquals(expected[0],student2);
        Assert.assertEquals(expected[1],student1);
        Assert.assertEquals(expected[2],student3);


    }

    @Test

    public void testGetGradeBook(){
        Double[] examScore1 = {45.0,55.0,65.0};
        Double[] examScore2 = {90.0,95.0,99.0};

        Student student1 = new Student("Dolio","Durrant",examScore1);
        Student student2 = new Student("Leon","Hunter",examScore2);


        //When
        Student[] students = new Student[]{student1, student2};
        Classroom classroom = new Classroom(students);
        Map<Student,String> gradeBook = classroom.getGradeBook();

        //Then

        Assert.assertEquals(gradeBook.get(student1),"E");
        Assert.assertEquals(gradeBook.get(student2),"A");


    }



}
