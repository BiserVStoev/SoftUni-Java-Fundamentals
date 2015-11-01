package com.company;

import java.io.Serializable;

public class Course implements Serializable{
    private String field;
    private int numberOfStudents;

    public Course(String field, int numberOfStudents) {
        this.setField(field);
        this.setnumberOfStudents(numberOfStudents);
    }

    public String getField() {

        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setnumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "{Field: " + this.getField() + ", Number of students: " + this.getNumberOfStudents() + "}";
    }
}
