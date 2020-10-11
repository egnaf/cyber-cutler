package io.github.egnaf.cybercutler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    private TextView welcome;
    private ConstraintLayout welcomeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcome = findViewById(R.id.text_welcome);
        welcomeLayout = findViewById(R.id.welcome_layout);

        welcome.setText("Привет, Саша!");
    }

    public void openMainPage(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
