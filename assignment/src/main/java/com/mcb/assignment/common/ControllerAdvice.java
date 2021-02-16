package com.mcb.assignment.common;

import com.mcb.assignment.auth.AuthException;
import com.mcb.assignment.course.CourseException;
import com.mcb.assignment.department.DepartmentException;
import com.mcb.assignment.instructor.InstructorException;
import com.mcb.assignment.student.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessage handleMethodArgument(MethodArgumentNotValidException exception) {
    List<String> errorMessages = new ArrayList<>();
    exception
        .getBindingResult()
        .getAllErrors()
        .forEach(e -> errorMessages.add(e.getDefaultMessage()));
    return new ErrorMessage("400", errorMessages);
  }

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessage handleAuthException(AuthException exception) {

    return new ErrorMessage(exception.getCode(), Collections.singletonList(exception.getMessage()));
  }

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessage handleCourseException(CourseException exception) {
    return new ErrorMessage(exception.getCode(), Collections.singletonList(exception.getMessage()));
  }

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessage handleDepartmentException(DepartmentException exception) {
    return new ErrorMessage(exception.getCode(), Collections.singletonList(exception.getMessage()));
  }

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessage handleStudentException(StudentException exception) {
    return new ErrorMessage(exception.getCode(), Collections.singletonList(exception.getMessage()));
  }

  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessage handleInstructorException(InstructorException exception) {
    return new ErrorMessage(exception.getCode(), Collections.singletonList(exception.getMessage()));
  }
}
