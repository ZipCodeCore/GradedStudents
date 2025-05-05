package io.zipcoder;

import java.util.*;
import java.util.function.ToLongFunction;

public class Classroom implements Comparator<Student> {
    private Student[] students;
    private Integer maxNumberOfStudents;

    //constructor 1: int representative of the maxNumberOfStudents that this Classroom can hold.
    public Classroom(Integer maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }
    //constructor 2 Student[] representative of the collection of Student objects this Classroom will store.
    public Classroom(Student[] students) {
        this.students = students;
    }
    //constructor 3: nullary. initializes the composite students object o
    //be an empty array of 30 Student objects
    public Classroom() {
        this.students = new Student[30];
    }
    //getter return the composit students object

    public String getStudents() {
        StringBuilder builder = new StringBuilder();
        for (Student s : students) {
            builder.append("===================\n");
            try {
                builder.append(s.toString());
            } catch (Exception e) {
                builder.append("No Students Currently Enrolled\n");
            }
            builder.append("===================\n\n");
        }
            return builder.toString();
        }
    //getter: returns sum of all exams divided by the number of students
    public Double getAverageExamScore() {
        double sum = 0.0;
        for (Student s : students) {
            if (s != null) {
                sum += s.getAverageExamScore();
            }
        }
        return sum / students.length;
    }
    //addStudent student uses Student parameter to add a Student object to students list
    public void addStudent(Student student) {
        List<Student> studentsList = new ArrayList<>(Arrays.asList(students));
        studentsList.add(student);
        studentsList.remove(null);
        students = studentsList.toArray(new Student[0]);
    }

    //removes student from students object. array is re-ordered after removed. null at end
    public void removeStudent(String firstName, String lastName) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(students));
        for (Student s : studentList) {
            if (s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                studentList.remove(s);
                break;
            }
        }
        studentList.sort(this);
        students = studentList.toArray(new Student[0]);
    }

    //can't mdify arrays.asList so wrapper ArrayList
    public ArrayList<Student> getStudentByScore() {
        ArrayList<Student> studentList = new ArrayList<>(Arrays.asList(students));
        studentList.sort(this);
        return studentList;
    }

    //getStudentByScore returns and array representation of Student object sorted in descending score order.
    //if two students same score, order them lexigraphically
    public String getGradeBook() {
        Map<String, ArrayList<Student>> gradeBook = new TreeMap<>();
        ArrayList<Student> sortedStudentList = getStudentByScore();
        Integer binSize = sortedStudentList.size() / 5;
        gradeBook.put("A", new ArrayList<>(sortedStudentList.subList(0, binSize)));
        gradeBook.put("B", new ArrayList<>(sortedStudentList.subList(binSize, binSize * 2)));
        gradeBook.put("C", new ArrayList<>(sortedStudentList.subList(binSize * 2, binSize * 3)));
        gradeBook.put("D", new ArrayList<>(sortedStudentList.subList(binSize * 3, binSize * 4)));
        gradeBook.put("F", new ArrayList<>(sortedStudentList.subList(binSize * 4, binSize * 5)));

        StringBuilder builder = new StringBuilder();
        for (Map.Entry entry : gradeBook.entrySet()) {
            builder.append("" + entry.getKey() + " Students: \n\n\n" + entry.getValue().toString() + "\n");
        }
        return builder.toString();
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }

    @Override
    public Comparator<Student> thenComparingLong(ToLongFunction<? super Student> keyExtractor) {
        return null;
    }
}



