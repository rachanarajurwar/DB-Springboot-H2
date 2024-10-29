package com.example.dbspringdemo.exception;

import com.example.dbspringdemo.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IllegalArgumentDemoServiceException {

  @ExceptionHandler(value = {ResourceNotFoundException.class})
  public APIResponse<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
    ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST,ex.getLocalizedMessage(),ex.getCause());
    return new APIResponse<>(error);
  }



}
