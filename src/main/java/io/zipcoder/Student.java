package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    //Constructor

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList(Arrays.asList(examScores));
        ;
    }


    //setters and getters

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


    //methods
    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        String outputOfScores = "";

        for(int index = 0; index < examScores.size(); index ++){

            int exam = (index + 1);
            double score = examScores.get(index);

            outputOfScores += ("Exame " + exam + " -> " + score + "\n");
        }

        return outputOfScores;
    }

    public void addExamScore(double newScore){
        examScores.add(newScore);
    }

    public void setExamScore(int examNumber, double newScore){
        examScores.set(examNumber - 1, newScore);
    }

    public Double getAverageExamScore(){
        double totalScore = 0.00;

        for(int index = 0; index < examScores.size(); index++)
            totalScore += examScores.get(index);

        return (totalScore/examScores.size());
    }

    @Override
    public String toString(){

        String ouput = ("\n> Student Name: " + firstName + " " + lastName + "\n" +
                        "> Average Score: " + getAverageExamScore() + "\n" +
                        "> Exam Scores: \n" + getExamScores());

        return ouput;
    }

}
