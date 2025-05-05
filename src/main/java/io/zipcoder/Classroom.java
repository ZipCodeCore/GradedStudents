package io.zipcoder;

import java.util.*;

public class Classroom {
    Student[] students;
    int MaxNumberOfStudents;


    public Classroom(int MaxNumberOfStudent){
        MaxNumberOfStudents = MaxNumberOfStudent;

    }
    public Classroom(Student[] allStudents){
        this.students = allStudents;

    }
    public Classroom(){
        this.students = new Student[30];

    }

    public Student[] getStudents() {

        return students;
    }

    public Double getAverageExamScore(){
        Double average = 0.0;
        for(int i = 0; i < students.length; i++){
            average += students[i].getAverageExamScore();
        }
        return average/students.length;
    }
    public void addStudent(Student student){
        students = new Student[MaxNumberOfStudents];
        for(int i = 0; i < students.length; i++){
            if(students[i] == null){
                students[i] = student;
                break;
            }
        }

    }

    public void removeStudent(String firstName, String lastName){
        for(int i = 0; i < students.length; i++){
            if((students[i].firstName + students[i].lastName).equals(firstName + lastName));
            Student temp = students[i];
            for(int j = i; j < students.length-1; j++){
                students[j] = students[j+1];
            }
            students[students.length-1] = null;
            break;
        }

    }

    public Student[] getStudentsByScore() {

        //order from largest to smallest.
        Arrays.sort(students, Collections.reverseOrder());
        return students;
    }

    public Map getGradeBook(){
        Map<String, String> book = new TreeMap<String, String>();
        for(int i = 0; i < students.length; i++){
            if(students[i].getAverageExamScore() >= 90){
                book.put(students[i].firstName, "A");
            }
            else if(students[i].getAverageExamScore() >= 80){
                book.put(students[i].firstName, "B");
            }
            else if(students[i].getAverageExamScore() >= 70){
                book.put(students[i].firstName, "C");
            }
            else if(students[i].getAverageExamScore() >= 60){
                book.put(students[i].firstName, "D");
            }
            else{
                book.put(students[i].firstName, "F");
            }

        }
        for(Map.Entry g: book.entrySet()){
            System.out.println(g);
        }
        return book;

    }

}
