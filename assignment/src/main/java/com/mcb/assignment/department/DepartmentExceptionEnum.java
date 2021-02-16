package com.mcb.assignment.department;

public enum DepartmentExceptionEnum {
  ID_REQUIRED_EXCEPTION("department id is needed for update", "429"),
  DEPARTMENT_NOTFOUND_EXCEPTION("cannot find deparment", "404");

  public String message;
  public String code;

  DepartmentExceptionEnum(String message, String code) {
    this.message = message;
    this.code = code;
  }
}
