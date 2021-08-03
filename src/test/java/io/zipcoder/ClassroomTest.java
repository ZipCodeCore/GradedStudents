package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {
    Double[] testScores = {70.0, 80.0, 90.0};
    @Test
    public void TestGetStudents() {
        Student student = new Student("Rex","Casio", testScores);
        Classroom classroom =  new Classroom();
        classroom.addStudent(student);

        Student actual = classroom.getStudents()[0];

        Assert.assertEquals(student,actual);
    }

    @Test
    public void TestRemoveStudents() {
        Student student1 = new Student("Rex","Casio", testScores);
        Student student2 = new Student("Rox","Casio", testScores);
        Student student3 = new Student("Rosie","Casio", testScores);
        Student student4 = new Student("Russell","Casio", testScores);
        Classroom classroom =  new Classroom();

        classroom.addStudent(student1);
        classroom.addStudent(student2);
        classroom.addStudent(student3);
        classroom.addStudent(student4);
        classroom.removeStudent("Rox", "Casio");
        Student [] expected = {student2, student3, student4, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null};

        Student [] actual = classroom.getStudents();


        Assert.assertArrayEquals(expected, actual);
    }
}
