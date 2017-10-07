package com.codgin.paulocalado.splitt.Helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.codgin.paulocalado.splitt.Control.TableLayoutControl;
import com.codgin.paulocalado.splitt.Model.Table;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulocalado on 07/10/17.
 */

public class TableHelper {

    public static void getTablesHelper(CollectionReference tableRef, final Context context, final RecyclerView rvTable){
        final List<Table> tableList = new ArrayList<>();
        tableRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(tableList.size()!=0){
                    tableList.clear();
                }
                if(task.isSuccessful()){
                    for (DocumentSnapshot document : task.getResult()){
                        tableList.add(document.toObject(Table.class));
                    }
                    TableLayoutControl.setLayoutTables(tableList, context, rvTable);
                }

            }
        });
    }
}
