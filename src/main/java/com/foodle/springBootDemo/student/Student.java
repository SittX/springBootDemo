package com.foodle.springBootDemo.student;

import javax.persistence.*;

// @Entity annotation marks Student class as Java entity
@Entity
@Table(name = "student")
public class Student {
    public Student() {
    }

    public Student(String name, Integer age, long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    // Primary key of the entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name",nullable = false)

    private String name;

    @Column(name = "age",nullable = false)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
