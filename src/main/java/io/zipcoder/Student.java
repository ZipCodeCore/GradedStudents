package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList(Arrays.asList(testScores));
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

    public Integer getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public String getExamScores() {
        StringBuilder output = new StringBuilder();
        output.append("Exam Scores:\n");
        for (int i = 0; i < examScores.size(); i++) {
            output.append(String.format("\tExam %s -> %3.2f\n", i+1, examScores.get(i)));
        }
//        System.out.print(output.toString());
        return output.toString();
    }

    public void addExamScore(Double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(Integer index, Double score) {
        this.examScores.set(index, score);
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        if (examScores.size() > 0) {
            for (Double score : examScores) {
                sum += score;
            }
        }
        Integer divisor = (!(getNumberOfExamsTaken() > 0) ? 1 : getNumberOfExamsTaken());
        return sum / divisor;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Student Name: %s %s\n", firstName, lastName));
        output.append(String.format("> Average Exam Score: %3.2f\n",getAverageExamScore()));
        output.append("> "+getExamScores());
        System.out.println(output.toString());
        return output.toString();
    }

    public void purgeData() {
        this.setFirstName("");
        this.setLastName("");
        this.examScores = new ArrayList<>(0);
    }

    public Boolean checkIfValid() {
        return (getFirstName().length() > 0
                && getLastName().length() > 0);
    }
}
