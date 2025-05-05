package io.zipcoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    Student(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        examScores = new ArrayList<>();

    }

    Student(String firstName, String lastName, ArrayList examScores) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.examScores = examScores;
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



    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        fullName.append(this.getFirstName())
                .append(" ")
                .append(this.getLastName());
        return fullName.toString();
    }




    public int getNumberOfExamsTaken() {
        return examScores.size();
    }




    public String getExamScores() {
        StringBuilder examScoreBuilder = new StringBuilder();
        for (int i = 0; i < examScores.size(); i++) {
            examScoreBuilder.append("\tExam " + (i + 1) + ": " + examScores.get(i) + "\n");
        }
        return examScoreBuilder.toString();
    }




    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }




    public void setExamScores(int examNumber, double newScore) {
        examScores.set(examNumber, newScore);
    }




    public Double getAverageExamScore() {
        double averageScore = 0;
        double sum = 0;

        if (!examScores.isEmpty()) {
            for (double score : examScores) {
                sum += score;
            }
            averageScore = sum / examScores.size();
        }
        return averageScore;
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nStudent Name: " + firstName + " " + lastName)
                .append("\n > Average Score: " + getAverageExamScore())
                .append("\n > Exam Scores:")
                .append("\n" + getExamScores());

        return sb.toString();
    }
}