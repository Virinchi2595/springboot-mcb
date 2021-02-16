package com.mcb.assignment.instructor;

public enum InstructorExceptionEnum {
  ID_REQUIRED_EXCEPTION("instructor id is needed for update", "429"),
  INSTRUCTOR_NOTFOUND_EXCEPTION("cannot find instructor", "404");

  public String message;
  public String code;

  InstructorExceptionEnum(String message, String code) {
    this.message = message;
    this.code = code;
  }
}
