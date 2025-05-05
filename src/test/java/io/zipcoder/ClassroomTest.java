package io.zipcoder;

import org.junit.Test;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Arrays;




public class ClassroomTest {
    ArrayList<Double> examScoresOne = new ArrayList<>(Arrays.asList(85.0, 90.0, 95.0));
    Student studentOne = new Student("Emily","Blanding", examScoresOne);
    ArrayList<Double> examScoresTwo = new ArrayList<>(Arrays.asList(75.0, 90.0, 80.0));
    Student studentTwo = new Student("Ben","Messick", examScoresTwo);
    ArrayList<Double> examScoresThree = new ArrayList<>(Arrays.asList(100.0, 100.0, 100.0));
    Student studentThree = new Student("Elliot", "Journs", examScoresThree);
    ArrayList<Double> examScoresFour = new ArrayList<>(Arrays.asList(65.0, 70.0, 60.0));
    Student studentFour = new Student("Bob", "Adams", examScoresFour);
    ArrayList<Double> examScoresFive = new ArrayList<>(Arrays.asList(65.0, 70.0, 60.0));
    Student studentFive = new Student("Samantha", "Pennington", examScoresFive);
    ArrayList<Double> examScoresSix = new ArrayList<>(Arrays.asList(65.0, 55.0, 45.0));
    Student studentSix = new Student("Andrew","Xavier", examScoresSix);

    @Test
    public void firstConstructorTest() {
        Student[] students = {studentOne, studentTwo};
        Classroom classroom = new Classroom(students);
        Assert.assertNotNull(classroom);
    }

    @Test
    public void testSecondConstructor() {
        Student[] students = {studentTwo, studentThree};
        Classroom classroom = new Classroom(students);
        Assert.assertNotNull(classroom);

    }

    @Test
    public void testThirdConstructor() {
        Student[] students = {studentOne, studentTwo};
        Classroom classroom = new Classroom(students);
        Assert.assertNotNull(classroom);
    }

    @Test
    public void testGetStudents() {
        Student[] students = {studentOne, studentTwo, studentThree};
        Classroom classroom = new Classroom(students);

        Student[] expected = {studentOne, studentTwo, studentThree};
        Student[] actual = classroom.getStudents();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        //Given
        Student[] students = {studentOne, studentTwo, studentThree};
        Classroom classroom = new Classroom(students);
        //When
        long expected =Math.round(Math.ceil((85.0 + 90.0 + 95.0 + 75.0 + 90.0 + + 80.0 + 100.0 + 100.0 + 100.0)/9));
        //That
        long actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddStudent(){
        //Given
        Classroom classroom = new Classroom(2);
        ArrayList<Double> examScores = new ArrayList<>(Arrays.asList(100.0, 95.0, 85.0, 100.0));
        Student student = new Student ("Samantha", "Pennington", examScores);
        //When
        Student[] expectedEnrollment = {student, studentOne};
        //Then
        classroom.addStudent(student);
        classroom.addStudent(studentOne);
        Student[] actualEnrollment = classroom.getStudents();

        Assert.assertArrayEquals(expectedEnrollment, actualEnrollment);
    }

    @Test
    public void testRemoveStudent() {
        Classroom classroom = new Classroom(3);
        //When
        classroom.addStudent(studentOne);
        classroom.addStudent(studentTwo);
        classroom.addStudent(studentThree);
        Student[] expectedEnrollment = {studentOne, studentTwo, null};
        classroom.getStudents();
        //Then
        String studentFirstName = studentThree.getFirstName();
        String studentLastName = studentThree.getLastName();
        classroom.removeStudent(studentFirstName, studentLastName);
        Student[] actualEnrollment = classroom.getStudents();

        Assert.assertArrayEquals(expectedEnrollment, actualEnrollment);
    }

    @Test
    public void testGetStudentByScore(){

        Classroom classroom = new Classroom(6);
        //Given
        ArrayList<Double> examScoresOne = new ArrayList<>(Arrays.asList(85.0, 90.0, 95.0));
        Student studentOne = new Student("Emily","Blanding", examScoresOne);

        ArrayList<Double> examScoresTwo = new ArrayList<>(Arrays.asList(70.0, 90.0, 80.0));
        Student studentTwo = new Student("Ben","Messick", examScoresTwo);

        ArrayList<Double> examScoresThree = new ArrayList<>(Arrays.asList(100.0, 100.0, 100.0));
        Student studentThree = new Student("Elliot", "Journs", examScoresThree);

        ArrayList<Double> examScoresFour = new ArrayList<>(Arrays.asList(65.0, 70.0, 60.0));
        Student studentFour = new Student("Bob", "Adams", examScoresFour);

        ArrayList<Double> examScoresFive = new ArrayList<>(Arrays.asList(65.0, 70.0, 60.0));
        Student studentFive = new Student("Samantha", "Pennington", examScoresFive);

        ArrayList<Double> examScoresSix = new ArrayList<>(Arrays.asList(65.0, 55.0, 45.0));
        Student studentSix = new Student("Andrew","Xavier", examScoresSix);
        //When
        Student[] students= {studentOne, studentTwo, studentThree, studentFour, studentFive, studentSix};
        Student[] expectedOrder = {studentThree, studentOne, studentTwo, studentFour, studentFive, studentSix};
        classroom.addStudent(studentOne);
        classroom.addStudent(studentTwo);
        classroom.addStudent(studentThree);
        classroom.addStudent(studentFour);
        classroom.addStudent(studentFive);
        classroom.addStudent(studentSix);
        //Then
        Student[] actualOrder = classroom.getStudentsByScore();
        Assert.assertArrayEquals(expectedOrder, actualOrder);

    }

//    @Test
//    public void testSortByScoreThenName() {
//        Classroom classroom = new Classroom();
//        ArrayList<Double> examScoresOne = new ArrayList<>(Arrays.asList(85.0, 90.0, 95.0));
//        Student studentOne = new Student("Emily","Blanding", examScoresOne);
//
//        ArrayList<Double> examScoresTwo = new ArrayList<>(Arrays.asList(70.0, 90.0, 80.0));
//        Student studentTwo = new Student("Ben","Messick", examScoresTwo);
//        int expected = -1;
//        classroom.addStudent(studentOne);
//        classroom.addStudent(studentTwo);
//        int actual = classroom.sortByScoreThenName.compare(studentOne,studentTwo);
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void testGetGradeBook() {
        Student[] students = {studentOne, studentTwo, studentThree, studentFour, studentFive, studentSix};
        Classroom classroom = new Classroom(students);

        LinkedHashMap<Student,String> actualStudentMap = classroom.getGradeBook();
        System.out.println(actualStudentMap.toString());

    }

    @Test
    public void testGetGradeBookNameAndGrade() {
        Student[] students = {studentOne, studentTwo, studentThree, studentFour, studentFive, studentSix};
        Classroom classroom = new Classroom(students);

        LinkedHashMap<String,String> actualStudentMap = classroom.getGradeBookNameAndFinalGrade();
        System.out.println(actualStudentMap);
    }
}




