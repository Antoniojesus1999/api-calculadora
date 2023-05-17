package com.iteriam.sanitas.calculadora.controllers;

import com.iteriam.sanitas.calculadora.controllers.constants.ConstantsController;
import com.iteriam.sanitas.calculadora.controllers.responses.ResponseBase;
import com.iteriam.sanitas.calculadora.controllers.responses.get.OperationResult;
import com.iteriam.sanitas.calculadora.models.Operator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Operations controller
 */
public interface CalculatorController {

    /**
     * Get operation result
     *
     * @return operation result
     */
    @Operation(
            summary = "Calculadora",
            description = "Calculadora suma y resta")
    @Tag(name = "API CALCULADORA", description = "Operations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = ConstantsController.API_RESPONSE_200),
            @ApiResponse(responseCode = "500", description = ConstantsController.API_RESPONSE_500)
            })
    @GetMapping(value = "/operations", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<ResponseBase<OperationResult>> getOperation(
            @RequestParam(value = "operand1",required = false) BigDecimal operand1,
            @RequestParam("operator")  Operator operator,
            @RequestParam(value = "operand2",required = false) BigDecimal operand2);



}
