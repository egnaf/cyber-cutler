package io.github.egnaf.cybercutler.api.controller;

import io.github.egnaf.cybercutler.api.model.CalculatorRequest;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Marketplace {

    @GET("/marketplace")
    CalculatorRequest marketplace(@Query("x-ibm-client-id") String clientId);
}
