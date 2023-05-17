package com.iteriam.sanitas.calculadora.controllers.impl;

import com.iteriam.sanitas.calculadora.controllers.CalculatorController;
import com.iteriam.sanitas.calculadora.controllers.constants.ConstantsController;
import com.iteriam.sanitas.calculadora.controllers.exception.model.OperandNullException;
import com.iteriam.sanitas.calculadora.controllers.responses.ResponseBase;
import com.iteriam.sanitas.calculadora.controllers.responses.get.OperationResult;
import com.iteriam.sanitas.calculadora.log.Logger;
import com.iteriam.sanitas.calculadora.models.Operator;
import com.iteriam.sanitas.calculadora.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Calculator controller
 */
@RestController
public class CalculatorControllerImpl implements CalculatorController {

    @Autowired
    private OperationService operationsService;
    @Autowired
    private Logger logger;

    @Override
    public ResponseEntity<ResponseBase<OperationResult>> getOperation(BigDecimal operand1, Operator operator, BigDecimal operand2) {
        if (operand1 == null || operand2 == null) {
            throw new OperandNullException(ConstantsController.ERROR_OPERATOR);
        }
        BigDecimal response = operationsService.runOperation(operand1, operator.getOperatorValue(), operand2);
        logger.log(String.valueOf(response));
        return new ResponseEntity<>(new ResponseBase<>(new OperationResult(response)), HttpStatus.OK);
    }


}

