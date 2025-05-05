package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class ClassroomTest {

    @Test
    public void testGetStudents() {
        //given
        Double[] testScores = {90.0, 80.0, 70.0};
        Student student = new Student("Tohru", "Honda", testScores);
        //when
        Classroom classroom = new Classroom();
        classroom.addStudent(student);
        Student actual = classroom.getStudents()[0];
        //then
        Assert.assertEquals(student, actual);
    }

    @Test
    public void testGetAverageExamScore() {
        //given
        Double[] examScores1 = {90.0, 95.0, 100.0}; //95
        Double[] examScores2 = {85.0, 90.0, 87.0}; //87.3
        Double[] examScores3 = {70.0, 65.0, 55.0}; //63.3
        Student student1 = new Student("Blossom", "Ultonium",examScores1);
        Student student2 = new Student("Buttercup", "Ultonium", examScores2);
        Student student3 = new Student("Bubbles", "Ultonium", examScores3);
        Student[] testStudentArr = {student1, student2, student3};
        double expected = 81.888;
        //when
        Classroom classroom = new Classroom();
        double actual = classroom.getAverageExamScores(testStudentArr);
        //then
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testAddStudents() {
        //given
        Double[] examScores1 = {90.0, 95.0, 100.0}; //95
        Double[] examScores2 = {85.0, 90.0, 87.0}; //87.3
        Double[] examScores3 = {70.0, 65.0, 55.0}; //63.3
        Student student1 = new Student("Blossom", "Ultonium",examScores1);
        Student student2 = new Student("Buttercup", "Ultonium", examScores2);
        Student student3 = new Student("Bubbles", "Ultonium", examScores3);
        Student[] expected = {student1, student2, student3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        //when
        Classroom testClassroom = new Classroom();
        testClassroom.addStudent(student1);
        testClassroom.addStudent(student2);
        testClassroom.addStudent(student3);
        Student[] actual = testClassroom.getStudents();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStudents() {
        //given
        Double[] examScores1 = {90.0, 95.0, 100.0};
        Double[] examScores2 = {85.0, 90.0, 87.0};
        Double[] examScores3 = {70.0, 65.0, 55.0};
        Student student1 = new Student("Erwin", "Smith",examScores1);
        Student student2 = new Student("Hanji", "Zoe", examScores2);
        Student student3 = new Student("Eren", "Yeager", examScores3);
        Student[] expected = {student2, student3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        //when
        Classroom testClassroom = new Classroom();
        testClassroom.addStudent(student1);
        testClassroom.addStudent(student2);
        testClassroom.addStudent(student3);
        testClassroom.removeStudent("Erwin", "Smith");
        Student[] actual = testClassroom.getStudents();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStudentsByScore() {
        //given
        Double[] examScores1 = {85.0, 90.0, 87.0};
        Double[] examScores2 = {90.0, 95.0, 100.0};
        Double[] examScores3 = {85.0, 90.0, 87.0};
        Student student1 = new Student("Craig", "Boone",examScores1);
        Student student2 = new Student("Veronica", "Santangelo", examScores2);
        Student student3 = new Student("Cass", "Sharon", examScores3);
        Student[] expected = {student2, student3, student1};
        //when
        Classroom testClassroom = new Classroom(student1, student2, student3);
        Student[] actual = testClassroom.getStudentsByScore();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetGradeBook() {
        //given
        Double[] examScores1 = {85.0, 90.0, 87.0};
        Double[] examScores2 = {90.0, 95.0, 100.0};
        Double[] examScores3 = {85.0, 90.0, 87.0};
        Double[] examScores4 = {65.0, 50.0, 57.0};
        Double[] examScores5 = {75.0, 60.0, 67.0};
        Double[] examScores6 = {85.0, 80.0, 77.0};
        Student student1 = new Student("Craig", "Boone", examScores1);
        Student student2 = new Student("Veronica", "Santangelo", examScores2);
        Student student3 = new Student("Cass", "Sharon", examScores3);
        Student student4 = new Student("Kyo", "Sohma", examScores4);
        Student student5 = new Student("Tohru", "Honda", examScores5);
        Student student6 = new Student("Hatsuharu", "Sohma", examScores6);
        Student[] expected = {student1, student2, student3, student4, student5, student6};
        //when
        Classroom testClassroom = new Classroom(student1, student2, student3, student4, student5, student6);
        //then
        System.out.println(testClassroom.getGradeBook());
    }
}
