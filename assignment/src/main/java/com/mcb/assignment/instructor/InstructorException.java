package com.mcb.assignment.instructor;

import lombok.Data;

@Data
public class InstructorException extends RuntimeException {

  private String message;
  private String code;

  public InstructorException(String message, String code) {
    this.code = code;
    this.message = message;
  }
}
