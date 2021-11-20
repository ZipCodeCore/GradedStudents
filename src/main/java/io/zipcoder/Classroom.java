package io.zipcoder;

import java.util.*;

public class Classroom extends Student {

    private Student[] students;
    private List<Student> studentList;
    private ArrayList<Double> studentsScore = new ArrayList<>();
    private Integer maxNoOfStudents;

    public Classroom(int maxNoOfStudents){
        this.maxNoOfStudents = maxNoOfStudents;
        students = new Student[maxNoOfStudents];
        studentList = new ArrayList<>();
    }

    public Classroom(Student[] students){
        this.students = students;
    }

    public Classroom(){
        studentList = new ArrayList<>();
        this.students = new Student[30];
    }


    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Double getAverageScore(){
        Double average = 0.00;
        Double total = 0.00;
        for (int i = 0; i < students.length; i++) {
            total += students[i].getAverageScore();
            
        }
        return total / students.length;
    }

    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if(students[i]== null){
                students[i] = student;
            }
        }

    }

    public void removeStudent(String firstName , String lastName) {
        List<Student> students = new ArrayList<>();
        if(this.students !=null) {
            students = new ArrayList<>(Arrays.asList(this.students));
        }
        for(Student student : students) {
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                students.remove(student);
                break;
            }
        }
        this.students = students.toArray(new Student[]{});
    }


    public Student[] getStudentByScore() {
        Student[] students = this.students.clone();
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students.length - i - 1; j++) {
                if (students[j].getAverageScore() < students[j + 1].getAverageScore()) {
                    Student student = students[i];
                    students[j] = students[j + 1];
                    students[j + 1] = student;
                } else if (students[j].getAverageScore() == students[j + 1].getAverageScore()) {
                    if (students[j].getFirstName().compareTo(students[j + 1].getFirstName()) > 0) {
                        Student student = students[i];
                        students[j] = students[j + 1];
                        students[j + 1] = student;
                    }
                }
            }
        }
        return students;
    }

    public Map<Student,String> getGradeBook(){
        Map<Student, String> gradeBook=new HashMap<>();
        String grade="";
        for(Student student:students){
            double averageExamScore=student.getAverageScore();
            if(averageExamScore>=90)
                grade="A";
            else if(averageExamScore>=80)
                grade="B";
            else if(averageExamScore>=70)
                grade="C";
            else if(averageExamScore>=60)
                grade="D";
            else
                grade="E";
            gradeBook.put(student,grade);
        }
        return gradeBook;
    }


}
