package io.zipcoder;

import java.text.DecimalFormat;
import java.util.*;

public class Classroom {

    Student[] students;
    int maxNumberOfStudents;


    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Classroom(Student... students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() { return students; }

    public double getAverageExamScores(Student[] students) {
        double total = 0.0;
        for (Student s : students) {
            total += s.getAverageTestScore();

        }
        return total / students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }

    public int actualStudentCount() { //counts how many actual students there are in a classroom size of 30
        int totalStudents = 0;
        for(int i = 0; i < students.length; i++) {
            if(students[i] != null) {
                totalStudents++;
            }
        }
        return totalStudents;
    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> newStudentList = new ArrayList<Student> (Arrays.asList(students));

        for (int i = 0; i < newStudentList.size(); i++) {
            Student student = newStudentList.get(i);
            if(student == null) {
                continue;
            } else if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                newStudentList.remove(student);
                newStudentList.add(null);
            }
        }
        this.students = newStudentList.toArray(new Student[0]);
    }

    public Student[] getStudentsByScore() {
        List<Student> studentList = new ArrayList<Student> (Arrays.asList(students));

        Comparator<Student> byExamScores = Comparator.comparing(Student::getAverageTestScore);
        Comparator<Student> byFullName = Comparator.comparing(Student::getFullName);

        Collections.sort(studentList, byExamScores.reversed().thenComparing(byFullName));

        Student[] studentsSortedByScore = studentList.toArray(new Student[0]);

        return studentsSortedByScore;
    }

    public Map<Student, Character> getGradeBook() {
        Student[] studentList = this.getStudents();
        Map<Student, Character> gradeBookResult = new HashMap<>();
        int length = actualStudentCount();
        for(int i = 0; i < length; i++) {
            gradeBookResult.put(studentList[i], getDeviation(studentList[i]));
        }
        return gradeBookResult;
    }

    public char getDeviation(Student student) {
        //need average score of each person in class
        Double averageClassExamScore = this.getAverageExamScores(students);
        Double averageStudentExamScore = student.getAverageTestScore();
        Double preDeviation = 0.0;
        for(Student testScoreAverage : students) {
            preDeviation += Math.pow(averageStudentExamScore - averageClassExamScore, 2);
        }
        Double standardDeviation = Math.sqrt((preDeviation / actualStudentCount() - 1));
//        Double preDeviation = Math.pow(averageStudentExamScore - averageClassExamScore, 2);
//        Double standardDeviation = Math.sqrt(preDeviation/(actualStudentCount() -1));

        if(averageStudentExamScore >= (averageClassExamScore + (standardDeviation * 2))){
            return 'A';
        } else if(averageStudentExamScore >= (averageClassExamScore + standardDeviation)){
            return 'B';
        } else if(averageStudentExamScore >= averageClassExamScore){
            return 'C';
        } else if(averageStudentExamScore >= (averageClassExamScore - standardDeviation)){
            return 'D';
        } else {
            return 'F';
        }
    }
}
