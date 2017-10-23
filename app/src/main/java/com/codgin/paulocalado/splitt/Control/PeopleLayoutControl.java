package com.codgin.paulocalado.splitt.Control;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.codgin.paulocalado.splitt.Adapters.PeopleAdapter;
import com.codgin.paulocalado.splitt.Adapters.ProductAdapter;
import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Product;
import com.codgin.paulocalado.splitt.R;
import com.codgin.paulocalado.splitt.RecyclerItemClickListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by paulocalado on 13/10/17.
 */

public class PeopleLayoutControl {

    public static void setLayoutRVPeople(final List<Person> personList, final ModelGetPerson modelGetPerson){
        double totalMesa =0;
        PeopleAdapter adapter = new PeopleAdapter(personList);
        LinearLayoutManager llm = new LinearLayoutManager(modelGetPerson.getContext());
        modelGetPerson.getRvPerson().setLayoutManager(llm);
        modelGetPerson.getRvPerson().setAdapter(adapter);
        modelGetPerson.getRvPerson().addOnItemTouchListener(new RecyclerItemClickListener(modelGetPerson.getContext(),
                modelGetPerson.getRvPerson(), new RecyclerItemClickListener.OnItemClickListener(){
                    @Override
                    public void onItemClick(View view, int position) {
                        dialogPersonDetail(personList.get(position), modelGetPerson);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));

        for(Person person : personList){
            totalMesa+=person.getTotal();
        }
        modelGetPerson.getTxtTotalMesa().setText(modelGetPerson.getContext().getResources().getString(R.string.total_mesa)
                +String.format("%.2f",totalMesa));
    }

    public static void dialogPersonDetail(Person person, final ModelGetPerson modelGetPerson){
        final List<Product> productList = new ArrayList<>();
        final Dialog dialog = new Dialog(modelGetPerson.getContext());
        dialog.setContentView(R.layout.layout_person_detail);
        dialog.setTitle("Adicione a seu Pedido");

        final RecyclerView rvProductPersonDetail = (RecyclerView)dialog.findViewById(R.id.rvProductpersonDetail);
        TextView txtPersonDetail = (TextView)dialog.findViewById(R.id.textDetalhePessoa);

        txtPersonDetail.setText(person.getName()+", "+
                modelGetPerson.getContext().getResources().getString(R.string.text_detalhe_pessoa));

        CollectionReference productsRef =  FirebaseFirestore.getInstance().collection("users/"+modelGetPerson.getUser().getIdUser()+
                "/tables/"+modelGetPerson.getTable().getNameTable()+"/people/"+person.getName()+"/productList");

        productsRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(productList.size()!=0){
                    productList.clear();
                }

                for(DocumentSnapshot document : documentSnapshots){
                    productList.add(document.toObject(Product.class));
                }

                ProductAdapter adapter = new ProductAdapter(productList);
                LinearLayoutManager llm = new LinearLayoutManager(modelGetPerson.getContext());
                rvProductPersonDetail.setLayoutManager(llm);
                rvProductPersonDetail.setAdapter(adapter);

            }
        });

        dialog.show();

    }
}
