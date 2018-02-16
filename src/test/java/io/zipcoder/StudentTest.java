package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class StudentTest {

    Student testStudent;

    @Before
    public void setup() {
        testStudent = new testStudent();
    }

    @Test
    public void newStudentTest(){
        testStudent.firstName= null;
        testStudent.lastName=null;
        String expected = "Jim";
        String actual = "Bob";
        Assert.assertEquals(expected,actual);
    }

}