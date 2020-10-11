package io.github.egnaf.cybercutler.api.controller;

import io.github.egnaf.cybercutler.api.model.CalculatorRequest;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Calculator {

    @POST("/calculator")
    CalculatorRequest calculate(@Query("x-ibm-client-id") String clientId);
}
