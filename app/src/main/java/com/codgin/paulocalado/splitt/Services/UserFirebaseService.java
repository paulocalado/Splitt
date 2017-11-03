package com.codgin.paulocalado.splitt.Services;

import android.content.Context;

import com.codgin.paulocalado.splitt.Helpers.UserHelper;
import com.codgin.paulocalado.splitt.Model.User;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

/**
 * Created by Paulo on 03/10/2017.
 */

public class UserFirebaseService {

    public static void searchUser(final User user, Context context){

        DocumentReference userFirestoreReference = FirebaseFirestore.getInstance().document("users/"+user.getIdUser());
        UserHelper.searchUserHelper(userFirestoreReference, user,context);
    }
}
