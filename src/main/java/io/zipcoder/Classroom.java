package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

public class Classroom {

    private Student[] students;


    public Classroom(int maxNumberOfStudents){
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students){
        this.students = students;
    }

    public Classroom(){
        students = new Student[30];
    }


    public Student[] getStudents(){
        return students;
    }

    public double getAverageExamScore(){
        double totalScore=0;
        double averageScore;

        for(int i = 0; i < students.length; i++){
            totalScore += Double.parseDouble(students[i].getAverageExamScore());
        }

        averageScore = totalScore/students.length;
        return averageScore;
    }

    public void addStudent(Student student){
        ArrayList<Student> studentList;
        if (this.students[0]==null){
            studentList=new ArrayList<>();
            studentList.add(student);
        }
        else {
            studentList = new ArrayList<>(Arrays.asList(this.students));
            studentList.add(student);
        }

        this.students = studentList.toArray(this.students);
    }

    public void removeStudent(String firstName, String lastName){
        ArrayList<Student> studentList;
        studentList = new ArrayList<>(Arrays.asList(this.students));

        for(Student student:  this.students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                studentList.remove(student);
            }
        }

        this.students=studentList.toArray(this.students);
    }

    public Student[] getStudentsByScore(){
        TreeMap<Double, Student> studentsByAverageScore = new TreeMap<Double, Student>(Collections.reverseOrder());
        ArrayList<Student> studentListByAverage;
        studentListByAverage = new ArrayList<>();
            for(Student student: this.students){
                studentsByAverageScore.put(Double.parseDouble(student.getAverageExamScore()), student);
            }
        for(Map.Entry<Double,Student> entry : studentsByAverageScore.entrySet()) {
            Student value = entry.getValue();

            studentListByAverage.add(value);
        }
        this.students=studentListByAverage.toArray(this.students);

            return this.students;
    }

    public HashMap<Student, String> getGradeBook() {
        HashMap<Student, String> gradeBook = new HashMap<>();
        Student[] sortedByAverage= getStudentsByScore();

        int a = (int)Math.round(.1 * sortedByAverage.length)-1;
        int b = (int)Math.round(.3 * sortedByAverage.length)-1;
        int c = (int)Math.round(.5 * sortedByAverage.length)-1;
        int d = (int)Math.round(.9 * sortedByAverage.length)-1;

        for (int i = 0; i < sortedByAverage.length; i++) {
            if(i<=a){
                gradeBook.put(sortedByAverage[i], "A");

            } else if(i<=b){
                gradeBook.put(sortedByAverage[i], "B");

            } else if(i<=c){
                gradeBook.put(sortedByAverage[i],"C");

            } else if(i<=d){
                gradeBook.put(sortedByAverage[i],"D");

            } else{
                gradeBook.put(sortedByAverage[i],"F");

            }
        }


               return gradeBook;
    }


}











