package com.iteriam.sanitas.calculadora.exception;

import com.iteriam.sanitas.calculadora.Constant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OperatorExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMethodArgumentTypeMismatchException() throws Exception {
        mockMvc.perform(get("/operations")
                        .param("operand1", "100")
                        .param("operator", "valor-incorrecto-para-operator")
                        .param("operand2", "200")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError()) .andExpect(jsonPath("$.errorCode").value(500))
                .andExpect(jsonPath("$.errorMessage").value(Constant.ERROR_OPERATOR_NOT_SUPPORTED_TEST));
    }


}