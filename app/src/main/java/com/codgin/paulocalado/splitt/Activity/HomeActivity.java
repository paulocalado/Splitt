package com.codgin.paulocalado.splitt.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.codgin.paulocalado.splitt.Fragments.PeopleFragment;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.codgin.paulocalado.splitt.R;

public class HomeActivity extends AppCompatActivity {
    public Table table;
    public User user;
    public Bundle bundle = new Bundle();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    PeopleFragment peopleFragment = new PeopleFragment();
                    bundle.putSerializable("table", table);
                    bundle.putSerializable("user", user);
                    peopleFragment.setArguments(bundle);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content, peopleFragment, "peopleFragment")
                            .addToBackStack(null)
                            .commit();
                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intentTable = getIntent();
        table = (Table) intentTable.getSerializableExtra("table");
        user = (User)intentTable.getSerializableExtra("user");
        PeopleFragment peopleFragment = new PeopleFragment();
        bundle.putSerializable("table", table);
        bundle.putSerializable("user", user);
        peopleFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, peopleFragment, "peopleFragment")
                .addToBackStack(null)
                .commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed()
    {
        finish();

    }

}
