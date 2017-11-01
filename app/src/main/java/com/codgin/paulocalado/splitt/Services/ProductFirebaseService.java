package com.codgin.paulocalado.splitt.Services;

import android.util.Log;

import com.codgin.paulocalado.splitt.Control.CalculatorControl;
import com.codgin.paulocalado.splitt.Helpers.ProductHelper;
import com.codgin.paulocalado.splitt.Helpers.TableHelper;
import com.codgin.paulocalado.splitt.Model.ModelGetProduct;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Product;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

/**
 * Created by paulocalado on 16/10/17.
 */

public class ProductFirebaseService {

    public static void addProductTable(User user, Table table, Product product){
        DocumentReference productRef = FirebaseFirestore.getInstance().document("users/"+user.getIdUser()+
                "/tables/"+table.getNameTable()+"/products/"+product.getProductName());

        CollectionReference collectionProductRef = FirebaseFirestore.getInstance().collection("users/"+user.getIdUser()+
                        "/tables/"+table.getNameTable()+"/products");

        DocumentReference tableRef = FirebaseFirestore.getInstance().document("users/"+user.getIdUser()+
                "/tables/"+table.getNameTable());

        product.setProductTotal(CalculatorControl.totalPerProduct(product.getProductQt(), product.getProductPrice()));

        productRef.set(product);
        TableHelper.setTotalTable(collectionProductRef, tableRef);
    }


    public static void getProduct(ModelGetProduct modelGetProduct){
        CollectionReference collectionProductRef = FirebaseFirestore.getInstance().collection("users/"+
                modelGetProduct.getUser().getIdUser()+
                "/tables/"+modelGetProduct.getTable().getNameTable()+"/products");

        modelGetProduct.setRefProduct(collectionProductRef);

        ProductHelper.getProduct(modelGetProduct);
    }

    public static void deleteProduct(ModelGetProduct modelGetProduct, Product product){
        CollectionReference productTableRef = FirebaseFirestore.getInstance().collection("users/"+
                modelGetProduct.getUser().getIdUser()+
                "/tables/"+modelGetProduct.getTable().getNameTable()+"/products");

        DocumentReference tableRef = FirebaseFirestore.getInstance().document("users/"+
                modelGetProduct.getUser().getIdUser()+
                "/tables/"+modelGetProduct.getTable().getNameTable());

        CollectionReference peopleRef = FirebaseFirestore.getInstance().collection("users/"+
                modelGetProduct.getUser().getIdUser()+
                "/tables/"+modelGetProduct.getTable().getNameTable()+"/people");

        productTableRef.document(product.getProductName()).delete();
        TableHelper.setTotalTable(productTableRef, tableRef);


    }
}
