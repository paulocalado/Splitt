package com.codgin.paulocalado.splitt.Control;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.codgin.paulocalado.splitt.Activity.HomeActivity;
import com.codgin.paulocalado.splitt.Adapters.TableAdapter;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.RecyclerItemClickListener;

import java.util.List;

/**
 * Created by paulocalado on 07/10/17.
 */

public class TableLayoutControl {

    public static void setLayoutTables(final List<Table> tableList, final Context context, RecyclerView rvTables){
        TableAdapter adapter = new TableAdapter(tableList);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvTables.setLayoutManager(llm);
        rvTables.setAdapter(adapter);
        rvTables.addOnItemTouchListener(new RecyclerItemClickListener(context, rvTables, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intentHome = new Intent(context, HomeActivity.class);
                intentHome.putExtra("table", tableList.get(position));
                context.startActivity(intentHome);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
}
