package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void testClassroomConstructorMaxStudents(){
        //Given
        int maxNumberOfStudents = 10;
        Classroom testClassRoom = new Classroom(maxNumberOfStudents);

        //Then
        Assert.assertEquals(maxNumberOfStudents, testClassRoom.getMaxNumberOfStudents());
    }

    @Test
    public void testClassroomConstructorStudents(){
        //Given
        Double[] testScores = {100.0, 90.0, 80.0, 0.0};
        Student studentOne = new Student("Cristina", "McClintock", testScores);

        Double[] testScores2 = {100.0, 90.0, 80.0, 0.0};
        Student studentTwo = new Student("Marci", "Brahma",testScores2);

        Double[] testScores3 = {100.0, 90.0, 80.0, 0.0};
        Student studentThree = new Student("Eric", "Jefferson", testScores3);

        Student[] testStudents = {studentOne, studentTwo, studentThree};

        //When
        Classroom testClassRoom = new Classroom(testStudents);

        //Then
        Assert.assertEquals(testStudents,testClassRoom.getStudents());
    }

    @Test
    public void testClassroomNullaryConstructor(){
        //Given
        int expectedLength = 30;
        //When
        Classroom testClassRoom = new Classroom();

        //Then
        Assert.assertEquals(expectedLength, testClassRoom.getStudents().length);
        Assert.assertTrue(testClassRoom.getStudents()[0] == null);
    }

    @Test
    public void testGetAverageExamScore(){
        //Given
        Double[] testScores = {100.0, 150.0};
        Student studentOne = new Student("Cristina", "McClintock",testScores);
        Double[] testScores2 = {225.0, 25.0};
        Student studentTwo = new Student("Marci", "Brahma",testScores2);
        Student[] testStudents = {studentOne, studentTwo};
        Double expectedAverage = 125.0;
        Classroom testClassRoom = new Classroom(testStudents);

        //Then
        Assert.assertEquals(expectedAverage, testClassRoom.getAverageExamScore());
    }

    @Test
    public void testAddStudent(){
        //Given
        int maxNumberOfStudents = 1;
        Double[] testScores = {100.0, 150.0, 250.0, 0.0};
        Student studentOne = new Student("Cristina", "McClintock",testScores);
        Classroom testClassRoom = new Classroom(maxNumberOfStudents);
        String expectedEmpty = "[null]";
        String expectedOutput =
                "[Student Name: Cristina McClintock\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "     Exam 1 -> 100\n" +
                "     Exam 2 -> 150\n" +
                "     Exam 3 -> 250\n" +
                "     Exam 4 -> 0\n]";
        //When
        String actualBefore = Arrays.toString(testClassRoom.getStudents());
        testClassRoom.add(studentOne);
        String actualAfter = Arrays.toString(testClassRoom.getStudents());

        Assert.assertEquals(expectedEmpty, actualBefore);
        Assert.assertEquals(expectedOutput, actualAfter);
    }

    @Test
    public void testRemoveStudent(){
        //Given
        Double[] testScores = {100.0, 150.0, 250.0, 0.0};
        Student studentOne = new Student("Cristina", "McClintock",testScores);
        Double[] testScores2 = {225.0, 25.0};
        Student studentTwo = new Student("Marci", "Brahma",testScores2);
        Student[] testStudentArray = {studentOne,studentTwo};
        Classroom testClassRoom = new Classroom(testStudentArray);
        String firstName = "Cristina";
        String lastName = "McClintock";
        String expectedOutput =
                "[Student Name: Marci Brahma\n" +
                        " > Average Score: 125\n" +
                        " > Exam Scores:\n" +
                        "     Exam 1 -> 225" +
                        "     Exam 2 -> 25" + "," +
                        "[]";
        //When
        testClassRoom.removeStudent(firstName, lastName);

        //Then
        Assert.assertEquals(expectedOutput, Arrays.toString(testClassRoom.getStudents()));
    }

    @Test
    public void testGetStudentsByScore(){
        //Given
        Double[] testScores = {100.0, 200.0, 300.0};
        Student studentOne = new Student("Ted", "Smith",testScores);

        Double[] testScores2 = {100.0, 200.0, 300.0};
        Student studentTwo = new Student("Cristina", "McClintock", testScores2);

        Double[] testScores3 = {300.0, 300.0, 300.0};
        Student studentThree = new Student("Cristina", "McClintock", testScores3);

        Student[] studentArray = {studentOne, studentTwo, studentThree};

        String[] expected = {"Cristina McClintock - Avg Score: 300",
                "Cristina McClintock - Avg Score: 200", "Ted Smith - Avg Score: 200"};

        //When
        Classroom testClassRoom = new Classroom(studentArray);

        Assert.assertEquals(expected,testClassRoom.getStudentsByScore());
    }

    @Test
    public void testGetGradeBook(){
        Double[] testScores1 = {10.0, 10.0, 10.0, 10.0};
        Student studentOne = new Student("Cristina", "McClintock", testScores1);

        Double[] testScores2 = {20.0, 20.0, 20.0, 20.0};
        Student studentTwo = new Student("Marci", "Brahma",testScores2);

        Double[] testScores3 = {30.0, 30.0, 30.0, 30.0};
        Student studentThree = new Student("Eric", "Jefferson", testScores3);

        Double[] testScores4 = {40.0, 40.0, 40.0, 40.0};
        Student studentFour = new Student("John", "Doe", testScores4);

        Double[] testScores5 = {50.0, 50.0, 50.0, 50.0};
        Student studentFive = new Student("Jane", "Smith", testScores5);

        Double[] testScores6 = {60.0, 60.0, 60.0, 60.0};
        Student studentSix = new Student("Tom", "Hanks",testScores6);

        Double[] testScores7 = {70.0, 70.0, 70.0, 70.0};
        Student studentSeven = new Student("Ann", "Thomas", testScores7);

        Double[] testScores8 = {80.0, 80.0, 80.0, 80.0};
        Student studentEight = new Student("Brittney", "Spears", testScores8);

        Double[] testScores9 = {90.0, 90.0, 90.0, 90.0};
        Student studentNine= new Student("Jessie", "James",testScores9);

        Double[] testScores10 = {100.0, 100.0, 100.0, 100.0};
        Student studentTen = new Student("Eric", "Decker", testScores10);

        Student[] arrayOfStudents = {studentOne, studentTwo, studentThree, studentFour, studentFive,
                                    studentSix, studentSeven, studentEight, studentNine, studentTen};

        Classroom cr = new Classroom(arrayOfStudents);

        String expected = "Eric Decker - A\n" +
                          "Jessie James = B\n";

        System.out.println(cr.getGradeBook());
    }

}
