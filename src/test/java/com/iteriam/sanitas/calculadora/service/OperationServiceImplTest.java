package com.iteriam.sanitas.calculadora.service;

import com.iteriam.sanitas.calculadora.services.impl.OperationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;


/**
 * OperationServiceImpl
 */

class OperationServiceImplTest {

    @InjectMocks
    private OperationServiceImpl operationService;

    @BeforeEach
    void setUp() {
        operationService = new OperationServiceImpl();
    }

    /**
     * runOperation Test
     */
    @Test
    void runOperationAddTest() {

        BigDecimal expected = BigDecimal.valueOf(2.40);
        BigDecimal result = operationService.runOperation(BigDecimal.valueOf(1.20),"+",BigDecimal.valueOf(1.20));
        Assertions.assertEquals(expected,result);
    }

    /**
     * runOperationSub Test
     */
    @Test
    void runOperationSubTest() {
        BigDecimal expected = BigDecimal.valueOf(1.10);
        BigDecimal result = operationService.runOperation(BigDecimal.valueOf(3.30),"-",BigDecimal.valueOf(2.20));
        Assertions.assertEquals(expected,result);
    }


}
