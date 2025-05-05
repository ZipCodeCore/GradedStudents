package io.zipcoder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        Student[] students = new Student[maxNumberOfStudents];
        this.students = students;

    }

    public Classroom(Student[] students) {
        this.students = students;

    }

    public Classroom() {
        Student[] students = new Student[30];
        this.students = students;

    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for (Student s : this.students) {
            sum += s.getAverageExamScore();
        }
        return Math.round(sum / this.students.length);
    }

    public void addStudent(Student newStudent) {
        if(this.containsANull()){
            for(int i = 0; i < this.students.length; i++){
                if(this.students[i] == null){
                    this.students[i] = newStudent;
                    break;
                }
            }
        }
        else{
            this.students = Arrays.copyOf(this.students, this.students.length + 1);
            this.students[students.length - 1] = newStudent;
        }
    }

    public void removeStudent(String firstName, String lastName) {
        Student studentToRemove = this.identifyStudent(firstName, lastName);
        int studentToRemoveIndex = this.identifyStudentIndex(studentToRemove);
        this.students[studentToRemoveIndex] = null;
        this.moveNullToEnd();
    }

    public Student[] getStudentsByScore() {
        Arrays.sort(this.students, byAverageScoreThenByName);

        return this.students;
    }

    public String getGradeBookString() {
        Arrays.sort(this.students, byAverageScoreThenByName);
        StringBuilder builder = new StringBuilder();
        for(Student s : this.students){
            builder.append(s.getFirstName() + " " + s.getLastName() + " : " + this.getLetterGrade(s) + "\n");
        }

        return builder.toString();
    }

    public HashMap<Student, Character> getGradeBookMap(){
        Arrays.sort(this.students, byAverageScoreThenByName);
        HashMap<Student, Character> gradeBook = new HashMap<>(this.students.length);
        for(Student s : this.students){
            gradeBook.put(s, this.getLetterGrade(s));
        }
        return gradeBook;
    }

    public boolean containsANull(){
        for(Student s : this.students){
            if(s == null){
                return true;
            }
        }
        return false;
    }

    public Student identifyStudent(String firstName, String lastName) {
        for (Student s : this.students) {
            if (firstName.equals(s.getFirstName()) && lastName.equals(s.getLastName())) {
                return s;
            }
        }
        return null;
    }

    public int identifyStudentIndex(Student student) {
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] == student) {
                return i;
            }
        }
        return -1;
    }

    public void moveNullToEnd() {
        Student[] temp = new Student[this.students.length];
        int counter = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                temp[counter] = this.students[i];
                counter++;
            }
        }
        temp[temp.length - 1] = null;
        this.students = temp;
    }

    public static double calculatePercentileThreshold(double [] values, double percentile){
        if(percentile * values.length == (int) (percentile*values.length) ){
            int index = (int) (percentile * values.length);
            return (values[values.length-index] + values[values.length-(index+1)])/2;
        }

        int index = (int) Math.ceil(percentile * values.length);
        return values[values.length-index];
    }

    public Character getLetterGrade(Student student){
        Arrays.sort(this.students, byAverageScoreThenByName);
        double[] allAverages = this.getAllAverages();
        if(student.getAverageExamScore()>= calculatePercentileThreshold(allAverages,.9)){
            return 'A';
        }
        else if(student.getAverageExamScore()>= calculatePercentileThreshold(allAverages,.71)){
            return 'B';
        }
        else if(student.getAverageExamScore()>= calculatePercentileThreshold(allAverages,.5)){
            return 'C';
        }
        else if(student.getAverageExamScore()>= calculatePercentileThreshold(allAverages,.11)){
            return 'D';
        }
        else{
            return 'F';
        }
    }

    public double[] getAllAverages(){
        double[] output = new double[this.students.length];
        for(int i = 0; i < this.students.length; i++){
            output[i] = this.students[i].getAverageExamScore();
        }
        return output;
    }

    public static Comparator<Student> byAverageScoreThenByName = new Comparator<Student>() {

        @Override
        public int compare(Student s1, Student s2){
            if (s1.getAverageExamScore() < s2.getAverageExamScore()) {
                return 1;
            }
            else if (s1.getAverageExamScore() > s2.getAverageExamScore()) {
                return -1;
            }
            else {
                if(s1.getLastName().equals(s2.getLastName())){
                    return sortByFirstName(s1,s2);
                }
                return sortByLastName(s1,s2);
            }
        }
    };

    public static int sortByFirstName (Student s1, Student s2){
        int longerFirstName = s1.getFirstName().length() >= s2.getFirstName().length() ?
                s1.getFirstName().length() : s2.getFirstName().length();
        for(int i = 0; i < longerFirstName; i++) {
            if (s1.getFirstName().charAt(i) > s2.getFirstName().charAt(i)) {
                return 1;
            } else if (s1.getFirstName().charAt(i) < s2.getFirstName().charAt(i)) {
                return -1;
            }
        }
        return 0;
    }

    public static int sortByLastName (Student s1, Student s2){
        int longerLastName = s1.getLastName().length() >= s2.getLastName().length() ?
                s1.getLastName().length() : s2.getLastName().length();
        for(int i = 0; i < longerLastName; i++) {
            if (s1.getLastName().charAt(i) > s2.getLastName().charAt(i)) {
                return 1;
            } else if (s1.getLastName().charAt(i) < s2.getLastName().charAt(i)) {
                return -1;
            }
        }
        return 0;
    }
}






