package com.example.ACDMobile2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       TextView dontHaveAccount = (TextView) findViewById(R.id.dontHaveAccount);

       dontHaveAccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openRegisterActivity();
           }
       });

    }

    public void openRegisterActivity (){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}