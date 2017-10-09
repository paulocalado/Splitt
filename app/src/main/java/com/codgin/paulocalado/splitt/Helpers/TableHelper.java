package com.codgin.paulocalado.splitt.Helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codgin.paulocalado.splitt.Control.TableLayoutControl;
import com.codgin.paulocalado.splitt.Model.ModelGetTable;
import com.codgin.paulocalado.splitt.Model.Table;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulocalado on 07/10/17.
 */

public class TableHelper {

    public static void getTablesHelper(CollectionReference tableRef, final ModelGetTable modelGetTable){
        final List<Table> tableList = new ArrayList<>();
        tableRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(tableList.size()!=0){
                    tableList.clear();
                }
                for(DocumentSnapshot document : documentSnapshots){
                    tableList.add(document.toObject(Table.class));

                }
                if(tableList.size()==0){
                    modelGetTable.getImageEmpty().setVisibility(View.VISIBLE);
                    modelGetTable.getTextEmpty().setVisibility(View.VISIBLE);
                }else{
                    modelGetTable.getImageEmpty().setVisibility(View.GONE);
                    modelGetTable.getTextEmpty().setVisibility(View.GONE);
                }

                TableLayoutControl.setLayoutTables(tableList, modelGetTable.getContext(), modelGetTable.getRvTable());
            }
        });

    }
}
