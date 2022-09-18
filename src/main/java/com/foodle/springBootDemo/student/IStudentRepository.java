package com.foodle.springBootDemo.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
