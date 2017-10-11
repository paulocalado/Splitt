package com.codgin.paulocalado.splitt.Services;

import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by paulocalado on 11/10/17.
 */

public class PersonFirebaseService {

        public static void createPersonFirebase(User user, Table table, Person person){
            DocumentReference tableRef = FirebaseFirestore.getInstance().document("users/"+user.getIdUser()+
                    "/tables/"+table.getNameTable()+"/people/"+person.getName());

            tableRef.set(person);
        }
}
