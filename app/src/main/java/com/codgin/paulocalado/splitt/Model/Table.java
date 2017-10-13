package com.codgin.paulocalado.splitt.Model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Paulo on 04/10/2017.
 */

public class Table implements Serializable {
    String nameTable;
    double total;
    double totalWithTip;
    int tip;
    int qtPeople;
    Map<String, Person> people;

    public Table(){}

    public Map<String, Person> getPeople() {
        return people;
    }

    public void setPeople(Map<String, Person> people) {
        this.people = people;
    }

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
