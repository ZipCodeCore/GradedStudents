package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(){

    }

    public Student (String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList();
        this.examScores.addAll((Arrays.asList(testScores)));
    }

    public void setFirstName(String firstName){

        this.firstName = firstName;
    }

    public String getFirstName(){

        return this.firstName;
    }

    public void setLastName(String lastName){

        this.lastName = lastName;
    }

    public String getLastName(){

        return this.lastName;
    }

    public Integer getNumberOfExamsTaken(){

        int counter = 0;

        for(Double score : examScores){
            counter++;
        }

        return counter;
    }

    public String getExamScores(){
        StringBuilder scoreBuilder = new StringBuilder();

        scoreBuilder.append("Exam Scores:" + "\n");
        for(int i = 0; i < examScores.size(); i++){
            scoreBuilder.append("\t\t" + "Exam " + (i + 1) + " -> " + examScores.get(i) + "\n");
        }
        return scoreBuilder.toString();
    }

    public void addExamScore(double examScore){

         examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore){

        examScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore(){

        double total = 0;

        for (Double score : examScores){
            total += score;
            }

        double average = Math.round(total / examScores.size());

        return average;
    }
    @Override
    public String toString(){
        StringBuilder combineAll = new StringBuilder();

        combineAll.append("Student Name: " + getFirstName() + " " + getLastName() + "\n");
        combineAll.append("> Average Score: " + getAverageExamScore() + "\n");
        combineAll.append("> " + getExamScores());


        return combineAll.toString();
    }

}
