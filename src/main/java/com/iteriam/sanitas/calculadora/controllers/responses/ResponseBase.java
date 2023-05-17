package com.iteriam.sanitas.calculadora.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseBase<T> {

    private final T data;
}
