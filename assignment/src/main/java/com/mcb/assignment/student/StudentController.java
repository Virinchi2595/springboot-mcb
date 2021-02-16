package com.mcb.assignment.student;

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
@RequestMapping("/v1/students")
@CrossOrigin
@Validated
public class StudentController {
  @Autowired private StudentService studentService;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<Student>> getStudents() {
    return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
  }

  @PostMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
    return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
  }

  @PutMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student) {
    return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
  }

  @DeleteMapping(
      value = "/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteStudent(@NotNull @NotEmpty @PathVariable("id") Integer id) {
    studentService.deleteStudent(id);
    return new ResponseEntity<>(
        String.format("successfully deleted student with id %s", id), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Student> getStudentById(@NotNull @NotEmpty @PathVariable("id") Integer id) {
    return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
  }

  @GetMapping(value = "/instructor", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Student>> getStudentByStudentId(
      @NotNull @NotEmpty @RequestParam("instructorId") Integer id) {
    return new ResponseEntity<>(studentService.getStudentsByInstructorId(id), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}/course-duration", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Long> getCourseDurationByStudentId(
      @NotNull @NotEmpty @PathVariable("studentId") Integer id) {
    return new ResponseEntity<>(studentService.getCourseDurationByStudentId(id), HttpStatus.OK);
  }

  @PostMapping(value = "/enroll")
  public ResponseEntity<Course_Student> enroll(
      @NotNull @NotEmpty @RequestBody Course_Student courseStudent) {
    return new ResponseEntity<>(studentService.enroll(courseStudent), HttpStatus.OK);
  }
}
