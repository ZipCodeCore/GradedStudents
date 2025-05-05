package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

// this is a blueprint in case we want multiple students
public class Student implements Comparable<Student>{
    // declaring variables
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, ArrayList<Double> examScores){
        // assigning parameter variables to the object "Student" in line 13
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;
    }

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        // this converts an array to an arrayList
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExamsTaken(){
        return examScores.size();
    }

    public String getExamScores(){
        String output = " Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++) {
             output += " \t" + "Exam " + (i+1) + " -> " + Math.round(examScores.get(i));
             // if i is not equal to the index of last element than make a new line,
            // otherwise if its the last index dont go to the next line.
             if (i != examScores.size()-1) {
                 output += "\n";
             }
        }
        return output;
    }


    public void addExamScore(double newScore) {
        examScores.add(newScore);
    }

    public void setExamScore(int examNum, double newScoreOnExam){
        examScores.set(examNum, newScoreOnExam);
    }

    public Double getAverageExamScore() {
        Double totalExams = 0.0;
        for (int i = 0; i < getNumberOfExamsTaken(); i++) {
            totalExams += examScores.get(i);
        }
        return totalExams / getNumberOfExamsTaken();
    }

    @Override
    public String toString(){
        return "Student Name: " + getFirstName() + " " + getLastName() + "\n" +
                "> Average Score: " + getAverageExamScore() + "\n>" + getExamScores();
    }


    @Override
    public int compareTo(Student o) {
        return Double.compare(this.getAverageExamScore(), o.getAverageExamScore());
    }
}
