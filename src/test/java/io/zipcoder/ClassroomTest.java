package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




public class ClassroomTest {

    @Test
    public void constructor1Test() {
        Classroom testClassroom = new Classroom(20);

        int expected = 20;
        int actual = testClassroom.getMaximumNumberOfStudents();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void constructor2Test() {
        Student[] students = new Student[0];
        Classroom testClassroom = new Classroom(students);

        String[] expected = {};
        String[] actual = testClassroom.getStudents();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructor3Test() {
        Classroom testClassroom = new Classroom();

        int expected = 30;
        int actual = testClassroom.getMaximumNumberOfStudents();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getStudentsTest() {

        Student student1 = new Student("Tyrion", "Lannister");
        Student student2 = new Student("Cersei", "Lannister");
        Student student3 = new Student("Jaime", "Lannister");
        Student[] students = {student1, student2, student3};
        Classroom classroom = new Classroom(students);

        String[] expected = {"Tyrion Lannister", "Cersei Lannister", "Jaime Lannister"};
        String[] actual = classroom.getStudents();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getAverageExamScoreTest() {

        Student student1 = new Student("Tyrion", "Lannister");
        Student student2 = new Student("Cersei", "Lannister");
        Student student3 = new Student("Jaime", "Lannister");
        Student[] students = {student1, student2, student3};
        Classroom testClassroom = new Classroom(students);

        student1.addExamScore(78);
        student1.addExamScore(89);
        student2.addExamScore(67);
        student2.addExamScore(100);
        student3.addExamScore(60);
        student3.addExamScore(95);

        Double expected = 81.5;
        Double actual = testClassroom.getAverageExamScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isStudentEnrolled() {
        Student student1 = new Student("Tyrion", "Lannister");
        Student student2 = new Student("Cersei", "Lannister");
        Student student3 = new Student("Jaime", "Lannister");
        Student[] students = {student1, student2, student3};

        Classroom testClassroom = new Classroom(students);

        boolean outcome = testClassroom.isStudentEnrolled(student1.getFullName());
        Assert.assertTrue(outcome);

    }

    @Test
    public void addStudentTest() {
        Student student1 = new Student("George", "Washington");

        Classroom testClassroom = new Classroom(1);

        testClassroom.addStudent(student1);

        String[] expected = {"George Washington"};
        String[] actual = testClassroom.getStudents();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeExistingStudentTest() {
        Student student1 = new Student("Thomas", "Jefferson");
        Student student2 = new Student("Aaron", "Burr");
        Student student3 = new Student("Alexander", "Hamilton");
        Student[] students = {student1, student2, student3};

        Classroom testClassroom = new Classroom(students);

        Student[] expected = {student1, student3, null};
        Student[] actual = testClassroom.removeStudent("Aaron", "Burr");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNonExistingStudentTest() {
        Student student1 = new Student("Thomas", "Jefferson");
        Student student2 = new Student("Aaron", "Burr");
        Student student3 = new Student("Alexander", "Hamilton");
        Student[] students = {student1, student2, student3};

        Classroom testClassroom = new Classroom(students);

        Student[] expected = {student1, student2, student3};
        Student[] actual = testClassroom.removeStudent("Bob", "Ross");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest_NoCollisions() {
        Student student1 = new Student("Tyrion", "Lannister");
        Student student2 = new Student("Cersei", "Lannister");
        Student student3 = new Student("Jaime", "Lannister");
        Student[] students = {student1, student2, student3};
        Classroom testClassroom = new Classroom(students);

        student1.addExamScore(100);
        student1.addExamScore(100);
        student2.addExamScore(65);
        student2.addExamScore(70);
        student3.addExamScore(95);
        student3.addExamScore(90);

        Student[] expected = {student1, student3, student2};
        Student[] actual = testClassroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest_SameName() {
        Student student1 = new Student("Tyrion", "Lannister");
        Student student2 = new Student("Tyrion", "Lannister");
        Student student3 = new Student("Jaime", "Lannister");
        Student[] students = {student1, student2, student3};
        Classroom testClassroom = new Classroom(students);

        student1.addExamScore(100);
        student1.addExamScore(100);
        student2.addExamScore(65);
        student2.addExamScore(70);
        student3.addExamScore(95);
        student3.addExamScore(90);

        Student[] expected = {student1, student3, student2};
        Student[] actual = testClassroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getStudentsByScoreTest_SameAverageScore() {
        Student student1 = new Student("Tyrion", "Lannister");
        Student student2 = new Student("Cersei", "Lannister");
        Student student3 = new Student("Jaime", "Lannister");
        Student[] students = {student1, student2, student3};
        Classroom testClassroom = new Classroom(students);

        student1.addExamScore(100);
        student1.addExamScore(100);
        student2.addExamScore(100);
        student2.addExamScore(100);
        student3.addExamScore(50);
        student3.addExamScore(90);

        Student[] expected = {student2, student1, student3};
        Student[] actual = testClassroom.getStudentsByScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getGradeBookTest() {
        Student student1 = new Student("George", "Washington");
        Student student2 = new Student("John", "Adams");
        Student student3 = new Student("Thomas", "Jefferson");
        Student student4 = new Student("James", "Madison");
        Student student5 = new Student("James", "Monroe");
        Student student6 = new Student("John Q.", "Adams");
        Student student7 = new Student("Andrew", "Jackson");
        Student student8 = new Student("Martin", "VanBuren");
        Student student9 = new Student("William", "Harrison");
        Student student10 = new Student("John", "Tyler");
        Student[] students = {student1, student2, student3, student4, student5,
                            student6, student7, student8, student9, student10};



        Classroom testClassroom = new Classroom(students);
        student1.addExamScore(100);
        student2.addExamScore(90);
        student3.addExamScore(80);
        student4.addExamScore(70);
        student5.addExamScore(60);
        student6.addExamScore(50);
        student7.addExamScore(40);
        student8.addExamScore(30);
        student9.addExamScore(20);
        student10.addExamScore(10);




        List<Student> gradeA = new ArrayList<>();
        gradeA.add(student1);

        List<Student> gradeB = new ArrayList<>();
        gradeB.add(student2);
        gradeB.add(student3);

        List<Student> gradeC = new ArrayList<>();
        gradeC.add(student4);
        gradeC.add(student5);


        List<Student> gradeD = new ArrayList<>();
        gradeD.add(student6);
        gradeD.add(student7);
        gradeD.add(student8);
        gradeD.add(student9);

        List<Student> gradeF = new ArrayList<>();
        gradeF.add(student10);




        HashMap<String, List<Student>> expectedGradeBook = new HashMap<>();
        expectedGradeBook.put("A", gradeA);
        expectedGradeBook.put("B", gradeB);
        expectedGradeBook.put("C", gradeC);
        expectedGradeBook.put("D", gradeD);
        expectedGradeBook.put("F", gradeF);

        HashMap<String, List<Student>> actualGradeBook = testClassroom.getGradeBook();



        Assert.assertEquals(expectedGradeBook, actualGradeBook);

    }
}
