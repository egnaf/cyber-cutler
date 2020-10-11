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

public class DetectedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detected);
    }

    public void openCreditPage(View view) {
        Intent main = new Intent(this, CreditOrderActivity.class);

        // TODO: fix vtb api in future
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"comment\":\"Комментарий\",\"customer_party\":{\"email\":\"apetrovich@example.com\",\"income_amount\":140000,\"person\":{\"birth_date_time\":\"1981-11-01\",\"birth_place\":\"г. Воронеж\",\"family_name\":\"Иванов\",\"first_name\":\"Иван\",\"gender\":\"female\",\"middle_name\":\"Иванович\",\"nationality_country_code\":\"RU\"},\"phone\":\"+99999999999\"},\"datetime\":\"2020-10-10T08:15:47Z\",\"interest_rate\":15.7,\"requested_amount\":300000,\"requested_term\":36,\"trade_mark\":\"Mazda\",\"vehicle_cost\":600000}");
            Request request = new Request.Builder()
                    .url("https://gw.hackathon.vtb.ru/vtb/hackathon/carloan")
                    .post(body)
                    .addHeader("x-ibm-client-id", "8442d3beff9d92637c51ad021e171ee8")
                    .addHeader("content-type", "application/json")
                    .addHeader("accept", "application/json")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                System.out.println(response);
            } catch (IOException e) {
                // ignore
            }
        }).start();

        startActivity(main);
    }
}