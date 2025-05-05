package io.zipcoder;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;



    public Student(String firstName, String lastName, ArrayList<Double> examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getNumberOfExamsTaken (){
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder();
            sb.append("Exam Scores: \n");
        for (int i = 0; i < examScores.size(); i++) {
            sb.append("     Exam "+ (i+1) + " -> " + examScores.get(i)+ "\n");
        }
        return sb.toString();

    }

    public boolean addExamScore(Double examScore){
           return examScores.add(examScore);
    }

    public void setExamScores(int examNumber, double newScore){
        examScores.set(examNumber, newScore);
    }

    public double getAverageExamScore(){
        int combinedTotal = 0;
        for (int i = 0; i < getNumberOfExamsTaken(); i++){
            combinedTotal += examScores.get(i);
        }
        return  combinedTotal/getNumberOfExamsTaken();

    }
    public double setCurvedAverageExamScore (double curvedAverageExamScore) {
        return curvedAverageExamScore;
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Student Name: "+ getFirstName()+ " "+ getLastName() +"\n");
        sb.append(" > Average Score: " +getAverageExamScore()+"\n");
        sb.append(" > ");
        sb.append(getExamScores()+"\n");

        return sb.toString();

    }
}

