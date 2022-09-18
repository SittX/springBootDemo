package com.foodle.springBootDemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
  private final IStudentService studentService;

  @Autowired
  public StudentController(IStudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping
  public ResponseEntity<Student> addNewStudent(@RequestBody Student student){
    return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Student>> getStudents(){
    return new ResponseEntity<List<Student>>(studentService.getAllStudents(),HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId){
    return new ResponseEntity<Student>(studentService.getStudentById(studentId),HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<Student> updateStudent(@RequestBody Student student){
    return new ResponseEntity<Student>(studentService.updateStudent(student),HttpStatus.OK);
  }

  @DeleteMapping("/delete")
  public ResponseEntity<List<Student>> deleteStudent(@RequestParam(name = "id") Long studentId){
    return new ResponseEntity<List<Student>>(studentService.deleteStudent(studentId),HttpStatus.OK);
  }
}
