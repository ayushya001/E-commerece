package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.ResponseModelClass.signup_response_model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
    EditText Remail,Rpass,Rmobile;
    Button r;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        Remail=findViewById(R.id.lemail);
        Rpass=findViewById(R.id.Rpassword);
        Rmobile=findViewById(R.id.Rmobile);
        tv = findViewById(R.id.signup_report);
        r=findViewById(R.id.Registerbttn);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userregister(Remail.getText().toString(),Rpass.getText().toString(),Rmobile.getText().toString());
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void userregister(String email,String password,String mobile){
        String name="not applicable";
        String address = "not appliciable";

        Call<signup_response_model> call=apicontroller.getInstance()
                .getapi()
                .getregister(name,email,password,mobile,address);
        call.enqueue(new Callback<signup_response_model>() {
            @Override
            public void onResponse(Call<signup_response_model> call, Response<signup_response_model> response) {
                signup_response_model obj = response.body();
                String result = obj.getMessage().trim();
                if (result.equals("inserted")){
                    tv.setText("Successfully registered");
                    Remail.setText("");
                    Rpass.setText("");
                    Rmobile.setText("");
                }
                if (result.equals("exist")){
                    tv.setText("sorry....! you are already registered");
                    Remail.setText("");
                    Rpass.setText("");
                    Rmobile.setText("");
                }
            }

            @Override
            public void onFailure(Call<signup_response_model> call, Throwable t) {
                tv.setText("Something went wrong");
                Toast.makeText(Register.this,t.toString(), Toast.LENGTH_SHORT).show();
                Remail.setText("");
                Rpass.setText("");
                Rmobile.setText("");
            }
        });

    }
}