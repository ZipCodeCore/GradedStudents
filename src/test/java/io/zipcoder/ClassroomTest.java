package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void getAverageExamScoreTest() {
        // Given
        Student student1 = new Student("Allen", "Shup", new Double[]{100.0, 88.0, 95.0});
        Student student2 = new Student("Ben", "Alpit", new Double[]{100.0, 90.0, 84.0});
        Student student3 = new Student("Charles", "Compton", new Double[]{100.0, 60.0, 70.0});
        Double expectedAverageScore = 88.0;

        // When
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Double actualAverageScore = Math.ceil(classroom.getAverageExamScore());

        // Then
        Assert.assertEquals(expectedAverageScore, actualAverageScore);
    }

    @Test
    public void addStudentTest() {
        // Given
        Student student1 = new Student("Allen", "Shup", new Double[]{100.0, 88.0, 95.0});
        Student student2 = new Student("Ben", "Alpit", new Double[]{100.0, 90.0, 84.0});
        Student student3 = new Student("Charles", "Compton", new Double[]{100.0, 60.0, 70.0});
        Student expectedStudent = student3;

        // When
        Student[] students = new Student[]{student1, student2};
        Classroom classroom = new Classroom(students);
        classroom.addStudent(student3);
        Student actualStudent = classroom.students[2];

        // Then
        Assert.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void removeStudentTest() {
        // Given
        Student student1 = new Student("Allen", "Shup", new Double[]{100.0, 88.0, 95.0});
        Student student2 = new Student("Ben", "Alpit", new Double[]{100.0, 90.0, 84.0});
        Student student3 = new Student("Charles", "Compton", new Double[]{100.0, 60.0, 70.0});
        Integer expectedLength = 2;

        // When
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] newArray = classroom.removeStudent(student3.getFirstName(), student3.getLastName());
        Integer actualLength = newArray.length;

        // Then
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void getStudentByScoreTest() {
        // Given
        Student student1 = new Student("Allen", "Shup", new Double[]{60.0, 88.0, 95.0});
        Student student2 = new Student("Ben", "Alpit", new Double[]{100.0, 90.0, 84.0});
        Student student3 = new Student("Charles", "Compton", new Double[]{100.0, 100.0, 90.0});
        Student[] expectedArray = new Student[]{student3, student2, student1};

        // When
        Student[] students = new Student[]{student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] actualArray = classroom.getStudentByScore();

        // Then
        Assert.assertArrayEquals(expectedArray, actualArray);
    }
}
