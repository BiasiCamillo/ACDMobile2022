package com.example.ACDMobile2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ACDMobile2022.Fragment.RegisterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.ic_person);

    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        addRegisterFragment();
    }

    public void addRegisterFragment() {

        RegisterFragment registerFragment = new RegisterFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_register_activity, registerFragment)
                .commit();


    }

     public void alreadyHaveAnAccount(){
        TextView alreadyAccount = (TextView) findViewById(R.id.alreadyHaveAccouynt);
        alreadyAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(goLogin);
            }
        });
    }

    public void sendRegister(){

    }

    public void addAccountFirebase(){
        EditText nickname = findViewById(R.id.inputNickname);
        EditText email = findViewById(R.id.inputEmail);
        EditText password = findViewById(R.id.inputPassword);
        EditText confirmPassword = findViewById(R.id.inputConfirmPassword);
        Button btnRegister = findViewById(R.id.buttonRegister);
        DAOCuratoreFireBase dao = new DAOCuratoreFireBase();
        Log.d("passo0","passo0");
        btnRegister.setOnClickListener(view -> {
            CuratoreFireBase curatore = new CuratoreFireBase(nickname.getText().toString(),email.getText().toString(),password.getText().toString());
            dao.add(curatore).addOnSuccessListener(suc ->
            {
                Log.d("passo1","passo1");
                Toast.makeText(this,"Riga aggiunta",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->{
                Log.d("passo2","passo2");
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });


        });
    }


}