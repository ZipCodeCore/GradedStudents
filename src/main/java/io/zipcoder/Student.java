package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    ArrayList<Double> examScores;
    Double[] testScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<Double>(Arrays.asList(testScores));
    }



    // ================== GETTERS ================== //
    public String getFullName(){
        return this.lastName + ", " + this.firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder stringOfTestScores = new StringBuilder();

        for (int i = 0; i < examScores.size() ; i++) {
            stringOfTestScores.append(examScores.get(i)).append(" | ");
            stringOfTestScores.append(i);
        }
        return String.valueOf(examScores);
                //Arrays.toString(testScores);
    }

    public void addExamScore(double testScore) {
        this.examScores.add(testScore);
    }

    public Double getStudentAverageExamScore() {
        double totalSum = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            totalSum = totalSum + examScores.get(i);
        }
        return totalSum / examScores.size();
    }

    // ===================== SETTERS =================== //
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExamScore(int examNumber, double newScore){
        this.examScores.set(examNumber - 1, newScore);
    }

    @Override
    public String toString() {

        return String.format("Student Name: %s %s\n" + "    Average Score: %.2f\n" + "    Exam Scores: %s \n",
                firstName, lastName, getStudentAverageExamScore(), getExamScores());
//        return "Student Name: " + firstName + " " + lastName + '\n' +
//                "Average Score: " + getAverageExamScore() + '\n' +
//                "Exam Scores: " + getExamScores();
    }
}
