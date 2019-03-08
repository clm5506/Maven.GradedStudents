package io.zipcoder;

import java.util.*;

public class Classroom {

    Student[] students;
    int maxNumberOfStudents;


    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this(30);
    }

    public int getMaxNumberOfStudents() {
        return this.maxNumberOfStudents;
    }

    public Student[] getStudents() {
        return this.students;
    }

    public Double getAverageExamScore() {
       Double numOfExams = 0.0;
        Double scores = 0.0;

        for(Student stud : students){
            numOfExams += stud.getNumberOfExamsTaken();
            scores += stud.getExamScoresTotal();
        }

        return  scores/numOfExams;
    }


    public void add(Student studentOne) {

        boolean hasRoom = false;

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = studentOne;
                hasRoom = true;
                break;
            }
        }   if(hasRoom == false) {
            ArrayList<Student> studArrList = new ArrayList<>(Arrays.asList(students));
            studArrList.add(studentOne);
            this.students = studArrList.toArray(new Student[studArrList.size()]);
        }

    }

    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> studArrList = new ArrayList<>(Arrays.asList(students));

        for(int i = 0; i < studArrList.size(); i++){
            if(studArrList.get(i).getFirstName().equals(firstName) &&
                    studArrList.get(i).getLastName().equals(lastName)){
                studArrList.remove(i);
                studArrList.add(null);
                break;
            }

        }
        this.students = studArrList.toArray(new Student[studArrList.size()]);
    }

    public Student[] getStudentsByScore() {
        StudentComparator sc = new StudentComparator();

        Arrays.sort(students,sc);
        return students;
    }

    public String getGradeBook() {

        Map<String, String> gb = new TreeMap<>();


        StudentComparator sc = new StudentComparator();
        Arrays.sort(students,sc);

        for(int i = 0; i < students.length; i++){
            Double percentile = (double)(students.length - i)/students.length;
            String fullName = students[i].getFirstName() + " " + students[i].getLastName();
            gb.put(fullName, getGrade(percentile));
       }

        return gb.toString().replace("{","").replace("}","");

    }

    public String getGrade(Double percentile){
        String grade = "";
        if(percentile >= .9){
            grade = "A";
        } else if(percentile > .7 && percentile <.9 ){
            grade = "B";
        } else if(percentile > .5 && percentile <= .7){
            grade = "C";
        } else if( percentile >=.11 && percentile <=.49){
            grade = "D";
        } else{
            grade = "F";
        }

        return grade;
    }

}