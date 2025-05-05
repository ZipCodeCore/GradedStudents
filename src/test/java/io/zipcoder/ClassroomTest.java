package io.zipcoder;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Arrays;
import java.util.HashMap;



public class ClassroomTest {
    Student stinkyPete;
    Student smellyPeter;
    Student sugarySam;
    Student juicyJoe;
    Student terribleTariq;
    Classroom test;



    @Before
    public void setUp() {
        stinkyPete = new Student("Stinky", "Pete", new Double[]{100.0, 50.25, 25.3});
        smellyPeter = new Student("Smelly", "Peter", new Double[]{99.0, 100.0, 91.0});
        sugarySam = new Student("Sugary", "Sam", new Double[]{75.0, 82.0, 91.0});
        juicyJoe = new Student("Juicy", "Joe", new Double[]{83.0, 29.87, 88.5});
        terribleTariq = new Student("Terrible", "Tariq", new Double[]{100., 100.0, 100.});
        test = new Classroom(new Student[]{stinkyPete, smellyPeter, sugarySam, juicyJoe, terribleTariq});

    }

    @Test
    public void getStudentsTest(){
        //Given
        //Classroom test

        //When
        Student [] expected = {stinkyPete, smellyPeter, sugarySam, juicyJoe, terribleTariq};
        Student [] actual = test.getStudents();

        //Then
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void nullaryClassroomTest(){
        //Given
        Classroom nullaryTest = new Classroom();

        //When
        int expectedSize = 30;
        int actualSize = nullaryTest.getStudents().length;

        //Then
        Assert.assertEquals(actualSize,expectedSize);
    }

    @Test
    public void maxClassroomSizeTest(){
        //Given
        Classroom maxSizeTest = new Classroom(20);

        //When
        int expectedSize = 20;
        int actualSize = maxSizeTest.getStudents().length;

        //Then
        Assert.assertEquals(actualSize,expectedSize);
    }

    @Test
    public void getAverageExamScoreTest(){
        //Given
        //Classroom test

        //When
        double expectedAverage = 81.0;
        double actualAverage = test.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAverage,actualAverage, 0.01);
    }

    @Test
    public void addStudentTest(){
        //Given
        Classroom toBeAddedTo = new Classroom(0);
        Student lazyLeon = new Student("Lazy", "Leon", new Double[]{0.0, 50.0, 100.0});



        //When
        toBeAddedTo.addStudent(lazyLeon);
        String expected =
                "[Student Name: Lazy Leon\n"+
                        "Average Score = 50.0\n"+
                        "Exam Scores:\n"+
                        "\tExam 1 => 0\n" +
                        "\tExam 2 => 50\n" +
                        "\tExam 3 => 100\n]";
        String actual = Arrays.toString(toBeAddedTo.getStudents());

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addStudentTest2(){
        //Given
        Classroom toBeAddedTo = new Classroom(1);
        Student lazyLeon = new Student("Lazy", "Leon", new Double[]{0.0, 50.0, 100.0});



        //When
        toBeAddedTo.addStudent(lazyLeon);
        String expected =
                "[Student Name: Lazy Leon\n"+
                        "Average Score = 50.0\n"+
                        "Exam Scores:\n"+
                        "\tExam 1 => 0\n" +
                        "\tExam 2 => 50\n" +
                        "\tExam 3 => 100\n]";
        String actual = Arrays.toString(toBeAddedTo.getStudents());

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeStudentTest(){
        //Given
        //Classroom test

        //When
        test.removeStudent("Stinky", "Pete");
        Student [] expected = {smellyPeter, sugarySam, juicyJoe, terribleTariq, null};
        Student [] actual = test.getStudents();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getStudentsByScoreTest(){
        //Given
        //Classroom test
        Student franticFroilan = new Student("Frantic", "Froilan",new Double[]{100., 100.0, 100.});
        test.addStudent(franticFroilan);

        //When
        Student [] expected = {franticFroilan, terribleTariq, smellyPeter, sugarySam, juicyJoe, stinkyPete};
        Student[] actual = test.getStudentsByScore();


        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getStudentsByScoreSimilarNameTest(){
        //Given
        //Classroom test
        Student franticFroilan = new Student("Frantic", "Froilan",new Double[]{100., 100.0, 100.});
        Student franticFroilaz = new Student("Frantic", "Froilaz",new Double[]{100., 100.0, 100.});
        test.addStudent(franticFroilaz);
        test.addStudent(franticFroilan);


        //When
        Student [] expected = {franticFroilan, franticFroilaz, terribleTariq, smellyPeter, sugarySam, juicyJoe, stinkyPete};
        Student[] actual = test.getStudentsByScore();


        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getStudentsByScoreSameLastNameTest(){
        //Given
        //Classroom test
        Student franticFroilan = new Student("Frantic", "Froilan",new Double[]{100., 100.0, 100.});
        Student fineFroilan = new Student("Fine", "Froilan",new Double[]{100., 100.0, 100.});
        test.addStudent(franticFroilan);
        test.addStudent(fineFroilan);


        //When
        Student [] expected = {fineFroilan, franticFroilan, terribleTariq, smellyPeter, sugarySam, juicyJoe, stinkyPete};
        Student[] actual = test.getStudentsByScore();


        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void identifyStudentTest(){
        //Given
        //Classroom test

        //When
        Student expected = terribleTariq;
        Student actual = test.identifyStudent("Terrible", "Tariq");

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void identifyStudentIndexTest(){
        //Given
        //Classroom test

        //When
        int expected = 4;
        int actual = test.identifyStudentIndex(terribleTariq);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void moveNullToEndTest(){
        //Given
        Student franticFroilan = new Student ("Frantic", "Froilan", new Double[]{100.0, 75.0, 88.0});
        Student lazyLeon = new Student("Lazy", "Leon", new Double[]{0.0, 50.0, 100.0});
        Student [] test = {null, franticFroilan, lazyLeon};
        Classroom reorderTest = new Classroom (test);


        //When
        reorderTest.moveNullToEnd();
        Student [] expected = {franticFroilan, lazyLeon, null};
        Student [] actual = reorderTest.getStudents();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void calculatePercentileThresholdTest(){
        //Given
        double [] testValues = {99,99,98,96,95,93,89,88,87,85,79,78,77,72,71,70,69,69,68,66,62,61,56,54,43};

        //When
        double percentile = .9;
        double expectedThreshold = 98;
        double actualThreshold = Classroom.calculatePercentileThreshold(testValues, .9);

        //Then
        Assert.assertEquals(expectedThreshold, actualThreshold, 0.01);

    }

    @Test
    public void calculatePercentileThresholdTest2(){
        //Given
        double [] testValues = {99,99,98,96,95,93,89,88,87,85,79,78,77,72,71,70,69,69,68,66,62,61,56,54,43};

        //When
        double percentile = .2;
        double expectedThreshold = 64;
        double actualThreshold = Classroom.calculatePercentileThreshold(testValues, .2);

        //Then
        Assert.assertEquals(expectedThreshold, actualThreshold, 0.01);

    }

    @Test
    public void getAllAveragesTest(){
        //Given
        //Classroom test

        //When
        double[] expected = {59,97,83,67,100};
        double[] actual = test.getAllAverages();

        //Then
        Assert.assertTrue(Arrays.equals(expected,actual));
    }

    @Test
    public void containsANullTest(){
        //Given
        Classroom nullTest = new Classroom();

        //When
        boolean expected = true;
        boolean actual = nullTest.containsANull();

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void containsANullTest2(){
        //Given
        //Classroom test

        //When
        boolean expected = false;
        boolean actual = test.containsANull();

        //Then
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getGradeBookStringTest(){
        //Given
        //Classroom test
        Student noName55 = new Student("No", "Name55", new Double[]{55.0});
        Student noName50 = new Student("No", "Name50", new Double[]{50.0});
        Student noName49 = new Student("No", "Name49", new Double[]{49.0});
        Student noName45 = new Student("No", "Name45", new Double[]{45.0});
        Student noName25 = new Student("No", "Name25", new Double[]{25.0});
        test.addStudent(noName55);
        test.addStudent(noName50);
        test.addStudent(noName49);
        test.addStudent(noName45);
        test.addStudent(noName25);


        //When
        String expected =
                "Terrible Tariq : A\n"+
                        "Smelly Peter : B\n"+
                        "Sugary Sam : B\n"+
                        "Juicy Joe : C\n"+
                        "Stinky Pete : C\n"+
                        "No Name55 : D\n"+
                        "No Name50 : D\n"+
                        "No Name49 : D\n"+
                        "No Name45 : D\n"+
                        "No Name25 : F\n";

        String actual = test.getGradeBookString();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getGradeBookMapTest(){
        //Given
        //Classroom test
        Student noName55 = new Student("No", "Name55", new Double[]{55.0});
        Student noName50 = new Student("No", "Name50", new Double[]{50.0});
        Student noName49 = new Student("No", "Name49", new Double[]{49.0});
        Student noName45 = new Student("No", "Name45", new Double[]{45.0});
        Student noName25 = new Student("No", "Name25", new Double[]{25.0});
        test.addStudent(noName55);
        test.addStudent(noName50);
        test.addStudent(noName49);
        test.addStudent(noName45);
        test.addStudent(noName25);


        //When
        HashMap<Student,Character> expected = new HashMap<>(10);
        expected.put(terribleTariq, 'A');
        expected.put(smellyPeter, 'B');
        expected.put(sugarySam, 'B');
        expected.put(stinkyPete, 'C');
        expected.put(juicyJoe, 'C');
        expected.put(noName55, 'D');
        expected.put(noName50, 'D');
        expected.put(noName49, 'D');
        expected.put(noName45, 'D');
        expected.put(noName25, 'F');


        HashMap<Student, Character> actual = test.getGradeBookMap();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLetterGradeTest(){
        //Given
        //Classroom test
        Student noName55 = new Student("No", "Name55", new Double[]{55.0});
        Student noName50 = new Student("No", "Name50", new Double[]{50.0});
        Student noName49 = new Student("No", "Name49", new Double[]{49.0});
        Student noName45 = new Student("No", "Name45", new Double[]{45.0});
        Student noName25 = new Student("No", "Name25", new Double[]{25.0});
        test.addStudent(noName55);
        test.addStudent(noName50);
        test.addStudent(noName49);
        test.addStudent(noName45);
        test.addStudent(noName25);

        //When
        char expected = 'C';
        char actual = test.getLetterGrade(juicyJoe);

        //Then
        Assert.assertEquals(expected,actual);

    }

}
