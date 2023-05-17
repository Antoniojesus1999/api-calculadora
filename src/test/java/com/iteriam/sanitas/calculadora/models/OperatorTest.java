package com.iteriam.sanitas.calculadora.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Operator test
 */
class OperatorTest {

    /**
     * Test Operator execution
     */
    @Test
    void getOperatorValueTest() {
        Operator result = Operator.fromValue("+");
        String expectedValue = result.getOperatorValue();
        String resultValue = "+";
        Assertions.assertEquals(expectedValue,resultValue);

    }

    @Test
    void fromValueTest() {
        Operator expected = Operator.ADD;
        Operator result = Operator.fromValue("+");
        Assertions.assertEquals(expected,result);
    }
}
