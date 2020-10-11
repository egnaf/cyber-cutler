package io.github.egnaf.cybercutler.api.controller;

import java.util.Map;

import io.github.egnaf.cybercutler.api.model.CalculatorRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CarRecognition {

    @POST("/carRecognition")
    CalculatorRequest carRecognition(@Query("x-ibm-client-id") String clientId, @Body Map<String, Object> body);
}
