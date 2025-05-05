package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    ArrayList<Double>examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
                this.firstName=firstName;
                this.lastName=lastName;
                this.examScores = new ArrayList<Double>(Arrays.asList(testScores));

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getTestScores() {
        return examScores;
    }

    public int getNumberOfTestsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String scoreReport = "";
        for (int i = 0; i < examScores.size(); i++) {
            scoreReport += "Exam " + i + 1 + " --> " + examScores.get(i) + "\n";
        }
        return scoreReport;
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public Double getAverageExamScore() {
        double sum = 0;
        double avgReport = 0;
        for (int i = 0; i < examScores.size(); i++) {
            sum += examScores.get(i);
            avgReport = sum/examScores.size();
        }
        return avgReport;
    }

@Override
    public String toString(){
        return "'''\n" + "Student Name: " + firstName + " " + lastName + "\n" + getExamScores()+ "\n" + getAverageExamScore()+"\n'''";
    }



/*    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", testScores=" + examScores +
                '}';
    }*/
}

