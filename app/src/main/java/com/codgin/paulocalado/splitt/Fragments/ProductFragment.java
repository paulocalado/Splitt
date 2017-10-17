package com.codgin.paulocalado.splitt.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codgin.paulocalado.splitt.Helpers.PersonHelper;
import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.ModelGetProduct;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Product;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.codgin.paulocalado.splitt.R;
import com.codgin.paulocalado.splitt.Services.PersonFirebaseService;
import com.codgin.paulocalado.splitt.Services.ProductFirebaseService;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


public class ProductFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Table table;
    public User user;
    public ModelGetPerson modelGetPerson;
    public List<Person> personList;

    private OnFragmentInteractionListener mListener;

    public ProductFragment() {
        // Required empty public constructor
    }


    public static ProductFragment newInstance(String param1, String param2) {
        ProductFragment fragment = new ProductFragment();
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
        View v = inflater.inflate(R.layout.fragment_product, container, false);
        Bundle bundleHome = this.getArguments();

        table = (Table) bundleHome.getSerializable("table");
        user = (User) bundleHome.getSerializable("user");

        personList = PersonHelper.getPeopleToAddProduct(user,table);

        RecyclerView rvProduct = (RecyclerView)v.findViewById(R.id.rvProduct);
        TextView textEmpty = (TextView)v.findViewById(R.id.empty_view);
        ImageView sadImage = (ImageView)v.findViewById(R.id.sadImage);

        ModelGetProduct modelGetProduct = new ModelGetProduct(rvProduct,getContext(),sadImage,
                textEmpty, user, table);

        ProductFirebaseService.getProduct(modelGetProduct);

        v.findViewById(R.id.floatAddProduct).setOnClickListener(this);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floatAddProduct:
                dialogAddProduto();
                break;

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

    public void dialogAddProduto(){
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_add_produto);
        dialog.setTitle("Adicione a seu Pedido");

        final List<Person> checkedPeople = new ArrayList<>();
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(R.id.lista_pessoa_dialog);
        final TextInputLayout edtProductName = (TextInputLayout) dialog.findViewById(R.id.edtDialogNomeProduto);
        final TextInputLayout edtProductPrice = (TextInputLayout)dialog.findViewById(R.id.edit_valor_dialog);
        final TextInputLayout edtProductQt = (TextInputLayout)dialog.findViewById(R.id.edit_quantidade_produto);
        Button btnAddProduct = (Button)dialog.findViewById(R.id.btnAdicionarProduto);

        for(final Person person: personList){
            CheckBox checkBox = new AppCompatCheckBox(getContext());
            checkBox.setText(person.getName());
            checkBox.setTextColor(Color.rgb(192,77,249));

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked){
                        checkedPeople.add(person);
                        //listaPessoa.remove(pessoa);
                    }else{
                        checkedPeople.remove(person);
                    }

                }
            });
            linearLayout.addView(checkBox);
        }

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product productToAdd = new Product(edtProductName.getEditText().getText().toString(),
                        Double.parseDouble(edtProductPrice.getEditText().getText().toString()),
                        Integer.parseInt(edtProductQt.getEditText().getText().toString()));

                ProductFirebaseService.addProductTable(user,table,productToAdd);
                PersonFirebaseService.addProductPerson(checkedPeople, user, table, productToAdd);
                
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
