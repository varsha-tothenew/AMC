package com.ttn.assignment.Services.Impl;

import com.ttn.assignment.Services.ClassConfigurationService;
import com.ttn.assignment.Services.StudentClassService;
import com.ttn.assignment.Student;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Component(immediate = true,service = StudentClassService.class )
@Designate(ocd = ClassConfigurationService.class)
public class StudentClassServiceImpl implements StudentClassService {

    List<Student> studentList = new ArrayList<Student>();
    int studentListSize = studentList.size();
    int passingMarks;
    int classLimit;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Activate
    public void activate(ClassConfigurationService classConfigurationService) {

        passingMarks = classConfigurationService.passingMarks();
        classLimit = classConfigurationService.classLimit();

        logger.info("\n\nStudent Configuration Service Activated.\n");


        Student student1, student2, student3, student4;
        student1 = new Student(1, "Varsha", 21, 95);
        student2 = new Student(2, "Anu", 22, 97);
        student3 = new Student(3, "Ayushi", 21, 30);
        student4 = new Student(4, "Amren", 23, 63);

        logger.info("\n\nStudent Implementation:\n" +
                "Adding Student 1: " + addStudent(student1) +
                "\nAdding Student 2: " + addStudent(student2) +
                "\nAdding Student 3: " + addStudent(student3) +
                "\nAdding Student 4: " + addStudent(student4) +
                "\nDeleting Last Student: " + deleteStudent(2) +
                "\nIs Student 3 Pass:" + isStudentPassed(4) +
                "\nGetting Student 1: " + getStudent(1) +
                "\nGetting All Students: " + getAllStudents() +
                "\n");

    }

    boolean isClassLimitReached() {
        if (studentListSize == classLimit)
            return true;
        else return false;
    }

    public String addStudent(Student student) {
        if (!isClassLimitReached()) {
            studentList.add(student);
            return "Added: " + student;
        } else
            return "Student cannot be added limit reached.";

    }

    public String deleteStudent(int id) {
        if (studentListSize == 0)
            return "class list empty";
        else {
            studentList.remove(id);
            return "Deleted" + id;
        }
    }

    public boolean isStudentPassed(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                if (student.getMarks() >= passingMarks) {
                    return true;
                }
            }
        }
        return false;
    }

    public Student getStudent(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return studentList;
    }
}
