package io.zipcoder;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;
    private Integer numberOfExamsTaken;

    /*public Student(String firstName){
        this.firstName = firstName;
    }*/

    public Student(String firstName, String lastName, ArrayList<Double> testScores) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = testScores;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public ArrayList<Double> getTestScores(){
        return this.examScores;
    }

    public String getExamScores() {
        StringBuilder builder = new StringBuilder();
        builder.append("Exam Scores:\n");
        for (int i=0;i<examScores.size();i++) {

            builder.append("Exam "+ (i+1)+" -> " + examScores.get(i) + "\n");

        }
        return builder.toString();
    }

    public void addExamScores(Double score){
        examScores.add(score);


    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }


    public void setExamScores(int examNumber,double newScore) {
        examScores.set(examNumber-1,newScore);

    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student Name: "+ this.getFirstName()+" "+this.getLastName()+ "\n"+
                        "> Average Score: "+ this.getAverageScoreForAStudent(this.examScores)+"\n"+
                "> Exam Scores:\n");
        for (int i=0;i<examScores.size();i++) {

            builder.append("Exam "+ (i+1)+" -> " + examScores.get(i) + "\n");

        }
        return builder.toString();

    }

    public Double getAverageScoreForAStudent(ArrayList<Double>testScores) {
        Double sum =0.0;
        for (Double scores:testScores) {
           sum+=scores;
        }

        return sum/testScores.size();

    }
}
