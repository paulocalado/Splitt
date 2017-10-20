package com.codgin.paulocalado.splitt.Model;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Paulo on 04/10/2017.
 */

public class User implements Serializable{
    String idUser;
    String nameUser;
    Map<String, Table> tablesUser;


    public User(){}

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Map<String, Table> getMesasUser() {
        return tablesUser;
    }

    public void setMesasUser(Map<String, Table> tablesUser) {
        this.tablesUser = tablesUser;
    }
}
