package com.codgin.paulocalado.splitt.Control;


import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;


import com.codgin.paulocalado.splitt.Adapters.ProductAdapter;
import com.codgin.paulocalado.splitt.Fragments.ProductFragment;
import com.codgin.paulocalado.splitt.Helpers.PersonHelper;
import com.codgin.paulocalado.splitt.Model.ModelGetProduct;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Product;
import com.codgin.paulocalado.splitt.R;
import com.codgin.paulocalado.splitt.RecyclerItemClickListener;
import com.codgin.paulocalado.splitt.Services.ProductFirebaseService;

import java.util.List;

/**
 * Created by paulocalado on 16/10/17.
 */

public class ProductLayoutControl {
    public static void setProductLayout(final List<Product> productList, final ModelGetProduct modelGetProduct){
        ProductAdapter adapter = new ProductAdapter(productList);
        LinearLayoutManager llm = new LinearLayoutManager(modelGetProduct.getContext());
        modelGetProduct.getRvProduct().setLayoutManager(llm);
        modelGetProduct.getRvProduct().setAdapter(adapter);
        modelGetProduct.getRvProduct().addOnItemTouchListener(new RecyclerItemClickListener(modelGetProduct.getContext(),
                modelGetProduct.getRvProduct(), new RecyclerItemClickListener.OnItemClickListener(){


                    @Override
                    public void onItemClick(View view, int position) {
                        deleteOrUpdateDialog(productList.get(position), modelGetProduct);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                }));

    }

    public static void deleteOrUpdateDialog(final Product product, final ModelGetProduct modelGetProduct){
        final AlertDialog.Builder builder = new AlertDialog.Builder(modelGetProduct.getContext());
        builder.setTitle(modelGetProduct.getContext().getResources().getString(R.string.hey)+" "+
        modelGetProduct.getUser().getNameUser()+" "+
        modelGetProduct.getContext().getResources().getString(R.string.choose_delete_update_dialog));



        builder.setPositiveButton(modelGetProduct.getContext().getResources().getString(R.string.update_product) +" "+
                        product.getProductName(),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addMoreProducts(modelGetProduct, product);
                        dialogInterface.dismiss();
                    }
                });
        builder.setNegativeButton(modelGetProduct.getContext().getResources().getString(R.string.delete_product) +" "+
                        product.getProductName(),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        confirmDeleteDialog(product, modelGetProduct);
                        dialogInterface.dismiss();
                    }
                });

        final AlertDialog dialog = builder.create();
        dialog.setOnShowListener( new DialogInterface.OnShowListener() {
                                      @Override
                                      public void onShow(DialogInterface arg0) {
                                          dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED);
                                          dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.GREEN);

                                      }
                                  });

        dialog.show();
    }

    public static void addMoreProducts(ModelGetProduct modelGetProduct, Product product){
        LinearLayout layout = new LinearLayout(modelGetProduct.getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(modelGetProduct.getContext());
        builder1.setMessage(R.string.title_criar_mesa_dialog);
        builder1.setCancelable(false);
        final EditText input = new EditText(modelGetProduct.getContext());
        input.setHint(R.string.hint_criar_mesa_dialog);
        layout.addView(input);

        for(final Person person: modelGetProduct.getPersonList()){
            CheckBox checkBox = new AppCompatCheckBox(modelGetProduct.getContext());
            checkBox.setText(person.getName());
            checkBox.setTextColor(Color.rgb(192,77,249));

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked){
                        //checkedPeople.add(person);

                    }else{
                        //checkedPeople.remove(person);
                    }

                }
            });
            layout.addView(checkBox);
        }
        builder1.setView(layout);
        builder1.setPositiveButton("sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder1.setNegativeButton("nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    public static void confirmDeleteDialog(final Product product, final ModelGetProduct modelGetProduct){
        AlertDialog.Builder builder = new AlertDialog.Builder(modelGetProduct.getContext());
        builder.setTitle("Deseja excluir: "+product.getProductName()+"?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteProduct(modelGetProduct, product);
            }
        });

        builder.setNegativeButton("Nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialogConfirmDelete = builder.create();

        dialogConfirmDelete.show();
    }

    public static void deleteProduct(ModelGetProduct modelGetProduct, Product product){
        ProductFirebaseService.deleteProduct(modelGetProduct,product);
        PersonHelper.deleteProductPerson(modelGetProduct,product);
    }
}
