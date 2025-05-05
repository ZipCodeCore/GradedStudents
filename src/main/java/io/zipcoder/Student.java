package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = new ArrayList<Double>(Arrays.asList(testScores));
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

    public ArrayList<Double> getTestScores(){
        return this.testScores;
    }

    public Integer getNumberOfExamsTaken(){
            return this.getTestScores().size();
    }

    public void addExamScore(double examScore){
        this.getTestScores().add(examScore);
    }

    public String getExamScores(){
        String printOut = "";
        ArrayList<Double> examScores = this.getTestScores();

        for(int i = 0; i < examScores.size(); i++){
            printOut += "    Exam " + (i + 1) + " -> ";
            printOut += examScores.get(i);
            printOut += "\n";
        }
        return printOut;
    }


    public void setExamScore(int examNumber, double newScore){
        ArrayList<Double> testScores = this.getTestScores();
        testScores.set(examNumber - 1, newScore);
    }

    public double getAverageExamScore(){
        double sum = this.getTestScores().stream().mapToDouble(Double::doubleValue).sum();
        return sum / this.getTestScores().size();
    }

    @Override
    public String toString(){
        String readout = "";
        readout += "Student Name: " + this.firstName + " " + this.lastName;
        readout += "\n";
        readout += "> Average Score: " + this.getAverageExamScore();
        readout += "\n";
        readout += "> Exam Scores:";
        readout += "\n";
        readout += this.getExamScores();

        return readout;
    }

}
