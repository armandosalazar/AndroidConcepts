package com.example.androidconcepts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidconcepts.interfaces.UserApi;
import com.example.androidconcepts.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {
    private TextView textViewName, textViewUserName, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        textViewName = findViewById(R.id.textViewName);
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewEmail = findViewById(R.id.textViewEmail);
    }

    public void getUserById(View view) {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserApi userApi = retrofit.create(UserApi.class);
        Call<User> call = userApi.getUserById(1);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful()) {
                    User user = response.body();
                    assert user != null;
                    textViewName.setText(user.getName());
                    textViewUserName.setText(user.getUsername());
                    textViewEmail.setText(user.getEmail());
                    Toast.makeText(RetrofitActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Toast.makeText(RetrofitActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}