package com.codgin.paulocalado.splitt.Control;

import android.support.v7.widget.LinearLayoutManager;


import com.codgin.paulocalado.splitt.Adapters.ProductAdapter;
import com.codgin.paulocalado.splitt.Model.ModelGetProduct;
import com.codgin.paulocalado.splitt.Model.Product;

import java.util.List;

/**
 * Created by paulocalado on 16/10/17.
 */

public class ProductLayoutControl {
    public static void setProductLayout(List<Product> productList, ModelGetProduct modelGetProduct){
        ProductAdapter adapter = new ProductAdapter(productList);
        LinearLayoutManager llm = new LinearLayoutManager(modelGetProduct.getContext());
        modelGetProduct.getRvProduct().setLayoutManager(llm);
        modelGetProduct.getRvProduct().setAdapter(adapter);
    }
}
