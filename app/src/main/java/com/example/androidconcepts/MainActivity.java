package com.example.androidconcepts;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private Button btnSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Hello World");
        btnSecondActivity = findViewById(R.id.btnSecondActivity);
        btnSecondActivity.setOnClickListener(view -> openSecondActivity());
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void openRetrofitActivity(View view) {
        startActivity(new Intent(this, Retrofit.class));
    }
}