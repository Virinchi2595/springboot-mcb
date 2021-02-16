package com.mcb.assignment.auth;

import lombok.Data;

@Data
public class AuthException extends RuntimeException {

  private String message;
  private String code;

  public AuthException(String message, String code) {
    this.code = code;
    this.message = message;
  }
}
