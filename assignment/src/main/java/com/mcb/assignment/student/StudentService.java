package com.mcb.assignment.student;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {
  @Autowired private StudentRepo studentRepo;

  @Autowired private CourseStudentRepo courseStudentRepo;

  Iterable<Student> getAllStudents() {

    return studentRepo.findAll();
  }

  Student getStudentById(Integer id) {
    return studentRepo
        .findById(id)
        .orElseThrow(
            () ->
                new StudentException(
                    StudentExceptionEnum.COURSE_NOTFOUND_EXCEPTION.message,
                    StudentExceptionEnum.COURSE_NOTFOUND_EXCEPTION.code));
  }

  Student createStudent(Student student) {
    Student savedStudent = studentRepo.save(student);
    log.info("created student with id :{}", savedStudent.getID());
    return savedStudent;
  }

  Student updateStudent(Student student) {
    if (student.getID() == null) {
      throw new StudentException(
          StudentExceptionEnum.ID_REQUIRED_EXCEPTION.message,
          StudentExceptionEnum.ID_REQUIRED_EXCEPTION.code);
    }
    studentRepo
        .findById(student.getID())
        .orElseThrow(
            () ->
                new StudentException(
                    StudentExceptionEnum.COURSE_NOTFOUND_EXCEPTION.message,
                    StudentExceptionEnum.COURSE_NOTFOUND_EXCEPTION.code));
    Student updatedStudent = studentRepo.save(student);
    log.info("updated student with id :{}", updatedStudent.getID());
    return updatedStudent;
  }

  void deleteStudent(int id) {
    studentRepo.deleteById(id);
    log.info("deleted student with id :{}", id);
  }

  List<Student> getStudentsByInstructorId(Integer id) {
    return studentRepo.getStudentsByInstructorId(id);
  }

  long getCourseDurationByStudentId(Integer id) {
    return studentRepo.getCourseDurationByStudentId(id);
  }

  public Course_Student enroll(Course_Student courseStudent) {
    return courseStudentRepo.save(courseStudent);
  }
}
