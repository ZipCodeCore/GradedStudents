package io.zipcoder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;

    public Student(String firstName, String lastName, ArrayList<Double> testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
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

    public int getNumberOfExamsTaken() {
        return testScores.size();
    }

    public String getExamScores() {
        StringBuilder getScores = new StringBuilder();
        for (int i = 0; i < testScores.size(); i++) {
            getScores.append("Exam ").append(i + 1).append("-> ");
            getScores.append(testScores.get(i)).append("\n");
        }
        return getScores.toString();
    }

    public Double addExamScore() {
        return testScores.get(testScores.size() - 1);
    }

    public Double setExamScores() {
        return testScores.get(0);
    }

    public Double averageOfExams() {
        Double[] exams = testScores.toArray(new Double[testScores.size()]);
        Double sum = 0.00;
        for (int i = 0; i < exams.length; i++) {
            sum = sum + exams[i];
        }
        Double average = sum / exams.length;
        return average;
    }

    public String toFormattedString() {
        StringBuilder studentsToString = new StringBuilder();
        studentsToString.append("Student Name: ").append(firstName).append(" ").append(lastName + "\n").append("Average -> ").append(averageOfExams()).append("\n").append(getExamScores());


        return studentsToString.toString();

    }

//    public String sortByAverages(){
//        StringBuilder sortedSB = new StringBuilder();
//        for (int i = 0; i < testScores.size(); i++) {
//
//        }
//
//        Collections.sort(testScores, Collections.reverseOrder());
//        for (Double test : testScores){
//            sortedSB.append(test).append(firstName).append(lastName);
//        }
//        return sortedSB.toString();



}
