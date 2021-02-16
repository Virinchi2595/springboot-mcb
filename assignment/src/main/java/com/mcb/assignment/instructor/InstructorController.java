package com.mcb.assignment.instructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1/instructors")
@CrossOrigin
@Validated
public class InstructorController {

  @Autowired private InstructorService instructorService;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<Instructor>> getInstructors() {
    return new ResponseEntity<>(instructorService.getAllInstructors(), HttpStatus.OK);
  }

  @PostMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Instructor> createInstructor(@Valid @RequestBody Instructor instructor) {
    return new ResponseEntity<>(instructorService.createInstructor(instructor), HttpStatus.CREATED);
  }

  @PutMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Instructor> updateInstructor(@Valid @RequestBody Instructor instructor) {
    return new ResponseEntity<>(instructorService.updateInstructor(instructor), HttpStatus.OK);
  }

  @DeleteMapping(
      value = "/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteInstructor(
      @NotNull @NotEmpty @PathVariable("id") Integer id) {
    instructorService.deleteInstructor(id);
    return new ResponseEntity<>(
        String.format("successfully deleted instructor with id %s", id), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Instructor> getInstructorById(
      @NotNull @NotEmpty @PathVariable("id") Integer id) {
    return new ResponseEntity<>(instructorService.getInstructorById(id), HttpStatus.OK);
  }
}
