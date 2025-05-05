package io.zipcoder;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void getStudentsTest() {
        int maxNumOfStudents = 4;
        Classroom class1 = new Classroom(maxNumOfStudents);
        ArrayList<Double> s1Scores = new ArrayList<>(Arrays.asList(100.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(125.0));
        ArrayList<Double> s3Scores = new ArrayList<>(Arrays.asList(150.0));
        ArrayList<Double> s4Scores = new ArrayList<>(Arrays.asList(175.0));

        Student s11 = new Student("student", "one", s1Scores);
        Student s12 = new Student("student", "two", s2Scores);
        Student s13 = new Student("student", "three", s3Scores);
        Student s14 = new Student("student", "four", s4Scores);

        ArrayList <Student> expectedStudents = new ArrayList<Student>(Arrays.asList(s11, s12, s13, s14));
        class1.studentsList = expectedStudents;
        ArrayList actual = class1.getStudents();
        ArrayList expected = expectedStudents;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAverageExamScore() {
        int maxNumOfStudents = 2;
        // : Given
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        Double expected = 125.0;

        // When
        Double output = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student s1 = new Student("Leon", "Hunter", examScores);

        String expected = " ===========================\n" +
                " []\n" +
                " ===========================\n" +
                " [Student Name: Leon Hunter\n" +
                " > Average Score: 125\n" +
                " > Exam Scores:\n" +
                "     Exam 1 -> 100\n" +
                "     Exam 2 -> 150\n" +
                "     Exam 3 -> 250\n" +
                "     Exam 4 -> 0";

        // When
        ArrayList<Student> preEnrollment = classroom.getStudents();
        classroom.addStudent(s1);
        ArrayList<Student> postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = preEnrollment.toString();
        String postEnrollmentAsString = postEnrollment.toString();

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);

    }

    @Test
    public void removeStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student s1 = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(s1);

        int actual = classroom.getStudents().size();

        // When
        ArrayList<Student> preEnrollment = classroom.getStudents();
        classroom.removeStudent(s1, s1);
        ArrayList<Student> postEnrollment = classroom.getStudents();


        Assert.assertEquals(maxNumberOfStudents, actual);
        System.out.println(maxNumberOfStudents);

    }

    @Test
    public void getStudentsByScoreTest() {

        // : Given
        ArrayList<Double> s1Scores = new ArrayList<>(Arrays.asList(100.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(125.0));
        ArrayList<Double> s3Scores = new ArrayList<>(Arrays.asList(150.0));
        ArrayList<Double> s4Scores = new ArrayList<>(Arrays.asList(175.0));

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] expectedStudents = {s2, s3, s4, s1};
        Classroom expectedClassroom = new Classroom(expectedStudents);

        // When
        Student[] actualStudents = {s3, s4, s1, s2};
        Classroom actualClassroom = new Classroom(actualStudents);
        actualClassroom.getStudentsByScore();

        // When
        Assert.assertEquals(actualClassroom.getStudents(), expectedClassroom.getStudents());

    }
    @Test
    public void getGradeBookTest() {

        // : Given
        ArrayList<Double> s1Scores = new ArrayList<>(Arrays.asList(90.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(85.0));
        ArrayList<Double> s3Scores = new ArrayList<>(Arrays.asList(77.0));
        ArrayList<Double> s4Scores = new ArrayList<>(Arrays.asList(65.0));

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] expectedStudents = {s2, s3, s4, s1};
        Classroom expectedClassroom = new Classroom(expectedStudents);

        // When
        Student[] actualStudents = {s3, s4, s1, s2};
        Classroom actualClassroom = new Classroom(actualStudents);
        actualClassroom.getStudentsByScore();

        // When
        Assert.assertEquals(actualClassroom.getStudents(), expectedClassroom.getStudents());

    }













}
