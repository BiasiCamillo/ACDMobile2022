package com.example.ACDMobile2022;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
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
    private static final int ID_PERMESSO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        replaceFragment(new HomeFragment());
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},ID_PERMESSO);




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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {

            case ID_PERMESSO: {

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                    //Viene attivata la fotocamera
                } else {

                    AlertDialog.Builder gestionePermessoRifiutato = new AlertDialog.Builder(this);
                    gestionePermessoRifiutato.setTitle("Permesso Rifiutato");
                    gestionePermessoRifiutato.setMessage("Per utilizzare l'applicazione abbiamo necessariamente bisogno del permesso" +
                            "in quanto fondamentale per l'utilizzo dell'applicazione, premi Si per dare il permesso, premi No per non" +
                            "dare il permesso");
                    gestionePermessoRifiutato.setCancelable(false);
                    gestionePermessoRifiutato.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        grantResults [0]= PackageManager.PERMISSION_GRANTED;

                        }
                    });
                    gestionePermessoRifiutato.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });


                    gestionePermessoRifiutato.show();

                }
            }


        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}