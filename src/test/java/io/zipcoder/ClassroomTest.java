package io.zipcoder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


public class ClassroomTest {

    public Classroom classroom;

    @Before
    public void setUp() {
        classroom = new Classroom();
    }

    @Test
    public void testGetAverageExamScore() {
        ArrayList<Double> studentOneScores = new ArrayList<>();
        ArrayList<Double> studentTwoScores = new ArrayList<>();

        studentOneScores.add(100.0);
        studentOneScores.add(150.0);

        studentTwoScores.add(225.0);
        studentTwoScores.add(25.0);

        Student studentOne = new Student("Don", "Aaron", studentOneScores);
        Student studentTwo = new Student("Joseph", "Robert", studentTwoScores);

        ArrayList<Student> students = new ArrayList<>();
        students.add(studentOne);
        students.add(studentTwo);

        Classroom classroom = new Classroom(students);

        Double expected = 125.0;
        Double actual = classroom.getAverageExamScore();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetStudents() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        ArrayList<Double> scores = new ArrayList<>();
        scores.add(100.0);
        scores.add(150.0);
        scores.add(250.0);
        scores.add(0.0);
        Student student = new Student("Thomas", "Robert", scores);

        classroom.addStudent(student);
        String[] postEnrollment = classroom.getStudents();


        String[] expected =
                {"Student Name: Thomas Robert\n" +
                        "> Average Score: 125.0\n" +
                        "> Exam Scores:\n" +
                        "Exam 1 -> 100.0\n" +
                        "Exam 2 -> 150.0\n" +
                        "Exam 3 -> 250.0\n" +
                        "Exam 4 -> 0.0\n"};
        String[] actual = postEnrollment;
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void testAddStudent() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        ArrayList<Double> scores = new ArrayList<>();
        scores.add(100.0);
        scores.add(150.0);
        scores.add(250.0);
        scores.add(0.0);
        Student student = new Student("Thomas", "Robert", scores);
        classroom.addStudent(student);

        String[] expected = {"Student Name: Thomas Robert\n" +
                "> Average Score: 125.0\n" +
                "> Exam Scores:\n" +
                "Exam 1 -> 100.0\n" +
                "Exam 2 -> 150.0\n" +
                "Exam 3 -> 250.0\n" +
                "Exam 4 -> 0.0\n"};
        String[] actual = classroom.getStudents();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testRemoveStudent() {

        int maxNumberOfStudents = 2;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        ArrayList<Double> scores1 = new ArrayList<>();
        scores1.add(100.0);
        scores1.add(150.0);
        scores1.add(250.0);
        scores1.add(0.0);
        Student student1 = new Student("Thomas", "Robert", scores1);
        classroom.addStudent(student1);

        ArrayList<Double> scores2 = new ArrayList<>();
        scores2.add(150.0);
        scores2.add(180.0);
        scores2.add(225.0);
        scores2.add(90.0);
        Student student2 = new Student("Mary", "Abraham", scores2);
        classroom.addStudent(student2);


        classroom.removeStudent("Thomas", "Robert");

        String[] expected = {"Student Name: Mary Abraham\n" +
                "> Average Score: 161.25\n" +
                "> Exam Scores:\n" +
                "Exam 1 -> 150.0\n" +
                "Exam 2 -> 180.0\n" +
                "Exam 3 -> 225.0\n" +
                "Exam 4 -> 90.0\n"};
        String[] actual = classroom.getStudents();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testGetStudentsByScore() {
        int maxNumberOfStudents = 5;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        ArrayList<Double> scores1 = new ArrayList<>();
        scores1.add(180.0);
        scores1.add(150.0);
        scores1.add(250.0);
        scores1.add(180.0);
        Student student1 = new Student("Thomas", "Robert", scores1);
        classroom.addStudent(student1);

        ArrayList<Double> scores2 = new ArrayList<>();
        scores2.add(150.0);
        scores2.add(180.0);
        scores2.add(225.0);
        scores2.add(190.0);
        Student student2 = new Student("Mary", "Abraham", scores2);
        classroom.addStudent(student2);


        ArrayList<Double> scores3 = new ArrayList<>();
        scores3.add(180.0);
        scores3.add(150.0);
        scores3.add(250.0);
        scores3.add(200.0);
        Student student3 = new Student("Natalie", "Albert", scores3);
        classroom.addStudent(student3);

        ArrayList<Double> scores4 = new ArrayList<>();
        scores4.add(200.0);
        scores4.add(250.0);
        scores4.add(175.0);
        scores4.add(70.0);
        Student student4 = new Student("Eduardo", "Rodrigez", scores4);
        classroom.addStudent(student4);

        ArrayList<Double> scores5 = new ArrayList<>();
        scores5.add(180.0);
        scores5.add(150.0);
        scores5.add(250.0);
        scores5.add(200.0);
        Student student5 = new Student("Natalie", "Richard", scores5);
        classroom.addStudent(student5);

        String[] expected = {
                "Student Name: Natalie Albert\n" +
                        "> Average Score: 195.0\n" +
                        "> Exam Scores:\n" +
                        "Exam 1 -> 180.0\n" +
                        "Exam 2 -> 150.0\n" +
                        "Exam 3 -> 250.0\n" +
                        "Exam 4 -> 200.0\n",

                "Student Name: Natalie Richard\n" +
                        "> Average Score: 195.0\n" +
                        "> Exam Scores:\n" +
                        "Exam 1 -> 180.0\n" +
                        "Exam 2 -> 150.0\n" +
                        "Exam 3 -> 250.0\n" +
                        "Exam 4 -> 200.0\n",

                "Student Name: Thomas Robert\n" +
                        "> Average Score: 190.0\n" +
                        "> Exam Scores:\n" +
                        "Exam 1 -> 180.0\n" +
                        "Exam 2 -> 150.0\n" +
                        "Exam 3 -> 250.0\n" +
                        "Exam 4 -> 180.0\n",


                "Student Name: Mary Abraham\n" +
                        "> Average Score: 186.25\n" +
                        "> Exam Scores:\n" +
                        "Exam 1 -> 150.0\n" +
                        "Exam 2 -> 180.0\n" +
                        "Exam 3 -> 225.0\n" +
                        "Exam 4 -> 190.0\n",

                "Student Name: Eduardo Rodrigez\n" +
                        "> Average Score: 173.75\n" +
                        "> Exam Scores:\n" +
                        "Exam 1 -> 200.0\n" +
                        "Exam 2 -> 250.0\n" +
                        "Exam 3 -> 175.0\n" +
                        "Exam 4 -> 70.0\n"};


        String[] actual = classroom.getStudentByScore();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetGradeBook(){
        int maxNumberOfStudents = 10;
        Classroom classroom = new Classroom(maxNumberOfStudents);

        ArrayList<Double> scores1 = new ArrayList<>();
        scores1.add(180.0);
        scores1.add(150.0);
        scores1.add(250.0);
        scores1.add(140.0);
        Student student1 = new Student("Thomas", "Robert", scores1);
        classroom.addStudent(student1);

        ArrayList<Double> scores2 = new ArrayList<>();
        scores2.add(150.0);
        scores2.add(180.0);
        scores2.add(225.0);
        scores2.add(190.0);
        Student student2 = new Student("Mary", "Abraham", scores2);
        classroom.addStudent(student2);


        ArrayList<Double> scores3 = new ArrayList<>();
        scores3.add(180.0);
        scores3.add(150.0);
        scores3.add(250.0);
        scores3.add(200.0);
        Student student3 = new Student("Natalie", "Albert", scores3);
        classroom.addStudent(student3);

        ArrayList<Double> scores4 = new ArrayList<>();
        scores4.add(200.0);
        scores4.add(250.0);
        scores4.add(175.0);
        scores4.add(70.0);
        Student student4 = new Student("Eduardo", "Rodrigez", scores4);
        classroom.addStudent(student4);

        ArrayList<Double> scores5 = new ArrayList<>();
        scores5.add(180.0);
        scores5.add(100.0);
        scores5.add(250.0);
        scores5.add(200.0);
        Student student5 = new Student("Natalie", "Richard", scores5);
        classroom.addStudent(student5);

        ArrayList<Double> scores6 = new ArrayList<>();
        scores6.add(180.0);
        scores6.add(100.0);
        scores6.add(150.0);
        scores6.add(280.0);
        Student student6 = new Student("Efrem", "Gebray", scores6);
        classroom.addStudent(student6);

        ArrayList<Double> scores7 = new ArrayList<>();
        scores7.add(150.0);
        scores7.add(180.0);
        scores7.add(125.0);
        scores7.add(130.0);
        Student student7 = new Student("Melat", "Abraha", scores7);
        classroom.addStudent(student7);


        ArrayList<Double> scores8 = new ArrayList<>();
        scores8.add(180.0);
        scores8.add(150.0);
        scores8.add(120.0);
        scores8.add(200.0);
        Student student8 = new Student("Bereket", "Negash", scores8);
        classroom.addStudent(student8);

        ArrayList<Double> scores9 = new ArrayList<>();
        scores9.add(200.0);
        scores9.add(150.0);
        scores9.add(175.0);
        scores9.add(70.0);
        Student student9 = new Student("Medahane", "Tecle", scores9);
        classroom.addStudent(student9);

        ArrayList<Double> scores10 = new ArrayList<>();
        scores10.add(140.0);
        scores10.add(150.0);
        scores10.add(250.0);
        scores10.add(200.0);
        Student student10 = new Student("Bryan", "Scot", scores10);
        classroom.addStudent(student10);

        String expected = "Grade Book\n"+
                          "First Name             Last Name                         Grade\n"+
                          "Natalie              Albert              195.0             A\n"+
                          "Mary             Abraham                 186.25              B\n"+
                          "Bryan                Scot                185.0               C\n"+
                          "Natalie              Richard             182.5               C\n"+
                          "Thomas               Robert              180.0               C\n"+
                          "Efrem                Gebray              177.5               C\n"+
                          "Eduardo              Rodrigez            173.75              D\n"+
                          "Bereket              Negash              162.5               D\n"+
                          "Medahane             Tecle               148.75              D\n"+
                          "Melat                Abraha              146.25             F\n";

        String actual = classroom.getGradeBook();
        Assert.assertEquals(expected,actual);


    }


}
