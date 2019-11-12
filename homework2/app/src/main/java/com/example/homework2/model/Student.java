package com.example.homework2.model;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected Integer mCWID;

    protected ArrayList<CourseEnrollment> mCourses;

    public Student(String fname, String lname, Integer cwid) {
        mFirstName = fname;
        mLastName = lname;
        mCWID = cwid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Integer getCwid() {
        return mCWID;
    }

    public void setCwid(Integer sCwid) {
        mCWID = sCwid;
    }

    public ArrayList<CourseEnrollment> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<CourseEnrollment> courses) {
        mCourses = courses;
    }

}
