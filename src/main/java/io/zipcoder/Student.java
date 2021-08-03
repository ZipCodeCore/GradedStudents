package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    Double[] testScores;
    ArrayList<Double> examScores;

    public Student(String firstName,String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken() {
            return examScores.size();
    }

    public String getFullName() {return firstName + " " + lastName;}

    public String getExamScores() {
        String score = "Exam Scores: \n";

        for(int i =0; i < examScores.size(); i++) {
            score += "\tExam " + (i + 1) +  " -> ";
            score += examScores.get(i) + "\n";
        }
        return score;
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){
        examScores.set(examNumber, newScore);
    }

    public double getAverageExamScore() {
        double average = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            average += examScores.get(i);

        } return average / examScores.size();
    }

    @Override
    public String toString(){
        String nameScore = "Student Name: " + firstName + " " + lastName + "\n";
        nameScore = nameScore +  "> Average Score: " + this.getAverageExamScore() + "\n";
        nameScore = nameScore + "> " + this.getExamScores();
        return nameScore;
    }
}
