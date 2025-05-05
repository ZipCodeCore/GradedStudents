package io.zipcoder;



import java.util.ArrayList;
import java.util.Comparator;


public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;
    private double percentile = 0.0;
    private String curveGrade = "";

    public Student(String firstName, String lastName, ArrayList<Double> testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = testScores;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getNumberOfExamsTaken() {
        return this.examScores.size();
    }

    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }

    public double getPercentile() {
        return this.percentile;
    }

    public void setCurveGrade(String curveGrade) {
        this.curveGrade = curveGrade;
    }

    public String getCurveGrade() {
        return this.curveGrade;
    }

    public String getExamScores() {
        StringBuilder allTestScores = new StringBuilder("Exam Scores:\n");
        int count = 1;
        for (double value : this.examScores) {
            allTestScores.append("\tExam " + count + " -> " + value + "\n");
            count++;

        }
        return allTestScores.toString();
    }

    public void addExamScore(double score) {
        this.examScores.add(score);
    }

    public void setExamScore(int testNumber, double scoreNumber) {
        this.examScores.set(testNumber, scoreNumber);
    }

    public double getAverageExamScore() {
        double scoreTotal = 0;
        for (double score : this.examScores) {
            scoreTotal += score;
        }
        return scoreTotal / this.examScores.size();
    }

    @Override
    public String toString() {
        StringBuilder toStringOutput = new StringBuilder("Student Name: ");
        toStringOutput.append(this.firstName + " " + this.lastName + "\n");
        toStringOutput.append("> Average Score: " + this.getAverageExamScore() + "\n");
        toStringOutput.append("> " + this.getExamScores());
        return toStringOutput.toString();
    }

    public static Comparator<Student> AverageTestScoreComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            int average1 = (int)o1.getAverageExamScore();
            int average2 = (int)o2.getAverageExamScore();

            return average2 - average1;
        }
    };

}
