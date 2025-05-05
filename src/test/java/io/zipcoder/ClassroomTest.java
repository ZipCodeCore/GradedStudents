package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ClassroomTest {

    private Student student1;
    private Student student2;
    private Student student3;
    private ArrayList<Double> testScores1;
    private ArrayList<Double> testScores2;
    private ArrayList<Double> testScores3;
    private Student[] students;
    private Classroom classroom1;

    @Before
    public void setUp(){
        testScores1 = new ArrayList<>();
        testScores2 = new ArrayList<>();
        testScores3 = new ArrayList<>();

        testScores1.add(1.0);
        testScores1.add(2.0);
        testScores1.add(3.0);
        student1 = new Student("Steve", "Stevenson", testScores1);
        testScores2.add(100.0);
        testScores2.add(95.0);
        testScores2.add(90.0);
        student2 = new Student("John", "Johnson", testScores2);
        testScores3.add(73.0);
        testScores3.add(64.0);
        testScores3.add(83.0);
        student3 = new Student("Jack", "Jackson", testScores3);
        students = new Student[]{student1, student2, student3};
        classroom1 = new Classroom(students);
    }

    @Test
    public void getStudentsTest() {
        String expected = "[Student Name: Steve Stevenson\n" +
                "> Average Score: 2.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n" +
                ", Student Name: John Johnson\n" +
                "> Average Score: 95.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 95.0\n" +
                "\tExam 3 -> 90.0\n" +
                ", Student Name: Jack Jackson\n" +
                "> Average Score: 73.33333333333333\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 73.0\n" +
                "\tExam 2 -> 64.0\n" +
                "\tExam 3 -> 83.0\n" +
                "]";
        String actual = classroom1.getStudents();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        Double expected = 56.77;
        Double actual = classroom1.getAverageExamScore();
        Assert.assertEquals(expected, actual, .01);
    }

    @Test
    public void addStudentTest() {
        Student student4 = new Student("James", "Jameson", testScores3);
        classroom1.addStudent(student4);
        String expected = "[Student Name: Steve Stevenson\n" +
                "> Average Score: 2.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n" +
                ", Student Name: John Johnson\n" +
                "> Average Score: 95.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 95.0\n" +
                "\tExam 3 -> 90.0\n" +
                ", Student Name: Jack Jackson\n" +
                "> Average Score: 73.33333333333333\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 73.0\n" +
                "\tExam 2 -> 64.0\n" +
                "\tExam 3 -> 83.0\n" +
                ", Student Name: James Jameson\n" +
                "> Average Score: 73.33333333333333\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 73.0\n" +
                "\tExam 2 -> 64.0\n" +
                "\tExam 3 -> 83.0\n" +
                "]";
        String actual = classroom1.getStudents();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void removeStudentTest() {
        classroom1.removeStudent("Jack", "Jackson");
        String expected = "[Student Name: Steve Stevenson\n" +
                "> Average Score: 2.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n" +
                ", Student Name: John Johnson\n" +
                "> Average Score: 95.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 95.0\n" +
                "\tExam 3 -> 90.0\n" +
                ", null]";
        String actual = classroom1.getStudents();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest() {
        String expected = "[Student Name: John Johnson\n" +
                "> Average Score: 95.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 95.0\n" +
                "\tExam 3 -> 90.0\n" +
                ", Student Name: Jack Jackson\n" +
                "> Average Score: 73.33333333333333\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 73.0\n" +
                "\tExam 2 -> 64.0\n" +
                "\tExam 3 -> 83.0\n" +
                ", Student Name: Steve Stevenson\n" +
                "> Average Score: 2.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n" +
                "]";
        String actual = classroom1.getStudentsByScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest2() {
        Student student4 = new Student("Sam", "Samson", testScores1);
        classroom1.addStudent(student4);
        String expected = "[Student Name: John Johnson\n" +
                "> Average Score: 95.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100.0\n" +
                "\tExam 2 -> 95.0\n" +
                "\tExam 3 -> 90.0\n" +
                ", Student Name: Jack Jackson\n" +
                "> Average Score: 73.33333333333333\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 73.0\n" +
                "\tExam 2 -> 64.0\n" +
                "\tExam 3 -> 83.0\n" +
                ", Student Name: Sam Samson\n" +
                "> Average Score: 2.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n" +
                ", Student Name: Steve Stevenson\n" +
                "> Average Score: 2.0\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 1.0\n" +
                "\tExam 2 -> 2.0\n" +
                "\tExam 3 -> 3.0\n" +
                "]";
        String actual = classroom1.getStudentsByScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getGradeBookTest() {
        ArrayList<Double> testScores4 = new ArrayList<>();
        ArrayList<Double> testScores5 = new ArrayList<>();
        ArrayList<Double> testScores6 = new ArrayList<>();
        ArrayList<Double> testScores7 = new ArrayList<>();
        ArrayList<Double> testScores8 = new ArrayList<>();
        ArrayList<Double> testScores9 = new ArrayList<>();
        ArrayList<Double> testScores10 = new ArrayList<>();
        testScores4.add(70.0);
        testScores4.add(43.0);
        testScores4.add(33.0);
        Student student4 = new Student("Sam", "Samson", testScores4);
        classroom1.addStudent(student4);
        testScores5.add(63.0);
        testScores5.add(99.0);
        testScores5.add(25.0);
        Student student5 = new Student("James", "Jameson", testScores5);
        classroom1.addStudent(student5);
        testScores6.add(39.0);
        testScores6.add(59.0);
        testScores6.add(84.0);
        Student student6 = new Student("April", "Ludgate", testScores6);
        classroom1.addStudent(student6);
        testScores7.add(45.0);
        testScores7.add(87.0);
        testScores7.add(14.0);
        Student student7 = new Student("Harry", "Stiles", testScores7);
        classroom1.addStudent(student7);
        testScores8.add(34.0);
        testScores8.add(66.0);
        testScores8.add(74.0);
        Student student8 = new Student("Robert", "Robertson", testScores8);
        classroom1.addStudent(student8);
        testScores9.add(43.0);
        testScores9.add(76.0);
        testScores9.add(25.0);
        Student student9 = new Student("Kyle", "Reese", testScores9);
        classroom1.addStudent(student9);
        testScores10.add(100.0);
        testScores10.add(95.0);
        testScores10.add(89.0);
        Student student10 = new Student("Michael", "Bay", testScores10);
        classroom1.addStudent(student10);


        String expected = "John Johnson = A\n" +
                "Michael Bay = B\n" +
                "Jack Jackson = C\n" +
                "James Jameson = C\n" +
                "April Ludgate = C\n" +
                "Robert Robertson = D\n" +
                "Kyle Reese = D\n" +
                "Sam Samson = D\n" +
                "Harry Stiles = F\n" +
                "Steve Stevenson = F\n";
        String actual = classroom1.getGradeBook();

        Assert.assertEquals(expected, actual);




    }

    @Test
    public void setPercentileForStudentsTest() {
        ArrayList<Double> testScores4 = new ArrayList<>();
        ArrayList<Double> testScores5 = new ArrayList<>();
        ArrayList<Double> testScores6 = new ArrayList<>();
        ArrayList<Double> testScores7 = new ArrayList<>();
        ArrayList<Double> testScores8 = new ArrayList<>();
        ArrayList<Double> testScores9 = new ArrayList<>();
        ArrayList<Double> testScores10 = new ArrayList<>();
        testScores4.add(70.0);
        testScores4.add(43.0);
        testScores4.add(33.0);
        Student student4 = new Student("Sam", "Samson", testScores4);
        classroom1.addStudent(student4);
        testScores5.add(63.0);
        testScores5.add(99.0);
        testScores5.add(25.0);
        Student student5 = new Student("James", "Jameson", testScores5);
        classroom1.addStudent(student5);
        testScores6.add(39.0);
        testScores6.add(59.0);
        testScores6.add(84.0);
        Student student6 = new Student("April", "Ludgate", testScores6);
        classroom1.addStudent(student6);
        testScores7.add(45.0);
        testScores7.add(87.0);
        testScores7.add(14.0);
        Student student7 = new Student("Harry", "Stiles", testScores7);
        classroom1.addStudent(student7);
        testScores8.add(34.0);
        testScores8.add(66.0);
        testScores8.add(74.0);
        Student student8 = new Student("Robert", "Robertson", testScores8);
        classroom1.addStudent(student8);
        testScores9.add(43.0);
        testScores9.add(76.0);
        testScores9.add(25.0);
        Student student9 = new Student("Kyle", "Reese", testScores9);
        classroom1.addStudent(student9);
        testScores10.add(100.0);
        testScores10.add(95.0);
        testScores10.add(89.0);
        Student student10 = new Student("Michael", "Bay", testScores10);
        classroom1.addStudent(student10);

        classroom1.setPercentileForAllStudents();
        double expected = 60;
        double actual = student8.getPercentile();

        Assert.assertEquals(expected, actual, .001);
    }

    @Test
    public void setGradeBookTest(){
        ArrayList<Double> testScores4 = new ArrayList<>();
        ArrayList<Double> testScores5 = new ArrayList<>();
        ArrayList<Double> testScores6 = new ArrayList<>();
        ArrayList<Double> testScores7 = new ArrayList<>();
        ArrayList<Double> testScores8 = new ArrayList<>();
        ArrayList<Double> testScores9 = new ArrayList<>();
        ArrayList<Double> testScores10 = new ArrayList<>();
        testScores4.add(70.0);
        testScores4.add(43.0);
        testScores4.add(33.0);
        Student student4 = new Student("Sam", "Samson", testScores4);
        classroom1.addStudent(student4);
        testScores5.add(63.0);
        testScores5.add(99.0);
        testScores5.add(25.0);
        Student student5 = new Student("James", "Jameson", testScores5);
        classroom1.addStudent(student5);
        testScores6.add(39.0);
        testScores6.add(59.0);
        testScores6.add(84.0);
        Student student6 = new Student("April", "Ludgate", testScores6);
        classroom1.addStudent(student6);
        testScores7.add(45.0);
        testScores7.add(87.0);
        testScores7.add(14.0);
        Student student7 = new Student("Harry", "Stiles", testScores7);
        classroom1.addStudent(student7);
        testScores8.add(34.0);
        testScores8.add(66.0);
        testScores8.add(74.0);
        Student student8 = new Student("Robert", "Robertson", testScores8);
        classroom1.addStudent(student8);
        testScores9.add(43.0);
        testScores9.add(76.0);
        testScores9.add(25.0);
        Student student9 = new Student("Kyle", "Reese", testScores9);
        classroom1.addStudent(student9);
        testScores10.add(100.0);
        testScores10.add(95.0);
        testScores10.add(89.0);
        Student student10 = new Student("Michael", "Bay", testScores10);
        classroom1.addStudent(student10);

        classroom1.setGradeBook();

        String expected = "B";
        String actual = student10.getCurveGrade();
        Assert.assertEquals(expected, actual);
    }
}
