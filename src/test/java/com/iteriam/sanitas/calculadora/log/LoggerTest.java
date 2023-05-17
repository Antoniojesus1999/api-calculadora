package com.iteriam.sanitas.calculadora.log;

import com.iteriam.sanitas.calculadora.log.impl.LoggerImpl;
import io.corp.calculator.TracerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

/**
 * Logger test
 */
class LoggerTest {
    private LoggerImpl logger;
    private TracerImpl tracer;

    @BeforeEach
    void setUp() throws Exception {
        tracer = Mockito.spy(new TracerImpl());
        logger = new LoggerImpl();

        Field field = LoggerImpl.class.getDeclaredField("tracerImpl");
        field.setAccessible(true);
        field.set(logger, tracer);
    }

    /**
     * Trace test
     */
    @Test
    void traceTest() {
        String message1 = "5";
        String message2 = "text";

        logger.log(message1);
        logger.log(message2);

        verify(tracer, times(1)).trace(message1);
        verify(tracer, times(1)).trace(message2);
    }
}
