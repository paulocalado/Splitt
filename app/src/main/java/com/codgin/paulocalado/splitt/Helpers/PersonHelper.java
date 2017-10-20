package com.codgin.paulocalado.splitt.Helpers;

import android.view.View;

import com.codgin.paulocalado.splitt.Control.PeopleLayoutControl;
import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulocalado on 13/10/17.
 */

public class PersonHelper {

    public static void getPeopleHelper(final ModelGetPerson modelGetPerson){
        final List<Person> personList = new ArrayList<>();
        final DocumentReference tableRef = FirebaseFirestore.getInstance().document("users/"+
                        modelGetPerson.getUser().getIdUser()+"/tables/"+modelGetPerson.getTable().getNameTable());

        modelGetPerson.getRefPerson().addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(personList.size()>0){
                    personList.clear();
                }
                for(DocumentSnapshot document : documentSnapshots){
                    personList.add(document.toObject(Person.class));
                }
                if(personList.size()==0){
                    modelGetPerson.getImageEmpty().setVisibility(View.VISIBLE);
                    modelGetPerson.getTextEmpty().setVisibility(View.VISIBLE);
                }else{
                    modelGetPerson.getImageEmpty().setVisibility(View.GONE);
                    modelGetPerson.getTextEmpty().setVisibility(View.GONE);
                }
                tableRef.update("qtPeople", personList.size());

                PeopleLayoutControl.setLayoutRVPeople(personList, modelGetPerson);
            }
        });
    }

    public static List<Person> getPeopleToAddProduct(User user, Table table){
        final List<Person> personList = new ArrayList<>();
        CollectionReference personRef = FirebaseFirestore.getInstance().collection("users/"+
                user.getIdUser()+"/tables/"+table.getNameTable()+
                "/people");

        personRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(personList.size()>0){
                    personList.clear();
                }
                for(DocumentSnapshot document : documentSnapshots){
                    personList.add(document.toObject(Person.class));
                }
            }
        });

        return personList;
    }
}
