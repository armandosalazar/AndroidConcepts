package com.example.androidconcepts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void goToMainActivity(View view) {
        Log.d("[<<<<<<<>>>>>>]", "Home");
    }
}