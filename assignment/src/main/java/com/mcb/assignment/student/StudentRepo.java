package com.mcb.assignment.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {

  @Query(
      value =
          "SELECT s.* From Student s\n"
              + "INNER JOIN Course_Student cs ON s.ID = cs.student_id\n"
              + "INNER JOIN Course c  ON cs.course_id=c.ID\n"
              + "WHERE c.instructor_id = :instructorId",
      nativeQuery = true)
  public List<Student> getStudentsByInstructorId(@Param("instructorId") Integer instructorId);

  @Query(
      value =
          "SELECT SUM(duration)\n"
              + "FROM Course c\n"
              + "INNER JOIN Course_Student cs ON cs.course_id = c.id\n"
              + "INNER JOIN Student s ON s.id = cs.student_id\n"
              + "WHERE s.id = :studentId",
      nativeQuery = true)
  public long getCourseDurationByStudentId(@Param("studentId") Integer studentId);
}
