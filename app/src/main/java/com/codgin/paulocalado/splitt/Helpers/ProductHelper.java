package com.codgin.paulocalado.splitt.Helpers;

import com.codgin.paulocalado.splitt.Control.ProductLayoutControl;
import com.codgin.paulocalado.splitt.Model.ModelGetProduct;
import com.codgin.paulocalado.splitt.Model.Product;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulocalado on 16/10/17.
 */

public class ProductHelper {

    public static void getProduct(final ModelGetProduct modelGetProduct){
        final List<Product> productList = new ArrayList<>();

        modelGetProduct.getRefProduct().addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if(productList.size()!=0){
                    productList.clear();
                }

                for(DocumentSnapshot document : documentSnapshots){
                    productList.add(document.toObject(Product.class));
                }
                ProductLayoutControl.setProductLayout(productList, modelGetProduct);
            }
        });
    }
}
