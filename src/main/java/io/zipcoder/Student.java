package io.zipcoder;

import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Comparable {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        for (int i =0; i <testScores.length; i++) {
            examScores.add(testScores[i]);
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamScore(int examNumber, Double examGrade) {
        examScores.set(examNumber-1, examGrade);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public Double getAverageExamScore() {
        Double sumOfExamScores =0.00;
        for (int i =0; i < examScores.size(); i++) {
            sumOfExamScores += examScores.get(i);
        } return sumOfExamScores / examScores.size();
    }
    public void addExamScore(Double testScore) {
        examScores.add(testScore);
    }

    public String getExamScores() {
        StringBuilder examScoresLister = new StringBuilder("Exam Scores: ");
        for (int i = 0; i < examScores.size(); i++) {
            examScoresLister.append("\n\tExam " + (i + 1) + " -> " +(examScores.get(i)));
        }
        return examScoresLister.toString();
    }
    public String toString() {
        String stringStudent;
        stringStudent = String.format("Student Name: %s %s\n" +
                " > Average Score: %.1f\n" +
                " > " + getExamScores(),firstName, lastName, getAverageExamScore());
        return stringStudent;

    }

    @Override
    public int compareTo(Object s) {
        return Comparator.comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getLastName).compare(this,(Student) s);
    }
}