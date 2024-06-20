package org.example;

import org.example.mobile.Contact;
import org.example.mobile.MobilePhone;
import org.example.models.Grocery;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Grocery grocery = new Grocery();
//        grocery.startGrocery();
//    }

        MobilePhone mobilePhone = new MobilePhone("34343434343", new ArrayList<>());
        mobilePhone.addNewContact(new Contact("orhun", "2355644343"));
        mobilePhone.printContacts();
    }
}
