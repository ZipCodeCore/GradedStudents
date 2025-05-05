package io.zipcoder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class StudentTest {

    Student student;

    @Before
    public void setUp(){
        Double[] examScores = {98.0, 78.0, 98.0, 91.0};
        student = new Student("Pete", "Jones", new ArrayList<>(Arrays.asList(examScores)));

    }
    @Test
    public void getExamScoresTest(){
        String expected =
                "Exam Scores:\n" +
                        " \tExam 1 -> 98\n" +
                        " \tExam 2 -> 78\n" +
                        " \tExam 3 -> 98\n" +
                        " \tExam 4 -> 91\n";
        String actual = student.getExamScores();
        assertEquals(expected, actual);
        System.out.println(actual);
    }
    @Test
    public void addExamScoresTest(){
        Double newScore = 100.0;
        student.addExamScore(newScore);
        boolean hasTheScoreBeenAdded = student.getActualExamScores().get(student.getActualExamScores().size()-1).equals(newScore);
        assertTrue(hasTheScoreBeenAdded);
    }
}