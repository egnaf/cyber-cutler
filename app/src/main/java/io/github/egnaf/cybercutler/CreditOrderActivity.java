package io.github.egnaf.cybercutler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreditOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_order);
    }

    public void openOrderedPage(View view) {
        Intent main = new Intent(this, OrderedActivity.class);
        startActivity(main);
    }
}