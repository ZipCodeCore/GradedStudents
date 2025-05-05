package io.zipcoder;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;

import java.util.*;

public class Classroom {
    // Declaring variables
    public int maxNumOfStudents;
    Student[] students = new Student[30];
    ArrayList<Student> studentsList = new ArrayList();

    public Classroom(int maxNumOfStudents){
        this.maxNumOfStudents = maxNumOfStudents;
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(){
    }

    public ArrayList<Student> getStudents(){
        return studentsList;
    }

    public Double getAverageExamScore() {
        Double totalExams = 0.0;
        for (int i = 0; i < students.length; i++) {
            totalExams += students[i].getAverageExamScore();
        }
        return totalExams / students.length;
    }

    public void addStudent(Student student1) {
        studentsList.add(student1);
    }

    public void removeStudent(Student firstName, Student lastName) {
        for (int i = 0; i < studentsList.size(); i++) {
            if(studentsList.get(i).firstName.equals(firstName) && studentsList.get(i).lastName.equals(lastName)){
                studentsList.remove(i);
            }
            students[students.length-1] = null;
            break;
        }
    }

    public Student[] getStudentsByScore() {
        Arrays.sort(students, Collections.reverseOrder());
        return students;
    }

    public Map getGradeBook() {
    Map<String, String> gradeBook = new TreeMap<>();
        for (int i = 0; i < students.length; i++) {
            if(students[i].getAverageExamScore() >= 90){
                gradeBook.put(students[i].firstName, "A");
            }
            else if(students[i].getAverageExamScore() >= 80) {
                gradeBook.put(students[i].firstName, "B");
            }
            else if(students[i].getAverageExamScore() >= 70) {
                gradeBook.put(students[i].firstName, "C");
            }
            else if(students[i].getAverageExamScore() >= 60) {
                gradeBook.put(students[i].firstName, "D");
            }
            else {gradeBook.put(students[i].firstName, "F");
            }

        }
        for (Map.Entry j: gradeBook.entrySet()){
            System.out.println(j);
        }
        return gradeBook;
        }




















    }
