package com.mcb.assignment.department;

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
@RequestMapping("/v1/departments")
@CrossOrigin
@Validated
public class DepartmentController {

  @Autowired private DepartmentService departmentService;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Iterable<Department>> getDepartments() {
    return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
  }

  @PostMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Department> createDepartment(@Valid @RequestBody Department Department) {
    return new ResponseEntity<>(departmentService.createDepartment(Department), HttpStatus.CREATED);
  }

  @PutMapping(
      value = "",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Department> updateDepartment(@Valid @RequestBody Department Department) {
    return new ResponseEntity<>(departmentService.updateDepartment(Department), HttpStatus.OK);
  }

  @DeleteMapping(
      value = "/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> deleteDepartment(
      @NotNull @NotEmpty @PathVariable("id") Integer id) {
    departmentService.deleteDepartment(id);
    return new ResponseEntity<>(
        String.format("successfully deleted Department with id %s", id), HttpStatus.OK);
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Department> getDepartmentById(
      @NotNull @NotEmpty @PathVariable("id") Integer id) {
    return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
  }
}
