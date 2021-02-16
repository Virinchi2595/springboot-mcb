package com.mcb.assignment.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Integer> {

  @Query(
      value = "SELECT * FROM Course S INNER JOIN Course_Student cs ON  cs.student_id = :studentId",
      nativeQuery = true)
  List<Course> getCoursesByStudentId(@Param("studentId") Integer studentId);
}
