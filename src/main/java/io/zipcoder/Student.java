package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;

    public Student(String firstName, String lastName, Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = new ArrayList<Double>(Arrays.asList(testScores));
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

    public String  getExamScores() {
       String result = "";
        for (int i = 0; i < testScores.size(); i++){
            result += "Exam " + (i + 1) + " score: " + testScores.get(i) + "\n";
        }
        return result;
      /*  LinkedHashMap<String,Double> map = new LinkedHashMap<>();
        for (int i = 0; i < testScores.size(); i++) {
            map.put("Exam " + (i + 1) + " score",testScores.get(i));
            map.toString();
        }
   return map;*/
    }

    public void addExamScore(Double examScore){
        testScores.add(examScore);
    }

    public Integer getNumberOfExamsTaken(Integer numberOfExams){
        return testScores.size();
    }
    public void setExamScore(Integer examNumber, Double updatedScore) {
     testScores.set(examNumber - 1, updatedScore);
    }
    public Double getAverageTestScores(){
        Double sum = 0.0;
        for (int i = 0; i < testScores.size(); i++) {
             sum += testScores.get(i);
        }
        return sum / testScores.size();
    }
    public String toString(){
        String newString = "";
                  String result = newString +=  "Student Name: " + firstName + " " + lastName + "\n" +
                    "> Average Score: " + this.getAverageTestScores() + "\n" +
                    "> Exam Scores: " + this.getExamScores() + "\n";
        return result;
    }
}
