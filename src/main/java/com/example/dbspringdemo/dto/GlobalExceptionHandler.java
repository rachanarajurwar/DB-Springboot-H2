package com.example.dbspringdemo.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


  @ExceptionHandler(RuntimeException.class)
  private ResponseEntity<ErrorDto> throwError(RuntimeException e){
return new ResponseEntity<ErrorDto>(new ErrorDto("wooohhooo"), HttpStatus.BAD_REQUEST);
  }

}
