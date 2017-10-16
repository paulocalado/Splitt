package com.codgin.paulocalado.splitt.Control;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.codgin.paulocalado.splitt.Adapters.PeopleAdapter;
import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.R;
import com.codgin.paulocalado.splitt.RecyclerItemClickListener;

import java.util.List;

/**
 * Created by paulocalado on 13/10/17.
 */

public class PeopleLayoutControl {

    public static void setLayoutRVPeople(final List<Person> personList, ModelGetPerson modelGetPerson){
        PeopleAdapter adapter = new PeopleAdapter(personList);
        LinearLayoutManager llm = new LinearLayoutManager(modelGetPerson.getContext());
        modelGetPerson.getRvPerson().setLayoutManager(llm);
        modelGetPerson.getRvPerson().setAdapter(adapter);
        modelGetPerson.getRvPerson().addOnItemTouchListener(new RecyclerItemClickListener(modelGetPerson.getContext(),
                modelGetPerson.getRvPerson(), new RecyclerItemClickListener.OnItemClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));
    }

    public void dialogPersonDetail(ModelGetPerson modelGetPerson){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(modelGetPerson.getContext());
        builder1.setMessage(R.string.title_criar_mesa_dialog);
        builder1.setCancelable(false);

        builder1.setPositiveButton(
                R.string.positive_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

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
