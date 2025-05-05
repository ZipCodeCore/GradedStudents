package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(){

    }

    public Student (String firstName, String lastName, Double[] testScores) {
        this.firstName =firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>();
        this.examScores.addAll(Arrays.asList(testScores));

    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getNumberOfExamsTaken() {
        int tests = 0;
        for (int i = 0; i<examScores.size(); i++) {
            tests++;
        }

        return tests;
    }

    public String getExamScores() {
        StringBuilder allExamScores = new StringBuilder();
        allExamScores.append("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            allExamScores.append("\tExam " + (i + 1) + " -> " + examScores.get(i) + "\n");
        }

        return allExamScores.toString().trim();
    }

    public void addExamScore(Double examScore){

        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, Double newScore) {

        this.examScores.set(examNumber -1, newScore);
    }

    public double getAverageExamScore() {
        double combinedScores = 0;
        for(double score : examScores) {
            combinedScores += score;
        }
        return Math.round(combinedScores / getNumberOfExamsTaken());
    }

    @Override
    public String toString() {
        StringBuilder studentFile = new StringBuilder();
        studentFile.append("Student Name: " + getFirstName() + " " + getLastName() +"\n");
        studentFile.append("> Average Score: " + getAverageExamScore() + "\n");
        studentFile.append("> " + getExamScores() + "\n");
        return studentFile.toString();
    }


    @Override
    public int compareTo(Student student) {
        double sAvg1 = getAverageExamScore();
        double sAvg2 = student.getAverageExamScore();

        if (sAvg1 > sAvg2) {
            return -1;
        } else if (sAvg1 < sAvg2) {
            return 1;
        } else {
            return lastName.compareTo(student.lastName);
        }
    }
}


