package io.github.egnaf.cybercutler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CreditOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_order);
    }

    public void openOrderedPage(View view) {

        // TODO: fix vtb api in future
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"clientTypes\":[\"ac43d7e4-cd8c-4f6f-b18a-5ccbc1356f75\"],\"cost\":850000,\"initialFee\":200000,\"kaskoValue\":28912427,\"language\":\"ru-RU\",\"residualPayment\":29.96878612,\"settingsName\":\"Haval\",\"specialConditions\":[\"57ba0183-5988-4137-86a6-3d30a4ed8dc9\",\"b907b476-5a26-4b25-b9c0-8091e9d5c65f\",\"cbfc4ef3-af70-4182-8cf6-e73f361d1e68\"],\"term\":5}");
            Request request = new Request.Builder()
                    .url("https://gw.hackathon.vtb.ru/vtb/hackathon/calculate")
                    .post(body)
                    .addHeader("x-ibm-client-id", "8442d3beff9d92637c51ad021e171ee8")
                    .addHeader("content-type", "application/json")
                    .addHeader("accept", "application/json")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                System.out.println(response);
            } catch (IOException ignored) {
            }
        }).start();

        Intent main = new Intent(this, OrderedActivity.class);
        startActivity(main);
    }
}
