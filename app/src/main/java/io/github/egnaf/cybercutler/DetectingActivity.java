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

public class DetectingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detecting);
    }

    public void openDetectedPage(View view) {

        // TODO: fix vtb api in future
        new Thread(() -> {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\"content\":\"sizcituhitadjao\"}");
            Request request = new Request.Builder()
                    .url("https://gw.hackathon.vtb.ru/vtb/hackathon/car-recognize")
                    .post(body)
                    .addHeader("x-ibm-client-id", "8442d3beff9d92637c51ad021e171ee8")
                    .addHeader("content-type", "application/json")
                    .addHeader("accept", "application/json")
                    .build();

            try {
                Response response = client.newCall(request).execute();
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Intent main = new Intent(this, DetectedActivity.class);
        startActivity(main);
    }
}