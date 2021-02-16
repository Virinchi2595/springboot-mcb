package com.mcb.assignment.course;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CourseService {

  @Autowired private CourseRepo courseRepo;

  Iterable<Course> getAllCourses() {

    return courseRepo.findAll();
  }

  Course getCourseById(Integer id) {
    return courseRepo
        .findById(id)
        .orElseThrow(
            () ->
                new CourseException(
                    CourseExceptionEnum.COURSE_NOTFOUND_EXCEPTION.message,
                    CourseExceptionEnum.COURSE_NOTFOUND_EXCEPTION.code));
  }

  Course createCourse(Course course) {
    Course savedCourse = courseRepo.save(course);
    log.info("created course with id :{}", savedCourse.getID());
    return savedCourse;
  }

  Course updateCourse(Course course) {
    if (course.getID() == null) {
      throw new CourseException(
          CourseExceptionEnum.ID_REQUIRED_EXCEPTION.message,
          CourseExceptionEnum.ID_REQUIRED_EXCEPTION.code);
    }
    courseRepo
        .findById(course.getID())
        .orElseThrow(
            () ->
                new CourseException(
                    CourseExceptionEnum.COURSE_NOTFOUND_EXCEPTION.message,
                    CourseExceptionEnum.COURSE_NOTFOUND_EXCEPTION.code));
    Course updatedCourse = courseRepo.save(course);
    log.info("updated course with id :{}", updatedCourse.getID());
    return updatedCourse;
  }

  void deleteCourse(int id) {
    courseRepo.deleteById(id);
    log.info("deleted course with id :{}", id);
  }

  List<Course> getCoursesByStudentId(Integer id) {
    return courseRepo.getCoursesByStudentId(id);
  }
}
