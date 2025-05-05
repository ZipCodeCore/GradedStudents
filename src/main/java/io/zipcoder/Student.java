package io.zipcoder;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();
    String letterGrade;


    public Student(String firstName, String lastName, Double[] testScores, String letterGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        Collections.addAll(this.examScores, testScores);
        this.letterGrade = letterGrade;
    }
    public String getLetterGrade() {
        return this.letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
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

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores() {
        int index = 1;
        String result = "Exam Scores:\n";
        for (Double score: examScores) {
            result += "Exam " + index + " -> " +score + "\n";
            index++;
        }
        return result;
    }

    public void addExamScore(double newScore) {
        examScores.add(newScore);
    }

    public void setExamScore(int index, double newScore) {
        examScores.set(index - 1, newScore);
    }

    public Double getAverageExamScore() {
        Double allExamScore = 0.0;
        for (Double score: examScores) {
            allExamScore += score;
        }
        return allExamScore/examScores.size();
    }

    /**
     * Student Name: Leon Hunter
     * 		> Average Score: 125
     * 		> Exam Scores:
     * 		    Exam 1 -> 100
     * 		    Exam 2 -> 150
     * 		    Exam 3 -> 250
     * 		    Exam 4 -> 0
     */

    @Override
    public String toString(){
        String result = "Student Name: " + firstName + " " + lastName + "\n" +
                "Average Score: " + getAverageExamScore() + "\n" + getExamScores() +
                "Letter Grade:" + getLetterGrade() + "\n";
        return result;
    }

    @Override
    public int compareTo(Student student) {
        return (int) (this.getAverageExamScore() - student.getAverageExamScore());
    }
}
