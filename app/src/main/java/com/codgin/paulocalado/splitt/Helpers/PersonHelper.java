package com.codgin.paulocalado.splitt.Helpers;

import android.view.View;

import com.codgin.paulocalado.splitt.Control.PeopleLayoutControl;
import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.Person;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
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

                PeopleLayoutControl.setLayoutRVPeople(personList, modelGetPerson);
            }
        });
    }
}
