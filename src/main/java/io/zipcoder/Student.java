package io.zipcoder;
import java.util.Arrays;
import java.util.ArrayList;

public  class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public Student() {
        this.firstName = "First";
        this.lastName = "Last";
        this.examScores = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Double> getExamScores() {
        return examScores;
    }

    //public Double getExamScoresAsString() {
    //    Student student = new Student();;
    //    return getScoresAsString(input);
   // }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return this.getExamScores().size();
    }

    public void addExamScore(double examScore) {
        this.examScores.add(examScore);
    }

    public void setExamScores(int examNumber, double newScore) {
        examScores.remove(examNumber - 1);
        examScores.add(examNumber - 1, newScore);
    }

    public double getAverageExamScore() {
        Double sum = 0.0;
        for (int i = 0; i < examScores.size(); i++) {
            sum += examScores.get(i);
        }
        return sum / getNumberOfExamsTaken();

    }

    public String toString() {
        String output = "Student Name: " + firstName + " " + lastName + "\n> Average Score: " + getAverageExamScore() + "\n> Exam Scores:\n";
        return getScoresAsString(output);
    }

    private String getScoresAsString(String output) {
        for (int i = 0; i < examScores.size(); i++) {
            output += "\tExam " + (i + 1) + " -> " + Math.round(examScores.get(i)) + "\n";
        }

        return output;
    }
}




