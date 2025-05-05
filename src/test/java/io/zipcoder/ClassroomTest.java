package io.zipcoder;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {
    @Test
    public void getStudents() {
        // : Given
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0 ));
        ArrayList<Double> s2Scores = new ArrayList<Double>(Arrays.asList( 225.0, 25.0 ));

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Student[] output = classroom.getStudents();

        // Then
        System.out.println(output);
    }
    @Test
    public void getAverageExamScoreTest() {
        // : Given
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<Double>(Arrays.asList(225.0, 25.0));

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);
        Double expected = 125.0;

        // When
        Double actual = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, actual);
        System.out.print(actual);
    }
    @Test
    public void addStudentTest() {
        //:Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double>  s2Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0, 225.0, 25.0));
        Student s2 = new Student("Leon", "Hunter", s2Scores);

        //: When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(s2);
        Student[] postEnrollment = classroom.getStudents();

        //: Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }
    @Test
    public void removeStudentTest() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double>  s2Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0, 225.0, 25.0));
        Student s2 = new Student("Leon", "Hunter", s2Scores);
        classroom.addStudent(s2);

        int actual = classroom.getStudents().length;

        classroom.removeStudent("Leon", "Hunter");
        Assert.assertEquals(maxNumberOfStudents, actual);
        System.out.println("===========================");
        System.out.println(maxNumberOfStudents);
        System.out.println("===========================");
        System.out.println(actual);
    }

    @Test
    public void getStudentsByScore() {

        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<Double>(Arrays.asList(225.0, 25.0));
        ArrayList<Double> s3Scores = new ArrayList<Double>(Arrays.asList( 100.0, 88.0 ));
        ArrayList<Double> s4Scores = new ArrayList<Double>(Arrays.asList( 77.0, 64.0 ));

        Student s1 = new Student("King", "King", s2Scores);
        Student s2 = new Student("Valerie", "Fragier", s1Scores);
        Student s3 = new Student("Ryan", "Miller", s3Scores);
        Student s4 = new Student("Mike", "Gray", s4Scores);

        Student[] students = {s1, s2, s3, s4};
        Classroom classroom = new Classroom(students);

        Student[] preEnrollment = classroom.getStudents();

        String preEnrollmentAsString = Arrays.toString(preEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        Student[] postEnrollment = classroom.getStudentsByScore();
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        System.out.println(postEnrollmentAsString);
    }
    @Test
    public void getGradeBook() {
        // : Given
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<Double>(Arrays.asList(90.0, 75.0));
        ArrayList<Double> s3Scores = new ArrayList<Double>(Arrays.asList( 25.0, 88.0 ));
        ArrayList<Double> s4Scores = new ArrayList<Double>(Arrays.asList( 77.0, 64.0 ));
        ArrayList<Double> s5Scores = new ArrayList<Double>(Arrays.asList( 60.0, 64.0 ));
        Student s1 = new Student("King", "King", s1Scores);
        Student s2 = new Student("Valerie", "Fragier", s2Scores);
        Student s3 = new Student("Ryan", "Miller", s3Scores);
        Student s4 = new Student("Mike", "Gray", s4Scores);
        Student s5 = new Student("Kendra", "Ng", s5Scores);
        Student[] students = {s1, s2, s3, s4, s5};
        Classroom classroom = new Classroom(students);
        System.out.println("===========================");
        Map preEnrollment = classroom.getGradeBook();
        System.out.println("===========================");
    }
}