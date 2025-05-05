package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class ClassroomTest {
    @Test
    public void getStudents() {

        Double[] testScores = {100.0, 150.0, 250.0, 0.0};
        Student testStudent = new Student("Leon", "Hunter", testScores);
        Student[] students = {testStudent};
        Classroom classroom = new Classroom(students);

        String expected = "[Student Name: Leon Hunter\n" +
                "> Average Score: 125.0\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 100.0\n" +
                "\t   Exam 2 -> 150.0\n" +
                "\t   Exam 3 -> 250.0\n" +
                "\t   Exam 4 -> 0.0\n]";
        String actual = Arrays.toString(classroom.getStudents());

        Assert.assertEquals(expected, actual);
    }

    @Test
        public void testGetClassAverageExamScore() {
    // : Given
    Double[] s1Scores = {100.0, 150.0};
    Double[] s2Scores = {225.0, 25.0};
    Student s1 = new Student("student", "one", s1Scores);
    Student s2 = new Student("student", "two", s2Scores);

    //when
    Student[] students = {s1, s2};
    Classroom classroom = new Classroom(students);

    // Then
    Double expected = 125.0;
    Double actual = classroom.getClassAverageExamScore();
    Assert.assertEquals(expected, actual);
    }

    @Test
        public void testAddStudent() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student testStudent = new Student("Leon", "Hunter", examScores);
        // When
        classroom.addStudent(testStudent);
        // Then
        String expected =
                "[Student Name: Leon Hunter\n" +
                        "> Average Score: 125.0\n" +
                        "> Exam Scores: \n" +
                        "\t   Exam 1 -> 100.0\n" +
                        "\t   Exam 2 -> 150.0\n" +
                        "\t   Exam 3 -> 250.0\n" +
                        "\t   Exam 4 -> 0.0\n]";
        String actual = Arrays.toString(classroom.getStudents());
        Assert.assertEquals(expected, actual);
    }



    @Test
    public void removeStudentTest() {

        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScoresS1 = {92.0, 150.0, 250.0, 0.0};
        Double[] examScoresS2 = {250.0, 100.0, 100.0, 150.0};
        Double[] examScoresS3 = {0.0, 150.0, 250.0, 50.00};
        Double[] examScoresS4 = {100.0, 120.0, 150.0, 0.0};
        // When
        Student testS1 = new Student("Leon", "Hunter", examScoresS1);
        Student testS2 = new Student("Joe", "Smith", examScoresS2);
        Student testS3 = new Student("Mike", "Jones", examScoresS3);
        Student testS4 = new Student("Bob", "Johnson", examScoresS4);


        classroom.addStudent(testS1);
        classroom.addStudent(testS2);
        classroom.addStudent(testS3);
        classroom.addStudent(testS4);
        classroom.removeStudent("Bob", "Johnson");
        // Then
        String expected = "[Student Name: Leon Hunter\n" +
                "> Average Score: 164.0\n" +
                "> Exam Scores:\n" +
                "\t  Exam 1 -> 0.0\n" +
                "\t  Exam 2 -> 150.0\n" +
                "\t  Exam 3 -> 250.0\n" +
                "\t  Exam 4 -> 50.0\n" +
                ", Student Name: Joe Smith\n" +
                "> Average Score: 164.0\n" +
                "> Exam Scores:\n" +
                "\t  Exam 1 -> 92.0\n" +
                "\t  Exam 2 -> 150.0\n" +
                "\t  Exam 3 -> 250.0\n" +
                "\t  Exam 4 -> 0.0\n" +
                ", Student Name: Mike Jones\n" +
                "> Average Score: 164.0\n" +
                "> Exam Scores:\n" +
                "\t  Exam 1 -> 250.0\n" +
                "\t  Exam 2 -> 100.0\n" +
                "\t  Exam 3 -> 100.0\n" +
                "\t  Exam 4 -> 150.0\n" +
                ", null]";

        String actual = Arrays.toString(classroom.getStudents());
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void moveNullSortArray() {

        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScoresS1 = {92.0, 150.0, 250.0, 0.0};
        Double[] examScoresS2 = {250.0, 100.0, 100.0, 150.0};
        Double[] examScoresS3 = {0.0, 150.0, 250.0, 50.00};
        Double[] examScoresS4 = {100.0, 120.0, 150.0, 0.0};
        // When
        Student testS1 = new Student("Leon", "Hunter", examScoresS1);
        Student testS2 = new Student("Joe", "Smith", examScoresS2);
        Student testS3 = new Student("Mike", "Jones", examScoresS3);
        Student testS4 = new Student("Bob", "Johnson", examScoresS4);


        classroom.addStudent(testS1);
        classroom.addStudent(testS2);
        classroom.addStudent(testS3);
        classroom.addStudent(testS4);
        classroom.removeStudent("Bob", "Johnson");
        classroom.moveNullSortArray();
        // Then
        String expected = "[Student Name: Leon Hunter\n" +
                "> Average Score: 164.0\n" +
                "> Exam Scores:\n" +
                "\t  Exam 1 -> 0.0\n" +
                "\t  Exam 2 -> 150.0\n" +
                "\t  Exam 3 -> 250.0\n" +
                "\t  Exam 4 -> 50.0\n" +
                ", Student Name: Joe Smith\n" +
                "> Average Score: 164.0\n" +
                "> Exam Scores:\n" +
                "\t  Exam 1 -> 92.0\n" +
                "\t  Exam 2 -> 150.0\n" +
                "\t  Exam 3 -> 250.0\n" +
                "\t  Exam 4 -> 0.0\n" +
                ", Student Name: Mike Jones\n" +
                "> Average Score: 164.0\n" +
                "> Exam Scores:\n" +
                "\t  Exam 1 -> 250.0\n" +
                "\t  Exam 2 -> 100.0\n" +
                "\t  Exam 3 -> 100.0\n" +
                "\t  Exam 4 -> 150.0\n" +
                ", null]";

        String actual = Arrays.toString(classroom.getStudents());
        Assert.assertNotEquals(expected, actual);

    }

    @Test
    public void getStudentByScoreTest() {
        int maxNumberOfStudents = 4;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScoresS1 = {92.0, 150.0, 250.0, 50.0};
        Double[] examScoresS2 = {250.0, 100.0, 100.0, 100.0};
        Double[] examScoresS3 = {92.0, 150.0, 250.0, 50.00};
        Double[] examScoresS4 = {90.0, 120.0, 99.0, 10.0};
        // When
        Student testS1 = new Student("Leon", "Hunter", examScoresS1);
        Student testS2 = new Student("Joe", "Smith", examScoresS2);
        Student testS3 = new Student("Mike", "Jones", examScoresS3);
        Student testS4 = new Student("Bob", "Johnson", examScoresS4);

        classroom.addStudent(testS1);
        classroom.addStudent(testS2);
        classroom.addStudent(testS3);
        classroom.addStudent(testS4);
        Student[] actual = classroom.getStudentsByScore(150.0);
        // Then
        Student [] expected = new Student[]{testS1, testS3};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortFoundStudentsTest() {
        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] student1score = {100.0, 100.0, 250.0};
        Double[] student2score = {100.0, 100.0, 250.0};
        // When
        Student student1 = new Student("George", "Allen", student1score);
        Student student2 = new Student("Cathy", "Brown", student2score);

        List<Student> unsorted = new ArrayList<Student>();
        unsorted.add(student1);
        unsorted.add(student2);

        String expected = "[Student Name: Cathy Brown\n" +
                "> Average Score: 150.0\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 100.0\n" +
                "\t   Exam 2 -> 100.0\n" +
                "\t   Exam 3 -> 250.0\n" +
                ", Student Name: George Allen\n" +
                "> Average Score: 150.0\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 100.0\n" +
                "\t   Exam 2 -> 100.0\n" +
                "\t   Exam 3 -> 250.0\n" +
                "]";


        List<Student> actual = classroom.sortFoundStudents(unsorted);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void getGradeBook() {
        //Given

        Double[] examScores1 = {99.0, 50.0, 82.0};
        Double[] examScores2 = {100.0, 100.0, 50.0};
        Double[] examScores3 = {92.0, 80.0, 73.0};
        Double[] examScores4 = {100.0, 84.0, 62.0};
        Double[] examScores5 = {60.0, 50.0, 90.0};

        Student student1 = new Student ("Leon", "Hunter", examScores1);
        Student student2 = new Student ("Joe", "Smith", examScores2);
        Student student3 = new Student ("Mike", "Jones", examScores3);
        Student student4 = new Student ("John", "Brown", examScores4);
        Student student5 = new Student ("Tim", "Johnson", examScores5);

        Student[] students = new Student[5];
        Classroom classroom = new Classroom(students);

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);
        classroom.addStudent(student5);

        //When
        String expected = "{A=[Student Name: Leon Hunter\n" +
                "> Average Score: 77.0\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 99.0\n" +
                "\t   Exam 2 -> 50.0\n" +
                "\t   Exam 3 -> 82.0\n" +
                "], B=[Student Name: Joe Smith\n" +
                "> Average Score: 83.33333333333333\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 100.0\n" +
                "\t   Exam 2 -> 100.0\n" +
                "\t   Exam 3 -> 50.0\n" +
                "], C=[Student Name: Mike Jones\n" +
                "> Average Score: 81.66666666666667\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 92.0\n" +
                "\t   Exam 2 -> 80.0\n" +
                "\t   Exam 3 -> 73.0\n" +
                "], D=[Student Name: John Brown\n" +
                "> Average Score: 82.0\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 100.0\n" +
                "\t   Exam 2 -> 84.0\n" +
                "\t   Exam 3 -> 62.0\n" +
                ", Student Name: Tim Johnson\n" +
                "> Average Score: 66.66666666666667\n" +
                "> Exam Scores: \n" +
                "\t   Exam 1 -> 60.0\n" +
                "\t   Exam 2 -> 50.0\n" +
                "\t   Exam 3 -> 90.0\n" +
                "]}";
        TreeMap<Character, ArrayList<Student>> actual = classroom.getGradeBook();
        //Then
        Assert.assertEquals(expected, actual.toString());
    }
}





    // removeStudent(String firstName, String lastName) uses their name to remove them

    // getStudentsByScore() - returns an array of students by descending score. (If two have the same score, order them lexigraphically)

    //getGradeBook() - shows students by percentile ranking (A, B, C, D, F)


