package io.zipcoder;

import java.util.*;

public class Classroom {

    ArrayList<Student> students = new ArrayList<>();

    public Classroom(int maxNumberOfStudents) {
        ArrayList<Student> students = new ArrayList<>(maxNumberOfStudents);
    }

    public Classroom(ArrayList<Student> students) {
        this.students = students;
    }

    public Classroom() {
        this(30);
    }

    public String[] getStudents() {
        String[] studentsArrayToString = new String[students.size()];
        int studentsArrayIndex = 0;
        for (Student student : students) {
            studentsArrayToString[studentsArrayIndex] = student.toString();
            studentsArrayIndex++;
        }

        return studentsArrayToString;

    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Student aStudent : students) {
            builder.append("============================\n");
            builder.append("[]\n");
            builder.append("============================\n");
            builder.append("Student Name: ");
            builder.append(aStudent.getFirstName() + " ");
            builder.append(aStudent.getLastName() + "\n");
            builder.append("> Average Score: ");
            builder.append(aStudent.getAverageScoreForAStudent(aStudent.getTestScores()) + "\n");
        }
        return builder.toString();
    }

    public Double getAverageExamScore() {

        Double classAverageTotal = 0.0;

        for (int i = 0; i < students.size(); i++) {
            classAverageTotal += students.get(i).getAverageScoreForAStudent(students.get(i).getTestScores());
        }
        Double averageExamScore = classAverageTotal / students.size();

        return averageExamScore;

    }

    public void removeStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                students.remove(student);
            }
        }
    }

    public String getGradeBook() {

        Collections.sort(this.students, myComparator);
        StringBuilder builder = new StringBuilder();
        builder.append("Grade Book\n");
        builder.append("First Name              Last Name               Grade\n");

        for (int i = 0; i < students.size(); i++) {
            if (100 * (i + 1) / students.size() <= 10) {
                builder.append(students.get(i).getFirstName()+"             "+students.get(i).getLastName()+"               "+"A\n");
            } else if (10 < 100 * (i + 1) / students.size() && 100 * (i + 1) / students.size() <= 29) {
                builder.append(students.get(i).getFirstName()+"             "+students.get(i).getLastName()+"               "+"B\n");
            } else if (29 < 100 * (i + 1) / students.size() && 100 * (i + 1) / students.size() <= 50) {
                builder.append(students.get(i).getFirstName()+"             "+students.get(i).getLastName()+"               "+"C\n");
            } else if (50 <100 * (i + 1) / students.size() && 100 * (i + 1) / students.size() <= 89) {
                builder.append(students.get(i).getFirstName()+"             "+students.get(i).getLastName()+"               "+"D\n");
            } else builder.append(students.get(i).getFirstName()+"              "+students.get(i).getLastName()+"               "+"F\n");
        }
        return builder.toString();

    }


    public String[] getStudentByScore() {

        Collections.sort(this.students, myComparator);
        String[] sortedArrayList = this.getStudents();
        return sortedArrayList;
    }

    static final Comparator<Student> myComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            if ((s1.getAverageScoreForAStudent(s1.getTestScores()) > s2.getAverageScoreForAStudent(s2.getTestScores()))) {
                return s2.getAverageScoreForAStudent(s2.getTestScores()).compareTo
                        (s1.getAverageScoreForAStudent(s1.getTestScores()));
            } else if ((s1.getAverageScoreForAStudent(s1.getTestScores())) ==
                    (s2.getAverageScoreForAStudent(s2.getTestScores()))) {
                if (s1.getFirstName().equals(s2.getFirstName())) {
                    return s1.getLastName().compareTo(s2.getLastName());
                } else {
                    return s1.getFirstName().compareTo(s2.getFirstName());
                }
            }

            return s2.getAverageScoreForAStudent(s2.getTestScores()).compareTo
                    (s1.getAverageScoreForAStudent(s1.getTestScores()));
        }

    };



}
