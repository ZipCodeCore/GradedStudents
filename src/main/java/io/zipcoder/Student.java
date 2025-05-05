package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable <Student> {

    String firstName;  // collection of characters representative of a first name
    String lastName;   // collection of characters representative of a last name
    ArrayList<Double> examScores;   // dynamic collection of decimal values representative of test scores
    String letterGrade;

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public Student(String letterGrade, String firstName, String lastName, Double[] examScores) {
        this.letterGrade = letterGrade;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
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

    public Integer getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public String getExamScores() {
        int index = 1;
        String result = "Exam Scores:\n";
        for (Double score: examScores) {
            result += "Exam " + index + " -> " +score + "\n";
            index++;
        }
        result += "Letter Grade: " + letterGrade;
        return result;
    }

    public void addExamScore(Double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScore(int examNumber, Double newScore) {
        this.examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore() {
        Double summation = 0.0;
        for (int i = 0; i < this.examScores.size(); i++) {
            summation += this.examScores.get(i);
        }
        return summation / this.examScores.size();
    }

    public String toString() {  // This is some dumb shit - sat here for hours because i forgot to include 'this.letterGrade + " " + '
        return this.letterGrade + " " + this.firstName + " " + this.lastName + ", " + this.examScores;
    }

    @Override
    public int compareTo(Student smallStudent) {
        if (this.getAverageExamScore() == smallStudent.getAverageExamScore()) {
            return this.getFirstName().compareToIgnoreCase(smallStudent.getFirstName());
            // This compares the scores, haven't been able to
        }                                                                                 // compare lexicographically
       // return (int) (this.getAverageExamScore() - smallStudent.getAverageExamScore());
        return (int) (smallStudent.getAverageExamScore() - this.getAverageExamScore());
    }
}
