package com.example.ACDMobile2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ACDMobile2022.Fragment.LoginFragment;
import com.example.ACDMobile2022.Fragment.RegisterFragment;
import com.example.ACDMobile2022.databinding.FragmentLoginBinding;

public class LoginActivity extends AppCompatActivity {

    FragmentLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(getApplicationContext(),"Cliccato!",Toast.LENGTH_LONG);
        Log.d("Ciao","ciao");


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Inflate the layout for this fragment
        Toast.makeText(getApplicationContext(),"Cliccato!",Toast.LENGTH_LONG);
        binding.dontHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Cliccato!",Toast.LENGTH_LONG);
                replaceFragment(new RegisterFragment());
            }
        });

    }

    public void openRegisterActivity (){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}