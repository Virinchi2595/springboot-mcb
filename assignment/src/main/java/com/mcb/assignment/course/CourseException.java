package com.mcb.assignment.course;

import lombok.Data;

@Data
public class CourseException extends RuntimeException {

  private String message;
  private String code;

  public CourseException(String message, String code) {
    this.code = code;
    this.message = message;
  }
}
