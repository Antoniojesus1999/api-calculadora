package com.iteriam.sanitas.calculadora.controllers.exception;

import com.iteriam.sanitas.calculadora.controllers.constants.ConstantsController;
import com.iteriam.sanitas.calculadora.controllers.exception.model.OperationErrorResponse;
import com.iteriam.sanitas.calculadora.controllers.exception.model.OperandNullException;
import com.iteriam.sanitas.calculadora.controllers.exception.model.OperatorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OperatorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<OperationErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return handleOperatorException(new OperatorException(ConstantsController.ERROR_OPERATOR_NOT_SUPPORTED+ ex.getValue()));

    }

    @ExceptionHandler(value = {OperatorException.class})
    public ResponseEntity<OperationErrorResponse> handleOperatorException(OperatorException ex) {
        OperationErrorResponse error = new OperationErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage()) ;
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {OperandNullException.class})
    public ResponseEntity<OperationErrorResponse> operandNullExceptionException(OperandNullException ex) {
        OperationErrorResponse error = new OperationErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage()) ;
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}