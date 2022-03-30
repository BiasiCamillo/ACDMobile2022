package com.example.ACDMobile2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent goLogin = new Intent(this, LoginActivity.class);
        startActivity(goLogin);

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


}