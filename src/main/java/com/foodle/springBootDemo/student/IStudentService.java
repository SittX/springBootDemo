package com.foodle.springBootDemo.student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student updateStudent(Student student);

    List<Student> deleteStudent(Long id);

    Student getStudentById(Long id);


}
