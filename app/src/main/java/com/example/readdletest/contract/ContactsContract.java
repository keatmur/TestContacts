package com.example.readdletest.contract;

import com.example.readdletest.model.Contact;

import java.util.ArrayList;

public interface ContactsContract {

    interface View {

        void  showContactList(ArrayList<Contact>contacts);

    }
    interface Presenter {
         void randomChange(ArrayList<Contact>contacts);
         void changeAccountStatus();
         void changeName();
         void addNewContact();
         void dellRandomContact();


        }

}
