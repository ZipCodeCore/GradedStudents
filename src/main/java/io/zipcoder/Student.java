package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student>{
    String firstName;
    String lastName;
    ArrayList<Double> examScore;



    Student(String firstName , String lastName , Double[] testScores){
        this.firstName=firstName;
        this.lastName=lastName;
        this.examScore= new ArrayList<Double>(Arrays.asList(testScores));

    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Double> getExamScore() {
        return examScore;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Integer getNumberOfExamsTaken(){
        if(this.examScore!= null){
            return examScore.size();
        }
        else return 0;
    }


    public String getExamScores() {
        StringBuilder output=new StringBuilder();
        output.append("Exam Scores:\n");
        for(int i=0;i<examScore.size();i++){
            output.append(String.format("\tExam %s -> %s\n",i+1,Math.round(examScore.get(i))));
        }
        return output.toString();
    }

    /*
    public String getExamScores(){
        String output="Exam Scores:\n";
        for(int i=0;i<examScore.size();i++){
            output=output+String.format("Exam %s -> %s\n",i+1,Math.round(examScore.get(i)));
        }
        System.out.println(output);
        return output;
    }
    */

    public void addExamScore(Double examScore){
        this.examScore.add(examScore);

    }
    public void setExamScore(int examNumber, double newScore){
        this.examScore.set(examNumber-1,newScore);
    }


    public Integer averageExamScore(){
        Double sum=0.0;
        for(int i=0;i<this.examScore.size();i++){
            sum=(sum+this.examScore.get(i));

        }
        int avg=(int)Math.rint(sum/this.examScore.size());
        return avg;
    }
    @Override
    public String toString(){
        return "Student Name: "+firstName+" "+lastName+"\n> Average Score: "+averageExamScore()+"\n> "+getExamScores();


    }


    ArrayList<Student>studentArrayList=new  ArrayList<>();

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
