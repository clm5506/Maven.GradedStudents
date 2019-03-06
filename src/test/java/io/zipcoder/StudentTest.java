package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void testStudentConstructor(){

        //Given
        String firstName = "Cristina";
        String lastName = "McClintock";
        Double[] testScores = {100.00};
        String expectedScores = "Exam Scores:\n" +
                "\tExam 1 -> 100\n";
        //When
        Student testStudent = new Student(firstName,lastName,testScores);

        //Then
        Assert.assertEquals(firstName, testStudent.getFirstName());
        Assert.assertEquals(lastName, testStudent.getLastName());
        Assert.assertEquals(expectedScores,testStudent.getExamScores());
    }

    @Test
    public void testGetterFirstName(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {70.0, 80.0, 90.0};

        Student testStudent = new Student(firstName1,lastName1,testScores);
        //Then
       Assert.assertEquals(firstName1,testStudent.getFirstName());
    }

    @Test
    public void testSetterFirstName(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {70.0, 80.0, 90.0};
        Student testStudent = new Student(firstName1,lastName1,testScores);
        String firstName = "Cris";

        //When
        testStudent.setFirstName(firstName);

        //Then
        Assert.assertEquals(firstName, testStudent.getFirstName());
    }

    @Test
    public void testGetterLastName(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {70.0, 80.0, 90.0};
        Student testStudent = new Student(firstName1,lastName1,testScores);

        //Then
        Assert.assertEquals(lastName1,testStudent.getLastName());
    }

    @Test
    public void testSetterLastName(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {70.0, 80.0, 90.0};
        Student testStudent = new Student(firstName1,lastName1,testScores);
        String lastName = "McC";

        //When
        testStudent.setLastName(lastName);

        //Then
        Assert.assertEquals(lastName,testStudent.getLastName());
    }

    @Test
    public void testGetNumberOfExamsTaken(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {70.0, 80.0, 90.0};
        Integer expected = 3;
        Student testStudent = new Student(firstName1,lastName1,testScores);

        //Then
        Assert.assertEquals(expected, testStudent.getNumberOfExamsTaken());
    }

    @Test
    public void testGetExamScores(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        String expectedScores =
                "Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 95\n" +
                "\tExam 3 -> 123\n" +
                "\tExam 4 -> 96\n";

        Student testStudent = new Student(firstName1,lastName1,testScores);

        //Then
        Assert.assertEquals(expectedScores, testStudent.getExamScores());
    }

    @Test
    public void testAddExamScore(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {};
        Double score = 100.0;
        String expected =
                "Exam Scores:\n" +
                "\tExam 1 -> 100\n";
        Student testStudent = new Student(firstName1,lastName1,testScores);

        //When
        testStudent.addExamScore(score);

        //Then
        Assert.assertEquals(expected, testStudent.getExamScores());
    }

    @Test
    public void testSetExamScore(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {100.0};
        Double score = 105.0;
        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 105\n";
        //When
        Student testStudent = new Student(firstName1,lastName1,testScores);
        testStudent.setExamScore(1, score);

        //Then
        Assert.assertEquals(expected, testStudent.getExamScores());
    }

    @Test
    public void testGetAverageExamScore(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {100.0, 90.0, 80.0, 0.0};
        int expectedAverage = 68;
        Student testStudent = new Student(firstName1,lastName1,testScores);

        //Then
        Assert.assertEquals(expectedAverage, testStudent.getAverageExamScore());
    }

    @Test
    public void testStudentToString(){
        //Given
        String firstName1 = "Cristina";
        String lastName1 = "McClintock";
        Double[] testScores = {100.0, 95.0, 123.0, 96.0};
        Student testStudent = new Student(firstName1,lastName1,testScores);
        String expected =
                        "Student Name: Cristina McClintock\n" + "> Average Score: 104\n"
                        + "> Exam Scores:\n" +   "\tExam 1 -> 100\n" +
                                "\tExam 2 -> 95\n" +
                                "\tExam 3 -> 123\n" +
                                "\tExam 4 -> 96\n";
        //Then

        Assert.assertEquals(expected, testStudent.toString());

    }
}