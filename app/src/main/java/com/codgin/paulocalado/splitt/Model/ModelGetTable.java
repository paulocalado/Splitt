package com.codgin.paulocalado.splitt.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;

/**
 * Created by paulocalado on 07/10/17.
 */

public class ModelGetTable {

    CollectionReference refTable;
    RecyclerView rvTable;
    Context context;
    ImageView imageEmpty;
    TextView textEmpty;
    User user;

    public ModelGetTable(CollectionReference refTable, RecyclerView rvTable, Context context, ImageView imageEmpty, TextView textEmpty) {
        this.refTable = refTable;
        this.rvTable = rvTable;
        this.context = context;
        this.imageEmpty = imageEmpty;
        this.textEmpty = textEmpty;
    }

    public ModelGetTable(RecyclerView rvTable, Context context, ImageView imageEmpty, TextView textEmpty, User user) {
        this.rvTable = rvTable;
        this.context = context;
        this.imageEmpty = imageEmpty;
        this.textEmpty = textEmpty;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CollectionReference getRefTable() {
        return refTable;
    }

    public void setRefTable(CollectionReference refTable) {
        this.refTable = refTable;
    }

    public RecyclerView getRvTable() {
        return rvTable;
    }

    public void setRvTable(RecyclerView rvTable) {
        this.rvTable = rvTable;
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
}
