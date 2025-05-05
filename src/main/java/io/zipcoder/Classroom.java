package io.zipcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Classroom {
    private ArrayList<Student> students;

    public Classroom(int maxNumberOfStudents) {
        students = new ArrayList<>(maxNumberOfStudents);

    }

    public Classroom(ArrayList<Student> students) {
        this.students = students;
    }

    public Classroom() {
        this(30);
    }

    public String getStudents() {
        String studentList = "";
        for (Student students : students) {
            studentList += students.toFormattedString();

        }
        return studentList;
    }

    public Double getAverageExamsScores() {
        Double classTotalAvg = 0.0;
        for (int i = 0; i < students.size(); i++) {
            classTotalAvg += students.get(i).averageOfExams();
        }
        return classTotalAvg / students.size();

    }

    public void addAStudent(Student student) {
        students.add(student);
    }

    public void removeAStudent(String firstName, String lastName) {
        for (Student s1 : students) {
            if (s1.getFirstName().equals(firstName) && s1.getLastName().equals(lastName)) {
                students.remove(s1);
            }
        }

    }

    public List<Student> getStudentsByScore() {
        Comparator<Student> comparator = new Comparator<Student>() {

            @Override
            public int compare(Student student1, Student student2) {
                Double student1score = student1.averageOfExams();
                Double student2score = student2.averageOfExams();
                if (student1score < student2score) {
                    return 1;
                }
                if (student1score > student2score) {
                    return -1;
                }
                else{
                    String student1Last = student1.getLastName().toLowerCase();
                    String student2Last = student2.getLastName().toLowerCase();
                    int lastCompare = student1Last.compareTo(student2Last);
                    if (lastCompare < 0) {
                        return -1;
                    }
                    if (lastCompare > 0) {
                        return 1;
                    }
                    String student1First = student1.getFirstName().toLowerCase();
                    String student2First = student2.getFirstName().toLowerCase();
                    return student1First.compareTo(student2First);
                }
            }
        };
        List<Student> list = new ArrayList <Student> (this.students);

        Collections.sort(list, comparator);
        //Collections.reverse(list);
        return list;
    }
    public TreeMap<Character, ArrayList<Student>> getGradeBook(){
        TreeMap <Character, ArrayList<Student>> gradeBook = new TreeMap<>();

        List <Student> students = this.getStudentsByScore();
        int numOfStudents = students.size();
        for (int i = 1; i <= numOfStudents; i++){
            Double percent = ((i-1)/(double)numOfStudents);
            Character gradeLetter;

            if (percent <= .1) gradeLetter = 'A';
            else if (percent > .1 && percent <= .29) gradeLetter = 'B';
            else if (percent > .29 && percent <= .50) gradeLetter = 'C';
            else if (percent > .50 && percent <= .89) gradeLetter = 'D';
            else gradeLetter = 'F';

            if (!gradeBook.containsKey(gradeLetter)){
                gradeBook.put(gradeLetter, new ArrayList<Student>());
            }
            ArrayList<Student> currentStudents = gradeBook.get(gradeLetter);
            Student student = students.get(i-1);
            currentStudents.add(student);
            gradeBook.put(gradeLetter, currentStudents);
        }



        return gradeBook;
    }
}






























