package com.codgin.paulocalado.splitt.Control;

/**
 * Created by paulocalado on 16/10/17.
 */

public class CalculatorControl {

    public static double totalPerProduct(int qtProduct, double productPrice){
        double total =0;

        total = qtProduct*productPrice;

        return total;
    }

    public static double totalProductPerPerson(int qtdProduct, int qtdPessoa, double productPrice){
        double total =0;

        total = (qtdProduct*productPrice)/qtdPessoa;

        return total;
    }
}
