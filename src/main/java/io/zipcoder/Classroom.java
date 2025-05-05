package io.zipcoder;

import java.lang.reflect.Array;
import java.util.*;

public class Classroom {

    private Student[] student;

    public Classroom(Integer maxNumberOfStudents) {
        this.student = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] newStudentArray) {
        this.student = new Student[newStudentArray.length];
        for (int i = 0; i < newStudentArray.length; i++) {
            student[i] = newStudentArray[i];
        }
    }

    public Classroom() {
        this.student = new Student[30];
    }

    public Student[] getStudents() {
        return student;
    }

    public Double getAverageExamScore() {
        Double result = 0.0;
        for (Student element : student) {
            result += element.getAverageExamScore();
        }
        return result / student.length;
    }

    public void addStudent(Student student) {
        ArrayList<Student> addStudentArray = new ArrayList<>(Arrays.asList(this.student)); // might be the issue - it creates a list from
        addStudentArray.add(student);                                                 // the parameter 'Student student' instead of the class
        this.student = addStudentArray.toArray(new Student[0]);   // same concept as removing a student
    }

    public void removeStudent (String firstName, String lastName) {
        ArrayList<Student> removeStudentArray = new ArrayList<>(Arrays.asList(student));
        for (Student element : removeStudentArray) {
           String actualFirstName = element.getFirstName();
           String actualLastName = element.getLastName();
           if (actualFirstName == firstName && actualLastName == lastName) {
               removeStudentArray.remove(element);
           }
        }
        this.student = removeStudentArray.toArray(new Student[0]);
    }

    public Student[] getStudentsByScore() {
     //   ArrayList<Student> sortStudentArray = new ArrayList<>(Arrays.asList(student));
     //   for (Student element : sortStudentArray) {
      //      element.getFirstName();
     //       sortStudentArray.sort(Comparator.comparingDouble(student -> element.getAverageExamScore()).thenComparing(student -> element.getFirstName()));
     //   }
         //    Arrays.sort(student);
        List<Student> students = Arrays.asList(this.getStudents());
        Comparator<Student> byScore = Comparator.comparing(Student::getAverageExamScore);
        Comparator<Student> byFirstName = Comparator.comparing(Student::getFirstName);

        Collections.sort(students, byScore.thenComparing(byFirstName));
        return students.toArray(new Student[0]);
        }

    public Student[] getGradeBook() {
       Arrays.sort(student);
       ArrayList<Student> addingTheGrade = new ArrayList<>(Arrays.asList(student));

        Double result = 0.0;
        Double standardDevi;
        for (Student eachStudent : addingTheGrade) {
            result += Math.pow(eachStudent.getAverageExamScore() - getAverageExamScore(), 2);
            standardDevi = Math.sqrt(result/(student.length - 1));
            if (eachStudent.getAverageExamScore() >= (getAverageExamScore() + (standardDevi * 2))) {
                eachStudent.setLetterGrade("A");
            } else if (eachStudent.getAverageExamScore() >= (getAverageExamScore() + (standardDevi))) {
                eachStudent.setLetterGrade("B");
            } else if (eachStudent.getAverageExamScore() >= getAverageExamScore()) {
                eachStudent.setLetterGrade("C");
            } else if (eachStudent.getAverageExamScore() >= (getAverageExamScore() - (standardDevi))) {
                eachStudent.setLetterGrade("D");
            } else {
                eachStudent.setLetterGrade("F");
            }
        }
        System.out.println(addingTheGrade);
        return addingTheGrade.toArray(new Student[0]);
    }
}

