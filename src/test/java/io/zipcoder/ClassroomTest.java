package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {
    @Test
    public void getAverageExamScoreTest() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student studentOne = new Student("student", "one", s1Scores);
        Student studentTwo = new Student("student", "two", s2Scores);

        Student[] students = {studentOne, studentTwo};
        Classroom classroom = new Classroom(students);

        double actual = classroom.getAverageExamScore();
        double expected = 125.0;

        Assert.assertEquals(expected, actual, 0.01);

    }

    @Test
    public void addStudentTest() {
        int maxNumberOfStudents = 10;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] studentOneScores = {125.0, 150.0, 100.0, 25.0};
        Student studentOne = new Student("Aurna", "Drayke", studentOneScores);


        classroom.addStudent(studentOne);

        Student[] actual = classroom.getStudents();
        Student[] expected = new Student[10];
        expected[0] = studentOne;

        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeStudentTest() {
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student studentOne = new Student("student", "one", s1Scores);
        Student studentTwo = new Student("student", "two", s2Scores);

        classroom.addStudent(studentOne);
        classroom.addStudent(studentTwo);

        classroom.removeStudent(studentOne.getFirstName(), studentOne.getLastName());

        String actual = Arrays.toString(classroom.getStudents());
        String expected = "[Student Name: student two\n" + "Average Score: 125.0\n" + "Exam Scores:\n" + "Exam 1: 225.0\n" + "Exam 2: 25.0\n" + ", null]";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortArrayAfterRemovingStudentTest() {
        Double[] s2Scores = {225.0, 75.0};
        Student student2 = new Student("student", "two", s2Scores);

        Student[] testArray = {null, student2};
        Classroom classroom = new Classroom(testArray);
        classroom.sortArrayAfterRemovingStudent();

        String actual = Arrays.toString(classroom.getStudents());
        String expected = "[Student Name: student two\n" + "Average Score: 150.0\n" + "Exam Scores:\n" + "Exam 1: 225.0\n" + "Exam 2: 75.0\n" + ", null]";


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest(){

        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        Double[] s1Scores = {150.0, 150.0};
        Double[] s2Scores = {100.0, 100.0};
        Double[] s3Scores = {150.0, 150.0};
        Student studentOne = new Student("Aurna", "Drayke", s3Scores);
        Student studenttwo= new Student("Joe", "Schmo", s1Scores);
        Student studentThree = new Student("Alec", "Daran", s2Scores);


        String actual = Arrays.toString(classroom.getStudentsByScore());
        String expected = "[Student Name: Alec Daran \\n\" + \"Average Score: 150.0\\n\" + \"Exam Scores:\\n\" + \"Exam 1: 150.0\\n\" + \"Exam 2: 150.0]\n"
                + "Student Name: Aurna Drayke\n" + "Average Score: 150.0\n" + "Exam Scores:\n" + "Exam 1: 150.0\n" + "Exam 2: 150.0\n"
                + "Student Name: Joe Schmo \n" + "Average Score: 100.0\n" + "Exam Scores:\n" + "Exam 1: 100.0\n" + "Exam 2: 100.0]\n";

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void compareTest(){
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        Double[] s1Scores = {100.0, 100.0};
        Double[] s2Scores = {50.0, 50.0};

        Student studentOne = new Student("student", "one", s1Scores);
        Student studentTwo = new Student("student", "two", s2Scores);

        int actual = classroom.compare(studentOne, studentTwo);
        int expected = -1;

        Assert.assertEquals(expected, actual);
    }
}
