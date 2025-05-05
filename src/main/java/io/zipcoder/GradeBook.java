package io.zipcoder;

import java.util.Arrays;

public class GradeBook {
    private Grade[] grades;

    public GradeBook(Grade[] grades){
        this.grades = grades;
    }
    public Grade[] getGrades() {
        return grades;
    }
    @Override
    public String toString(){
        String result = "";
        for(Grade grade: grades)
            result += grade.toString();
        return result;
    }
}
