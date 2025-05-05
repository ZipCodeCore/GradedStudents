package io.zipcoder;

import java.util.ArrayList;

public class Student implements Comparable<Student>{
    String firstName;
    String lastName;
    ArrayList<Double> examScores;

    public Student(String firstName, String lastName, ArrayList<Double>  examScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = examScores;

    }

    public String getExamScores(){
        String output = "Exam Scores:\n";
        int count = 1;
        for(int i = 0; i <= examScores.size()-1; i++){
            output +=" \tExam " + count + " -> " + examScores.get(i) + "\n";
            count++;

        }
        return output;
    }

    public void addExamScore(Double score){
        examScores.add(score);
    }

    public void setExamScores(int examNumber, double newScore){
        examScores.set(examNumber, newScore);
    }

    public Double getAverageExamScore(){
        Double average = 0.0;
        for(int i = 0; i < examScores.size(); i++){
            average += examScores.get(i);
        }
        return average/examScores.size();

    }

    @Override
    public String toString(){
        return "Student Name: " + getFirstName() + " " + getLastName() + "\n" + "> Average Score: " + getAverageExamScore() + "\n" + "> " + getExamScores();
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

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }


    @Override
    public int compareTo(Student compStu) {
        if(getAverageExamScore() > compStu.getAverageExamScore()) {
            return 1;
        }
        else if(getAverageExamScore() < compStu.getAverageExamScore()){
            return -1;
        }
        else{
            return (this.firstName + this.lastName).compareTo(compStu.firstName + compStu.lastName);
        }

    }
}
