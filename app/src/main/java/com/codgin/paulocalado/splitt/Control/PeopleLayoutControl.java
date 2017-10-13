package com.codgin.paulocalado.splitt.Control;

import android.support.v7.widget.LinearLayoutManager;

import com.codgin.paulocalado.splitt.Adapters.PeopleAdapter;
import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.Person;

import java.util.List;

/**
 * Created by paulocalado on 13/10/17.
 */

public class PeopleLayoutControl {

    public static void setLayoutRVPeople(final List<Person> personList, ModelGetPerson modelGetPerson){
        PeopleAdapter adapter = new PeopleAdapter(personList);
        LinearLayoutManager llm = new LinearLayoutManager(modelGetPerson.getContext());
        modelGetPerson.getRvPerson().setLayoutManager(llm);
        modelGetPerson.getRvPerson().setAdapter(adapter);
    }
}
