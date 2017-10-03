package com.codgin.paulocalado.splitt.Helpers;

import android.content.Context;
import android.content.Intent;

import com.codgin.paulocalado.splitt.Activity.TableListActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Paulo on 03/10/2017.
 */

public class UserHelper {

    public static void searchUserHelper(final DatabaseReference userReference, final Context context){
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Intent intentList = new Intent(context, TableListActivity.class);
                    context.startActivity(intentList);
                }else{
                    createUser(userReference);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static void createUser(DatabaseReference userReference){
         userReference.setValue("criando user");
    }
}
