package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student[] students;
    private int maxNumberOfStudents;


    public Classroom(){
        this.students = new Student[30];
        this.maxNumberOfStudents = 30;
        this.initializeStudentArray();
    }

    public Classroom(int maxNumberOfStudents){
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new Student[maxNumberOfStudents];
        this.initializeStudentArray();
    }

    public Classroom(Student[] students){
        this.students = students;
    }

    private void initializeStudentArray() {
        for(int i = 0; i < students.length; i++){

        }
    }

    public Student[] getStudents() {
        List<Student> studentList = new ArrayList<Student>(Arrays.asList(students));
        while(studentList.remove(null)){}
        return studentList.toArray(new Student[0]);
    }

    public double getAverageExamScore(){
        double sum = 0.00;
        Student[] students = this.getStudents();
        for(Student element: students){
            sum += element.getAverageExamScore();
        }
        return sum / actualStudentCount();
    }

    public int actualStudentCount(){
        Integer studentCount = 0;
        Student[] students = this.getStudents();
        Integer length = students.length;
        for(int i = 0; i < length; i++){
            if(students[i] != null)
                studentCount++;
        }
        return studentCount;
    }

    public void addStudent(Student student){
        List<Student> studentArrayList;
        if(this.getStudents().length > 0){
            studentArrayList = new ArrayList<Student>(Arrays.asList(this.getStudents()));
        } else {
            studentArrayList = new ArrayList<Student>();
        }

        studentArrayList.add(student);
        this.students = studentArrayList.toArray(new Student[0]);
    }

    public void removeStudent(String firstName, String lastName){
        boolean adjust = false;
        Student[] studentArray = this.getStudents();
        for(int i = 0; i < studentArray.length; i++){
            if(studentArray[i].getFirstName() == firstName){
                if(studentArray[i].getLastName() == lastName){
                    studentArray[i] = null;
                    adjust = true;
                }
            }
        }
        if(adjust)
            this.adjustForNull();
    }

    public void adjustForNull(){
        Student[] studentArray = this.getStudents();
        Student[] adjustedStudentArray = new Student[this.maxNumberOfStudents];
        int lastIndex = 0;
        for(int i = 0; i < studentArray.length; i++){
            if(studentArray[i] != null){
                adjustedStudentArray[lastIndex] = studentArray[i];
                lastIndex++;
            }
        }
        this.students = adjustedStudentArray;
    }

    public Student[] getStudentsByScore(){
        List<Student> students = new ArrayList<>(Arrays.asList(this.getStudents()));
        Comparator<Student> byScore = Comparator.comparing(Student::getAverageExamScore);
        Comparator<Student> byFirstName = Comparator.comparing(Student::getLastName);
        Comparator<Student> byLastName = Comparator.comparing(Student::getFirstName);

        Collections.sort(students, byScore.thenComparing(byLastName).thenComparing(byFirstName));
        Collections.reverse(students);
        return students.toArray(new Student[0]);
    }

    public char getDeviationScore(Student student){
        Double averageClassExamScore = this.getAverageExamScore();
        Double averageStudentExamScore = student.getAverageExamScore();
        Double preDeviation = Math.pow(averageStudentExamScore - averageClassExamScore, 2);
        Double standardDeviation =  Math.sqrt(preDeviation/(actualStudentCount() - 1));

        if(averageStudentExamScore >= (averageClassExamScore + (standardDeviation * 2))){
            return 'A';
        } else if(averageStudentExamScore >= (averageClassExamScore + standardDeviation)){
            return 'B';
        } else if(averageStudentExamScore < (averageClassExamScore + standardDeviation) &&
                  averageStudentExamScore > averageClassExamScore){
            return 'C';
        } else if(averageStudentExamScore <= (averageClassExamScore + standardDeviation)){
            return 'D';
        } else {
            return 'F';
        }
    }

    public Map<Student, Character> getGradeBook(){
        Student[] studentlist = this.getStudents();
        Map<Student, Character> gradeMap = new HashMap<>();
        int length = actualStudentCount();
        for(int i = 0; i < length; i++){
            gradeMap.put(studentlist[i], getDeviationScore(studentlist[i]));
        }
        return gradeMap;
    }

}
