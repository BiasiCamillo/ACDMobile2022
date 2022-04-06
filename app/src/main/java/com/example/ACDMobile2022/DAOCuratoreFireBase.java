package com.example.ACDMobile2022;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOCuratoreFireBase {
    private DatabaseReference databaseReference;

    public DAOCuratoreFireBase() {
        FirebaseDatabase db = FirebaseDatabase.getInstance("https://acdmobile2022-default-rtdb.europe-west1.firebasedatabase.app");
        databaseReference = db.getReference(CuratoreFireBase.class.getSimpleName());
    }

    public Task<Void> add(CuratoreFireBase curatore){
        //if(curatore == null)  //throw exception
        return databaseReference.push().setValue(curatore);
    }
}
