package com.mcb.assignment.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@CrossOrigin
@Validated
public class CourseController {

  @Autowired private CourseService courseService;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<Course>> getCourses() {
    return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
  }

  @PostMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Course> createCourse(@Valid @RequestBody Course course) {
    return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
  }

  @PutMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Course> updateCourse(@Valid @RequestBody Course course) {
    return new ResponseEntity<>(courseService.updateCourse(course), HttpStatus.OK);
  }

  @DeleteMapping(
      value = "/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteCourse(@NotNull @NotEmpty @PathVariable("id") Integer id) {
    courseService.deleteCourse(id);
    return new ResponseEntity<>(
        String.format("successfully deleted course with id %s", id), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Course> getCourseById(@NotNull @NotEmpty @PathVariable("id") Integer id) {
    return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
  }

  @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Course>> getCourseByStudentId(
      @NotNull @NotEmpty @RequestParam("studentId") Integer id) {
    return new ResponseEntity<>(courseService.getCoursesByStudentId(id), HttpStatus.OK);
  }
}
