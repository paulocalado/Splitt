package com.codgin.paulocalado.splitt.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;

import java.util.List;

/**
 * Created by paulocalado on 16/10/17.
 */

public class ModelGetProduct {
    CollectionReference refProduct;
    RecyclerView rvProduct;
    Context context;
    ImageView imageEmpty;
    TextView textEmpty;
    List<Person> personList;
    User user;
    Table table;

    public ModelGetProduct(RecyclerView rvProduct, Context context, ImageView imageEmpty, TextView textEmpty, User user, Table table) {
        this.rvProduct = rvProduct;
        this.context = context;
        this.imageEmpty = imageEmpty;
        this.textEmpty = textEmpty;
        this.user = user;
        this.table = table;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public CollectionReference getRefProduct() {
        return refProduct;
    }

    public void setRefProduct(CollectionReference refProduct) {
        this.refProduct = refProduct;
    }

    public RecyclerView getRvProduct() {
        return rvProduct;
    }

    public void setRvProduct(RecyclerView rvProduct) {
        this.rvProduct = rvProduct;
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
