package com.codgin.paulocalado.splitt.Helpers;

import android.content.Context;
import android.content.Intent;

import com.codgin.paulocalado.splitt.Activity.TableListActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;

import java.util.Map;

/**
 * Created by Paulo on 03/10/2017.
 */

public class UserHelper {

    public static void searchUserHelper(final DocumentReference userReference,
                                        final Map<String, Object> user,
                                        final Context context){
       userReference.get()
               .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                   @Override
                   public void onSuccess(DocumentSnapshot documentSnapshot) {
                       if(documentSnapshot.exists()){

                           Intent intentList = new Intent(context, TableListActivity.class);
                           context.startActivity(intentList);
                       }else{

                           createUser(userReference, user);
                       }
                   }
               });


    }

    public static void createUser(DocumentReference userReference, Map<String, Object> user){
         userReference.set(user);
    }
}
