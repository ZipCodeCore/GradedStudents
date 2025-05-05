package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Luis J. Romero on 2/16/2018
 *
 * Restrictions - Ensure unit positive and negative unit tests exist per feature of the application
 */


public class ClassroomTest {

    private Classroom classroom;

    @Before
    public void executedBeforeEach() {

    }

    @Test
    public void ClassroomMaxNumberOfStudentsConstructorPositiveTest() {

        // Given
        int expectedMaxNumberOfStudents = 5;
        this.classroom = new Classroom(5);

        // When
        int actualMaxNumberOfStudents = this.classroom.studentsArray.length;

        // Then
        Assert.assertEquals(expectedMaxNumberOfStudents, actualMaxNumberOfStudents);

    }

    @Test
    public void ClassroomStudentsArrayConstructorPositiveTest() {

        // Given
        String expectedFirstName0 = "first0";
        String expectedFirstName1 = "first1";
        String expectedFirstName2 = "first2";

        String expectedLastName0 = "last0";
        String expectedLastName1 = "last1";
        String expectedLastName2 = "last2";

        Double[] expectedDoubleArray0 = {0.0, 1.0, 2.0};
        Double[] expectedDoubleArray1 = {1.0, 1.0, 2.0};
        Double[] expectedDoubleArray2 = {2.0, 1.0, 2.0};

        Student[] expectedStudentsArray = {new Student(expectedFirstName0, expectedLastName0, expectedDoubleArray0),
                new Student(expectedFirstName1, expectedLastName1, expectedDoubleArray1),
                new Student(expectedFirstName2, expectedLastName2, expectedDoubleArray2)};

        this.classroom = new Classroom(expectedStudentsArray);

        // When
        String actualFirstName0 = this.classroom.studentsArray[0].getFirstName();
        String actualFirstName1 = this.classroom.studentsArray[1].getFirstName();
        String actualFirstName2 = this.classroom.studentsArray[2].getFirstName();

        String actualLastName0 = this.classroom.studentsArray[0].getLastName();
        String actualLastName1 = this.classroom.studentsArray[1].getLastName();
        String actualLastName2 = this.classroom.studentsArray[2].getLastName();

        String actualDoubleArray0 = this.classroom.studentsArray[0].getExamScoresArrayList().toString();
        String actualDoubleArray1 = this.classroom.studentsArray[1].getExamScoresArrayList().toString();
        String actualDoubleArray2 = this.classroom.studentsArray[2].getExamScoresArrayList().toString();

        // Then
        Assert.assertEquals(expectedFirstName0, actualFirstName0);
        Assert.assertEquals(expectedFirstName1, actualFirstName1);
        Assert.assertEquals(expectedFirstName2, actualFirstName2);

        Assert.assertEquals(expectedLastName0, actualLastName0);
        Assert.assertEquals(expectedLastName1, actualLastName1);
        Assert.assertEquals(expectedLastName2, actualLastName2);

        Assert.assertEquals(Arrays.toString(expectedDoubleArray0), actualDoubleArray0);
        Assert.assertEquals(Arrays.toString(expectedDoubleArray1), actualDoubleArray1);
        Assert.assertEquals(Arrays.toString(expectedDoubleArray2), actualDoubleArray2);

//        System.out.println(actualFirstName0);
//        System.out.println(actualFirstName1);
//        System.out.println(actualFirstName2);
//
//        System.out.println(actualLastName0);
//        System.out.println(actualLastName1);
//        System.out.println(actualLastName2);
//
//        System.out.println(actualDoubleArray0);
//        System.out.println(actualDoubleArray1);
//        System.out.println(actualDoubleArray2);
    }

    @Test
    public void ClassroomDefaultConstructorPositiveTest() {

        // Given
        int expectedLengthOfStudentsArray = 30;
        this.classroom = new Classroom();

        // When
        int actualLengthOfStudentsArray = this.classroom.studentsArray.length;

        // Then
        Assert.assertEquals(expectedLengthOfStudentsArray, actualLengthOfStudentsArray);
    }

    @Test
    public void getStudentsDefaultConstructorPositiveTest() {

        // Given
        this.classroom = new Classroom();

        // When
        //String actualStudentsArrayAsString0 = this.classroom.getStudents()[0];

        // Then
        Assert.assertEquals(null, this.classroom.getStudents()[0]);
        Assert.assertEquals(null, this.classroom.getStudents()[15]);
        Assert.assertEquals(null, this.classroom.getStudents()[29]);

        //System.out.println(Arrays.toString(this.classroom.getStudents()));
    }


    @Test
    public void getStudentsStudentsArrayConstructorPositiveTest() {

        String expectedFirstName0 = "first0";
        String expectedFirstName1 = "first1";

        String expectedLastName0 = "last0";
        String expectedLastName1 = "last1";

        Double[] expectedDoubleArray0 = {0.0, 1.0, 2.0};
        Double[] expectedDoubleArray1 = {1.0, 1.0, 2.0};

        Student[] expectedStudentsArray = { new Student(expectedFirstName0, expectedLastName0, expectedDoubleArray0),
                                            new Student(expectedFirstName1, expectedLastName1, expectedDoubleArray1) };

        this.classroom = new Classroom(expectedStudentsArray);

        // When
//        String actualFirstName0 = this.classroom.studentsArray[0].getFirstName();
//        String actualFirstName1 = this.classroom.studentsArray[1].getFirstName();
//
//        String actualLastName0 = this.classroom.studentsArray[0].getLastName();
//        String actualLastName1 = this.classroom.studentsArray[1].getLastName();
//
//        String actualDoubleArray0 = this.classroom.studentsArray[0].getExamScoresArrayList().toString();
//        String actualDoubleArray1 = this.classroom.studentsArray[1].getExamScoresArrayList().toString();

        // Then
        //This test is deprecated, but it works
        Assert.assertEquals(expectedStudentsArray, this.classroom.getStudents());
        //System.out.println(Arrays.toString(this.classroom.getStudents()));
    }

    @Test
    public void getClassroomAverageExamScorePositiveTest() {
        // Given
        String expectedFirstName0 = "first0";
        String expectedFirstName1 = "first1";
        String expectedFirstName2 = "first2";

        String expectedLastName0 = "last0";
        String expectedLastName1 = "last1";
        String expectedLastName2 = "last2";

        Double[] expectedDoubleArray0 = { 25.0, 34.0, 41.0 };
        Double[] expectedDoubleArray1 = { 47.0, 7.0, 13.0 };
        Double[] expectedDoubleArray2 = { 50.0, 100.0, 35.0 };

        Student[] expectedStudentsArray = { new Student(expectedFirstName0, expectedLastName0, expectedDoubleArray0),
                                            new Student(expectedFirstName1, expectedLastName1, expectedDoubleArray1),
                                            new Student(expectedFirstName2, expectedLastName2, expectedDoubleArray2) };

        this.classroom = new Classroom(expectedStudentsArray);

        double expectedClassroomAverageExamScore = 39.1;

        // When
        double actualClassroomAverageExamScore = this.classroom.getClassroomAverageExamScore();

        // Then
        Assert.assertEquals(expectedClassroomAverageExamScore, actualClassroomAverageExamScore, 0.001);
        //System.out.println(expectedClassroomAverageExamScore);
    }

    @Test
    public void addStudentPositiveTest() {
        // Given
        String expectedFirstName0 = "first0";
        String expectedFirstName1 = "first1";
        String expectedFirstName2 = "first2";

        String expectedLastName0 = "last0";
        String expectedLastName1 = "last1";
        String expectedLastName2 = "last2";

        Double[] expectedDoubleArray0 = { 25.0, 34.0, 41.0 };
        Double[] expectedDoubleArray1 = { 47.0, 7.0, 13.0 };
        Double[] expectedDoubleArray2 = { 50.0, 100.0, 35.0 };

        Student[] expectedStudentsArray = { new Student(expectedFirstName0, expectedLastName0, expectedDoubleArray0),
                                            new Student(expectedFirstName1, expectedLastName1, expectedDoubleArray1),
                                            new Student(expectedFirstName2, expectedLastName2, expectedDoubleArray2) };

        this.classroom = new Classroom(expectedStudentsArray);
//        System.out.println(Arrays.toString(this.classroom.getStudents()));
//        System.out.println(this.classroom.getClassroomAverageExamScore());
//        System.out.println("+++++++++++++++++++++");

        String expectedNewFirst = "newFirst";
        String expectedNewLast = "newLast";
        Double[] expectedNewDoubleArray = { 9.0, 9.0, 9.0 };
        this.classroom.addStudent(new Student(expectedNewFirst, expectedNewLast, expectedNewDoubleArray));
//        System.out.println(Arrays.toString(this.classroom.getStudents()));
//        System.out.println(this.classroom.getClassroomAverageExamScore());

        // When
        String actualNewFirst = this.classroom.getStudents()[3].getFirstName();
        String actualNewLast = this.classroom.getStudents()[3].getLastName();
        String actualNewDoubleArray = this.classroom.getStudents()[3].getExamScoresArrayList().toString();
        //System.out.println(this.classroom.getStudents()[3].toString());

        // Then
        Assert.assertEquals(expectedNewFirst, actualNewFirst);
        Assert.assertEquals(expectedNewLast, actualNewLast);
        Assert.assertEquals(Arrays.toString(expectedNewDoubleArray), actualNewDoubleArray);
    }

    @Test
    public void removeStudentPositiveTest() {
        // Given
        String expectedFirstName0 = "first0";
        String expectedFirstName1 = "first1";
        String expectedFirstName2 = "first2";

        String expectedLastName0 = "last0";
        String expectedLastName1 = "last1";
        String expectedLastName2 = "last2";

        Double[] expectedDoubleArray0 = { 25.0, 34.0, 41.0 };
        Double[] expectedDoubleArray1 = { 47.0, 7.0, 13.0 };
        Double[] expectedDoubleArray2 = { 50.0, 100.0, 35.0 };

        Student[] expectedStudentsArray = { new Student(expectedFirstName0, expectedLastName0, expectedDoubleArray0),
                new Student(expectedFirstName1, expectedLastName1, expectedDoubleArray1),
                new Student(expectedFirstName2, expectedLastName2, expectedDoubleArray2) };

        this.classroom = new Classroom(expectedStudentsArray);
//        System.out.println("original array: ");
//        System.out.println(Arrays.toString(this.classroom.getStudents()));
//        System.out.println("+++++++++++++++++++++");

        String expectedNewFirst = "newFirst";
        String expectedNewLast = "newLast";
        Double[] expectedNewDoubleArray = { 9.0, 9.0, 9.0 };
        this.classroom.addStudent(new Student(expectedNewFirst, expectedNewLast, expectedNewDoubleArray));
//        System.out.println("array with added: ");
//        System.out.println(Arrays.toString(this.classroom.getStudents()));
//        System.out.println("+++++++++++++++++++++");


        String expectedFirstNameToRemove = expectedFirstName2;
        String expectedLastNameToRemove = expectedLastName2;
        this.classroom.removeStudent(expectedFirstNameToRemove, expectedLastNameToRemove);
//        System.out.println("array with removed: ");
//        System.out.println(Arrays.toString(this.classroom.getStudents()));

        // When


        // Then
        Assert.assertNull(this.classroom.getStudents()[3]);
    }

    @Test
    public void getStudentByAverageScorePositiveTest() {
        // Given
        String expectedFirstName0 = "Zack";
        String expectedFirstName1 = "Joseph";
        String expectedFirstName2 = "Ben";
        String expectedFirstName3 = "Adam";

        String expectedLastName0 = "Anderson";
        String expectedLastName1 = "Benjamin";
        String expectedLastName2 = "Charles";
        String expectedLastName3 = "Denver";


        Double[] expectedDoubleArray0 = { 2.0, 2.0, 2.0 };
        Double[] expectedDoubleArray1 = { 1.0, 1.0, 1.0 };
        Double[] expectedDoubleArray2 = { 2.0, 2.0, 2.0 };
        Double[] expectedDoubleArray3 = { 0.0, 0.0, 0.0 };

        Student[] expectedStudentsArray = { new Student(expectedFirstName0, expectedLastName0, expectedDoubleArray0),
                                            new Student(expectedFirstName1, expectedLastName1, expectedDoubleArray1),
                                            new Student(expectedFirstName2, expectedLastName2, expectedDoubleArray2),
                                            new Student(expectedFirstName3, expectedLastName3, expectedDoubleArray3) };

        this.classroom = new Classroom(expectedStudentsArray);
//        System.out.println("original array: ");
//        System.out.println(Arrays.toString(this.classroom.getStudents()));
//        System.out.println("+++++++++++++++++++++");

        // After calling getStudentsByAverageScore
        this.classroom.getStudentsbyAverageScore();
//        System.out.println("sorted new Comparator: ");
//        System.out.println(Arrays.toString(this.classroom.getStudents()));

        // When
        String actualFirstElementFirstName = this.classroom.getStudentsbyAverageScore()[0].getFirstName();
        String actualSecondElementFirstName = this.classroom.getStudentsbyAverageScore()[1].getFirstName();
        String actualThirdElementFirstName = this.classroom.getStudentsbyAverageScore()[2].getFirstName();
        String actualFourthElementFirstName = this.classroom.getStudentsbyAverageScore()[3].getFirstName();

        // Then (in expected order, from first element to last element):
//        String expectedFirstName2 = "Ben";
//        String expectedFirstName0 = "Zack";
//        String expectedFirstName1 = "Joseph";
//        String expectedFirstName3 = "Adam";

        Assert.assertEquals(expectedFirstName2, actualFirstElementFirstName);
        Assert.assertEquals(expectedFirstName0, actualSecondElementFirstName);
        Assert.assertEquals(expectedFirstName1, actualThirdElementFirstName);
        Assert.assertEquals(expectedFirstName3, actualFourthElementFirstName);
    }

    @Test
    public void getGradeBookPositiveTest() {
        // Given
        String expectedFirstName0 = "Zack";
        String expectedFirstName1 = "Joseph";
        String expectedFirstName2 = "Ben";
        String expectedFirstName3 = "Adam";
        String expectedFirstName4 = "David";

        String expectedLastName0 = "Anderson";
        String expectedLastName1 = "Benjamin";
        String expectedLastName2 = "Charles";
        String expectedLastName3 = "Denver";
        String expectedLastName4 = "Emerson";



        Double[] expectedDoubleArray0 = { 92.0, 95.0, 100.0 }; // A
        Double[] expectedDoubleArray1 = { 72.0, 73.0, 74.0 };  // B
        Double[] expectedDoubleArray2 = { 55.0, 65.0, 68.0 };  // C
        Double[] expectedDoubleArray3 = { 20.0, 35.0, 45.0 };  // D
        Double[] expectedDoubleArray4 = { 0.0, 5.0, 8.0 };     // F

        Student[] expectedStudentsArray = { new Student(expectedFirstName0, expectedLastName0, expectedDoubleArray0),
                new Student(expectedFirstName1, expectedLastName1, expectedDoubleArray1),
                new Student(expectedFirstName2, expectedLastName2, expectedDoubleArray2),
                new Student(expectedFirstName3, expectedLastName3, expectedDoubleArray3),
                new Student(expectedFirstName4, expectedLastName4, expectedDoubleArray4) };

        this.classroom = new Classroom(expectedStudentsArray);
//        System.out.println("original array: ");
//        System.out.println(Arrays.toString(this.classroom.getStudents()));
//
        // After calling getStudentsByAverageScore
        this.classroom.getStudentsbyAverageScore();
//        System.out.println("sorted new Comparator: ");
//        System.out.println(Arrays.toString(this.classroom.getStudents()));
//        System.out.println("+++++++++++++++++++++");

//        System.out.println("treeMap before calling GetGradeBook: ");
//        System.out.println(this.classroom.hashMap.toString());
//        System.out.println("+++++++++++++++++++++");

        this.classroom.getGradeBook();
//        System.out.println("treeMap after calling GetGradeBook: ");
//        System.out.println(this.classroom.hashMap.toString());

        // When
        String expectedMapValueLetter0 = "A";
        String actualMapValueLetter0 = this.classroom.hashMap.get(this.classroom.getStudentsbyAverageScore()[0]);

        // Then
        Assert.assertEquals(expectedMapValueLetter0, actualMapValueLetter0);
    }

}
