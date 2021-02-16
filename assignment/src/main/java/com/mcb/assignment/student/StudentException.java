package com.mcb.assignment.student;

import lombok.Data;

@Data
public class StudentException extends RuntimeException {

  private String message;
  private String code;

  public StudentException(String message, String code) {
    this.code = code;
    this.message = message;
  }
}
