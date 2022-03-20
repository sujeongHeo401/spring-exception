package com.example.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println(e.getClass().getName());
        System.out.println("------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("------------------");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }
    /// 특정 메소드의 예외만 잡는다
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity exception(Exception e){
//        System.out.println("------------------");
//        System.out.println(e.getLocalizedMessage());
//        System.out.println("------------------");
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
//    }
}
