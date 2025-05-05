package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public String getFirstName() {
        return firstName;
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

    public String getExamScores(){
        String output = "Exam Scores:\n";
        int counter = 1;
        for(int i = 0; i <= examScores.size() - 1; i++){
            output +=" \tExam " + counter + " -> " + examScores.get(i) + "\n";
            counter++;
        }
        return output;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public void addExamScore(Double score){ examScores.add(score); }

    public void setExamScores(int examNumber, double newScore) { examScores.set(examNumber, newScore); }

    public Double getAverageExamScore(){
        Double average = 0.0;
        for(int i = 0; i < examScores.size(); i++){
            average += examScores.get(i);
        }
        return average/examScores.size();
    }

    @Override
    public String toString(){
        return "Student: " + getFirstName() + getLastName() + ", Average Scores: " + getAverageExamScore() + getExamScores();
    }
}
