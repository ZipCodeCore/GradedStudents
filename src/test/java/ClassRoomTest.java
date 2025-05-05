import io.zipcoder.Student;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassRoomTest {

    @Test
    public void nullaryConstructorTest() {
        // Given
        ArrayList<Student> expectedStudents = new ArrayList<Student>(30);

        // When
        Classroom testClass = new Classroom();

        // Then
        ArrayList<Student> actualStudents = testClass.getStudents();

        Assert.assertEquals(expectedStudents, actualStudents);
    }


    @Test
    public void maxStudentsConstructorTest() {
        // Given
        Integer expected = 25;

        // When
        Classroom testClass = new Classroom(expected);

        // Then
        Integer actual = testClass.getMaxNumOfStudents();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getStudentsTest() {
        ArrayList<Double> examScoresTest = new ArrayList(Arrays.asList(85D, 75D, 90D));
        ArrayList<Double> examScoresTest2 = new ArrayList(Arrays.asList(88D, 90D, 92D));
        ArrayList<Double> examScoresTest3 = new ArrayList(Arrays.asList(88D, 90D, 92D));

        Student testStudent1 = new Student("Peter", "Moogie", examScoresTest);
        Student testStudent2 = new Student("Pope", "John Paul", examScoresTest2);
        Student testStudent3 = new Student("May", "West", examScoresTest3);

        ArrayList<Student> expectedStudents = new ArrayList<Student>(Arrays.asList(testStudent1, testStudent2, testStudent3));

        Classroom testClass = new Classroom(expectedStudents);

        ArrayList<Student> actual = testClass.getStudents();

        Assert.assertEquals(expectedStudents, actual);


    }

    @Test
    public void studentObjectsConstructorTest() {
        // Given
        ArrayList<Double> examScoresTest = new ArrayList(Arrays.asList(85D, 75D, 90D));
        ArrayList<Double> examScoresTest2 = new ArrayList(Arrays.asList(88D, 90D, 92D));
        ArrayList<Double> examScoresTest3 = new ArrayList(Arrays.asList(88D, 90D, 92D));

        Student testStudent1 = new Student("Peter", "Moogie", examScoresTest);
        Student testStudent2 = new Student("Pope", "John Paul", examScoresTest2);
        Student testStudent3 = new Student("May", "West", examScoresTest3);

        ArrayList<Student> expectedStudents = new ArrayList<Student>(Arrays.asList(testStudent1, testStudent2, testStudent3));

        // When
        Classroom testClass = new Classroom(expectedStudents);

        // Then
        ArrayList<Student> actualStudents = testClass.getStudents();

        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void getAverageExamScoreTest() {
        // : Given
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(225.0, 25.0));

        Student testStudent1 = new Student("student", "one", s1Scores);
        Student testStudent2 = new Student("student", "two", s2Scores);

        ArrayList<Student> testStudents = new ArrayList<Student>(Arrays.asList(testStudent1, testStudent2));
        Classroom classroom = new Classroom(testStudents);

        // When
        Double output = classroom.getAverageExamScore();

        // Then
        System.out.println(output);

    }

    @Test
    public void addStudentTest() {

        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(225.0, 25.0));

        Student testStudent1 = new Student("Petey", "Pablo", s1Scores);
        Student testStudent2 = new Student("Lil", "Jon", s2Scores);

        ArrayList<Student> testStudents = new ArrayList<Student>(Arrays.asList(testStudent1));
        Classroom classroom = new Classroom(testStudents);

        classroom.addStudent(testStudent2);
        Student actual = classroom.getStudents().get(1);
        Student expected = testStudent2;
        //System.out.println(actual.printToString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeStudentTest() {
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(100.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(225.0, 25.0));

        Student testStudent1 = new Student("Petey", "Pablo", s1Scores);
        Student testStudent2 = new Student("Lil", "Jon", s2Scores);

        ArrayList<Student> testStudents = new ArrayList<Student>(Arrays.asList(testStudent1, testStudent2));

        Classroom classroom = new Classroom(testStudents);
        classroom.removeStudent("Petey", "Pablo");
        ArrayList<Student> expected = new ArrayList<>(Arrays.asList(testStudent2));
        ArrayList<Student> actual = classroom.getStudents();
        //System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getStudentsByScoreTest() {
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(10.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(225.0, 25.0));
        ArrayList<Double> s3scores = new ArrayList<>(Arrays.asList(75.0, 125.0));

        Student testStudent1 = new Student("Petey", "Pablo", s1Scores);
        Student testStudent2 = new Student("Lil", "Jon", s2Scores);
        Student testStudent3 = new Student("Anne", "Buttigeg", s3scores);

        ArrayList<Student> testStudents = new ArrayList<Student>(Arrays.asList(testStudent1, testStudent2, testStudent3));

        ArrayList<Student> expected = new ArrayList<>(Arrays.asList(testStudent2, testStudent3, testStudent1));

        Classroom classroom = new Classroom(testStudents);

        ArrayList <Student> actual = classroom.getStudentsByScore();

//        Iterator<Student> myStudents = testStudents.iterator();
//        while (myStudents.hasNext()){
//            System.out.println(myStudents.next().printToString());
//        }

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getStudentsByScoreTest2() {
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(50.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(120.0, 80.0));
        ArrayList<Double> s3scores = new ArrayList<>(Arrays.asList(200.0, 0.0));

        Student testStudent1 = new Student("Petey", "Pablo", s1Scores);
        Student testStudent2 = new Student("Lil", "Jon", s2Scores);
        Student testStudent3 = new Student("Paul", "Bacchas", s3scores);

        ArrayList<Student> expected = new ArrayList<>(Arrays.asList(testStudent2, testStudent3, testStudent1));

        ArrayList<Student> testStudents = new ArrayList<Student>(Arrays.asList(testStudent2, testStudent1, testStudent3));

        Classroom classroom = new Classroom(testStudents);
        ArrayList <Student> actual = classroom.getStudentsByScore();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getGradeBooKTest (){
        ArrayList<Double> s1Scores = new ArrayList<Double>(Arrays.asList(10.0, 150.0));
        ArrayList<Double> s2Scores = new ArrayList<>(Arrays.asList(70.0, 50.0));
        ArrayList<Double> s3scores = new ArrayList<>(Arrays.asList(95.0, 95.0));

        Student testStudent1 = new Student("Petey", "Pablo", s1Scores);
        Student testStudent2 = new Student("Lil", "Jon", s2Scores);
        Student testStudent3 = new Student("Anne", "Buttigeg", s3scores);

        ArrayList<Student> testStudents = new ArrayList<Student>(Arrays.asList(testStudent1, testStudent2, testStudent3));

        //TreeMap<Student, String> expected = new TreeMap<Student, String>(testStudent2, testStudent3, testStudent1);

        Classroom classroom = new Classroom(testStudents);

        TreeMap<Student, String> expected = new TreeMap<Student, String>();
            expected.put(testStudent3, " A");
            expected.put(testStudent1, " B");
            expected.put(testStudent2, " C");

        Map<Student, String> actual = classroom.getGradeBook();

        Assert.assertEquals(expected,actual);

//        for (Map.Entry<Student, String> entry : actual.entrySet()) {
//            System.out.println("Key: " + entry.getKey().printToString() + ". Value: " + entry.getValue());
        }
//        for (Entry<String, String> entry : tree.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//
//            System.out.printf("%s : %s\n", key, value);
//        }


//        for(Map.Entry<Student, String> entry : selects.entrySet()) {
//            String key = entry.getKey();
//            HashMap value = entry.getValue();

        //Collection myStuff = actual.entrySet();
        //Spliterator sit = myStuff.entrySet().spliterator();
        //System.out.println(actual);
        //actual.forEach((k,v))  hm.forEach((k,v) -> System.out.println("key: "+k+" value:"+v));;
        //Iterator itr = actual.iterator();

        //Iterator<> myStudents = testStudents.iterator();
        //while (actual.hasNext()){
            //System.out.println(actual.next().printToString());

//
     }









