package com.iteriam.sanitas.calculadora.services.impl;


import com.iteriam.sanitas.calculadora.models.Operator;
import com.iteriam.sanitas.calculadora.services.OperationService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OperationServiceImpl implements OperationService {


    @Override
    public BigDecimal runOperation(BigDecimal operand1, String operation,BigDecimal operand2) {
        Operator operator = Operator.fromValue(operation);

        return switch (operator) {
            case ADD -> operand1.add(operand2);
            case SUB -> operand1.subtract(operand2);
        };

    }

}
