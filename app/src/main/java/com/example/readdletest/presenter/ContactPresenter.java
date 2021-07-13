package com.example.readdletest.presenter;

import com.example.readdletest.contract.ContactsContract;
import com.example.readdletest.fragments.ContactListFragment;
import com.example.readdletest.model.Contact;

import java.util.ArrayList;

public class ContactPresenter implements ContactsContract.Presenter {
    ArrayList<Contact> listContacts;
    ContactsContract.View view;

    public ContactPresenter() {

    }

    public void attachView(ContactListFragment listFragment) {
        view = listFragment;
    }

    public void detachView() {
        view = null;
    }

    @Override
    public void randomChange(ArrayList<Contact> contacts) {
        listContacts = new ArrayList<Contact>(contacts);
        int position = (int) (Math.random() * 4);
        switch (position) {
            case 0:
                changeAccountStatus();
            case 1:
                changeName();
            case 2:
                dellRandomContact();
            case 3:
                addNewContact();
                break;
            default:
                //дефулт изменение
        }
        view.showContactList(listContacts);
    }

    @Override
    public void changeAccountStatus() {
        int position = (int) (Math.random() * listContacts.size());
        listContacts.get(position).setAccountStatus(!listContacts.get(position).isAccountStatus());
    }

    @Override
    public void changeName() {
        int position = (int) (Math.random() * listContacts.size());
        listContacts.get(position).setName("Name" + position);
    }

    @Override
    public void addNewContact() {
        int position = listContacts.size();
        listContacts.add(new Contact("Name" + position, "name@gmail.com", false));
    }

    @Override
    public void dellRandomContact() {
        int position = (int) (Math.random() * listContacts.size());
        listContacts.remove(position);
    }
}
