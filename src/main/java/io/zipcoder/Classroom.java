package io.zipcoder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classroom {
    private Student[] studentArray;
    private int maxNumberOfStudents;


    public Classroom() {
        this.studentArray = new Student[30];
    }

        public Classroom(int maxNumberOfStudents) {
            this.studentArray = new Student[maxNumberOfStudents];
        }

        public Classroom(Student... students){
            this.studentArray = students;
        }

        public Student[] getStudentArray() {
            return studentArray;
        }

        public double getClassAverageExamScore() {
            double totalSum = 0;
            for (Student element: studentArray) {
                totalSum += element.getStudentAverageExamScore();
            }
            return totalSum / studentArray.length;
        }

        public void addStudent(Student student) {
            for (int i = 0; i < studentArray.length; i++) {
                if (studentArray[i] == null) {
                    studentArray[i] = student;
                    break;
                }
            }
//            ArrayList<Student> newEnrollment = new ArrayList<>(Arrays.asList(students));
//            if (students.length < maxNumberOfStudents) {
//                newEnrollment.add(student);
//            } else System.out.println("Enrollment full");
//            this.students = newEnrollment.toArray(new Student[0]);
        }

        public void removeStudent(String firstName, String lastName) {
//            for (int i = 0; i < studentArray.length - 1; i++) {
//                if (studentArray[i].getFirstName().equals(firstName) &&
//                        studentArray[i].getLastName().equals(lastName)){
//                    studentArray[i] = null;
//                } studentArray[i] = studentArray[i + 1];
//            }
//            studentArray[studentArray.length - 1] = null;

//newStudentList.set(newStudentList.indexOf(student), null);
            ArrayList<Student> newStudentList = new ArrayList<Student>(Arrays.asList(studentArray));

            for (int i = 0; i < newStudentList.size(); i++) {
                Student student = newStudentList.get(i);
                if (student == null) {
                    continue;
                } else if (student.getFirstName().equals(firstName) &&
                            student.getLastName().equals(lastName)) {
                        newStudentList.remove(student);
                        newStudentList.add(null); // adding null to the end of list to replace student position.
                    }
                }
                this.studentArray = newStudentList.toArray(new Student[0]);
            }



            public Student[] getStudentsByScore () {
                List<Student> studentList = new ArrayList<Student>(Arrays.asList(studentArray));

                Comparator<Student> byAvgExamScores = Comparator.comparing(Student::getStudentAverageExamScore);
                Comparator<Student> byFullName = Comparator.comparing(Student::getFullName);

                Collections.sort(studentList, byAvgExamScores.reversed().thenComparing(byFullName));

                //Collections.reverse(studentList); // Highest to lowest

                Student[] studentsSortedByScore = studentList.toArray(new Student[0]);

                return studentsSortedByScore;

                // by score , last name, first name
            }



    // ~*~ Thank you Leon ! ~*~
        public Map<Student, Character> getGradeBook() {
            Map<Student, Character> gradeBookResult = new HashMap<>();
            for (Student student : studentArray) {
                Double percentile = getPercentile(student);
                boolean isPercentileBetween0And10 = percentile > 0 && percentile <= 10;
                boolean isPercentileBetween11And29 = percentile > 11 && percentile <= 29;
                boolean isPercentileBetween30And50 = percentile > 30 && percentile <= 50;
                boolean isPercentileBetween51And89 = percentile > 51 && percentile <= 89;

                if (isPercentileBetween0And10) {
                    gradeBookResult.put(student, 'A');
                } else if (isPercentileBetween11And29) {
                    gradeBookResult.put(student, 'B');
                } else if (isPercentileBetween30And50) {
                    gradeBookResult.put(student, 'C');
                } else if (isPercentileBetween51And89) {
                    gradeBookResult.put(student, 'D');
               } else {
                    gradeBookResult.put(student, 'F');
                }
            }
            return gradeBookResult;
        }
            public double getPercentile (Student student){
                List<Double> allStudentGrades = Stream
                        .of(studentArray)
                        .map(Student::getStudentAverageExamScore)
                        .collect(Collectors.toList());

                double percentage = student.getStudentAverageExamScore();
                boolean isPercentileGreaterThan0 = percentage >= 0;
                boolean isPercentileLessThan100 = percentage <= 100;
                boolean isPercentileValid = isPercentileGreaterThan0 && isPercentileLessThan100;
                boolean isItemsEmpty = allStudentGrades.isEmpty();
                boolean areArgumentsValid = isPercentileValid && !isItemsEmpty;
                if (!areArgumentsValid) {
                    throw new IllegalArgumentException();
                }
                Collections.sort(allStudentGrades);
                return allStudentGrades.get((int)
                        Math.round(percentage / 100.0 * (allStudentGrades.size() - 1)));
            }

        }



