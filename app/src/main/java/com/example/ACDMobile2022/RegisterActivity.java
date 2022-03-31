package com.example.ACDMobile2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ACDMobile2022.Fragment.RegisterFragment;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //TextView alreadyHaveAccount = (TextView) findViewById(R.id.alreadyHaveAccouynt);
        //alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //openLoginActivity();

            }
      //  });
    //}

  //  public void openLoginActivity(){
    //    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
      //  startActivity(intent);
    //}

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addRegisterFragment();
    }

    public void addRegisterFragment(){

        RegisterFragment registerFragment = new RegisterFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_register_activity,registerFragment)
                .commit();



    }



}