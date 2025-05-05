package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void getFirstName1() {
        Student student = new Student("Bob", "",new Double[2]);
        String actual = student.getFirstName();
        String expected = "Bob";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getFirstName2() {
        Student student = new Student("Wes", "",new Double[2]);
        String actual = student.getFirstName();
        String expected = "Wes";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getFirstName3() {
        Student student = new Student("Wesley", "",new Double[2]);
        String actual = student.getFirstName();
        String expected = "Wesley";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstName1() {
        Student student = new Student("Wes", "", new Double[2]);
        student.setFirstName("Mike");
        String actual = student.getFirstName();
        String expected = "Mike";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setFirstName2() {
        Student student = new Student("Wesley", "", new Double[2]);
        student.setFirstName("Wes");
        String actual = student.getFirstName();
        String expected = "Wes";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setFirstName3() {
        Student student = new Student("", "", new Double[2]);
        student.setFirstName("Mike");
        String actual = student.getFirstName();
        String expected = "Mike";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName1() {
        Student student = new Student("", "Jones",new Double[2]);
        String actual = student.getLastName();
        String expected = "Jones";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getLastName2() {
        Student student = new Student("", "McMillan",new Double[2]);
        String actual = student.getLastName();
        String expected = "McMillan";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getLastName3() {
        Student student = new Student("", "Lastname",new Double[2]);
        String actual = student.getLastName();
        String expected = "Lastname";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastName1() {
        Student student = new Student("", "Wes",new Double[2]);
        student.setLastName("Jones");
        String actual = student.getLastName();
        String expected = "Jones";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setLastName2() {
        Student student = new Student("", "Name1",new Double[2]);
        student.setLastName("Name2");
        String actual = student.getLastName();
        String expected = "Name2";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setLastName3() {
        Student student = new Student("", "Lakeman",new Double[2]);
        student.setLastName("Tavner");
        String actual = student.getLastName();
        String expected = "Tavner";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumberOfExamsTaken1() {
        Student student = new Student("","", new Double[4]);
        Integer actual = student.getNumberOfExamsTaken();
        Integer expected = 4;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getNumberOfExamsTaken2() {
        Student student = new Student("","", new Double[9]);
        Integer actual = student.getNumberOfExamsTaken();
        Integer expected = 9;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getNumberOfExamsTaken3() {
        Student student = new Student("","", new Double[4]);
        student.addExamScore(59.45);
        student.addExamScore(59.45);
        Integer actual = student.getNumberOfExamsTaken();
        Integer expected = 6;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScores1() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.5);
        student.addExamScore(45.44);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 96.50\n" +
                "\tExam 2 -> 45.44\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getExamScores2() {
        Double[] examScores = { 97.45, 48.39 };
        Student student = new Student("","", examScores);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 97.45\n" +
                "\tExam 2 -> 48.39\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getExamScores3() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.5);
        student.addExamScore(59.45);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 96.50\n" +
                "\tExam 2 -> 59.45\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScore1() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.5);
        student.addExamScore(45.44);
        Integer actual = student.getNumberOfExamsTaken();
        Integer expected = 2;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void addExamScore2() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.5);
        student.addExamScore(45.44);
        student.addExamScore(96.5);
        student.addExamScore(45.44);
        Integer actual = student.getNumberOfExamsTaken();
        Integer expected = 4;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void addExamScore3() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.5);
        student.addExamScore(59.45);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 96.50\n" +
                "\tExam 2 -> 59.45\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScore1() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.5);
        student.setExamScore(0,100.0);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 100.00\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setExamScore2() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.50);
        student.addExamScore(86.55);
        student.addExamScore(67.00);
        student.setExamScore(1,59.45);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 96.50\n" +
                "\tExam 2 -> 59.45\n" +
                "\tExam 3 -> 67.00\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void setExamScore3() {
        Double[] examScores = { };
        Student student = new Student("","", examScores);
        student.addExamScore(96.5);
        student.addExamScore(44.44);
        student.setExamScore(0,34.22);
        String actual = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 34.22\n" +
                "\tExam 2 -> 44.44\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageExamScore1() {
        Double[] examScores = { 23.33, 45.23, 67.44, 100.00 };
        Student student = new Student("","", examScores);
        Double actual = student.getAverageExamScore();
        Double expected = 59.00;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAverageExamScore2() {
        Double[] examScores = { 24.67, 75.33 };
        Student student = new Student("","", examScores);
        Double actual = student.getAverageExamScore();
        Double expected = 50.00;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAverageExamScore3() {
        Double[] examScores = { 85.35 };
        Student student = new Student("","", examScores);
        Double actual = student.getAverageExamScore();
        Double expected = 85.35;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest1() {
        Double[] examScores = { 23.33, 45.23, 67.44, 100.00 };
        Student student = new Student("Wes","Jones", examScores);
        String actual = student.toString();
        String expected = "Student Name: Wes Jones\n" +
                "> Average Exam Score: 59.00\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 23.33\n" +
                "\tExam 2 -> 45.23\n" +
                "\tExam 3 -> 67.44\n" +
                "\tExam 4 -> 100.00\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void toStringTest2() {
        Double[] examScores = { 56.44, 45.23, 27.44, 100.00 };
        Student student = new Student("Mac","Book", examScores);
        String actual = student.toString();
        String expected = "Student Name: Mac Book\n" +
                "> Average Exam Score: 57.28\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 56.44\n" +
                "\tExam 2 -> 45.23\n" +
                "\tExam 3 -> 27.44\n" +
                "\tExam 4 -> 100.00\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void toStringTest3() {
        Double[] examScores = { 23.33, 45.23 };
        Student student = new Student("John","Lakeman", examScores);
        String actual = student.toString();
        String expected = "Student Name: John Lakeman\n" +
                "> Average Exam Score: 34.28\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 23.33\n" +
                "\tExam 2 -> 45.23\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void purgeDataTest() {
        Double[] examScores = { 23.33, 45.23 };
        Student student = new Student("John","Lakeman", examScores);
        student.purgeData();
        Student actual = student;
        Student expected = new Student("", "", new Double[0]);
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void checkIfValidTest1() {
        Double[] examScores = { 23.33, 45.23 };
        Student student = new Student("John","Lakeman", examScores);
        Assert.assertTrue(student.checkIfValid());
    }
    @Test
    public void checkIfValidTest2() {
        Double[] examScores = { 23.33, 45.23 };
        Student student = new Student("John","Lakeman", examScores);
        student.purgeData();
        Assert.assertFalse(student.checkIfValid());
    }
}