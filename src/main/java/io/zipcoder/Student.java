package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, ArrayList<Double> examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;

    }
    public String getExamScores(){
        StringBuilder stringOfExamScores = new StringBuilder();
        DecimalFormat df = new DecimalFormat("###");
        int counter = 1;
        stringOfExamScores.append("Exam Scores:\n");
        for(Double str : examScores){
            stringOfExamScores.append(" \tExam " + counter + " -> " + df.format(str) + "\n");
            counter++;
        }
        return stringOfExamScores.toString();
    }
    public void addExamScore(Double examScore){

    }
    public void setExamScores(){

    }
    public double getAverageExamScore(){
        return 0;
    }
    public double getNumberOfExamsTaken(){
        return 0;
    }
    public ArrayList<Double> getActualExamScores(){
        return examScores;
    }

    public void setFirstName(){

    }
    public void setLastName(){

    }
    public String getFirstName(){
        return null;
    }
    public String getLastName(){
        return null;
    }

    @Override
    public String toString(){
        return null;
    }
}
