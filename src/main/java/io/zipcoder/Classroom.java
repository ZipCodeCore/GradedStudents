package io.zipcoder;

import org.junit.Test;

import java.util.*;

public class Classroom extends Student {

    private Student[] students;
    ArrayList<Student> studentList;
    private ArrayList<Double> studentScores = new ArrayList<>();
    private Integer maxNumberOfStudents;
    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        students=new Student[maxNumberOfStudents];
        studentList=new ArrayList<>();

    }
    public Classroom(Student[] students ){
        this.students = students;

    }
    public Classroom(){
        studentList=new ArrayList<>();
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Double getAverageExamScore(){
        Double average=0.0;
        Double total=0.0;
        for (int i = 0; i < students.length; i++) {
        total+=students[i].getAverageExamScore();
            average=total/ students.length;
        }
        return average;
    }

    public void addStudent(Student student) {
        //students = new Student[maxNumberOfStudents];
        for(int i = 0; i < students.length; i++){
            if(students[i] == null){
                students[i] = student;
            }
        }
    }
    //0,1,2,3,4

    public void removeStudent(String firstName, String lastName) {
        List<Student> removeStudentArrayList = new ArrayList<>();
        if(this.students!=null){
            removeStudentArrayList=new ArrayList<>(Arrays.asList(this.students));
        }
        for (int i = 0; i < removeStudentArrayList.size(); i++) {
            if(removeStudentArrayList.get(i).getFirstName().equals(firstName))
            {
                removeStudentArrayList.remove(i);
            }


        }
        this.students = removeStudentArrayList.toArray(new Student[0]);
    }

//       Boolean check=false;
//        for(int i=0;i<students.length;i++){
//        if((students[i].getFirstName() + students[i].getLastName().equals(firstName+lastName)){
//                students[i]=students[i+1];
//            check=true;
//        }
//        if(check==true && i< students.length-1) {
//            students[i]=students[i+1];
//        }
//        if(i== students.length-1)
//        {
//            students[i]=null;
//        }
//
//        }
//        }
    public Student getStudentsByScore(){
    Arrays.sort(students);
    return null;
    }

//map<key,value>,grade string
    public Map<Student,String> getGradeBook(){
    Map<Student,String> gradeBook = new HashMap<>();
    String grade="";
    for(Student student:students){
        if(student.getAverageExamScore() >=90)
            grade="A";
        else if(student.getAverageExamScore()>=80)
            grade="B";
        else if(student.getAverageExamScore()>=70)
            grade="C";
        else if(student.getAverageExamScore()>=60)
            grade="D";
        else
            grade="F";
        gradeBook.put(student,grade);
        }
    return gradeBook;
    }
}
