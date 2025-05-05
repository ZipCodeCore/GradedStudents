package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.awt.geom.Arc2D;
import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void nullaryConstructorTest(){
        //given
        int expectedEnrollment = 30;

        //when
        Classroom classroom = new Classroom();
        int actual = classroom.getStudents().length;

        //then
        Assert.assertEquals(expectedEnrollment, actual);
    }

    @Test
    public void maxNumberStudentTest() {
        //given
        int maxStudents = 25;

        //when
        Classroom testClassroom = new Classroom(maxStudents);
        int actual = testClassroom.getStudents().length;

        //then
        Assert.assertEquals(maxStudents, actual);
    }

    @Test
    public void studentCollectionTest() {
        //given
        Double[] examScores = {85.0, 90.0, 95.0};
        Student student1 = new Student("Jay", "Kay", examScores);
        Student student2 = new Student("Shelly-Ann", "Frasier", examScores);
        Student student3 = new Student("Linda", "Jones", examScores);
        Student[] students = {student1, student2, student3};

        //when
        Classroom testClassroom = new Classroom(students);
        int actual = testClassroom.getStudents().length;

        //then
        Assert.assertEquals(3, actual);
    }
    @Test
    public void classAverageTest(){
        //given
        Double[] examScores = {85.0, 90.0, 95.0};
        Double[] examScores2 ={80.0, 90.0, 100.0};
        Double[] examScores3 = {100.0, 100.0, 80.0};
        Student student1 = new Student("Jay", "Kay", examScores);
        Student student2 = new Student("Shelly-Ann", "Frasier", examScores2);
        Student student3 = new Student("Linda", "Jones", examScores3);
        Student[] students = {student1, student2, student3};

        //when
        Classroom testClass = new Classroom(students);
        double actual = testClass.getAverageExamScore();

        //then
        double expected = 91.11;
        Assert.assertEquals(expected, actual, 0.01);
    }
     @Test
    public void addStudentTest(){
         //given
         int maxNumOfStudents = 1;
         Classroom testClassroom = new Classroom(maxNumOfStudents);
         Double[] examScores = {85.0, 90.0, 95.0};
         Student student1 = new Student("Jay", "Kay", examScores);

         //when
         Student[] preEnrollment = testClassroom.getStudents();
         System.out.println("===========================");

         String preEnrollmentAsString = Arrays.toString(preEnrollment);
         System.out.println(preEnrollmentAsString);

         //then
         testClassroom.addStudent(student1);
         Student[] postEnrollment = testClassroom.getStudents();
         String postEnrollmentAsString = Arrays.toString(postEnrollment);


         System.out.println("===========================");
         System.out.println(postEnrollmentAsString);
     }

     @Test
    public void removeStudentTest (){
        //given
         Double[] examScores = {85.0, 90.0, 95.0};
         Double[] examScores2 ={80.0, 90.0, 100.0};
         Double[] examScores3 = {100.0, 100.0, 80.0};
         Student student1 = new Student("Jay", "Kay", examScores);
         Student student2 = new Student("Shelly-Ann", "Frasier", examScores2);
         Student student3 = new Student("Linda", "Jones", examScores3);
         Student[] students = {student1, student2, student3};

         //when
         Classroom testRoom = new Classroom();
         testRoom.addStudent(student1);
         testRoom.addStudent(student2);
         testRoom.addStudent(student3);
         testRoom.removeStudentbyName("Jay", "Kay");

         //then
         System.out.println(Arrays.toString(testRoom.getStudents()));
         Student removedStudent = testRoom.getStudents()[2];
         Assert.assertNull(removedStudent);

        // Student actual = students[0];
//         Assert.assertNull(actual);

     }

    @Test
    public void removeStudentTest2 () {
        //given
        Double[] examScores = {85.0, 90.0, 95.0};
        Double[] examScores2 = {80.0, 90.0, 100.0};
        Double[] examScores3 = {100.0, 100.0, 80.0};
        Student student1 = new Student("Jay", "Kay", examScores);
        Student student2 = new Student("Shelly-Ann", "Frasier", examScores2);
        Student student3 = new Student("Linda", "Jones", examScores3);


        //when
        Classroom testRoom = new Classroom();
        testRoom.addStudent(student1);
        testRoom.addStudent(student2);
        testRoom.addStudent(student3);
        testRoom.removeStudentbyName("Shelly-Ann", "Frasier");

        //then
        System.out.println(testRoom.getStudents()[1]); //equals second student Linda Jones
        Student removedStudent = testRoom.getStudents()[2];
        Assert.assertNull(removedStudent);
    }

    @Test
    public void sortStudentScoreTest () {
        //given
        Double[] examScores = {85.0, 90.0, 95.0};
        Double[] examScores2 = {80.0, 90.0, 100.0};
        Double[] examScores3 = {100.0, 100.0, 80.0};
        Student student1 = new Student("Jay", "Kay", examScores);
        Student student2 = new Student("Shelly-Ann", "Frasier", examScores2);
        Student student3 = new Student("Linda", "Jones", examScores3);
        Student[] students = {student1, student2, student3};

        //when
        Classroom testRoom = new Classroom(students);
        Student[] testSort = testRoom.getStudentByScore();

        //then
        System.out.println(Arrays.toString(testSort));
    }

    @Test
    public void getGradesTest(){
        //given
        Double[] examScores = {85.0, 90.0, 95.0};
        Double[] examScores2 = {80.0, 90.0, 100.0};
        Double[] examScores3 = {100.0, 100.0, 80.0};
        Student student1 = new Student("Jay", "Kay", examScores);
        Student student2 = new Student("Shelly-Ann", "Frasier", examScores2);
        Student student3 = new Student("Linda", "Jones", examScores3);
        Student[] students = {student1, student2, student3};

        //when
        Classroom testRoom = new Classroom(students);
        char grade = testRoom.assignGrade(student2);

        //then
        System.out.println(grade);

        //System.out.println(testRoom.getGradeBook());

    }

    @Test
    public void getGradeBookTest() {
        //given
        Double[] examScores = {85.0, 70.0, 75.0};
        Double[] examScores2 = {90.0, 95.0, 100.0};
        Double[] examScores3 = {100.0, 100.0, 98.0};
        Double[] examScores4 = {60.0, 72.0, 65.0};
        Student student1 = new Student("Jay", "Kay", examScores);
        Student student2 = new Student("Shelly-Ann", "Frasier", examScores2);
        Student student3 = new Student("Linda", "Jones", examScores3);
        Student  student4 = new Student("Bud", "Dunce", examScores4);
        Student[] students = {student1, student2, student3, student4};

        //when
        Classroom testRoom = new Classroom(students);


        //then
        testRoom.getGradeBook();

    }
    @Test
    public void getGradeBookMapTest() {
        //given
        Double[] examScores = {85.0, 70.0, 75.0};
        Double[] examScores2 = {90.0, 95.0, 100.0};
        Double[] examScores3 = {100.0, 100.0, 98.0};
        Double[] examScores4 = {60.0, 72.0, 65.0};
        Student student1 = new Student("Jay", "Kay", examScores);
        Student student2 = new Student("Shelly-Ann", "Frasier", examScores2);
        Student student3 = new Student("Linda", "Jones", examScores3);
        Student  student4 = new Student("Bud", "Dunce", examScores4);
        Student[] students = {student1, student2, student3, student4};

        //when
        Classroom testRoom = new Classroom(students);
        char actualGrade = testRoom.getGradeBookMap().get(student4);

        //then
        Assert.assertEquals('F', actualGrade);

    }
}
