package com.warleydev.apimedic.services.exceptions;

public class InactiveException extends RuntimeException{
    public InactiveException(String msg){
        super(msg);
    }
}
