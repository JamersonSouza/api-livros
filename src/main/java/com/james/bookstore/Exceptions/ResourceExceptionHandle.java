package com.james.bookstore.Exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.james.bookstore.ServiceExceptions.DataIntegrityViolationException;
import com.james.bookstore.ServiceExceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardErrors> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
        StandardErrors error = new StandardErrors(System.currentTimeMillis(), 
        HttpStatus.NOT_FOUND.value(),
         e.getMessage());

         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardErrors> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
        StandardErrors error = new StandardErrors(System.currentTimeMillis(), 
        HttpStatus.BAD_REQUEST.value(),
         e.getMessage());

         return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
    }
    
}
