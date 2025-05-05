package io.zipcoder;

import java.util.*;

public class Classroom {
    public Student [] students;

    public Classroom (){
        this(30);
    }
    public Classroom (int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];

}
    public Classroom (Student[] students){
        this.students = students;
}
    public Student [] getStudents() {
        return this.students;
    }
//define a getter which returns the sum of all exams divided by the number of students

    public double getAverageExamScoreOfAllStudents() {
       double count = 0.0;
        double sumOfExamScores = 0.0;
        for(int i = 0; i < students.length; i++) {
            if (!(students[i] == null)) {
                sumOfExamScores += students[i].getAverageExamScore();
                count++;
            }
        }
        double average = Math.round(sumOfExamScores/count);
        return average;
    }
 //define a method which uses student perameter to add a student object to student list
    public void addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
    }
    public boolean removeStudent(String firstName, String lastName){
        for (int i = 0; i< students.length;i++){
            if ((students[i].getFirstName().equals(firstName)) && students[i].getLastName().equals(lastName)){
                students[i] = null;
                return true;
            }
        }
        return  false;
    }

    public int numberOfStudentsInClass () {
        int count = 0;
        for (int n = 0; n < students.length; n++) {
            if (students[n] != null) {
                count++;
            }
        }
        return count;
    }
    public String [] getStudentsByScore() {
        ArrayList<Student> temp = new ArrayList<>();
        String [] studentSortedArray = new String[students.length];

        for (int i = 0; i <numberOfStudentsInClass();i++){
            for(int k = 0; k < numberOfStudentsInClass(); k++) {
             if(students[i].getAverageExamScore() < students[k].getAverageExamScore()){
                 temp.add(students[i]);
                }

            else if(students[i].getAverageExamScore() == students[k].getAverageExamScore()) {
                int result = students[i].getFirstName().compareTo(students[k].getFirstName());
                if (result < 0) {
                    temp.add(students[i]);
                    temp.add(students[k]);
                }
                else if (result > 0){
                    temp.add(students[k]);
                    temp.add(students[i]);
                }
                else if(result == 0){
                    temp.add(students[i]);
                }

                }

            }

        }
        System.out.println(temp);
        for(int n = 0; n <numberOfStudentsInClass(); n++){
            studentSortedArray[n] = String.valueOf(temp.toArray()) + " ";
        }

        return studentSortedArray;

    }
//
//    public Character getLetterGrade(){
//        ArrayList<Double> intArrayOfAverageScores = new ArrayList<>(numberOfStudentsInClass());
//        //find the student with the highest average score in the class
//        for(int i = 0; i < numberOfStudentsInClass(); i++){
//           intArrayOfAverageScores.add(students[i].getAverageExamScore());
//        }
//        Collections.sort(intArrayOfAverageScores);
//        Double highestAverageScore = intArrayOfAverageScores.get(0);
//        //get the difference in percentage
//        Double percentageDifference = 100.0 - highestAverageScore;
//        //add the percentage difference to each student
//        for(int n = 0; n < numberOfStudentsInClass(); n++){
//           if(students[n].setCurvedAverageExamScore(students[n].getAverageExamScore() + percentageDifference) > 90.0);
//        }
//        for (int k = 0; k < numberOfStudentsInClass(); k++){
//           if (students[k].setCurvedAverageExamScore() > 90.0){
//
//            }
//        }

//}
    //grading curve
    public TreeMap<Student, Character> getGradeBook() {
//        TreeMap<Student, Character> gradeBook = new TreeMap<>();
//        for(int i = 0; i < numberOfStudentsInClass(); i++){
//            gradeBook.put(students[i].getFirstName() + " "+students[i].getLastName(), students[i].get);
//        }
return null;


    }


}
