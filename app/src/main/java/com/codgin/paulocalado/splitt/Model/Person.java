package com.codgin.paulocalado.splitt.Model;

import java.util.Map;

/**
 * Created by Paulo on 07/10/2017.
 */

public class Person {
    String name;
    double total;
    double totalWithTip;
    Map<String, Product> productList;

    public Person(){}

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalWithTip() {
        return totalWithTip;
    }

    public void setTotalWithTip(double totalWithTip) {
        this.totalWithTip = totalWithTip;
    }

    public Map<String, Product> getProductList() {
        return productList;
    }

    public void setProductList(Map<String, Product> productList) {
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
