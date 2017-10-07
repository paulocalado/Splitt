package com.codgin.paulocalado.splitt.Control;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.codgin.paulocalado.splitt.Adapters.TableAdapter;
import com.codgin.paulocalado.splitt.Model.Table;

import java.util.List;

/**
 * Created by paulocalado on 07/10/17.
 */

public class TableLayoutControl {

    public static void setLayoutTables(final List<Table> tableList, Context context, RecyclerView rvTables){
        TableAdapter adapter = new TableAdapter(tableList);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvTables.setLayoutManager(llm);
        rvTables.setAdapter(adapter);
    }
}
