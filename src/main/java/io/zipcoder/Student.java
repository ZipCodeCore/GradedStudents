package io.zipcoder;

import java.util.ArrayList;

public class Student  {

    private Integer numberOfExamsScores;
    private Double[] testScores;
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamScores(ArrayList<Double> examScores) {
        this.examScores = examScores;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public Double[] getTestScores() {
        return this.testScores;
    }

    public String getExamScores() {
       StringBuilder examScoresFormatted = new StringBuilder();
       examScoresFormatted.append("Exam Scores: ");
       for (int i = 0; i < testScores.length; i++) {
           examScoresFormatted.append("\n\t Exam " +(i+1) + " -> "+ Math.round(testScores[i]));
       }
        return examScoresFormatted.toString();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        this.examScore = examNumber
    }

    public Integer getNumberOfExamScores() {
        return 0;
    }

}