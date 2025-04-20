package io.zipcoder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private  List<Double> examScores = new ArrayList<>();
    private Integer examsTaken;

    public Student(String firstName,String lastName,Double[] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        for (int i = 0; i < testScores.length ; i++) {
            examScores.add(testScores[i]);

        }

    }

    public Student(){

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
        StringBuilder score = new StringBuilder();
        for (int i = 0; i < examScores.size(); i++) {
            score.append("Exam"+ (i+1) +" -> " + examScores.get(i) );
            score.append("\n");


        }

        return score.toString();
    }

    public String setExamScores(int examNumber, Double newScore) {
        examScores.set(examNumber,newScore);
        return getExamScores().toString();

    }

    public String addExamScore(double examScore){
        examScores.add(examScore);
        return getExamScores().toString();
    }

    public Integer getExamsTaken() {
        return examsTaken;
    }

   public Double getAverageScore(){
        Double total = 0.00;
       for (int i = 0; i < examScores.size(); i++) {
           total += examScores.get(i);
       }
       return total / examScores.size();
   }

@Override
    public String toString(){
        NumberFormat nf = new DecimalFormat();
        String getExamScores = getExamScores().replace(".0","");
        String result =  "Student Name: "+firstName+" "+lastName+"\n"+"> "+"Average Score: "+
                Math.round(getAverageScore())+"\n" + getExamScores;
        return result;
}

}
