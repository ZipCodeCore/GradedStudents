package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Student{

    //Instance Variables
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;



    //Constructors
    public Student(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, Double [] testScores){
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = new ArrayList<Double>(Arrays.asList(testScores));

    }



    //Methods
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setExamScore(int examNumber, Double examScore)
    {
        this.testScores.add(examNumber, examScore);
    }



    public String getExamScores()
    {
        //Create a String builder and then for loop
        StringBuilder sbExamScores = new StringBuilder();
        sbExamScores.append("Exam Scores:\n");


        for(int i = 0; i < testScores.size(); i++)
        {
            sbExamScores.append("\t\tExam " + (i + 1) + " -> " + new Double(testScores.get(i)).intValue()+"\n");

        }

        return sbExamScores.toString();

    }

    public void addExamScore(double examScore)
    {
        this.testScores.add(examScore);
    }


     public double getAverageExamScore()
    {
        double sum = 0;

        for (int i = 0; i < testScores.size(); i++)
        {
            sum += testScores.get(i);
        }

        double average = sum/testScores.size();
        return average;

    }

    //Override Method
    @Override
    public String toString()
    {
        String formatOutput = "Student name: " + this.firstName + " " + this.lastName + "\n" +
            "> Average Score: " + new Double(this.getAverageExamScore()).intValue() + "\n" + this.getExamScores();

        return formatOutput;
    }

    public static Comparator<Student> averageGradeComparison = new Comparator<Student>() {
        public int compare(Student s1, Student s2) {



            int firstAverage = new Double(s1.getAverageExamScore()).intValue();
            int secondAverage = new Double(s2.getAverageExamScore()).intValue();

            return secondAverage - firstAverage;

        }
    };


}
