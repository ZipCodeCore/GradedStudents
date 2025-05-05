package io.zipcoder;

import org.junit.Assert;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;


public class ClassroomTest {
    private Student[] testStudents;
    private int studentAmount;
    private int maxStudentAmount;
    private Classroom testClassroom;
    private Student testStudent;
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;

    @Test
    public void getMaxClassroomSize() {
        Integer maxStudentAmount = 10;
        Classroom testClassroom = new Classroom(maxStudentAmount);
        Integer expected = 10;
        Integer actual = testClassroom.getStudents().length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNullaryClassroomSize() {
        Classroom testClassroom = new Classroom();
        Integer expected = 30;
        Integer actual = testClassroom.getStudents().length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testArrayStudent() {
//        testScores = new ArrayList<>();
//        testStudent = new Student(firstName, lastName, testScores);

        ArrayList<Double> testScore0 = new ArrayList<Double>() {{
            add(81.0);
            add(92.0);
            add(76.0);
            add(68.0);
        }};
        Student student0 = new Student("Freddie", "Mercury", testScore0);

        Student[] testStudents = {student0};
        Classroom testClassroom = new Classroom(testStudents);
        String expected = "[Student Name: Freddie Mercury\n" +
                "> Average Score: 79.0\n" +
                "> Exam Scores: \n" +
                "\tExam 1 --> 81.0\n" +
                "\tExam 2 --> 92.0\n" +
                "\tExam 3 --> 76.0\n" +
                "\tExam 4 --> 68.0\n" +
                "]";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddStudent() {

        ArrayList<Double> testScore1 = new ArrayList<Double>() {{
            add(82.0);
            add(31.0);
            add(56.0);
            add(93.0);
        }};
        Student student1 = new Student("Spongebob", "Squarepants", testScore1);
        boolean expected = true;
        Classroom testClassroom = new Classroom();
        boolean actual = testClassroom.addStudents(student1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddStudent2() {
        ArrayList<Double> testScore9 = new ArrayList<Double>() {{
            add(81.0);
            add(92.0);
            add(34.0);
            add(68.0);
        }};
        Student student9 = new Student("Travis", "Touchdown", testScore9);


        ArrayList<Double> testScore8 = new ArrayList<Double>() {{
            add(88.0);
            add(99.0);
            add(76.0);
            add(68.0);
        }};
        Student student8 = new Student("Mike", "Ross", testScore8);
        boolean expected = false;
        Classroom testClassroom = new Classroom(1);
        testClassroom.addStudents(student8);
        boolean actual = testClassroom.addStudents(student9);
    }

    @Test
    public void testRemoveStudent() {
        Classroom testClassroom = new Classroom(2);
        ArrayList<Double> testScore7 = new ArrayList<Double>() {{ }};
        Student student7 = new Student("Rachel", "Zane", testScore7);
        testClassroom.addStudents(student7);
        ArrayList<Double> testScore6 = new ArrayList<Double>() {{
            add(97.0);
            add(97.0);
            add(97.0);
            add(97.0);
        }};
        Student student6 = new Student("Optimus", "Prime", testScore6);
        testClassroom.addStudents(student6);
        testClassroom.removeStudent("Rachel", "Zane");
        String expected = "[Student Name: Optimus Prime\n" +
                "> Average Score: 97.0\n" +
                "> Exam Scores: \n" +
                "\tExam 1 --> 97.0\n" +
                "\tExam 2 --> 97.0\n" +
                "\tExam 3 --> 97.0\n" +
                "\tExam 4 --> 97.0\n" +
                ", null]";
        String actual = Arrays.toString(testClassroom.getStudents());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStudent2() {
        Classroom testClassroom = new Classroom(2);
        ArrayList<Double> testScore7 = new ArrayList<Double>() {{ }};
        Student student7 = new Student("Rachel", "Zane", testScore7);
        testClassroom.addStudents(student7);
        ArrayList<Double> testScore6 = new ArrayList<Double>() {{ }};
        Student student6 = new Student("Optimus", "Prime", testScore6);
        testClassroom.addStudents(student6);

        String expected = "This student is not enrolled";
        String actual = testClassroom.removeStudent("Rachel", "Bane");
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetAverageScore() {
        Classroom testClassroom = new Classroom(2);
        ArrayList<Double> testScore7 = new ArrayList<Double>() {{
            add(66.0);
            add(92.0);
            add(76.0);
            add(42.0);
            //avg 69.0
        }};
        Student student6 = new Student("Rachel", "Zane", testScore7);
        testClassroom.addStudents(student6);
        ArrayList<Double> testScore6 = new ArrayList<Double>() {{
            add(99.0);
            add(99.0);
            add(99.0);
            add(99.0);
            //avg 99
        }};
        Student student7 = new Student("Optimus", "Prime", testScore6);
        testClassroom.addStudents(student7);
        Double expected = 84.0;
        Double actual = testClassroom.getClassAverage();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStudentsbyScore() {

        Classroom testClassroom = new Classroom(10);

        //Ten Students
        //Student 0
        ArrayList<Double> testScore0 = new ArrayList<Double>() {{
            add(82.0);
            add(92.0);
            add(76.0);
            add(68.0);
        }}; //avg 80
        Student student0 = new Student("Freddie", "Mercury", testScore0);
        testClassroom.addStudents(student0);

        //Student 1
        ArrayList<Double> testScore1 = new ArrayList<Double>() {{
            add(82.0);
            add(21.0);
            add(56.0);
            add(93.0);
        }}; //avg 63
        Student student1 = new Student("Spongebob", "Squarepants", testScore1);
        testClassroom.addStudents(student1);

        //Student 2
        ArrayList<Double> testScore2 = new ArrayList<Double>() {{
            add(99.0);
            add(43.0);
            add(56.0);
            add(88.0);
        }}; //avg 72
        Student student2 = new Student("Teddie", "Rosevelt", testScore2);
        testClassroom.addStudents(student2);

        //Student 3
        ArrayList<Double> testScore3 = new ArrayList<Double>() {{
            add(65.0);
            add(60.0);
            add(84.0);
            add(70.0);
        }}; //avg 70
        Student student3 = new Student("Fox", "McCloud", testScore3);
        testClassroom.addStudents(student3);

        //Student 4
        ArrayList<Double> testScore4 = new ArrayList<Double>() {{
            add(100.0);
            add(78.0);
            add(92.0);
            add(77.0);
        }}; //avg 87
        Student student4 = new Student("Yancy", "Nancy", testScore4);
        testClassroom.addStudents(student4);

        //Student 5
        ArrayList<Double> testScore5 = new ArrayList<Double>() {{
            add(77.0);
            add(92.0);
            add(99.0);
            add(68.0);
        }}; //avg 84
        Student student5 = new Student("Tommy", "Tim", testScore5);
        testClassroom.addStudents(student5);

        //Student 6
        ArrayList<Double> testScore6 = new ArrayList<Double>() {{
            add(98.0);
            add(98.0);
            add(98.0);
            add(98.0);
        }}; //avg 98
        Student student6 = new Student("Optimus", "Prime", testScore6);
        testClassroom.addStudents(student6);

        //Student 7
        ArrayList<Double> testScore7 = new ArrayList<Double>() {{
            add(63.0);
            add(92.0);
            add(76.0);
            add(42.0);
        }}; //avg 68
        Student student7 = new Student("Rachel", "Zane", testScore7);
        testClassroom.addStudents(student7);

        //Student 8
        ArrayList<Double> testScore8 = new ArrayList<Double>() {{
            add(81.0);
            add(95.0);
            add(76.0);
            add(68.0);
        }}; //avg 80
        Student student8 = new Student("Mike", "Ross", testScore8);
        testClassroom.addStudents(student8);

        //Student 9
        ArrayList<Double> testScore9 = new ArrayList<Double>() {{
            add(56.0);
            add(92.0);
            add(29.0);
            add(68.0);
        }}; //avg 61
        Student student9 = new Student("Travis", "Touchdown", testScore9);
        testClassroom.addStudents(student9);


        String expected = "Optimus Prime : 98.0\n" +
            "Yancy Nancy : 87.0\n" +
            "Tommy Tim : 84.0\n" +
            "Freddie Mercury : 80.0\n" +
            "Mike Ross : 80.0\n" +
            "Teddie Rosevelt : 72.0\n" +
            "Fox McCloud : 70.0\n" +
            "Rachel Zane : 68.0\n" +
            "Spongebob Squarepants : 63.0\n" +
            "Travis Touchdown : 61.0\n";

    String actual = testClassroom.getStudentsByScore();
        System.out.println(actual);
    Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGradeBook(){

        Classroom testClassroom = new Classroom(10);

        //Ten Students
        //Student 0
        ArrayList<Double> testScore0 = new ArrayList<Double>() {{
            add(82.0);
            add(92.0);
            add(76.0);
            add(68.0);
        }}; //avg 80
        Student student0 = new Student("Freddie", "Mercury", testScore0);
        testClassroom.addStudents(student0);

        //Student 1
        ArrayList<Double> testScore1 = new ArrayList<Double>() {{
            add(82.0);
            add(21.0);
            add(56.0);
            add(93.0);
        }}; //avg 63
        Student student1 = new Student("Spongebob", "Squarepants", testScore1);
        testClassroom.addStudents(student1);

        //Student 2
        ArrayList<Double> testScore2 = new ArrayList<Double>() {{
            add(99.0);
            add(43.0);
            add(56.0);
            add(88.0);
        }}; //avg 72
        Student student2 = new Student("Teddie", "Rosevelt", testScore2);
        testClassroom.addStudents(student2);

        //Student 3
        ArrayList<Double> testScore3 = new ArrayList<Double>() {{
            add(65.0);
            add(60.0);
            add(84.0);
            add(70.0);
        }}; //avg 70
        Student student3 = new Student("Fox", "McCloud", testScore3);
        testClassroom.addStudents(student3);

        //Student 4
        ArrayList<Double> testScore4 = new ArrayList<Double>() {{
            add(100.0);
            add(78.0);
            add(92.0);
            add(77.0);
        }}; //avg 87
        Student student4 = new Student("Yancy", "Nancy", testScore4);
        testClassroom.addStudents(student4);

        //Student 5
        ArrayList<Double> testScore5 = new ArrayList<Double>() {{
            add(77.0);
            add(92.0);
            add(99.0);
            add(68.0);
        }}; //avg 84
        Student student5 = new Student("Tommy", "Tim", testScore5);
        testClassroom.addStudents(student5);

        //Student 6
        ArrayList<Double> testScore6 = new ArrayList<Double>() {{
            add(98.0);
            add(98.0);
            add(98.0);
            add(98.0);
        }}; //avg 98
        Student student6 = new Student("Optimus", "Prime", testScore6);
        testClassroom.addStudents(student6);

        //Student 7
        ArrayList<Double> testScore7 = new ArrayList<Double>() {{
            add(63.0);
            add(92.0);
            add(76.0);
            add(42.0);
        }}; //avg 68
        Student student7 = new Student("Rachel", "Zane", testScore7);
        testClassroom.addStudents(student7);

        //Student 8
        ArrayList<Double> testScore8 = new ArrayList<Double>() {{
            add(81.0);
            add(95.0);
            add(76.0);
            add(68.0);
        }}; //avg 80
        Student student8 = new Student("Mike", "Ross", testScore8);
        testClassroom.addStudents(student8);

        //Student 9
        ArrayList<Double> testScore9 = new ArrayList<Double>() {{
            add(56.0);
            add(92.0);
            add(29.0);
            add(68.0);
        }}; //avg 61
        Student student9 = new Student("Travis", "Touchdown", testScore9);
        testClassroom.addStudents(student9);


        String expected = "Optimus Prime 98.0 : A\n" +
                "Yancy Nancy 87.0 : B\n" +
                "Tommy Tim 84.0 : C\n" +
                "Freddie Mercury 80.0 : C\n" +
                "Mike Ross 80.0 : C\n" +
                "Teddie Rosevelt 72.0 : D\n" +
                "Fox McCloud 70.0 : D\n" +
                "Rachel Zane 68.0 : D\n" +
                "Spongebob Squarepants 63.0 : F\n" +
                "Travis Touchdown 61.0 : F\n";
        String actual = testClassroom.getGradeBook();
        Assert.assertEquals(expected,actual);
    }
}
