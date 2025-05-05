package io.zipcoder;
import java.util.*;


public class Classroom{

    private Student[] students;


    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];

    }

    public Student[] getStudents() {
        return students;
    }


    public long getAverageExamScore() {
        int counter = 0;
        double scores = 0.0;
        for (Student student: students) {
            scores += student.accessTotalExamsScore();
            counter += student.getNumberOfExamsTaken();
        }
        return Math.round(scores / counter);
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (this.students[i] != (null)) {
                this.students[i] = this.students[i];
            } else if (students[i] == null) {
                this.students[i] = student;
                break;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        for (int p = 0; p < students.length - 1; p++) {
            String first = students[p].getFirstName();
            String last = students[p].getLastName();
            if (first.equals(firstName) && last.equals(lastName)) {
                students[p] = students[p + 1];
                students[p + 1] = null;
            }
            if (students[p] == null) {
                students[p] = this.students[p + 1];
                students[p + 1] = null;
            }
        }
        if(students[students.length-1].getLastName().equals(lastName) && students[students.length-1].getFirstName().equals(firstName)){
            students[students.length-1]= null;
        }
    }


    //student name, test score average, individual test scores, and final grade
    public LinkedHashMap<Student,String> getGradeBook(){
        LinkedHashMap<Student, String> gradeBook = new LinkedHashMap<>();
        Classroom classroom = new Classroom(students);
        classroom.getStudentsByScore();
        Student [] classMap = classroom.getStudentsByScore();
        int a = (int)Math.round(.1*classMap.length)-1;
        int b = (int)Math.round(.3*classMap.length)-1;
        int c = (int)Math.round(.5*classMap.length)-1;
        int d = (int)Math.round(.9*classMap.length)-1;

        for(int i = 0; i<classMap.length; i++) {
            if(i <= a) {
                gradeBook.put(classMap[i], "\nFinal grade: A");
            } else if (i <= b) {
                gradeBook.put(classMap[i], "\nFinal grade: B");
            } else if (i <= c) {
                gradeBook.put(classMap[i], "\nFinal grade: C");
            } else if (i <= d) {
                gradeBook.put(classMap[i], "\nFinal grade: D");
            }  else {
                gradeBook.put(classMap[i], "\nFinal grade: F");
            }
        }
        return gradeBook;
    }

    //just student name and final grade
    public LinkedHashMap<String,String> getGradeBookNameAndFinalGrade(){
        LinkedHashMap<String, String> gradeBookNameAndGrade = new LinkedHashMap<>();
        Classroom classroom = new Classroom(students);
        classroom.getStudentsByScore();
        Student [] classMap = classroom.getStudentsByScore();
        int a = (int)Math.round(.1*classMap.length)-1;
        int b = (int)Math.round(.3*classMap.length)-1;
        int c = (int)Math.round(.5*classMap.length)-1;
        int d = (int)Math.round(.9*classMap.length)-1;

        for(int i = 0; i<classMap.length; i++) {
            String firstAndLast = classMap[i].getFirstName() + " " + classMap[i].getLastName();
            if(i <= a) {
                gradeBookNameAndGrade.put(firstAndLast, " A\n");
            } else if (i <= b) {
                gradeBookNameAndGrade.put(firstAndLast, " B\n");
            } else if (i <= c) {
                gradeBookNameAndGrade.put(firstAndLast, " C\n");
            } else if (i <= d) {
                gradeBookNameAndGrade.put(firstAndLast, " D\n");
            }  else {
                gradeBookNameAndGrade.put(firstAndLast, " F\n");
            }
        }
        return gradeBookNameAndGrade;
    }


    public Student[] getStudentsByScore() {
        ArrayList<Student> student1and2 = new ArrayList<>(Arrays.asList(students));
        Collections.sort(student1and2, Comparator.comparing(Student::getAverageExamScore).reversed().thenComparing(Student::getLastName));
        return student1and2.toArray(new Student[]{});
    }

}
