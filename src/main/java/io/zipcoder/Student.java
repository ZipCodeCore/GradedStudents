package io.zipcoder;

import java.util.ArrayList;

public class Student implements Comparable <Student> {
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;
    private int totalExams;


    public Student(String firstName, String lastName, ArrayList<Double> testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String printTestScores() {
        StringBuilder printTestScores = new StringBuilder();
        printTestScores.append("Exam Scores: \n");
        for (int i = 0; i < testScores.size(); i++) {
            printTestScores.append("\tExam " + (i + 1) + " --> " + testScores.get(i) + "\n");
        }
        return printTestScores.toString();
    }

    public int getTotalExamsTaken() {
        return this.testScores.size();
    }

    public void setTotalExamsTaken(int totalExams) {
        this.totalExams = totalExams;
    }


    public void addExamScore(double examScore) {
        this.testScores.add(examScore);
    }

    public void setExamScore(int examNum, double newScore) {
        testScores.set(examNum - 1, newScore);
    }

    public double getAverageExamScores() {
        int sum = 0;
        for (int i = 0; i < testScores.size(); i++) {
            sum += testScores.get(i);
        }
        double average = (double) sum / testScores.size();
        return Math.round(average);
    }

    @Override
    public String toString() {
        StringBuilder studentBuilder = new StringBuilder("Student Name: ");
        studentBuilder.append(this.firstName + " " + this.lastName);
        studentBuilder.append("\n> Average Score: " + getAverageExamScores() + "\n");
        studentBuilder.append("> " + printTestScores());

        return studentBuilder.toString();
    }


    private int compareToLastName(Student temp) {
        return temp.getLastName().compareTo(this.getLastName());
    }

    @Override
    public int compareTo(Student temp) {
        int comparator = Double.compare(this.getAverageExamScores(), temp.getAverageExamScores());
        if (comparator == 0) {
            return compareToLastName(temp);
        }
        return comparator;
    }
}


