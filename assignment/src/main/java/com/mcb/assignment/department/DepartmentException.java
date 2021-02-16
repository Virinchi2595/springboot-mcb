package com.mcb.assignment.department;

import lombok.Data;

@Data
public class DepartmentException extends RuntimeException {

  private String message;
  private String code;

  public DepartmentException(String message, String code) {
    this.code = code;
    this.message = message;
  }
}
