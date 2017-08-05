package com.prateek.shopperslove.firebaseConnection;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by user on 8/5/2017.
 */

public class FirebaseConnection {
    public static FirebaseDatabase FIREBASE_DATABASE;
    public static DatabaseReference APP_DATABASE_REFERENCE;
    public static FirebaseStorage FIREBASE_STORAGE;
    public static StorageReference APP_LOGO_REFERENCE;
    private static FirebaseConnection firebaseConnection = null;

    public FirebaseConnection() {
        FIREBASE_DATABASE = FirebaseDatabase.getInstance();
        APP_DATABASE_REFERENCE = FIREBASE_DATABASE.getReference();
        FIREBASE_STORAGE = FirebaseStorage.getInstance();
        APP_LOGO_REFERENCE = FIREBASE_STORAGE.getReference().child("applogos");
    }

    public static FirebaseConnection getFirebaseConnection(){
        if(firebaseConnection == null) {
            firebaseConnection = new FirebaseConnection();
        }
       return firebaseConnection;
    }
}
