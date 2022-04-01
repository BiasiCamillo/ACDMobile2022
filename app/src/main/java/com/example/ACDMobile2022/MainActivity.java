package com.example.ACDMobile2022;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ACDMobile2022.Fragment.HomeFragment;
import com.example.ACDMobile2022.Fragment.LoginFragment;
import com.example.ACDMobile2022.Fragment.SettingsFragment;
import com.example.ACDMobile2022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button button;
    ActivityMainBinding activityMainBinding;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        replaceFragment(new HomeFragment());



        activityMainBinding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.ic_home:
                    Intent goHome = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(goHome);
                    break;
                case R.id.ic_person:
                    Intent goLogin = new Intent(this, LoginActivity.class);
                    startActivity(goLogin);

                    break;
                case R.id.ic_settings:
                    //Intent goSettings = new Intent()
                    break;
            }



            return true;
        } );

    }


    /*
        onResume():
        Qui vengono inserire dei primi processi all'inizio di tutto
        Qui vengono inserite animazioni , brani etc...
     */

     /*
        onPause():
        Qui bisogna salvare uno stato persistente.
        Vengono richiamati i metodi del salvataggio dello Stato e viene richiamato onSaveInstanceSave
     */

    /*
        onStop():
        Qui non si trovano, dati poichè l'activity può essere killata
        Viene eseiguito per interrompere l'animazioni e cambiare l'interfaccia utente
        Se si recupera l'activity segue l'onRestart, altrimenti segue l' OnDestroy
     */

    /*
        onDestroy():
        E' l'ultima chiamata che ricevi prima che l'activity venga distrutta
        O vine chiamato activityFinish, oppure il sistema sta distruggendo l'Activity
     */


    @Override
    protected void onDestroy() {
        Toast.makeText(this, "L'app è stata chiusa", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar,menu);
        return true;

    }
}