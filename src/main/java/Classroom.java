import io.zipcoder.Student;

//import com.google.common.collect;
import java.util.*;

public class Classroom {

    //instance variables
    private ArrayList<Student> students;
    private Integer maxNumberOfStudents;
    private static Map<Double, String> limits;



    //Nullary Constructor
    public Classroom() {
        students = new ArrayList<Student>(30);
        this.students = students;
    }

    //Constructor with int maxNumberOfStudents
    public Classroom(Integer maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        students = new ArrayList<>(maxNumberOfStudents);
    }

    //Constructor with the students <list> representative of the collection of student objects this classroom will store.
    public Classroom(ArrayList<Student> students) {
        this.students = students;
    }


    //Getters
    public ArrayList<Student> getStudents() {
        return students;
    }

    public Integer getMaxNumOfStudents() {
        return maxNumberOfStudents;
    }

    public Double getAverageExamScore() {
        Double totalExamScores = 0.0;
        int numOfStudents = students.size();

        for (int i = 0; i < students.size(); i++) {
            totalExamScores += students.get(i).getAverageExamScore();
        }
        return totalExamScores / numOfStudents;
    }

    public void addStudent (Student studentToAdd){
        //StringBuilder sb = new StringBuilder();
        students.add(studentToAdd);
//        sb.append("\n========================================\n");
//        sb.append(studentToAdd.printToString());
//        sb.append("========================================");
        //return sb.toString();
    }

    public void removeStudent (String firstName, String lastName){
        for (int i = 0; i < students.size(); i++) {
             if(students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)){
                 students.remove(i);
            }
        }
    }
    public ArrayList <Student> getStudentsByScore () {
        Collections.sort(students);
        return students;
    }
//Tried creating some maps and things to sort the student data.  Ended up using a custom comparator to sor the student list

//    for (int i = 0; i < students.size(); i++) {
//        students.get(i).getAverageExamScore();
//        students.sort(Comparator.naturalOrder());
//        HashMap<Student, Double> studentDoubleHashMap = new HashMap<>();
//        for (int i = 0; i < students.size(); i++) {
//            studentDoubleHashMap.put(students.get(i), students.get(i).getAverageExamScore());
//        }

    public Map getGradeBook (){
        //Integer numOfStudentsInClass = students.size();
        String letterGrade = "I";
        //orders students by score
        getStudentsByScore();
        //Limits for the tree map
//        static {
//        limits = new TreeMap<>();
//        limits.put(0.0 , "F");
//        limits.put(students.size()*0.11 , "D");
//        limits.put(students.size()*0.31, "C");
//        limits.put(students.size()*0.51, "B");
//        limits.put(students.size()*0.71, "B");
//        limits.put(students.size()* 0.9, "A");

        TreeMap<Student, String> gradeMap = new TreeMap<>();

//                gradeMap.put(90.0, "A");
//                gradeMap.put(71.0, "B");
//                gradeMap.put(51.0, "C");
//                gradeMap.put(11.0, "D");
//                gradeMap.put( 0.0, "F");

    for (int i = 0; i < students.size(); i++ ){

        if ( students.get(i).getAverageExamScore() >= 90){
            letterGrade = " A";}
        else if (students.get(i).getAverageExamScore() <= 90 && students.get(i).getAverageExamScore() >= 71){
            letterGrade = " B";}
        else if (students.get(i).getAverageExamScore() <= 70 && students.get(i).getAverageExamScore() >= 50){
            letterGrade= " C";}
        else if (students.get(i).getAverageExamScore() <= 90 && students.get(i).getAverageExamScore() >= 71){
            letterGrade = " D";}
        else {
            letterGrade = " F";}
        gradeMap.put(students.get(i), letterGrade);
        }
        return gradeMap;
    }

    }

    //
//+ " " + letterGrade

//    students.get(i).getFirstName() + " " + students.get(i).getLastName());
//    RangeMap<Integer, String> gradeLetter = ImmutableRangeMap.builder()
//            .put(Range.closed(90, 100), "A")
//            .put(Range.closed(60, 89), "B")
//            // ...
//            .build();
//
//    public String getGrade(String studentName) {
//        int averageScore = getAverageExamGrade(studentName);
//        return gradeLetter.get(averageScore);
//    }




