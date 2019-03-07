package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private Double[] testScores;
    private ArrayList<Double> examScores;


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

        String result =
                "Exam Scores:\n";
        for(int i = 1; i <= testScores.length; i++){
            result += "     Exam "+ i + " -> " + testScores[i-1].intValue() +"\n";
        }

        return result;
    }

    public Double getExamScoresTotal(){
        Double answer = 0.00;
        for(int i = 0; i < testScores.length; i++){
            answer += testScores[i];
        }
        return answer;

    }

    public void addExamScore(Double score) {
        examScores = new ArrayList<>(Arrays.asList(testScores));
        examScores.add(score);
        this.testScores =  examScores.toArray(new Double[examScores.size()]);
    }

    public void setExamScore(int index, Double score) {
        List<Double> examsArrayList = new ArrayList<>(Arrays.asList(testScores));

        examsArrayList.set(index-1, score);

        this.testScores =  examsArrayList.toArray(new Double[examsArrayList.size()]);

    }

    public int getAverageExamScore() {
        Double sum = 0.0;
        double ans = 0.0;
        for(Double d : testScores){
            sum += d;
        }

        double average = sum/testScores.length;
        ans = Math.round(average);
        return (int)ans;
    }

    @Override
    public String toString(){

        String result = "Student Name: " + getFirstName() + " " + getLastName() +
                "\n> Average Score: " + getAverageExamScore() + "\n> " + getExamScores();
    return result;
    }

}
