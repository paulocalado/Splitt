package com.codgin.paulocalado.splitt.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.codgin.paulocalado.splitt.R;
import com.codgin.paulocalado.splitt.Services.TableFirebaseService;

public class TableListActivity extends AppCompatActivity implements View.OnClickListener {
    public User user;
    public RecyclerView rvTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

         Intent intentLoging = getIntent();
         user = (User) intentLoging.getSerializableExtra("user");

        rvTable = (RecyclerView)findViewById(R.id.rvTables);
        findViewById(R.id.floatAddTable).setOnClickListener(this);


        TableFirebaseService.getTables(user,TableListActivity.this, rvTable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floatAddTable:
                dialogAddTable();
                break;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();

        TableFirebaseService.getTables(user, TableListActivity.this, rvTable);
    }

    public void dialogAddTable(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(R.string.title_criar_mesa_dialog);
        builder1.setCancelable(false);
        final EditText input = new EditText(this);
        input.setHint(R.string.hint_criar_mesa_dialog);
        builder1.setView(input);
        builder1.setPositiveButton(
                R.string.positive_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Table table = new Table();
                        table.setNameTable(input.getText().toString());
                        TableFirebaseService.createTable(user, table);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                R.string.negative_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
