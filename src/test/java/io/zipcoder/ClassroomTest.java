package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {
    @Test
    public void getAvgExamScoresTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores, "");
        Student s2 = new Student("student", "two", s2Scores, "");

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Double output = classroom.getClassAverageExamScore();
        // Then
        System.out.println(output);
        Assert.assertEquals(125.0, output, 0);
    }

    @Test
    public void addStudentTest(){
        // : Given
        //Making old students
        Double[] examScores1 = {123.0, 159.0, 170.0};
        Student jack = new Student("Jack","Smith", examScores1, "");
        Double[] examScores2 = {230.4, 215.0, 50.2};
        Student kate = new Student("Kate", "Green", examScores2, "");

        //Putting students into classroom
        Student[] oldStudents = {jack, kate};
        Classroom classroom = new Classroom(oldStudents);

        //New student
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores, "");

        // When
        //populate class
        Student[] preEnrollment = classroom.getStudents();
        //Add leon
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
    public void removeStudentTest(){
        // : Given
        //Making old students
        Double[] examScores1 = {123.0, 159.0, 170.0};
        Student jack = new Student("Jack","Smith", examScores1, "");
        Double[] examScores2 = {230.4, 215.0, 50.2};
        Student kate = new Student("Kate", "Green", examScores2, "");
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student leon = new Student("Leon", "Hunter", examScores, "");

        //Putting students into classroom
        Student[] oldStudents = {jack, kate, leon};
        Classroom classroom = new Classroom(oldStudents);

        // When
        //populate class
        Student[] preEnrollment = classroom.getStudents();
        //Add leon
        classroom.removeStudent("Leon", "Hunter");
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
    public void getStudentByScoreTest(){
        // : Given
        //Making old students
        Double[] examScores1 = {123.0, 159.0, 170.0};
        Student jack = new Student("Jack","Smith", examScores1, "");
        Double[] examScores2 = {230.4, 215.0, 50.2};
        Student kate = new Student("Kate", "Green", examScores2, "");
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student leon = new Student("Leon", "Hunter", examScores, "");

        //Putting students into classroom
        Student[] allStudents = {jack, kate, leon};
        Classroom classroom = new Classroom(allStudents);

        //Before sorting
        String preSorting = Arrays.toString(classroom.getStudents());
        //Sorting students
        classroom.getStudentByScore();
        String postSorting = Arrays.toString(classroom.getStudents());

        System.out.println(preSorting);
        System.out.println("===============AFTER SORTING===============");
        System.out.println(postSorting);
    }

    @Test
    public void getGradeBook() {
        // : Given
        //Making old students
        Double[] examScores1 = {70.0, 90.0, 77.0};
        Student jack = new Student("Jack","Smith", examScores1, "TEST");

        Double[] examScores2 = {69.4, 94.0, 88.2};
        Student kate = new Student("Kate", "Green", examScores2, "TEST");

        Double[] examScores3 = { 100.0, 93.0, 87.0};
        Student leon = new Student("Leon", "Hunter", examScores3, "TEST");

        Double[] examScores4 = {87.4, 60.0, 50.2};
        Student tim = new Student("Tim", "Bo", examScores4, "TEST");

        Double[] examScore5 = { 71.0, 82.0, 83.0};
        Student brian = new Student("Brian", "Jackson", examScore5, "TEST");

        //Putting students into classroom
        Student[] allStudents = {jack, kate, leon, tim, brian};
        Classroom classroom = new Classroom(allStudents);

        //When
        String preGrading = Arrays.toString(classroom.getStudents());
        classroom.getGradedBook();
        String postGrading = Arrays.toString(classroom.getStudents());

        //Then
        System.out.println(preGrading);
        System.out.println("==============AFTER GIVING LETTER GRADE =============");
        System.out.println(postGrading);

    }

    @Test
    public void sortingAndLetterGradeTest() {
        // : Given
        //Making old students
        Double[] examScores1 = {70.0, 90.0, 77.0};
        Student jack = new Student("Jack","Smith", examScores1, "TEST");

        Double[] examScores2 = {69.4, 94.0, 88.2};
        Student kate = new Student("Kate", "Green", examScores2, "TEST");

        Double[] examScores3 = { 100.0, 93.0, 87.0};
        Student leon = new Student("Leon", "Hunter", examScores3, "TEST");

        Double[] examScores4 = {87.4, 60.0, 50.2};
        Student tim = new Student("Tim", "Bo", examScores4, "TEST");

        Double[] examScore5 = { 71.0, 82.0, 83.0};
        Student brian = new Student("Brian", "Jackson", examScore5, "TEST");

        Double[] examScore6 = { 80.0, 87.0, 95.0};
        Student jason = new Student("Jason", "White", examScore5, "TEST");

        Double[] examScore7 = { 80.0, 87.0, 95.0};
        Student lily = new Student("Lily", "White", examScore5, "TEST");

        //Putting students into classroom
        Student[] allStudents = {jack, kate, leon, tim, brian, jason, lily};
        Classroom classroom = new Classroom(allStudents);

        //When
        String preGradeAndSort = Arrays.toString(classroom.getStudents());
        classroom.getGradedBook();
        classroom.getStudentByScore();
        String postGradeAndSort = Arrays.toString(classroom.getStudents());

        //Then
        System.out.println(preGradeAndSort);
        System.out.println("==============AFTER LETTER GRADE AND SORT =============");
        System.out.println(postGradeAndSort);
    }

}
