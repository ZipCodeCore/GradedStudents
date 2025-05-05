package io.zipcoder;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
   String firstName;
   String  lastName;
   ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores.addAll(Arrays.asList(testScores));

    }

    // Getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    // Setters


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Other Methods

    public String getExamsTaken() {
        String ans = "Exam Scores:";
        for (int i = 1; i <= examScores.size(); i++) {
            ans += "\n      Exam " + i + " -> " + Math.round(examScores.get(i - 1));
        }
        return ans;
    }

    public void takeExam(Double newScore) {
        this.examScores.add(newScore);
    }

    public void setExamScore(int examNumber, double newScore){
        this.examScores.set(examNumber - 1, newScore);
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            sum += this.examScores.get(i);
        }

        return sum/examScores.size();
    }

    @Override
    public String toString(){
      return  "Student Name: " + firstName + " " + lastName + "\n"
      +"> Average Score: " + getAverageExamScore() + "\n"
      +"> " + getExamsTaken();
    }
}
