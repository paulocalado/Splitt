package com.codgin.paulocalado.splitt.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.codgin.paulocalado.splitt.R;
import com.codgin.paulocalado.splitt.Services.PersonFirebaseService;


public class PeopleFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Table table;
    public User user;
    public ModelGetPerson modelGetPerson;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PeopleFragment() {
        // Required empty public constructor
    }

    public static PeopleFragment newInstance(String param1, String param2) {
        PeopleFragment fragment = new PeopleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_people, container, false);
        Bundle bundleHome = this.getArguments();

        table = (Table) bundleHome.getSerializable("table");
        user = (User) bundleHome.getSerializable("user");

        v.findViewById(R.id.floatAddPerson).setOnClickListener(this);
        RecyclerView rvPerson = (RecyclerView)v.findViewById(R.id.rvPerson);
        TextView txtEmpty = (TextView)v.findViewById(R.id.empty_view);
        ImageView imgEmpty = (ImageView)v.findViewById(R.id.sadImage);

        modelGetPerson = new ModelGetPerson(rvPerson, getContext(),imgEmpty,txtEmpty,user,table);

        PersonFirebaseService.getPeopleFirebase(modelGetPerson);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floatAddPerson:
                dialogAddPerson();
                break;
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    public void dialogAddPerson(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage(R.string.title_criar_mesa_dialog);
        builder1.setCancelable(false);
        final EditText input = new EditText(getContext());
        input.setHint(R.string.hint_criar_mesa_dialog);
        builder1.setView(input);
        builder1.setPositiveButton(
                R.string.positive_button,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Person person = new Person();
                        person.setName(input.getText().toString());
                        PersonFirebaseService.createPersonFirebase(user, table,person);
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
