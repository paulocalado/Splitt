package com.codgin.paulocalado.splitt.Services;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.codgin.paulocalado.splitt.Helpers.TableHelper;
import com.codgin.paulocalado.splitt.Model.ModelGetTable;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * Created by Paulo on 07/10/2017.
 */

public class TableFirebaseService {

    public static void createTable(User user, Table table){
        DocumentReference tableRef = FirebaseFirestore.getInstance().document("users/"+user.getIdUser()+
                                                                                "/tables/"+table.getNameTable());

        tableRef.set(table);
    }

    public static void getTables(User user, ModelGetTable modelGetTable){
        CollectionReference tableRef = FirebaseFirestore.getInstance().collection("users/"+user.getIdUser()+
                "/tables");

        TableHelper.getTablesHelper(tableRef, modelGetTable);

    }
}
