package com.iteriam.sanitas.calculadora.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * Class Operator
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Operator {
    ADD("+"),
    SUB("-");

    private String operatorValue;

    @JsonCreator
    public static Operator fromValue(String value) {
        return Arrays.stream(values())
                .filter(operator -> operator.name().equalsIgnoreCase(value)
                        || operator.operatorValue.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Operación no soportada para el valor: " + value));
    }

}
