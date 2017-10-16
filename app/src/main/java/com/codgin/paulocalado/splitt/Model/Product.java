package com.codgin.paulocalado.splitt.Model;

/**
 * Created by paulocalado on 13/10/17.
 */

public class Product {
    String productName;
    double productPrice;
    int productQt;
    double productTotal;

    public Product(String productName, double productPrice, int productQt) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQt = productQt;
    }

    public Product(){}

    public double getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(double productTotal) {
        this.productTotal = productTotal;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQt() {
        return productQt;
    }

    public void setProductQt(int productQt) {
        this.productQt = productQt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
