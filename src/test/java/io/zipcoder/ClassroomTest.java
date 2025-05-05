package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

public class ClassroomTest {

    public Classroom classroom;
    ArrayList<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        classroom = new Classroom();
    }

    @Test
    public void testGetStudents() {
        Classroom classroom = new Classroom(students);

        ArrayList<Double> testScore1 = new ArrayList<>();
        ArrayList<Double> testScore2 = new ArrayList<>();
        testScore1.add(100.2);
        testScore1.add(42.92);
        testScore2.add(120.0);
        testScore2.add(72.4);
        Student firstStudent = new Student("Clark", "Kent", testScore1);
        Student secondStudent = new Student("Mathew", "John", testScore2);

        students.add(firstStudent);
        students.add(secondStudent);

        String expected = "Student Name: Clark Kent\n" +
                "Average -> 71.56\n" +
                "Exam 1-> 100.2\n" +
                "Exam 2-> 42.92\n" +
                "Student Name: Mathew John\n" +
                "Average -> 96.2\n" +
                "Exam 1-> 120.0\n" +
                "Exam 2-> 72.4\n";
        String actual = classroom.getStudents();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverage() {
        ArrayList<Double> s1Scores = new ArrayList<>();
        ArrayList<Double> s2Scores = new ArrayList<>();
        s1Scores.add(100.0);
        s1Scores.add(60.23);
        s1Scores.add(87.66);
        s2Scores.add(120.0);
        s2Scores.add(106.01);
        s2Scores.add(50.32);
        Student firstStudent = new Student("Clark", "Kent", s1Scores);
        Student secondStudent = new Student("Mathew", "John", s2Scores);
        ArrayList<Student> students = new ArrayList<>();
        students.add(firstStudent);
        students.add(secondStudent);
        Classroom classroom = new Classroom(students);
        Double expected = 87.37;
        Double actual = classroom.getAverageExamsScores();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testAddStudent() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        ArrayList<Double> s1Scores = new ArrayList<>();
        s1Scores.add(100.0);
        s1Scores.add(60.23);
        s1Scores.add(87.66);

        Student student = new Student("Jim", "Carey", s1Scores);
        classroom.addAStudent(student);
        String expected = "Student Name: Jim Carey\n" +
                "Average -> 82.63\n" +
                "Exam 1-> 100.0\n" +
                "Exam 2-> 60.23\n" +
                "Exam 3-> 87.66\n";
        String actual = classroom.getStudents();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testRemoveAStudent() {
        Classroom classroom = new Classroom();
        ArrayList<Double> s1Scores = new ArrayList<>();
        s1Scores.add(100.0);
        s1Scores.add(60.23);
        s1Scores.add(87.66);
        Student student1 = new Student("Jim", "Carey", s1Scores);

        ArrayList<Double> s2Scores = new ArrayList<>();
        s2Scores.add(100.0);
        s2Scores.add(60.23);
        s2Scores.add(87.66);
        Student student2 = new Student("Steve", "Carrell", s2Scores);

        classroom.addAStudent(student1);
        classroom.addAStudent(student2);

        classroom.removeAStudent("Jim", "Carey");
        String expected = "Student Name: Steve Carrell\n" +
                "Average -> 82.63\n" +
                "Exam 1-> 100.0\n" +
                "Exam 2-> 60.23\n" +
                "Exam 3-> 87.66\n";
        String actual = classroom.getStudents();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStudentsByScore() {
        Classroom classroom = new Classroom();
        ArrayList<Double> s1Scores = new ArrayList<>();
        s1Scores.add(100.0);
        s1Scores.add(77.23);
        s1Scores.add(89.66);
        Student student1 = new Student("Jim", "Carey", s1Scores);

        ArrayList<Double> s2Scores = new ArrayList<>();
        s2Scores.add(100.0);
        s2Scores.add(60.23);
        s2Scores.add(87.66);
        Student student2 = new Student("Steve", "Carrell", s2Scores);

        ArrayList<Double> s3Scores = new ArrayList<>();
        s3Scores.add(100.0);
        s3Scores.add(60.23);
        s3Scores.add(87.66);
        Student student3 = new Student("Ginny", "Campbell", s2Scores);

        ArrayList<Double> s4Scores = new ArrayList<>();
        s4Scores.add(100.0);
        s4Scores.add(60.23);
        s4Scores.add(87.66);
        Student student4 = new Student("Harris", "Campbell", s2Scores);

        classroom.addAStudent(student1);
        classroom.addAStudent(student2);
        classroom.addAStudent(student3);
        classroom.addAStudent(student4);

        List<Student> expected = new ArrayList<Student>() {
            {
                add(student1);
                add(student3);
                add(student4);
                add(student2);
            }
        };

        List<Student> actual = classroom.getStudentsByScore();
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());

    }

    @Test
    public void testGetGradeBook() {

        Classroom classroom = new Classroom();
        ArrayList<Double> s1Scores = new ArrayList<>();
        s1Scores.add(100.0);
        s1Scores.add(0.23);
        s1Scores.add(87.66);
        Student student1 = new Student("Jim", "Carey", s1Scores);

        ArrayList<Double> s2Scores = new ArrayList<>();
        s2Scores.add(100.0);
        s2Scores.add(60.23);
        s2Scores.add(.66);
        Student student2 = new Student("Steve", "Carrell", s2Scores);

        ArrayList<Double> s3Scores = new ArrayList<>();
        s3Scores.add(100.0);
        s3Scores.add(60.23);
        s3Scores.add(87.66);
        Student student3 = new Student("Ginny", "Campbell", s1Scores);

        ArrayList<Double> s4Scores = new ArrayList<>();
        s4Scores.add(59.6);
        s4Scores.add(88.02);
        s4Scores.add(99.12);
        Student student4 = new Student("Harris", "Campbell", s3Scores);

        classroom.addAStudent(student1);
        classroom.addAStudent(student3);
        classroom.addAStudent(student4);
        classroom.addAStudent(student2);

        TreeMap<Character, ArrayList<Student>> tMap = classroom.getGradeBook();

    }


}

