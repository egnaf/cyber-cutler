package io.github.egnaf.cybercutler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetectingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detecting);
    }

    public void openDetectedPage(View view) {
        Intent main = new Intent(this, DetectedActivity.class);
        startActivity(main);
    }
}