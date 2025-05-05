package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    protected String firstName;
    protected String lastName;
    private ArrayList<Double> examScores;
    Double[] testScores;


    public Student(String firstName, String lasName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lasName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
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

    public ArrayList<Double> getExamScores() {

        return examScores;
    }

    // public void setExamScores(ArrayList<Double> examScores) {

    // this.examScores = examScores;
    // }


    public Integer getNumberOfExamsTaken() {

        return this.testScores.length;

    }

    public String GetExamScores() {
        StringBuilder stringOfScores = new StringBuilder();
        for (int i = 0; i < testScores.length; i++) {
            stringOfScores.append(testScores[i] + " | ");
            stringOfScores = stringOfScores.append(i);
        }
        return Arrays.toString(testScores);
    }

    //}
    // return Arrays.toString(examScores);
    // }

    public void addExamScores(double testScore) {

        this.examScores.add(testScore);
    }

    public void setExamScores(int examNumber, double newScore) {

        this.examScores.set(examNumber, newScore);
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for (int i = 0; i < testScores.length; i++) {
            sum += testScores[i];
        }
        return sum / testScores.length;
    }

    @Override
    public String toString() {
        return "NAME: " + firstName + " " + lastName + '\n' +
                "Average Score: " + getAverageExamScore() + '\n' +
                "Exam Scores: " + getExamScores();



       /*" NAME: " + firstName + lastName + "/n",
                " Avrg Exam Score : " + getAverageExamScore() + "/n",
                "Exam Score : " + getExamScores();*/


    }
}



