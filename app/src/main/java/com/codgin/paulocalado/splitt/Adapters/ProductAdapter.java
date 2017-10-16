package com.codgin.paulocalado.splitt.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codgin.paulocalado.splitt.Model.Product;
import com.codgin.paulocalado.splitt.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulocalado on 16/10/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<Product> productList = new ArrayList<>();

    public ProductAdapter(List<Product> productList){this.productList = productList;}

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_product, parent, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.txtNameProduct.setText(productList.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView txtNameProduct;
        TextView txtProductQt;
        TextView txtProductValue;

        ProductViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cardItenListaMesa);
            txtNameProduct = (TextView)itemView.findViewById(R.id.txtNameProduct);
            txtProductQt = (TextView)itemView.findViewById(R.id.txtProductQt);
            txtProductValue = (TextView)itemView.findViewById(R.id.txtProductPrice);
            //qual itemView.setOnClickListener( itemView);
        }


    }
}
