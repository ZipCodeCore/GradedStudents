package io.zipcoder;

import java.util.*;

public class Classroom {

        private Student[] students;
        private int maxNumOfStudents;


        public Classroom() {
                this.students = new Student[30];
        }

        public Classroom(int maxNumOfStudents) {
                this.students = new Student[maxNumOfStudents];

        }

        public Classroom(Student... students) {
                this.students = students;
        }

        public Student[] getStudents() {
                return students;
        } //do I need to clone?

        public double getAverageExamScore() {
                double total = 0;
                for (Student s : students) {
                        total += s.getAverageExamScore();
                }

                double average = total / correctForNull();

                return average;
        }

        public void addStudent(Student student) {
                for (int i = 0; i < students.length; i++) {
                        if (students[i] == null) {
                                students[i] = student;
                                break;
                        }

                }

        }

//                ArrayList <Student> newEnrollment = new ArrayList<>(Arrays.asList(students));
//                        newEnrollment.add(student);
//             this.students = newEnrollment.toArray(new Student[0]);

        public void removeStudentbyName(String firstName, String lastName) {
                ArrayList<Student> studentArray = new ArrayList<>(Arrays.asList(students));
                for (int i = 0; i < studentArray.size(); i++) {
                        Student student = studentArray.get(i);
                        if (student == null) {
                                continue;
                        } else if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                                studentArray.remove(student);
                                studentArray.add(null);
                        }
                }
                this.students = studentArray.toArray(new Student[0]);

        }
//                ArrayList<Student> studentArray = new ArrayList<>(Arrays.asList(students));
//                for (int i = 0; i < studentArray.size() ; i++) {
//                        Student student = studentArray.get(i);
//                        if (student.getLastName().equalsIgnoreCase(lastName) && student.getFirstName().equalsIgnoreCase(firstName)) {
//                                studentArray.set(student);
//                        }
//                } studentArray.add(null);

        public Student[] getStudentByScore() {
                List<Student> studentbyScore = new ArrayList<>(Arrays.asList(students));

                Comparator<Student> byExamScores = Comparator.comparing(Student::getAverageExamScore);
                Comparator<Student> byFullName = Comparator.comparing(Student::getFullName);

                studentbyScore.sort(byExamScores.reversed().thenComparing(byFullName));

                return studentbyScore.toArray(new Student[0]);
        }

        public Map <Student, Character> getGradeBookMap() {
                Student[] studentArray = students;
                Map<Student, Character> gradeBookAssigned = new HashMap<>();
                for (int i = 0; i < correctForNull(); i++) {
                        gradeBookAssigned.put(studentArray[i], assignGrade(studentArray[i]));
                }

                return gradeBookAssigned;
        }

        public void getGradeBook(){
                for (int i = 0; i < correctForNull(); i++) {
                        char grade = assignGrade(students[i]);
                        String name = students[i].getFullName();
                        System.out.println(name + " ->  " + grade);

                }
        }

        public char assignGrade(Student student){
                double studentAvg = student.getAverageExamScore();
                double classAvg = getAverageExamScore();
                double deviation = getDeviation();

                if (studentAvg >= classAvg + (2 * deviation)){
                        return 'A';
                } else if (studentAvg >= classAvg + deviation) {
                        return 'B';
                } else if (studentAvg >= classAvg){
                        return 'C';
                }else if (studentAvg >= classAvg - deviation){
                        return 'D';
                }
                return 'F';
        }

        public double getDeviation() {
                double deviation = 0;
                double classAverage = getAverageExamScore();
                for (Student s : students) {
                        if (s == null) {
                                deviation += 0;
                        } else {
                                double diff = classAverage - s.getAverageExamScore();
                                deviation += Math.pow(diff, 2);
                        }
                }
                double squaredDev = deviation / correctForNull();
                return Math.sqrt(squaredDev);


        }

        public int correctForNull() {
                int studentCount = 0;
                for (Student student : students) {
                        if (student != null) {
                                studentCount++;
                        }
                }
                return studentCount;

        }

}
