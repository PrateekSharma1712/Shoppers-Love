package com.prateek.shopperslove.dao.impl;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.prateek.shopperslove.dao.AppInfoDao;
import com.prateek.shopperslove.firebaseConnection.FirebaseConnection;
import com.prateek.shopperslove.model.AppInfo;
import com.prateek.shopperslove.model.AppList;

import java.util.List;

/**
 * Created by user on 8/5/2017.
 */

public class AppInfoDaoImpl implements AppInfoDao {
    FirebaseConnection firebaseConnection;
    @Override
    public List<AppInfo> fetchApplicationsInfo() {
        firebaseConnection = FirebaseConnection.getFirebaseConnection();
        DatabaseReference appDatabaseReference = firebaseConnection.APP_DATABASE_REFERENCE;
        final Query fetchAppInfoQuery = appDatabaseReference.orderByKey();
        fetchAppInfoQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("TAG", dataSnapshot.toString());
                AppList appInfos = dataSnapshot.getValue(AppList.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Hey nothing to do here !!
            }
        });
        return null;
    }
}
