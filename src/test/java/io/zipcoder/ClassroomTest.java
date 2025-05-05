package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeMap;

public class ClassroomTest {

    Classroom classroom = new Classroom();
    Student student1;
    Student student2;
    Student student3;


    @Before
 public void setup() throws Exception {
     ArrayList<Double> examScore1 = new ArrayList<>();
        student1 = new Student("Salle", "Sue", examScore1);
        examScore1.add(90.0);
        examScore1.add(89.0);
        examScore1.add(78.0);
     ArrayList<Double> examScore2 = new ArrayList<>();
        student2 = new Student("Molly", "Kale", examScore2);
        examScore2.add(99.0);
        examScore2.add(98.0);
        examScore2.add(100.0);
     ArrayList<Double> examScore3 = new ArrayList<>();
        student3 = new Student("Sam", "Iam", examScore3);
         examScore3.add(49.0);
         examScore3.add(58.0);
         examScore3.add(80.0);
         classroom.addStudent(student1);
         classroom.addStudent(student2);
         classroom.addStudent(student3);
 }
         @Test
         public void testAddStudent() {
             ArrayList<Double> examScore4 = new ArrayList<>();
             Student student4 = new Student("Silly", "Ham", examScore4);
             examScore4.add(59.0);
             examScore4.add(53.0);
             examScore4.add(23.0);
             classroom.addStudent(student4);

             Student[] expected = new Student[30];
             expected[0]= student1;
             expected[1]= student2;
             expected[2]= student3;
             expected[3]= student4;


             Assert.assertArrayEquals(expected, classroom.getStudents());
         }

         @Test
         public void testRemoveStudent(){

             boolean expected = true;
             boolean actual = classroom.removeStudent("Salle", "Sue");

             Assert.assertEquals(expected, actual);
         }

         @Test
         public void testNumberOfStudentsInClass() {
            int expected = 3;
            int actual = classroom.numberOfStudentsInClass();

             Assert.assertEquals(expected, actual);
         }
         @Test
        public void testGetAverageExamScoreOfAllStudents() {

            Double expected = 82.0;
            Double actual =  classroom.getAverageExamScoreOfAllStudents();

            Assert.assertEquals(expected,actual, .01);
    }

        @Test
        public void testGetStudentByScore (){
        String [] expected = {student3.toString(),student2.toString(),student1.toString()};
        String [] actual = classroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);
        }

        @Test
    public void testGetGradeBook(){
            TreeMap<Student, Character> expected =;
            TreeMap<Student, Character> actual = classroom.getGradeBook();

            Assert.assertEquals(expected,actual);
        }
// @Test
//    public void testDefaultConstructor() {
//        ArrayList<Double> examScore = new ArrayList<>();
//        Student student = new Student("Salle", "Sue", examScore);
//        examScore.add(90.0);
//        examScore.add(89.0);
//        examScore.add(78.0);
//
//        Student student1 = new Student("Molly", "Kale", examScore);
//        examScore.add(99.0);
//        examScore.add(98.0);
//        examScore.add(100.0);
//
//
//        Classroom classroom = new Classroom(30);
//        classroom.addStudent(student);










}
