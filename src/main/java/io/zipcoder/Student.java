package io.zipcoder;
import java.util.ArrayList;

public class Student {
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



}
