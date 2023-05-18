package com.iteriam.sanitas.calculadora.controllers.exception.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class NumParamsNullException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 8852049938063608993L;

    public NumParamsNullException(String message) {
        super(message);
    }
}
