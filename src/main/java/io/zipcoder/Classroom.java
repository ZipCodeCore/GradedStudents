package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;

public class Classroom implements Comparator<Student> {

    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this(30);
    }

    public Student[] getStudents() {
        return students;
    }

    protected Double getAverageExamScore() {
        Double sum = 0.00;
        for (Student student : students) {
            sum += student.getAverageExamScore();
        }

        double averageExamScore = Math.round(sum / this.getStudents().length * 100) / 100;
        return averageExamScore;

    }

    protected void addStudent(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == null) {
                this.students[i] = student;
                break;
            }
        }
    }

    protected void removeStudent(String firstName, String lastName) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null && this.students[i].getFirstName().equals(firstName) && this.students[i].getLastName().equals(lastName)) {
                this.students[i] = null;
                this.sortArrayAfterRemovingStudent();
                break;
            }
        }
    }

    protected void sortArrayAfterRemovingStudent() {
        Student[] sortAfterStudentRemoval = Arrays.copyOf(this.students, this.students.length);
        int counter = 0;
        for (int i = 0; i < this.students.length; i++){
            if (this.students[i] != null){
                sortAfterStudentRemoval[counter] = this.students[i];
                counter++;
            }
        }
        sortAfterStudentRemoval[this.students.length -1] = null;
        this.students = sortAfterStudentRemoval;
    }

    protected Student[] getStudentsByScore(){
        return null;
    }

    @Override
    public int compare(Student a, Student b){
        if (a.getAverageExamScore() == b.getAverageExamScore()){
            return a.getFirstName().compareTo(b.getFirstName());
        }
        if (a.getAverageExamScore() < b.getAverageExamScore()){
            return 1;
        } else{
            return -1;
        }

    }


}
