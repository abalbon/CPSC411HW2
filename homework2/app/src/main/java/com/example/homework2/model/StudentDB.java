package com.example.homework2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    static public StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB(){ createStudentObjects();}

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }

    public void add(Student stuObj) {
        mStudentList.add(stuObj);
    }

    protected void createStudentObjects() {
        Student student = new Student("Albert", "Balbon", 123456789);
        ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC 411", "B"));
        courses.add(new CourseEnrollment("CPSC 351", "B+"));
        student.setCourses(courses);
        mStudentList = new ArrayList<Student>();
        mStudentList.add(student);

        student = new Student( "Jim", "Tester", 112233445);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("CPSC 253U", "A"));
        courses.add(new CourseEnrollment("CPSC 362", "C"));
        courses.add(new CourseEnrollment("MATH 270B", "B-"));
        student.setCourses(courses);
        mStudentList.add(student);

        student = new Student("Jennifer", "Testing", 384902938);
        courses = new ArrayList<CourseEnrollment>();
        courses.add(new CourseEnrollment("Math 270B", "D"));
        courses.add(new CourseEnrollment("PSYCH 101", "A-"));
        courses.add(new CourseEnrollment("CPSC 362", "A"));
        student.setCourses(courses);
        mStudentList.add(student);
    }
}
