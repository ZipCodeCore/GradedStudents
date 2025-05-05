package io.zipcoder;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        this.examScores.addAll(Arrays.asList(examScores));

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;

    }

    public String getLastName(){
        return this.lastName;
    }

    public int getNumberOfExamsTaken(){
        return this.examScores.size();
    }

    public String getExamScores(){
        StringBuilder builder = new StringBuilder();
        builder.append("Exam Scores:\n");
        for (int i = 0; i<this.examScores.size(); i++){
            builder.append("\tExam " + (i+1) + " => " + Math.round(this.examScores.get(i)) + "\n");
        }
        return builder.toString();
    }

    public void addExamScore(Double newScore){
        this.examScores.add(newScore);
    }

    public void setExamScore(int examNumber, Double newScore){
        this.examScores.set(examNumber-1, newScore);
    }

    public double getAverageExamScore(){
        double sum = 0.0;
        for(Double d : this.examScores){
            sum += d;
        }
        return Math.round(sum/this.examScores.size());
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Student Name: " + this.getFirstName() + " " + this.getLastName() + "\n");
        builder.append("Average Score = " + this.getAverageExamScore() + "\n");
        builder.append(this.getExamScores());

        return builder.toString();
    }








}
