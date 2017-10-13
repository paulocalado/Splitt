package com.codgin.paulocalado.splitt.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;

/**
 * Created by paulocalado on 13/10/17.
 */

public class ModelGetPerson {
    CollectionReference refPerson;
    RecyclerView rvPerson;
    Context context;
    ImageView imageEmpty;
    TextView textEmpty;
    User user;
    Table table;

    public ModelGetPerson(
                          RecyclerView rvPerson, Context context,
                          ImageView imageEmpty, TextView textEmpty,
                          User user, Table table) {

        this.rvPerson = rvPerson;
        this.context = context;
        this.imageEmpty = imageEmpty;
        this.textEmpty = textEmpty;
        this.user = user;
        this.table = table;
    }


    public CollectionReference getRefPerson() {
        return refPerson;
    }

    public void setRefPerson(CollectionReference refPerson) {
        this.refPerson = refPerson;
    }

    public RecyclerView getRvPerson() {
        return rvPerson;
    }

    public void setRvPerson(RecyclerView rvPerson) {
        this.rvPerson = rvPerson;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ImageView getImageEmpty() {
        return imageEmpty;
    }

    public void setImageEmpty(ImageView imageEmpty) {
        this.imageEmpty = imageEmpty;
    }

    public TextView getTextEmpty() {
        return textEmpty;
    }

    public void setTextEmpty(TextView textEmpty) {
        this.textEmpty = textEmpty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
