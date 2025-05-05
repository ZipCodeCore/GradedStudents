package io.zipcoder;

import java.util.*;
import java.lang.StringBuilder;

public class Classroom {

    //Instance Variable
    private Student[] students;

    //Three Constructors
    public Classroom() {
        this(30);
    }

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public String getStudents() {
        return Arrays.toString(students);
    }

    public Double getAverageClassExamScore() {
        double sumOfAverages = 0;
        double studentCount = 0;


        for (int i = 0; i < this.students.length; i++) {
            if (students[i] != null) {
                sumOfAverages += students[i].getAverageExamScore();
                studentCount++;
            }
        }
        return sumOfAverages/studentCount;
    }

    public boolean addStudent(String firstName, String lastName, Double[] testScores) {
        for (int i = 0; i < this.students.length; i++) {
            if (students[i] == null) {
                students[i] = new Student(firstName, lastName, testScores);
                return true;

            }
        } return false;
    }

    public boolean removeStudent(String firstName, String lastName)
    {
        for (int i = 0; i < this.students.length; i++)
        {
            if (students[i].getFirstName().contains(firstName) && students[i].getLastName().contains(lastName))
            {
                students[i] = null;
                return true;
            }
        } return false;


    }

    public String listStudentByScore()
    {
        ArrayList<Student> noEmptySpaces = new ArrayList<>();

        for (int i = 0; i < this.students.length; i++)
        {
            if (this.students[i] != null)
            {
                noEmptySpaces.add(this.students[i]);
            }
        }

        Collections.sort(noEmptySpaces, Student.averageGradeComparison.thenComparing(Student::getLastName));
        return noEmptySpaces.toString();
    }

    public ArrayList<Student> getOrderedStudentAsList()
    {
        ArrayList<Student> noEmptySpaces = new ArrayList<>();

        for (int i = 0; i< this.students.length; i++)
        {
            if (this.students[i] != null)
            {
                noEmptySpaces.add(this.students[i]);
            }
        }

        Collections.sort(noEmptySpaces, Student.averageGradeComparison.thenComparing(Student::getLastName));
        return noEmptySpaces;

    }

    public String gradeClass()
    {
        ArrayList<Student> OrderOfListOfStudents = this.getOrderedStudentAsList();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < OrderOfListOfStudents.size(); i++)
        {
            if((int) Math.ceil(OrderOfListOfStudents.size() * .1) >= i + 1)
            {
                sb.append(OrderOfListOfStudents.get(i).getFirstName() + " " + getOrderedStudentAsList().get(i).getLastName() + ": A\n");
            }
            else if((int) Math.ceil(OrderOfListOfStudents.size() * .29) >= i + 1)
            {
                sb.append(OrderOfListOfStudents.get(i).getFirstName() + " " + getOrderedStudentAsList().get(i).getLastName() + ": B\n");
            }
            else if ((int) Math.ceil(OrderOfListOfStudents.size() * .50) >= i + 1)
            {
                sb.append(OrderOfListOfStudents.get(i).getFirstName()  + " " + getOrderedStudentAsList().get(i).getLastName() + ": C\n");
            }
            else if ((int) Math.ceil(OrderOfListOfStudents.size() * .89) >= i + 1)
            {
                sb.append(OrderOfListOfStudents.get(i).getFirstName() + " " + getOrderedStudentAsList().get(i).getLastName() + ": D\n");
            }
            else if ((int) Math.ceil(OrderOfListOfStudents.size() * .89) <= i + 1)
            {
                sb.append(OrderOfListOfStudents.get(i).getFirstName() + " " + getOrderedStudentAsList().get(i).getLastName() + ": F\n");
            }
        } return sb.toString();

    }







}

