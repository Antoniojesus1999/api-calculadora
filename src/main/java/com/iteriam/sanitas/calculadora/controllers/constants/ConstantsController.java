package com.iteriam.sanitas.calculadora.controllers.constants;

public final class ConstantsController {
    private ConstantsController(){}

    /**
     * Request completed successfully. Ok.
     */
    public static final String API_RESPONSE_200 = "Request completed successfully.";
    /**
     * Server error.
     */
    public static final String API_RESPONSE_500 = "Server error.";
    /**
     * Error operator.
     */
    public static final String ERROR_OPERATOR = "Falta operadores, Porfavor introduzca operador 1 y operador 2 para hacer el cálculo.";
    /**
     * Error operator not supported.
     */
    public static final String ERROR_OPERATOR_NOT_SUPPORTED = "Operación no soportada para el valor: ";

}