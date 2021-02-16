package com.mcb.assignment;

import com.mcb.assignment.course.Course;
import com.mcb.assignment.course.CourseRepo;
import com.mcb.assignment.department.Department;
import com.mcb.assignment.instructor.Instructor;
import com.mcb.assignment.student.Course_Student;
import com.mcb.assignment.student.Student;
import com.mcb.assignment.student.StudentRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AssignmentApplicationTests {

  @Autowired private TestEntityManager entityManager;

  @Autowired private StudentRepo studentRepo;

  @Autowired private CourseRepo courseRepo;

  @Test
  public void when_GetStudentsByInstructorId_thenReturnSuccess() {
    Instructor instructor =
        Instructor.builder()
            .first_name("test")
            .last_name("test")
            .department_name("test department")
            .headed_by("test")
            .phone("1234567799")
            .build();
    int instructorId = entityManager.persist(instructor).getID();
    Course course =
        Course.builder()
            .name("test")
            .instructor_id(instructorId)
            .department_name("test department")
            .duration(100)
            .build();
    int courseId = entityManager.persist(course).getID();
    Student student =
        Student.builder().first_name("test").last_name("test").phone("1234567890").build();
    int studentId = entityManager.persist(student).getID();
    Department department =
        Department.builder().name("test department").location("test location").build();

    Course_Student courseStudent =
        Course_Student.builder().course_id(courseId).student_id(studentId).build();
    entityManager.persist(department);
    entityManager.persist(courseStudent);
    entityManager.flush();
    List<Student> studentList = studentRepo.getStudentsByInstructorId(instructorId);
    Assert.assertEquals(1, studentList.size());
  }

  @Test
  public void when_GetCourseDurationByStudentId_thenReturnSuccess() {
    Instructor instructor =
        Instructor.builder()
            .first_name("test")
            .last_name("test")
            .department_name("test department")
            .headed_by("test")
            .phone("1234567799")
            .build();
    int instructorId = entityManager.persist(instructor).getID();
    Course course =
        Course.builder()
            .name("test")
            .instructor_id(instructorId)
            .department_name("test department")
            .duration(100)
            .build();

    Course course2 =
        Course.builder()
            .name("test")
            .instructor_id(instructorId)
            .department_name("test department")
            .duration(120)
            .build();
    int courseId = entityManager.persist(course).getID();
    int courseId2 = entityManager.persist(course2).getID();
    Student student =
        Student.builder().first_name("test").last_name("test").phone("1234567890").build();
    int studentId = entityManager.persist(student).getID();
    Department department =
        Department.builder().name("test department").location("test location").build();

    Course_Student courseStudent =
        Course_Student.builder().course_id(courseId).student_id(studentId).build();
    Course_Student courseStudent2 =
        Course_Student.builder().course_id(courseId2).student_id(studentId).build();
    entityManager.persist(department);
    entityManager.persist(courseStudent);
    entityManager.persist(courseStudent2);
    entityManager.flush();
    long duration = studentRepo.getCourseDurationByStudentId(studentId);
    Assert.assertEquals(220, duration);
  }

  @Test
  public void when_GetCoursesByStudentId_thenReturnSuccess() {
    Instructor instructor =
        Instructor.builder()
            .first_name("test")
            .last_name("test")
            .department_name("test department")
            .headed_by("test")
            .phone("1234567799")
            .build();
    int instructorId = entityManager.persist(instructor).getID();
    Course course =
        Course.builder()
            .name("test")
            .instructor_id(instructorId)
            .department_name("test department")
            .duration(100)
            .build();
    int courseId = entityManager.persist(course).getID();
    Student student =
        Student.builder().first_name("test").last_name("test").phone("1234567890").build();
    int studentId = entityManager.persist(student).getID();
    Department department =
        Department.builder().name("test department").location("test location").build();

    Course_Student courseStudent =
        Course_Student.builder().course_id(courseId).student_id(studentId).build();
    entityManager.persist(department);
    entityManager.persist(courseStudent);
    entityManager.flush();
    List<Course> courseList = courseRepo.getCoursesByStudentId(studentId);
    Assert.assertEquals(1, courseList.size());
    Assert.assertEquals(courseId, (int) courseList.get(0).getID());
  }
}
