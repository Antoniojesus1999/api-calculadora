package com.iteriam.sanitas.calculadora.exception;

import com.iteriam.sanitas.calculadora.Constant;
import com.iteriam.sanitas.calculadora.controllers.constants.ConstantsController;
import com.iteriam.sanitas.calculadora.services.OperationService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class OperatorExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private OperationService operationService;
    @InjectMocks
    private OperatorExceptionHandlerTest operatorExceptionHandlerTest;

    @Test
    void testMethodArgumentTypeMismatchException() throws Exception {
        mockMvc.perform(get("/operations")
                        .param(ConstantsController.PARAM_NUM1, "100")
                        .param(ConstantsController.PARAM_OPERATOR, "valor-incorrecto-para-operator")
                        .param(ConstantsController.PARAM_NUM2, "200")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError()) .andExpect(jsonPath("$.errorCode").value(500))
                .andExpect(jsonPath("$.errorMessage").value(Constant.ERROR_OPERATOR_NOT_SUPPORTED_TEST));
    }

    private ResultActions asyncGet(String route) throws Exception {
        return asyncGet(route, null);
    }

    private ResultActions asyncGet(String route, HttpHeaders headers) throws Exception {
        MockHttpServletRequestBuilder builder = get(route);

        if(headers != null) {
            builder.headers(headers);
        }

        MvcResult resultActions = mockMvc.perform(builder)
                .andExpect(request().asyncStarted())
                .andReturn();

        return mockMvc.perform(asyncDispatch(resultActions));
    }


}