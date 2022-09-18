package com.foodle.springBootDemo.student;

import com.foodle.springBootDemo.student.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements  IStudentService{

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Student updateStudent(Student student) {
        // Find the target student in the database
        Student targetStudent =studentRepository.findById(student.getId())
                .orElseThrow(() ->  new ResourceNotFoundException("Student","Id",student.getId()));

        // Update the fields of Student object
        targetStudent.setName(student.getName());
        targetStudent.setAge(student.getAge());

        // Save the updated student object to the DB
        studentRepository.save(targetStudent);

        return targetStudent;
    }

    @Override
    public List<Student> deleteStudent(Long id) {

        studentRepository.deleteById(id);

        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else{
            throw new ResourceNotFoundException("Student","Id",id);
        }

    }
}
