package io.zipcoder;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

//Constructors
    public Student (){};

    public Student (String firstName){
        this.firstName = firstName;
    }
    public Student (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList(Arrays.asList(testScores));
    }


//Methods
    public String getFirstName(){ return firstName;}

    public void setFirstName(String firstName) { this.firstName = firstName;}

    public String getLastName(){ return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public Integer getNumberOfExamsTaken(){ return examScores.size();}

    public String getExamScores() {
        StringBuilder output = new StringBuilder();
        output.append("Exam Scores: \n");
        for (int i = 0; i < examScores.size(); i++) {
            int count = (i + 1);
            double score = examScores.get(i);
            double newScore = score;
            output.append("\t   Exam " + count + " -> " + newScore + "\n");
        }
        return output.toString();
    }

    public void addExamScore(Double oneExam){
        examScores.add(oneExam);

    }

    public void setExamScores(int examNumber, Double newScore){
        examScores.set(examNumber -1, newScore);
    }

    public double getAverageExamScore(){
        double totalScore = 0;

        for (int i = 0; i < examScores.size(); i++){
            totalScore += examScores.get(i);
        }
        return (totalScore / examScores.size());
    }

    @Override
    public String toString(){
        StringBuilder info = new StringBuilder();
            info.append("Student Name: " + firstName + " " + lastName + "\n");
            info.append("> Average Score: " + getAverageExamScore() + "\n");
            info.append("> " + getExamScores());
            String infoResult = info.toString();
            return infoResult;
    }


}