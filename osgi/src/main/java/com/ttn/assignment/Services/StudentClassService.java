package com.ttn.assignment.Services;

import com.ttn.assignment.Student;

import java.util.List;

public interface StudentClassService {

    String addStudent(Student student);

    String deleteStudent(int a);

    boolean isStudentPassed(int b);

    Student getStudent(int c);

    List<Student> getAllStudents();
}
