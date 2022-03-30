package com.example.ACDMobile2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ACDMobile2022.Fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addFragmentLogin();
//       TextView dontHaveAccount = (TextView) findViewById(R.id.dontHaveAccount);
//
//       dontHaveAccount.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               openRegisterActivity();
//           }
//       });

    }

    @Override
    protected void onResume() {
        super.onResume();
        addFragmentLogin();
    }

    public void openRegisterActivity (){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void addFragmentLogin(){
        LoginFragment loginFragment = new LoginFragment();
        Log.d("passo 1","sono all");
        getSupportFragmentManager().beginTransaction().add(R.id.frame_loginFragment,LoginFragment.class, null).commit();
    }
}