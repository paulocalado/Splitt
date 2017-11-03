package com.codgin.paulocalado.splitt.Services;

import com.codgin.paulocalado.splitt.Control.CalculatorControl;
import com.codgin.paulocalado.splitt.Helpers.PersonHelper;
import com.codgin.paulocalado.splitt.Model.ModelGetPerson;
import com.codgin.paulocalado.splitt.Model.Person;
import com.codgin.paulocalado.splitt.Model.Product;
import com.codgin.paulocalado.splitt.Model.Table;
import com.codgin.paulocalado.splitt.Model.User;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paulocalado on 11/10/17.
 */

public class PersonFirebaseService {

        public static void createPersonFirebase(User user, Table table, Person person){
            DocumentReference personRef = FirebaseFirestore.getInstance().document("users/"+user.getIdUser()+
                    "/tables/"+table.getNameTable()+"/people/"+person.getName());

            personRef.set(person);
        }

        public static void getPeopleFirebase(ModelGetPerson modelGetPerson){
            CollectionReference personRef = FirebaseFirestore.getInstance().collection("users/"+
                    modelGetPerson.getUser().getIdUser()+"/tables/"+modelGetPerson.getTable().getNameTable()+
                    "/people");

            modelGetPerson.setRefPerson(personRef);

            PersonHelper.getPeopleHelper(modelGetPerson);
        }

        public static void setPerson(User user, Table table, List<Person> personList){
            for(Person person : personList){

                DocumentReference personRef = FirebaseFirestore.getInstance().document("users/"+user.getIdUser()+
                        "/tables/"+table.getNameTable()+"/people/"+person.getName());

                personRef.set(person);
            }

        }

    public static void addProductPerson(List<Person> personList, User user, Table table, Product product,
                                        double totalPerPerson){


        for(Person person : personList){
            DocumentReference personRef = FirebaseFirestore.getInstance().document("users/"+user.getIdUser()+
                    "/tables/"+table.getNameTable()+"/people/"+person.getName());


            Map<String, Product> mapProduct = new HashMap<>();

            if(person.getProductList()!= null){
                mapProduct = person.getProductList();
            }
            
            mapProduct.put(product.getProductName(), product);
            person.setProductList(mapProduct);
            person.setTotal(totalPerPerson+person.getTotal());
            personRef.set(person);

        }
    }

}
