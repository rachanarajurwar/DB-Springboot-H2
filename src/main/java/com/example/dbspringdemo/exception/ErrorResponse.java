package com.example.dbspringdemo.exception;


import org.springframework.http.HttpStatus;

public class ErrorResponse {

  private HttpStatus status;
  private String message;
  private Throwable throwable;

  public ErrorResponse(HttpStatus status, String message, Throwable throwable) {
    this.status = status;
    this.message = message;
    this.throwable = throwable;
  }


}
