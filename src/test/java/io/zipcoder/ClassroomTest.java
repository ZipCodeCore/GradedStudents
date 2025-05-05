package io.zipcoder;

import org.junit.Test;

public class ClassroomTest {

    @Test
    public void gtStudentsTest() {
        //given
        Double[] examScores = {};
        Student student1 = new Student("Cameron", "Howard", examScores);
        Student student2 = new Student("April", "Howard", examScores);
        Student[] students = {student1, student2};
Classroom classroom = new Classroom(students);
        //when
        String output = classroom.getStudents();
        //then
        System.out.println(output);
    }
}
