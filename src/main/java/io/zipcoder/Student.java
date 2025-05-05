package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String firstName;
    private String lastName;
    private Double[] testScores;
    public ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
        this.examScores = new ArrayList();
        this.examScores.addAll(Arrays.asList(testScores));
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

    public Double[] getTestScores(){
        return testScores;
    }

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores (){
        String listExamScores="";
        int count = 1;
        for(int i = 0; i < this.examScores.size(); i++) {
            listExamScores += "Exam " + count++ + " -> " + examScores.get(i) + "\n";
        }
        return listExamScores.trim();
    }

    public void addExamScore(Double score) {
        this.examScores.add(score);
    }

    public void setExamScore(int examNumber, double newScore){
        int indexOfExam = examNumber - 1;
        this.examScores.set(indexOfExam, newScore);
    }

    public String getAverageExamScore(){
        double examsTotalSum = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        for(int i = 0; i < this.examScores.size(); i++) {
            examsTotalSum+= examScores.get(i);
        }

        double tempAverageExamScore = examsTotalSum / this.examScores.size();
        String averageExamScore = df.format(tempAverageExamScore);
        return averageExamScore;
    }

    @Override
    public String toString(){
        String studentAverageAndScores="Student Name: " + getFirstName() + " " + getLastName() + "\n" +
                "> Average Score: " + getAverageExamScore() + "\n" + "> Exam Scores:\n" + getExamScores();

        return studentAverageAndScores;
    }


    }





