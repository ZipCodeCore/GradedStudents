package io.zipcoder;

import java.util.*;

public class Classroom {
    //declare the instance variables

    Student[] students;
    int maxNumberOfStudents;
    ArrayList<Student> studentList;

    //1st constructor
    public Classroom(int max) {
        this.maxNumberOfStudents = max;
        students=new Student[max];
        studentList=new ArrayList<>();
    }


    //2nd constructor
    //here student is the object in Student[]
    public Classroom(Student[] students) {
        this.students = students;
    }


    //3rd constructor
    public Classroom() {
        studentList=new ArrayList<>();
        students=new Student[30];


    }

    //define a method getStudent()
    public Student[] getStudents() {
        return students;
    }

    //get average exam score
    public Double getAverageExamScore() {


        double total = 0;
        for (Student s : students) {
            if (s != null)
                total = total + s.averageExamScore();
        }

        Double average = total / students.length;
        return average;
    }

    //define method add student

    public void addStudent(Student student) {

        for (int i = 0; i < students.length; i++) {
            if(students[i]==null){
                students[i]=student;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "students=" + Arrays.toString(students) +
                ", maxNumberOfStudents=" + maxNumberOfStudents +
                '}';
    }



    public void removeStudent(String firstName ,String lastName) {
        List<Student> studentsList = new ArrayList<>();
        if(this.students !=null) {
            studentsList = new ArrayList<>(Arrays.asList(this.students));
        }
        for(Student student : studentsList) {
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                studentsList.remove(student);
                break;
            }
        }
        this.students = studentsList.toArray(new Student[]{});

    }
    public Student getStudentsByScore(Student[] students){
        Arrays.sort(students, Collections.reverseOrder());


        return null;
    }
    public Map<Student, String> getGradebook() {
        Map<Student, String> gradebook = new HashMap<>();
        String grade = "";
        for (Student student : students) {
            if (student.averageExamScore() >= 90)
                grade = "A";
            else if (student.averageExamScore() >= 80)
                grade = "B";
            else if (student.averageExamScore() >= 70)
                grade = "C";
            else if (student.averageExamScore() >= 60)
                grade = "D";
            else
                grade = "F";
            gradebook.put(student, grade);
        }
        return gradebook;
    }





}



