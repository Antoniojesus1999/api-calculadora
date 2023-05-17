package com.iteriam.sanitas.calculadora.controllers.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class OperationResult {

    private final BigDecimal result;
}
