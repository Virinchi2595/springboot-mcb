package com.mcb.assignment.course;

public enum CourseExceptionEnum {
  ID_REQUIRED_EXCEPTION("course id is needed for update", "429"),
  COURSE_NOTFOUND_EXCEPTION("cannot find course", "404");

  public String message;
  public String code;

  CourseExceptionEnum(String message, String code) {
    this.message = message;
    this.code = code;
  }
}
