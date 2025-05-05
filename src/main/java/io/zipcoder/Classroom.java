package io.zipcoder;


import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Classroom {
    Student[] students;
    int maxNumberOfStudents;

    public Classroom(int maxNumberOfStudent){
        maxNumberOfStudents = maxNumberOfStudent;
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
        Double examSum = 0.0;
        for(int i = 0; i < students.length; i++){
            examSum += students[i].getAverageExamScore();
        }
        return examSum/students.length;
    }
    public void addStudent(Student student){
        students = new Student[maxNumberOfStudents];
        for (int i = 0; i < this.students.length; i++){
            if(this.students[i] == null){
                students[i] = student;
                break;
            }
        }
    }
    public void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if ((students[i].firstName + students[i].lastName).equals(firstName + lastName)) {
                System.arraycopy(students, i + 1, students, i, students.length - 1 - i);
            }
            students[students.length - 1] = null;
            break;
        }
    }
        public Student[] getStudentsByScore () {
            Student[] scoreArr = new Student[students.length];
            for (int i=0 ; i <students.length-1; i ++) {
                for (int j = i + 1; j < students.length; j++) {
                    if (students[i].getAverageExamScore().compareTo(students[j].getAverageExamScore()) < 0) {
                        Student temp = students[i];
                        students[i] = students[j];
                        students[j] = temp;
                    }
                }
            }
            return scoreArr;
    }

    public Map getGradeBook() {
        Map<String, String> gradeBook = new TreeMap<String, String>();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getAverageExamScore() >= 90) {
                gradeBook.put(students[i].getFirstName(), "A");
            } else if (students[i].getAverageExamScore() >= 80) {
                gradeBook.put(students[i].getFirstName(), "B");
            } else if (students[i].getAverageExamScore() >= 70) {
                gradeBook.put(students[i].getFirstName(), "C");
            } else if (students[i].getAverageExamScore() >= 60) {
                gradeBook.put(students[i].getFirstName(), "D");
            } else {
                gradeBook.put(students[i].getFirstName(), "F");
            }

        }
        for (Map.Entry g : gradeBook.entrySet()) {
            System.out.println(g);
        }
        return gradeBook;
    }
}
