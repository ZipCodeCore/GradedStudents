package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

public class ClassroomTest {


    @Test
    public void ConstructorTestMaxStudents1() {
        int givenMaxStudentLength = 50;
        Classroom testClassroom = new Classroom(givenMaxStudentLength);


        Student[] returnedStudentArray = testClassroom.getStudents();
        int returnedArrayLength = returnedStudentArray.length;

        Assert.assertEquals(givenMaxStudentLength, returnedArrayLength);
    }


    @Test
    public void ConstructorTestMaxStudents2() {
        int givenMaxStudentLength = 50;
        Classroom testClassroom = new Classroom(givenMaxStudentLength);


        Student[] returnedStudentArray = testClassroom.getStudents();
        int returnedArrayLength = returnedStudentArray.length;

        Assert.assertNotEquals(null, returnedArrayLength);

    }

    ///////////////////////////////////


    @Test
    public void getAverageExamScoreTest() {
        Double[] studentArr1 = {70.0, 61.0, 87.0, 98.0};
        Double[] studentArr2 = {85.0, 100.0, 88.0, 89.0};

        Student student1 = new Student("Jimin", "Park", studentArr1);
        Student student2 = new Student("Yoongi", "Min", studentArr2);


        Student[] arrayOfStudents = {student1, student2,};
        Classroom classroom1 = new Classroom(arrayOfStudents);

        Double expectedClassroomExamAvg = (student1.getAverageExamScore() + student2.getAverageExamScore()) / 2;
        Double actualClassroomExamAvg = classroom1.getAverageExamScore(arrayOfStudents);

        Assert.assertEquals(expectedClassroomExamAvg, actualClassroomExamAvg);


    }


    @Test
    public void getStudentsTest() {
        Double[] studentArr1 = {85.0, 84.0, 87.0, 98.0};
        Double[] studentArr2 = {85.0, 90.0, 87.0, 88.0};
        Double[] studentArr3 = {99.0, 90.0, 75.0, 52.0};
        Student student1 = new Student("Harry", "Potter", studentArr1);
        Student student2 = new Student("SpongeBob", "SquarePants", studentArr2);
        Student student3 = new Student("Namjoon", "Kim", studentArr3);

        Student[] arrayOfStudents = {student1, student2, student3};
        Classroom classroom1 = new Classroom(arrayOfStudents);

        Student[] actualStudentsArr = classroom1.getStudents();

        Assert.assertEquals(arrayOfStudents, actualStudentsArr);
        Assert.assertNotEquals(3, actualStudentsArr);

        //System.out.println(actualStudentsArr);

    }


    @Test
    public void getAverageExamScore2Test() {
        Double[] studentArr1 = {85.0, 84.0, 87.0, 98.0};
        Double[] studentArr2 = {85.0, 90.0, 87.0, 88.0};
        Double[] studentArr3 = {99.0, 90.0, 75.0, 52.0};
        Student student1 = new Student("Harry", "Potter", studentArr1);
        Student student2 = new Student("SpongeBob", "SquarePants", studentArr2);
        Student student3 = new Student("Namjoon", "Kim", studentArr3);

        Student[] arrayOfStudents = {student1, student2, student3};
        Classroom classroom1 = new Classroom(arrayOfStudents);

        Double expectedClassroomExamAvg = (student1.getAverageExamScore() + student2.getAverageExamScore() + student3.getAverageExamScore()) / 3;

        Double actualClassroomExamAvg = classroom1.getAverageExamScore(arrayOfStudents);

        Assert.assertEquals(expectedClassroomExamAvg, actualClassroomExamAvg);
        System.out.println(expectedClassroomExamAvg);

        }



    @Test
    public void addStudentTest() {
        Double[] scores1 = {85.0, 84.0, 87.0, 98.0};
        Double[] scoresr2 = {85.0, 90.0, 87.0, 88.0};
        Double[] scoresr3 = {99.0, 90.0, 75.0, 52.0};
        Student student1 = new Student("Harry", "Potter", scores1);
        Student student2 = new Student("SpongeBob", "SquarePants", scoresr2);
        Student student3 = new Student("Namjoon", "Kim", scoresr3);
        Student[] expected = {student1, student2, student3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,};

        //Classroom classroom101 = new Classroom(30);
        Classroom classroom101 = new Classroom();
        classroom101.addStudent(student1);
        classroom101.addStudent(student2);
        classroom101.addStudent(student3);

        Student[] actual = classroom101.getStudents();

        Assert.assertEquals(expected, actual);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(actual[i]);
        }

        //Student[] expectedStudentArray = {student1, student2, student3};
        //  Student[] returnedStudentArray = classroom101.getStudents();
        //System.out.print(Arrays.toString(expectedStudentArray));
        //System.out.print(Arrays.toString(returnedStudentArray));

        //Assert.assertNotEquals(null, returnedStudentArray);
    }


    @Test
    public void removeStudentTest() {
        Double[] scores1 = {80.0, 80.0, 100.0, 70.0};
        Double[] scores2 = {79.0, 80.0, 95.0, 85.0};
        Double[] scores3 = {100.0, 80.0, 92.0, 90.0};
        Student student1 = new Student("Harry", "Potter", scores1);
        Student student2 = new Student("SpongeBob", "SquarePants", scores2);
        Student student3 = new Student("Namjoon", "Kim", scores3);
        Student[] expected = {student2, student3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

        Classroom classroom101 = new Classroom();
        classroom101.addStudent(student1);
        classroom101.addStudent(student2);
        classroom101.addStudent(student3);
        classroom101.removeStudent("Harry", "Potter");
        Student[] actual = classroom101.getStudents();

        Assert.assertEquals(expected, actual);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(actual[i]);
        }
        }
        //System.out.println(expected);
        // System.out.println(actual);


    @Test
    public void getStudentByScore(){
        Double[] scores1 = {80.0, 80.0, 90.0};
        Double[] scores2 = {100.0, 100.0, 95.0};
        Double[] scores3 = {80.0, 80.0, 98.0};
        Student student1 = new Student("Harry", "Potter", scores1);
        Student student2 = new Student("SpongeBob", "SquarePants", scores2);
        Student student3 = new Student("Namjoon", "Kim", scores3);
        Student[] expected = {student2, student3, student1};

        //WHEN
        Classroom clasroom101 = new Classroom(student1, student2, student3);
        Student[] actual = clasroom101.getStudentByScore();

        //THEN
        Assert.assertEquals(expected, actual);

        for (int i = 0; i < actual.length; i++) {
            System.out.println(actual[i]);

        }
    }





}












