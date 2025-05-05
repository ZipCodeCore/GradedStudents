package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String firstName;
    String lastName;
    ArrayList<Double> examScores;
    Double[] testScores;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        this.examScores.addAll(Arrays.asList(testScores));


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

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public String getExamScores() {

        StringBuilder sb = new StringBuilder();
        for(Integer i = 0; i<examScores.size(); i++){
            sb.append("\tExam " + (i + 1) + " -> " + examScores.get(i) + "\n");
        }
        return sb.toString();
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber - 1, newScore);
    }

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public Double getAverageExamScore(){

        double sum = 0;
        for(Double i : this.examScores){
            sum  += i;
        }
        double roundToDecimal = Math.round(sum / examScores.size() * 100);
        double average = roundToDecimal / 100;
        return average;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: " + this.firstName + " " + this.lastName);
        sb.append("\n> Average Score: " + getAverageExamScore() + "\n> Exam Scores:\n");
        sb.append(getExamScores());

        return sb.toString();
    }
}
