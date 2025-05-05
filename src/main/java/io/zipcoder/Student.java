package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student  {
    private String firstName;
    private  String lastName;
    private ArrayList<Double> examScores;
    Double[] testScores;

    public  Student(String firstName, String lastName, Double ... examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(examScores));

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

    public void setLastName(String lastName) { this.lastName = lastName; }


    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        String result = "Exam Scores: \n";

        for(int i =0; i < examScores.size(); i++) {
            result += "\tExam " + (i + 1) +  " -> ";
            result += examScores.get(i) + "\n";
        }
        return result;
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(Integer examNumber, Double newScore) {
        examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore() {
        Double result = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            result = result + examScores.get(i);
        }
        return result / examScores.size();
    }
    @Override
    public String toString() {
    String result = "Student: " + firstName + " " +  lastName + "\n";
    result = result + "> Average Score: " + this.getAverageExamScore() + "\n";
      result = result + "> " +  getExamScores();


        return result;
    }
}
