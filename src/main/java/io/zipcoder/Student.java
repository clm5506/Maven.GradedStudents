package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private Double[] testScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = testScores;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
       return this.testScores.length;
    }


    public String getExamScores() {
        return this.testScores.toString();
    }

    public void addExamScore(Double score) {
        List<Double> examsArrayList = new ArrayList<>(Arrays.asList(testScores));

        examsArrayList.add(score);

        this.testScores =  examsArrayList.toArray(new Double[examsArrayList.size()]);
    }

    public void setExamScore(int index, Double score) {
        List<Double> examsArrayList = new ArrayList<>(Arrays.asList(testScores));

        examsArrayList.set(index-1, score);

        this.testScores =  examsArrayList.toArray(new Double[examsArrayList.size()]);

    }
    //might need to be changed to double
    public Double getAverageExamScore() {
        Double sum = 0.0;
        for(Double d : testScores){
            sum += d;
        }
        return sum / testScores.length;
    }

    @Override
    public String toString(){
    }
}
