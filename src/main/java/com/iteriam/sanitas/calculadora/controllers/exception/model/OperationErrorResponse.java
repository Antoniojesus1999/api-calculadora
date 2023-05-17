package com.iteriam.sanitas.calculadora.controllers.exception.model;

import lombok.Getter;

@Getter
public class OperationErrorResponse {

    private int errorCode;

    private String errorMessage;
    public OperationErrorResponse(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
