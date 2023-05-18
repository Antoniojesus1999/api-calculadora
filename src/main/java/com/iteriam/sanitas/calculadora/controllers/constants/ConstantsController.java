package com.iteriam.sanitas.calculadora.controllers.constants;

public final class ConstantsController {
    private ConstantsController() {
    }

    /**
     * Request completed successfully. Ok.
     */
    public static final String API_RESPONSE_200 = "Request completed successfully.";
    /**
     * Server error.
     */
    public static final String API_RESPONSE_500 = "Server error.";

    /**
     * Error operator not supported.
     */
    public static final String ERROR_OPERATOR_NOT_SUPPORTED = "Operación no soportada para el valor: ";

    /**
     * The constant PARAM_NUM1
     */
    public static final String PARAM_NUM1 = "operand1";
    /**
     * The constant PARAM_NUM2
     */
    public static final String PARAM_NUM2 = "operand2";

    /**
     * The constant PARAM_OPERATOR
     */
    public static final String PARAM_OPERATOR = "operator";

    /**
     * error operand test.
     */
    public static final String ERROR_OPERATOR = "Falta el parámetro operador, Por favor introduzca un operador válido ADD o SUB.";
    /**
     * Error operator.
     */
    public static final String ERROR_NUM_NULL = "Falta operadores, Por favor introduzca operador 1 y operador 2 para hacer el cálculo.";
}