package io.zipcoder;

import java.text.Collator;
import java.util.*;

public class Classroom {

    private Student[] students;


    Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];

    }

    Classroom(Student[] students) {
        this.students = students;
    }

    Classroom() {
        this(30);
    }



    public String[] getStudents() {
        String[] studentNameList = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            if(students[i] == null)
                break;

            studentNameList[i] = students[i].getFullName();
        }
        return studentNameList;
    }




    public int getMaximumNumberOfStudents() {
        return students.length;
    }




    public double getAverageExamScore() {
        double sum = 0;
        double averageScore = 0;

        if (!(students.length == 0)) {
            for (Student student : students) {
                sum += student.getAverageExamScore();
            }
            averageScore = sum / students.length;
        }

        return averageScore;
    }





    public boolean isStudentEnrolled(String fullNameToCheck) {
        boolean answer = false;

        for (Student student: students) {
            if (student.getFullName().equals(fullNameToCheck)) {
                answer = true;
                break;
            }
        }
        return answer;
    }




    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
        }

    }



    public Student[] removeStudent(String firstName, String lastName) {
        String nameToRemove = firstName + " " + lastName;
        Student[] result = new Student[students.length];

        int index = 0;
            for (int i = 0; i < students.length; i++) {
                if (!students[i].getFullName().equals(nameToRemove)) {
                    result[index] = students[i];
                    index++;
                }
            }
        return result;

    }



    public Student[] getStudentsByScore() {
        List<Student> studentsByScore = Arrays.asList(students);

        Collections.sort(studentsByScore, (s1, s2) -> {

                    if (s1.getAverageExamScore() > s2.getAverageExamScore()) {
                        return -1;
                    } else if (s1.getAverageExamScore() < s2.getAverageExamScore()) {
                        return 1;
                    } else {
                        return s1.getFullName().compareTo(s2.getFullName());
                    }
                });

        Student[] result = new Student[studentsByScore.size()];
        result = studentsByScore.toArray(result);

        return result;
    }





    public int percentile(Student[] sortedStudents, double percentile) {
        int index = (int) Math.ceil((percentile / (double) 100) * (double) sortedStudents.length);

        return index;
    }



    public HashMap<String, List<Student>> getGradeBook() {
       Student[] studentScores = this.getStudentsByScore();

       int gradeA = this.percentile(studentScores, 10);
       int gradeB = this.percentile(studentScores, 29);
       int gradeC = this.percentile(studentScores, 50);
       int gradeD = this.percentile(studentScores, 89);
       int gradeF = this.percentile(studentScores, 100);

       HashMap<String, List<Student>> gradeBook = new HashMap<>();

       List<Student> aStudents = Arrays.asList(Arrays.copyOfRange(studentScores, 0, gradeA));
       gradeBook.put("A", aStudents);

        List<Student> bStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeA, gradeB));
        gradeBook.put("B", bStudents);

        List<Student> cStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeB, gradeC));
        gradeBook.put("C", cStudents);

        List<Student> dStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeC, gradeD));
        gradeBook.put("D", dStudents);

        List<Student> fStudents = Arrays.asList(Arrays.copyOfRange(studentScores, gradeD, gradeF));
        gradeBook.put("F", fStudents);

        return gradeBook;
    }
}
