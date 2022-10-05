package com.example.demo.exception;

public class VoterDataNotFoundException extends Exception{
    public VoterDataNotFoundException() {
        super();
    }

    public VoterDataNotFoundException(String message) {
        super(message);
    }

    public VoterDataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VoterDataNotFoundException(Throwable cause) {
        super(cause);
    }

    protected VoterDataNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
