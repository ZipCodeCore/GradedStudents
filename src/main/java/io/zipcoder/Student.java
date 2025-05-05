package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    ArrayList<Double> examScores;

    public Student(String givenFirstName, String givenLastName, Double...examScores) {
        this.firstName = givenFirstName;
        this.lastName = givenLastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
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

    public String getFullName (){
        return this.firstName + " " + this.lastName;
    }

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        String output = "Exam Scores: \n";

        for (int i = 0; i < examScores.size(); i++) {
            output += "\t Exam " + (i + 1) + " -> ";
            output += examScores.get(i);
            output += "\n";

        }
        return output;
    }

    public void addExamScore(double score){
        examScores.add(score);
    }

    public void setExamScore(int testNumber, double newScore){
        examScores.remove(testNumber-1);
        examScores.add(testNumber-1, newScore);
    }

    public Double getAverageExamScore(){
        double total = 0;
        for (double score: examScores) {
             total += score;
            }
        Double avg = total/examScores.size();

        return avg;
    }

    @Override
    public String toString(){
        return String.format("Student Name: %s %s\n" + "> Average Score: %.1f \n" + "> %s", firstName, lastName, getAverageExamScore(), getExamScores());
    }


}
