package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student[] students;

    public Classroom() {
        this.students = new Student[30];

    }

    public Classroom(int maxStudentAmount) {
        this.students = new Student[maxStudentAmount];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return this.students;
    }


    public boolean addStudents(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == (null)) {
                students[i] = student;
                return true;
            }

        }
        return false;
    }

    public String removeStudent(String firstName, String lastName) {
        for (int i = 0; i < students.length; i++) {
            if ((students[i].getFirstName().equals(firstName)) && (students[i].getLastName().equals(lastName))) {
                students[i] = null;
                this.sortNullToEnd();
                break;
            }
        }
        return "This student is not enrolled";
    }

    public void sortNullToEnd() {
        int counter = 0;

        Student[] tempArray = Arrays.copyOf(this.students, this.students.length);
        for (int i = 0; i < this.students.length; i++) {
            if (!(students[i] == null)) {
                tempArray[counter] = students[i];
                counter++;
            }
        }
        tempArray[students.length - 1] = null;
        this.students = tempArray;

    }

    public double getClassAverage() {
        int sum = 0;
        for (Student student : this.students) {
            sum += student.getAverageExamScores();
        }
        return sum / students.length;

    }


    public String getStudentsByScore() {
        StringBuilder nameAndAverage = new StringBuilder();

        //Cant use an array on collections, gotta use arraylist.
        ArrayList<Student> studentsAsArrayList = new ArrayList<>();
        for (int i = 0; i < this.students.length; i++) {
            if (!(this.students[i] == null)) {
                studentsAsArrayList.add(this.students[i]);
            }
        }

        Collections.sort(studentsAsArrayList);
        Collections.reverse(studentsAsArrayList);

        for (Student students : studentsAsArrayList) {
            nameAndAverage.append(students.getFirstName() + " " + students.getLastName() + " " +
                    ": " + students.getAverageExamScores() + "\n");
        }
        return nameAndAverage.toString();
    }

    public String getGradeBook() {
        StringBuilder gradeBook = new StringBuilder();
        ArrayList<Student> sg = new ArrayList<>();
        for (int i = 0; i < this.students.length; i++) {
            if (!(this.students[i] == null)) {
                sg.add(this.students[i]);


            }
        }
        Collections.sort(sg);
        Collections.reverse(sg);

        /*
        10 students
        10 = F
        9-7 = D
        6-4 = C
        3-2 = B
        1 = A
         */
        for (int i = 0; i < sg.size(); i++) {
            if ((sg.size() * .10) >= i + 1) {
                gradeBook.append(sg.get(i).getFirstName() + " " + sg.get(i).getLastName() + " " + sg.get(i).getAverageExamScores() + " : A\n");
            } else if ((sg.size() * .29) >= i + 1) {
                gradeBook.append(sg.get(i).getFirstName() + " " + sg.get(i).getLastName() + " " + sg.get(i).getAverageExamScores() + " : B\n");
            } else if ((sg.size() * .50) >= i + 1) {
                gradeBook.append(sg.get(i).getFirstName() + " " + sg.get(i).getLastName() + " " + sg.get(i).getAverageExamScores() + " : C\n");
            } else if ((sg.size() * .89) >= i + 1) {
                gradeBook.append(sg.get(i).getFirstName() + " " + sg.get(i).getLastName() + " " + sg.get(i).getAverageExamScores() + " : D\n");
            } else {
                gradeBook.append(sg.get(i).getFirstName() + " " + sg.get(i).getLastName() + " " + sg.get(i).getAverageExamScores() + " : F\n");
            }
        }
        return gradeBook.toString();
    }
}