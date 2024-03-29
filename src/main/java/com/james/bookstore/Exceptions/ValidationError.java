package com.james.bookstore.Exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardErrors{

    private List<FieldMessage> errors = new ArrayList<>();


    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
        
        
    
}
