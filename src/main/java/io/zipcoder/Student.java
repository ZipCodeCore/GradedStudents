package io.zipcoder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Student extends Object{

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();
    private Integer examsTaken;


    public Student(String firstname, String lastName, Double[] testScores) {
        this.firstName = firstname;
        this.lastName = lastName;
        for (int i =0; i <testScores.length; i++) {
            examScores.add(testScores[i]);
        }

    }
    public Student(){

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
        return examsTaken;
    }

    public String getExamScores(){
        StringBuilder score= new StringBuilder();
        for (int i = 0; i < examScores.size(); i++) {
            score.append(" Exam "+ (i+1) + " -> " +examScores.get(i));
            score.append("\n");
        }
        return score.toString();

    }

    public String addExamScore(double examScore){
        examScores.add(examScore);

        return getExamScores().toString();
    }

    public String setExamScore(int examNumber, double newScore){
        examScores.set(examNumber,newScore);
        return getExamScores().toString();
    }
    public Double getAverageExamScore() {

        Double total =0.00;
        for (int i =0; i < examScores.size(); i++) {
            total += examScores.get(i);

        } return total / examScores.size();
    }
    @Override
    public String toString(){
        NumberFormat nf = new DecimalFormat("##");
        String getExamScores = getExamScores().replace(".0","");
        String result= "Student Name: "+firstName+" "+lastName+"\n"+"> "+"Average Score: "+
                Math.round(getAverageExamScore())+"\n" +"> "+ "Exam Scores:" +"\n" +
                getExamScores;

            return result;
    }


}
