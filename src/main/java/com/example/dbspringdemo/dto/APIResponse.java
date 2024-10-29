package com.example.dbspringdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {

   int totalCount;
    T response;
   // int code;

  public APIResponse(final T response){
    this.response = response;
  }

}
