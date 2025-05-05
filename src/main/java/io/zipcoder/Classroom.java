package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Classroom {
    ArrayList<Student> students = new ArrayList<>();

    //Constructors
    public Classroom(int maxNumberOfStudents){
        this.students = new ArrayList<>(maxNumberOfStudents);
    }

   public Classroom(Student[] classroom){
        this.students.addAll(Arrays.asList(classroom));
   }

    public Classroom(){
        this.students = new ArrayList<>(30);
    }

    //Get Methods
    public ArrayList<Student> getStudents(){ return this.students; }

    public String[] getStudentFirstNames(){
        String[] names = new String[students.size()];
        for(int i = 0; i < students.size(); i++){
            names[i] = students.get(i).getFirstName();
        }
        return names;
    }

    public Double getAverageExamScore(){
        Double sumScores = 0.0;
        Double sumExams = 0.0;
        for (int i = 0; i < students.size(); i++){
            Student kid = students.get(i);
            sumExams += kid.getNumberOfExamsTaken();
            sumScores += (kid.getAverageExamScore() * kid.getNumberOfExamsTaken());
        }
       return sumScores/sumExams;
    }

    public void addStudent(Student guy){
        students.add(guy);
    }

    public void removeStudent(String firstName, String lastName){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)){
               students.remove(i);
            }
        }
    }

    public Student[] getStudentsByScore(){
        Student[] rankings = students.toArray(new Student[students.size()]);
        Student placeholder;

        for(int w = 1; w < students.size(); w++){
            for(int i = 0; i < students.size() - w; i++){
                if(rankings[i].getAverageExamScore() > rankings[i+1].getAverageExamScore()){
                    placeholder = rankings[i+1];
                    rankings[i+1] = rankings[i];
                    rankings[i] = placeholder;
                }
            }
        }

        return rankings;
    }


}
