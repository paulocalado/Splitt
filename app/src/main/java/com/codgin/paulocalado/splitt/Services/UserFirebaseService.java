package com.codgin.paulocalado.splitt.Services;

import android.content.Context;

import com.codgin.paulocalado.splitt.Helpers.UserHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Paulo on 03/10/2017.
 */

public class UserFirebaseService {
    static DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();

    public static void searchUser(final String idUser, Context context){
    DatabaseReference userReference = firebaseReference.child("users/"+idUser);
        UserHelper.searchUserHelper(userReference, context);
    }
}
