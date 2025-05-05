package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student() {
        this.firstName = "";
        this.lastName = "";
        this.examScores = null;
    }

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Note: There should not be a setter for the testScore.
     * This object's state will be mutated via a takeExam method mentioned below.
     * @return
     */


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public ArrayList<Double> getExamScoresArrayList() {
        return this.examScores;
    }

    /**
     * Additionally, define a getter, getNumberOfExamsTaken(),
     * which returns the total number of exams taken by this student.
     *
     * I understand the number of exams taken is the length of the parameter
     * Double[] testScores, which is the same as the ArrayList<Double>
     */

    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder("Exam Scores:\n");
        for (int i = 0; i < this.examScores.size(); i++) {
            sb.append(" \tExam " + (i + 1) + " -> " + String.format("%.1f", this.examScores.get(i)) + "\n");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        int indexOfExamNumber = examNumber - 1;
        this.examScores.set(indexOfExamNumber, newScore);
    }

    public double getStudentAverageExamScore() {
        double sumOfExamScores = 0.0;
        for (double examScore : this.examScores) {
            sumOfExamScores += examScore;
        }
        double averageExamScore = sumOfExamScores / this.examScores.size();
        double roundedAverageExamScore = (double) Math.round(averageExamScore * 10) / 10;
        return roundedAverageExamScore;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(" Student Name: " + this.firstName + " " + this.lastName + "\n" +
                           " > Average Score: " + this.getStudentAverageExamScore() + "\n" +
                           " > ");

        sb.append(this.getExamScores());
        return sb.toString();
    }

    public String getLetterGrade() {

        double studentAverageScore = this.getStudentAverageExamScore();
        String letterGrade = "";

        if (studentAverageScore >= 90.0) {
            letterGrade = "A";
        } else if (studentAverageScore >= 80.0) {
            letterGrade = "B";
        } else if (studentAverageScore >= 70.0) {
            letterGrade = "C";
        } else if (studentAverageScore >= 60.0) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        return letterGrade;
    }

}
