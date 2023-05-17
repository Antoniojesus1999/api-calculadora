package com.iteriam.sanitas.calculadora.log.impl;

import com.iteriam.sanitas.calculadora.log.Logger;
import io.corp.calculator.TracerImpl;

public class LoggerImpl implements Logger {

    private TracerImpl tracerImpl;

    /**
     * Empty constructor
     */
    public LoggerImpl() {
        this.tracerImpl = new TracerImpl();
    }

    private TracerImpl getTracerImpl() {
        return tracerImpl == null ?  new TracerImpl() : tracerImpl;
    }

    @Override
    public void log(String message) {
        getTracerImpl().trace(message);
    }
}
