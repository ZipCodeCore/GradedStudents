package io.zipcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Classroom {
    int maxStudents;

    Student[] students;
    //ArrayList<Student> students = new ArrayList<>();



    public Classroom(int maxNumOfStudents){

        this.students = new Student[maxNumOfStudents];
    }

    public Classroom (Student... students){

        this.students = students;
    }

    public Classroom(){

        this.students = new Student[30];
    }


    /*public Student[] getStudents(){
        return this.students;

    }*/


    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> studentList = new ArrayList<Student>(Arrays.asList(students));

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student == null) {
                continue;

            } else if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                studentList.remove(student);
                studentList.add(null);
            }
        }
        this.students = studentList.toArray(new Student[0]);
    }


    public Student[] getStudents() {
        //Arrays.sort(students);
        return students;

    }


    //


    public double getAverageExamScore(Student[] student) {
        double sum = 0;
        for(Student estu : student) {
            sum += estu.getAverageExamScore();
        }
        //Double studentAverage = sum / student.length;
        //return studentAverage;
           return sum / students.length;
    }

    public void addStudent (Student student){

        for (int i = 0; i < students.length; i++){
            if (students[i] == null){
                students[i] = student;
                break;
            }
        }
}



    public Student[] getStudentByScore() {

        ArrayList<Student> studentList = new ArrayList<Student>(Arrays.asList(students));

        Comparator<Student> byExamScores = Comparator.comparing(Student::getAverageExamScore);
        Comparator<Student> byFullName = Comparator.comparing(Student::getFirstName);

        Collections.sort(studentList, byExamScores.reversed().thenComparing(byFullName));

        Student[] studentSortByScore = studentList.toArray(new Student[0]);

        return studentSortByScore;


}

/*public char getDeviationScore (Student student){
        Double averageClassExamScore = this.getAverageExamScore();
        Double averageStudentExamScore = student.getAverageExamScore();
        Double predevition = Math.pow((averageStudentExamScore - averageClassExamScore, 2);
        Double standardDeviation = Math.sqrt(preDeviation/(actualStudentCount() -1));

        if(averageStudentExamScore >= (averageClassExamScore + (standardDeviation * 2))){
            return 'A';
        }else if (averageStudentExamScore >= (averageClassExamScore + standardDeviation)){
        return 'B';
        }else if (averageStudentExamScore < (averageClassExamScore + standardDeviation) &&
                averageStudentExamScore > averageClassExamScore){
            return 'C';
        }else if  (averageStudentExamScore <= (averageClassExamScore + standardDeviation)) {
            return 'D';
        }else {
            return 'F';
        }
}

 public Map<Student, Character> getGradeBook(){
   Student[] studentlist = this.getStudents();
   Map<Student, Character> gradeMap = new HasMap<>();
   int length = actualStudentCount();
     for (int i = 0; i < length; i++) {
         gradeMap.put(Studentlist[i], getDeviationScore(studentlist[i]));
     }
    return gradeMap;
}


    }*/
//////////////////////////////////////////////////////////


    /*public void addStudent(Student student) {
        students.add(student);
    }*/
}






