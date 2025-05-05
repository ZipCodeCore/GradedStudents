package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Student implements Comparable<Student>{

    String firstName;
    String lastName;
    List<Double> examScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        examScores = new ArrayList<Double>(Arrays.asList(testScores));
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

    public String getExamScores() {
        Integer count = 1;
        StringBuilder builder = new StringBuilder();
        builder.append("> Exam Scores:\n");
        Iterator<Double> iterator = examScores.iterator();
        while (iterator.hasNext()) {
            builder.append("\tExam ").append(count).append(" -> ").append(iterator.next()).append("\n");
            count++;
        }
        return builder.toString();
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        Iterator iterator = examScores.iterator();
        while (iterator.hasNext()) {
            sum += (Double)iterator.next();
        }
        return sum / examScores.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
            builder.append("Student Name: ").append(firstName).append(" ").append(lastName).append("\n")
                    .append("> Average Score: ").append(getAverageExamScore()).append("\n")
                    .append(getExamScores());
            return builder.toString();
    }

    @Override
    public int compareTo(Student student) {
        if (Double.compare(getAverageExamScore(), student.getAverageExamScore()) != 0) {
            return Double.compare(student.getAverageExamScore(), getAverageExamScore());
        }
        else {
            return this.lastName.compareTo(student.getLastName());
        }
    }
}
