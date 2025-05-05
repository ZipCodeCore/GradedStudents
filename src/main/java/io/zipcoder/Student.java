package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student{
    private String firstName;
    private String lastName;
     List<Double> examScores;

    public Student(){}


    public Student (String firstName, String lastName, Double[] testScores  ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));

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

    public Integer getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        StringBuilder sbScores = new StringBuilder();

        System.out.println("Exam Scores : \n");
        for(int i = 0; i < examScores.size();i++){

            sbScores.append("Exam " + (i + 1) + " -> " + examScores.get(i) + "\n");
        }
        return sbScores.toString();
    }

    public void addExamScore(Double examScore){
        examScores.add(examScore);
    }

    public void setExamScores(int examNumber, double newScore){
        examScores.set(examNumber,newScore);

    }

    public Double getAverageExamScore(){
        Double total = 0.0 ;
        for(int i =0; i < examScores.size();i++){
            total += examScores.get(i);
        }
        return total/examScores.size();
    }

//    public void takeExam(Double examScore){examScores.add(examScore);}

    public String toString(){
        String nameLine = "Student Name : " + getFirstName()  + " " + getLastName() + "\n";
        String avgLine = "Average Score : " + getAverageExamScore() + "\n";
        String examLines = getExamScores() + "\n";

        return nameLine + avgLine + examLines;
    }
}
