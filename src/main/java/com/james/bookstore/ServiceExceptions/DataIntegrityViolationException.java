package com.james.bookstore.ServiceExceptions;

public class DataIntegrityViolationException extends RuntimeException{

    public DataIntegrityViolationException(String arg0) {
        super(arg0);
    }

    public DataIntegrityViolationException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    
    
}
