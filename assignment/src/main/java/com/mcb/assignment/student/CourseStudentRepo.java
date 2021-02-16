package com.mcb.assignment.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseStudentRepo extends JpaRepository<Course_Student, Integer> {}
