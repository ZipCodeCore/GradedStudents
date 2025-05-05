package io.zipcoder;

public class Grade {
    private Character grade;
    private Student student;

    public Grade(Student student, Character grade){
        this.grade = grade;
        this.student = student;
    }
    public Student getStudent(){
        return student;
    }
    public Character getGrade(){
        return grade;
    }

    @Override
    public String toString(){
        return String.format("%s %s, Grade: %c/n",
                student.getFirstName(),student.getLastName(),grade);
    }
}
