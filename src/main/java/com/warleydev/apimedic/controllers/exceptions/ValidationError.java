package com.warleydev.apimedic.controllers.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandardError{

    private List<FieldMessage> erros = new ArrayList<>();

    public void addError(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }

}
