package com.codgin.paulocalado.splitt.Activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codgin.paulocalado.splitt.Model.User;
import com.codgin.paulocalado.splitt.R;

public class TableListActivity extends AppCompatActivity implements View.OnClickListener {
    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_list);

        Intent intentLoging = getIntent();
         user = intentLoging.getParcelableExtra("user");

        findViewById(R.id.floatAddTable).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floatAddTable:
                Toast.makeText(this, user.getNameUser(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
