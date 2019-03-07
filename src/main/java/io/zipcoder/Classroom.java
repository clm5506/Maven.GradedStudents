package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

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
//        String[] ans = new String[students.length];
//
//        for(int i = 0; i < students.length; i ++) {
//
//            if (students[i] == null) {
//                ans[i] = "";
//            }else {
//                ans[i] = students[i].toString();
//            }
//        }
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
                studArrList.get(i);
                studArrList.add(null);
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
        return null;
    }


}