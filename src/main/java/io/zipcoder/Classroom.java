package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student[] students;


    //Constructors
    public Classroom(int maxStudents) {
        students = new Student[maxStudents];
    }
    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom() {
        this(30);
    }

    //Methods
    public Student[] getStudents(){
        return students;
    }

    public double getClassAverageExamScore(){
       double classTotalScore = 0;
       double numberOfStudents = students.length;
       for (int i = 0; i < students.length; i++){
          classTotalScore += students[i].getAverageExamScore();
       }
       return (classTotalScore/numberOfStudents);

    }

    public String addStudent(Student student){
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return student.toString();
            }
        }
        return "Classroom is full";
    }

    public boolean removeStudent(String firstName, String lastName){
        for (int i = 0; i < students.length; i++){
            Student student = students[i];
            if (student != null && student.getFirstName().contains(firstName) &&
                    student.getLastName().contains(lastName)) {
                students[i] = null;
                this.moveNullSortArray();
                return true;
            }
        }
        return false;
    }

    public void moveNullSortArray() {
        Student[] copyArray = Arrays.copyOf(students, students.length);

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) copyArray[i] = students[i];
        }
        copyArray[students.length - 1] = null;
        students = copyArray;
    }

    public Student[] getStudentsByScore(double matchingScore) {
        List<Student> studentScore = new ArrayList<>();

        for (Student student : getStudents()) {
            if (student.getExamScores().contains(String.valueOf(matchingScore))) {
                studentScore.add(student);
            }
        }
        studentScore = sortFoundStudents(studentScore);
        return studentScore.toArray(new Student[0]);
    }

    public List<Student> sortFoundStudents(List<Student> studentScore) {
        Collections.sort(studentScore, new StudentComparator());
        return studentScore;
    }

    class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student student1, Student student2) {
            int returnValue = -1;

            if (student1.getAverageExamScore() > student2.getAverageExamScore()) {
                returnValue = 1;
            } else if (student1.getAverageExamScore() == student2.getAverageExamScore()) {
                returnValue = compareLexigraphically(student1, student2);

            }
            return returnValue;
        }

        private int compareLexigraphically(Student student1, Student student2) {
            String student1Name = student1.getFirstName() + student1.getLastName();
            String student2Name = student2.getFirstName() + student2.getLastName();

            return student1Name.compareTo(student2Name);
        }
    }

    public TreeMap<Character, ArrayList<Student>> getGradeBook() {

        TreeMap<Character, ArrayList<Student>> gradeBook = new TreeMap<>();
        int numOfStudents = students.length;
        for (int i = 1; i <= numOfStudents; i++) {
            Double percent = ((i - 1) / (double) numOfStudents);
            Character gradeLetter;
            if (percent <= .1) gradeLetter = 'A';
            else if (percent > .1 && percent <= .29) gradeLetter = 'B';
            else if (percent > .29 && percent <= .50) gradeLetter = 'C';
            else if (percent > .50 && percent <= .89) gradeLetter = 'D';
            else gradeLetter = 'F';

            if (!gradeBook.containsKey(gradeLetter)) {
                gradeBook.put(gradeLetter, new ArrayList<Student>());
            }
            ArrayList<Student> currentStudents = gradeBook.get(gradeLetter);

            Student student = students[i - 1];
            currentStudents.add(student);
            gradeBook.put(gradeLetter, currentStudents);
        }
        return gradeBook;

    }

}



    // removeStudent(String firstName, String lastName) uses their name to remove them

    // getStudentsByScore() - returns an array of students by descending score. (If two have the same score, order them lexigraphically)

    //getGradeBook() - shows students by percentile ranking (A, B, C, D, F)



