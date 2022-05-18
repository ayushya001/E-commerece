package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.example.e_commerce.MainActivity2.ui.MainActivity2;
import com.example.e_commerce.ResponseModelClass.login_response_model;
import com.example.e_commerce.ResponseModelClass.signup_response_model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView dontacc,report;
    EditText lemail,lpassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        lemail=findViewById(R.id.lemail);
        report=findViewById(R.id.report);
        lpassword=findViewById(R.id.password);
        login = findViewById(R.id.logbtn);

        Verifyuserexistance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processlogin(lemail.getText().toString(),lpassword.getText().toString());
            }
        });
        dontacc = findViewById(R.id.dontacc);
        dontacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void processlogin(String email,String password ){
        Call<login_response_model> call=apicontroller.getInstance()
                .getapi()
                .getlogin(email,password);
        call.enqueue(new Callback<login_response_model>() {
            @Override
            public void onResponse(Call<login_response_model> call, Response<login_response_model> response) {
                login_response_model obj = response.body();
                String result = obj.getMessage().trim();
                if (result.equals("exist")){
                    SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
                    SharedPreferences.Editor editor =sp.edit();
                    editor.putString("username",email);
                    editor.putString("password",password);
                    editor.commit();
                    editor.apply();
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    startActivity(intent);
                    finish();
                }
                if (result.equals("Not_exist")){
                    report.setText("Invalid username and password");
                    lemail.setText("");
                    lpassword.setText("");
                }
            }
            @Override
            public void onFailure(Call<login_response_model> call, Throwable t) {
                report.setText("Something went wrong");
                lemail.setText("");
                Log.e("ayushdb", "onFailure: "+t.getMessage() );
                //Rpass.setText("");
            }
        });
    }
    public  void Verifyuserexistance(){
        SharedPreferences sp = getSharedPreferences("credentials",MODE_PRIVATE);
        if (sp.contains("username"))
            startActivity(new Intent(getApplicationContext(),MainActivity2.class));
    }
}