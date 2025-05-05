package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class ClassroomTest {
    @Test
    public void ClassroomTest() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student[] students = new Student[]{s1, s2};
        Classroom classroom = new Classroom(students);
        Student[] actual = classroom.getStudents();
        Assert.assertEquals(students, actual);
    }

    @Test
    public void getAverageExamScoreTest() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("Rose", "Petal", s1Scores);
        Student s2 = new Student("Subhash", "Bose", s2Scores);
        Student[] students = new Student[]{s1, s2};
        Classroom classroom = new Classroom(students);
        Double expected = 125.0;
        Double actual = classroom.getAverageExamScore();


        Assert.assertEquals(expected, actual);

    }

    @Test
    public void test2getAverageExamScore() {
        Double[] s1Scores = {100.0, 95.0};
        Double[] s2Scores = {100.0, 96.0};
        Student s1 = new Student("Student", "one", s1Scores);
        Student s2 = new Student("Student", "two", s2Scores);
        Student[] students = new Student[]{s1, s2};
        Classroom classroom = new Classroom(students);
        Double actual = classroom.getAverageExamScore();
        System.out.println(actual);
        Assert.assertNotEquals(100, classroom.getAverageExamScore(), 0.00009);

    }

    @Test
    public void addStudentTest() {
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = {100.0, 150.0, 250.0, 0.0};
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        System.out.println(classroom.toString());
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }


    @Test
    public void removeStudentTest() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Double[] s3Scores = {98.0, 112.0};
        Double[] s4Scores = {220.0, 45.0};
        Student s1 = new Student("Student", "one", s1Scores);
        Student s2 = new Student("Rose", "Petal", s2Scores);
        Student s3 = new Student("Student", "three", s3Scores);
        Student s4 = new Student("Student", "four", s4Scores);

        String firstName = "Rose";
        String lastName = "Petal";
        Classroom classroom = new Classroom();
        classroom.addStudent(s1);
        classroom.addStudent(s2);
        classroom.addStudent(s3);
        classroom.addStudent(s4);
        Student[] students = new Student[]{s1, s2, s3, s4};


        classroom.removeStudent("Rose", "Petal");
        Student[] expected = classroom.getStudents();
        Assert.assertEquals(s1, expected[0]);
        Assert.assertEquals(s3, expected[1]);
        Assert.assertEquals(s4, expected[2]);
        Assert.assertEquals(expected[3], null);
        // System.out.println(expected[3]);
        //Assert.assertEquals(expected[3]);


    }

    /*
    @Test
        public void getStudentByScoreTest(){
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Double[] s3Scores = { 98.0, 112.0 };
        Double[] s4Scores = { 220.0, 45.0 };
        Student s1=new Student("Student", "one", s1Scores);
        Student s2=new Student("Student", "two", s2Scores);
        Student s3=new Student("Student", "tree", s1Scores);
        Student s4=new Student("Student", "four", s2Scores);
        Student[] students=new Student[]{s1,s2,s3,s4};
        Classroom classroom =new Classroom(students);
        Student[] expected = {s4, s2,s1,s3};
        Student[] actual=classroom.getStudentsByScore( Student[] Students);
        Assert.assertArrayEquals(expected, actual);

        }*/
    @Test
    public void getStudentsByScoreTest() {
        Double[] scores1 = new Double[]{45.0, 50.0, 55.0};
        Double[] scores2 = new Double[]{60.0, 65.0};
        Double[] scores3 = new Double[]{70.0, 70.0};
        Student student1 = new Student("Jimmy", "John", scores1);
        Student student2 = new Student("Tammy", "Tohn", scores2);
        Student student3 = new Student("Jack", "Tohn", scores3);
        Student[] newStudents = {student1, student2, student3};
        Classroom classroom = new Classroom(newStudents);

    }
    @Test
    public void getGradebookTest() {
       /* int n = 20;
        Student[] students = new Student[n];
        for (int i = 1; i<=n; i++) {
            students[i-1] = new Student("","",new Double[] {100.0,5.0*i});
        }
        Classroom classroom = new Classroom(students);*/
        Double[] scores1 = new Double[] {45.0, 50.0, 55.0};
        Double[] scores2 = new Double[] {60.0, 65.0};
        Double[] scores3 = new Double[] {70.0, 70.0};
        Double[] scores4 = new Double[] {95.0, 90.0, 95.0};
        Double[] scores5 = new Double[] {80.0, 85.0};
        Student student1 = new Student("Jimmy", "John", scores1 );
        Student student2 = new Student("Tammy", "Tohn", scores2 );
        Student student3 = new Student("Jack", "Tohn", scores3 );
        Student student4 = new Student("Rhett", "Ale", scores4 );
        Student student5 = new Student("Amy", "Roberts", scores5 );
        Student[] newStudents = {student1, student2, student3, student4, student5};
        Classroom classroom = new Classroom(newStudents);

        Map<Student,String> gradebook = classroom.getGradebook();

        Assert.assertEquals(gradebook.get(student1),"F");
        Assert.assertEquals(gradebook.get(student2),"D");
        Assert.assertEquals(gradebook.get(student3),"C");
        Assert.assertEquals(gradebook.get(student4),"A");
        Assert.assertEquals(gradebook.get(student5),"B");

    }
}
