package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void addStudentTest()
    {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] s1Scores = {100.0, 80.0};
        classroom.addStudent("James", "Miller", s1Scores);
        String actual = classroom.getStudents();
        //System.out.println(actual);
        String expected = "[Student Name: James Miller\n> Average Score: 90\n>Exam Scores:\n\t\tExam 1 -> 100\n\t\tExam 2 -> 80\n";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void addStudentToEntireClassRoomTest()
    {
        int maxNumberOfStudents = 1;

        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] s1Scores = {90.0, 70.0};
        Double[] s2Scores = {100.0, 150.0};

        classroom.addStudent("James", "Miller", s1Scores);
        boolean actual = classroom.addStudent("Mike", "Tyson", s2Scores);
        System.out.println(actual);
        boolean expected = false;

        Assert.assertEquals(expected,actual);

    }


    @Test
    public void removeStudentTest()
    {
        Classroom classroom = new Classroom(2);

        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {100.0, 80.0};

        classroom.addStudent("Elton", "John", s1Scores);
        classroom.addStudent("Tim","Jones", s2Scores);

        boolean actual = classroom.removeStudent("Elton", "John");
        boolean expected = true;

        Assert.assertEquals(expected,actual);


    }



    @Test
    public void getAverageClassExamScoresTest()
    {
        Classroom classroom = new Classroom(2);

        Double [] s1Scores = {80.0, 100.0};
        Double [] s2Scores = {90.0, 70.0};

        classroom.addStudent("James","Thomas", s1Scores);
        classroom.addStudent("Will", "Jones", s2Scores);

        double actual = classroom.getAverageClassExamScore();
        double expected = 85.0;

        Assert.assertEquals(expected,actual, .001);
    }

    @Test
    public void listStudentsByScoreTest()
    {
        Classroom classroom = new Classroom();

        Double [] s1Scores = {100.0, 90.0};
        Double [] s2Scores = {85.0, 75.0};
        Double [] s3Scores = {90.0, 80.0};

        classroom.addStudent("Will", "Harkin", s1Scores);
        classroom.addStudent("James", "Williams", s2Scores);
        classroom.addStudent("Peter","White", s3Scores);

        String actual = classroom.listStudentByScore();
        String expected = "[Student Name: Will Harkin\n> Average Score: 80\nExam Scores:\n\t\tExam 1 -> 100\n\t\t" +
                "Exam 2 -> 90\n, Student Name: James Williams\n> Average Score: 80\nExam Scores:\n\t\tExam 1 -> 85\n\t\tExam 2 -> 75\nStudent Name: Peter White\n> Average Score: 85\nExam Scores:\n\t\tExam 1 -> 90\n\t\tExam 2 - >80\n]";


    }

    @Test
    public void gradeClassTest()
    {
        Classroom classroom = new Classroom(10);

        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 75.0};
        Double[] s3Scores = {80.0, 95.0};
        Double[] s4Scores = {65.0, 50.0};
        Double[] s5Scores = {225.0, 25.0};
        Double[] s6Scores = {100.0, 75.0};
        Double[] s7Scores = {125.0, 75.0};
        Double[] s8Scores = {60.0, 130.0};
        Double[] s9Scores = {55.0, 85.0};
        Double[] s10Scores = {70.0,95.0};

        classroom.addStudent("Jason", "Bourne", s1Scores);
        classroom.addStudent("Damion", "John", s2Scores);
        classroom.addStudent("Will", "Banks", s3Scores);
        classroom.addStudent("Adam", "Black", s4Scores);
        classroom.addStudent("Jen", "Thomas", s5Scores);
        classroom.addStudent("Claire", "Kovatch", s6Scores);
        classroom.addStudent("Don", "Casey", s7Scores);
        classroom.addStudent("Bill", "Blair", s8Scores);
        classroom.addStudent("Rick", "Ross", s9Scores);
        classroom.addStudent("Jay", "Ward", s10Scores);

        String actual = classroom.gradeClass();
        String expected = "Damion John: A\nJason Bourne: B\nJen Thomas: B\nDon Casey: C\nBill Blair: C\nClaire Kovatch: D\nWill Banks: D\nJay Ward: D\nRick Ross: D\nAdam Black: F\n";

        System.out.println(actual);

        Assert.assertEquals(expected, actual);


    }
















































}
