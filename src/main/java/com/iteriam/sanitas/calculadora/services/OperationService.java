package com.iteriam.sanitas.calculadora.services;

import java.math.BigDecimal;

public interface OperationService {
    BigDecimal runOperation(BigDecimal operand1, String operation, BigDecimal operand2);
}
