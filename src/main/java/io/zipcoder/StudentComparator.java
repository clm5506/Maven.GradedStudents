package io.zipcoder;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {


    @Override
    public int compare(Student student1, Student student2) {

        int ans = student1.getAverageExamScore() - student2.getAverageExamScore();
        if (ans == 0) {
            ans = student1.getLastName().compareTo(student2.getFirstName());
        }
        return ans;

    }
}