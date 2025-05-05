package io.zipcoder;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentSorter implements Comparator<Student> {
    List<Student> studentList; //

    public StudentSorter(Student[] students) {
        this.studentList = Arrays.asList(students);//
    }

    public Student[] sort(Comparator<Student> comparator) {
        Collections.sort(studentList, comparator);//
        return (Student[]) studentList.toArray();//
    }

    public int compare(Student o1, Student o2) {
        return 0;
    }

    public boolean equals(Student obj) {
        return false;
    }
}
