package com.iteriam.sanitas.calculadora.controllers;

import com.iteriam.sanitas.calculadora.controllers.constants.ConstantsController;
import com.iteriam.sanitas.calculadora.controllers.exception.model.NumParamsNullException;
import com.iteriam.sanitas.calculadora.controllers.impl.CalculatorControllerImpl;
import com.iteriam.sanitas.calculadora.controllers.responses.ResponseBase;
import com.iteriam.sanitas.calculadora.controllers.responses.get.OperationResult;
import com.iteriam.sanitas.calculadora.log.Logger;
import com.iteriam.sanitas.calculadora.models.Operator;
import com.iteriam.sanitas.calculadora.services.OperationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * CalculatorController test
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerImplTest {
    @InjectMocks
    private CalculatorControllerImpl operationsController;
    @Mock
    private OperationService operationsService;
    @Mock
    private Logger log;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test getOperation
     */
    @Test
    void getOperation() {
        when(operationsService.runOperation(any(), any(), any()))
                .thenReturn(BigDecimal.valueOf(2));

        BigDecimal operand1 = BigDecimal.ONE;
        BigDecimal operand2 = BigDecimal.ONE;
        Operator operator = Operator.ADD;
        BigDecimal expectedResponse = BigDecimal.valueOf(2);

        Mockito.when(operationsService.runOperation(operand1, operator.getOperatorValue(), operand2))
                .thenReturn(expectedResponse);

        ResponseEntity<ResponseBase<OperationResult>> result = operationsController.getOperation(operand1, operator, operand2);

        Mockito.verify(operationsService, Mockito.times(1)).runOperation(operand1, operator.getOperatorValue(), operand2);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(expectedResponse, Objects.requireNonNull(result.getBody()).getData().getResult());
    }

    @Test()
    @MockitoSettings(strictness = Strictness.LENIENT)
    void getOperationNumberException() {

        BigDecimal operand1 = null;
        Operator operator = Operator.ADD;
        BigDecimal operand2 = null;

        NumParamsNullException exception = assertThrows(NumParamsNullException.class, () -> {
            operationsController.getOperation(operand1, operator, operand2);
        });

        assertEquals(NumParamsNullException.class, exception.getClass());
        assertEquals(ConstantsController.ERROR_OPERATOR, exception.getMessage());

    }

    @Test
    public void testNullOperator() throws Exception {
        MockHttpServletRequestBuilder request = get("/operations")
                .param(ConstantsController.PARAM_NUM1, "10")
                .param(ConstantsController.PARAM_NUM2, "5");

        mockMvc.perform(request)
                .andExpect(status().isBadRequest());  // esperamos un error 400 Bad Request cuando operator es null
    }
    @Test
    public void testNullParamsNum() throws Exception {
        MockHttpServletRequestBuilder request = get("/operations")
                .param(ConstantsController.PARAM_OPERATOR, "ADD");

        mockMvc.perform(request)
                .andExpect(status().isBadRequest());  // esperamos un error 400 Bad Request cuando operator es null
    }
}
