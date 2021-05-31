package com.example.readdletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.readdletest.fragments.ContactListFragment;
import com.example.readdletest.fragments.DetailedInfokFragment;
import com.example.readdletest.util.listner.ContactListner;
import com.example.readdletest.model.Contact;

public class MainActivity extends AppCompatActivity {
    ContactListFragment listFragment;
    DetailedInfokFragment detailedInfokFragment;
    FragmentTransaction fTrans1;

    ContactListner contactListner = new ContactListner() {
        @Override
        public void setContact(Contact contact) {
            detailedInfokFragment = DetailedInfokFragment.newInstance(contact);
            fTrans1 = getSupportFragmentManager().beginTransaction();
            fTrans1.replace(R.id.fragment_list, detailedInfokFragment, "TAG1")
                    .addToBackStack(null)
                    .commit();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listFragment = new ContactListFragment();
        fTrans1 = getSupportFragmentManager().beginTransaction();
        fTrans1.add(R.id.fragment_list, listFragment, "TAG").commit();
        listFragment.setContactListner(contactListner);
    }

}