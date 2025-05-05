package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Classroom {

    protected Student[] studentsArray;
    protected HashMap<Student, String> hashMap;

    public Classroom(int maxNumberOfStudents) {
        this.studentsArray = new Student[maxNumberOfStudents];
        this.hashMap = new HashMap<Student, String>();
    }

    public Classroom(Student[] collectionOfStudents) {
        this.studentsArray = collectionOfStudents;
        this.hashMap = new HashMap<Student, String>();

    }

    public Classroom() {
        this.studentsArray = new Student[30];
        this.hashMap = new HashMap<Student, String>();

    }

    public Student[] getStudents() {
        return this.studentsArray;
    }

    public double getClassroomAverageExamScore() {
        double sumOfStudentAverageExamScores = 0.0;
        for (Student student : this.studentsArray) {
            sumOfStudentAverageExamScores += student.getStudentAverageExamScore();
        }
        double averageClassroomExamScore = sumOfStudentAverageExamScores / this.studentsArray.length;
        double roundedClassroomAverageExamScore = (double) Math.round(averageClassroomExamScore * 10) / 10;
        return roundedClassroomAverageExamScore;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < this.studentsArray.length; i++) {
            if (this.studentsArray[i] == null) {
                this.studentsArray[i] = student;
                break;
            } else if (i == this.studentsArray.length - 1) {
                this.studentsArray = Arrays.copyOf(this.studentsArray, this.studentsArray.length + 1);
                this.studentsArray[this.studentsArray.length - 1] = student;
                break; // I had to add this break, otherwise the loop would never end
                // (because increasing the array's length in the else block
                // would also affect the condition inside the for loop, causing an infinite loop)
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {

        int l = this.studentsArray.length;
        int removeAndReplaceIndex = 0;

        for (int i = 0; i < l; i++)  {
            if (this.studentsArray[i].getFirstName() == firstName
                    && this.studentsArray[i].getLastName() == lastName) {
                removeAndReplaceIndex = i;
                break;
            }
        }

        for (int i = removeAndReplaceIndex; i < l; i++)  {
            if (i < l - 1) {
                this.studentsArray[i] = this.studentsArray[i + 1];
            } else if (i == l - 1) {
                this.studentsArray[i] = null;
            }
        }
    }

    /**
     * I understand that "ByScore" actually means "ByAverageScore" of each student
     */
    public Student[] getStudentsbyAverageScore() {

        Arrays.sort(this.studentsArray, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getStudentAverageExamScore() == o2.getStudentAverageExamScore()) {
                    return o1.getFirstName().compareTo(o2.getFirstName()); // natural order
                } else if (o1.getStudentAverageExamScore() > o2.getStudentAverageExamScore()) {
                    return -1; // to get int from double values; descending average (o2... - o1...)
                } else return 1;
            }
        });

        return this.studentsArray;
    }

    public HashMap<Student, String> getGradeBook() {
    /**
     * The class Classroom should define a method getGradeBook() which returns a mapping
     * of Student objects to a respective letter grade determined by creating a grading curve such that
     * An A is awarded to students whose class average is in the upper 10th percentile.
     * A B is awarded to students whose class average falls between the 25th and 29th percentile.
     * A C is awarded to students whose class average falls between the 30th and 50th percentile.
     * A D is awarded to students whose class average falls between the 51st and 89th percentile.
     * An F is awarded to students whose class average is in the lower 10th percentile.
     */

        for (Student student : this.studentsArray) {
            this.hashMap.put(student, student.getLetterGrade());
        }

        return this.hashMap;
    }


}
