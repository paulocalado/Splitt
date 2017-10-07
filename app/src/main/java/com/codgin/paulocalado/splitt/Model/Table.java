package com.codgin.paulocalado.splitt.Model;

/**
 * Created by Paulo on 04/10/2017.
 */

public class Table {
    String nameTable;
    double total;
    double totalWithTip;
    int tip;
    int qtPeople;

    public Table(){}

    public int getQtPeople() {
        return qtPeople;
    }

    public void setQtPeople(int qtPeople) {
        this.qtPeople = qtPeople;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

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

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }
}
