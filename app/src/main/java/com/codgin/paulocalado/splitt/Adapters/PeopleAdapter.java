package com.codgin.paulocalado.splitt.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by paulocalado on 13/10/17.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder> {
    List<Person> personList = new ArrayList<>();

    public PeopleAdapter(List<Person> personList){this.personList = personList;}

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_person, parent, false);
        PeopleViewHolder pvh = new PeopleViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        holder.txtNamePerson.setText(personList.get(position).getName());
        holder.txtTotalPerson.setText(holder.txtTotalPerson.getContext().getResources().getString(R.string.total_mesa)+
                                        String.format("%.2f", personList.get(position).getTotal()));
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class PeopleViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtNamePerson;
        TextView txtTotalPerson;


        PeopleViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardPeopleList);
            txtNamePerson = (TextView) itemView.findViewById(R.id.txtNamePerson);
            txtTotalPerson = (TextView) itemView.findViewById(R.id.txtTotalPerson);

        }
    }
}
