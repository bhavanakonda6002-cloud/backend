package com.campus.smart_campus.repository;

import com.campus.smart_campus.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}