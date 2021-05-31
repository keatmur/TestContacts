package com.example.readdletest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readdletest.R;
import com.example.readdletest.model.Contact;
import com.example.readdletest.util.adapter.ContactsAdapter;
import com.example.readdletest.util.listner.ContactListner;
import com.example.readdletest.util.listner.OnContactClickListner;

import java.util.ArrayList;


public class ContactListFragment extends Fragment {
    Toolbar toolbar;
    Button changes;
    RecyclerView contactsRecView;
    ContactsAdapter concatsAdapter;
    GridLayoutManager gridLayoutManager;
    ArrayList<Contact> listContacts = new ArrayList<>();
    ContactListner contactListner;

    OnContactClickListner clickListner = new OnContactClickListner() {
        @Override
        public void onItemClick(Contact contact) {
            contactListner.setContact(contact);
        }
    };


    public ContactListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generetList();
        openMenu();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);

        inflateView(view);
        listenr(view);

        gridLayoutManager = new GridLayoutManager(view.getContext(), 1);
        contactsRecView.setLayoutManager(gridLayoutManager);
        concatsAdapter = new ContactsAdapter(listContacts, gridLayoutManager);
        concatsAdapter.setClickListner(clickListner);
        contactsRecView.setAdapter(concatsAdapter);

        return view;
    }

    public void inflateView(View view) {
        contactsRecView = view.findViewById(R.id.rv_contacts);
        changes = view.findViewById(R.id.bt_changes);
        toolbar = view.findViewById(R.id.toolbar);
    }

    public void generetList() {
        listContacts.add(new Contact("Mariya", "keatmur@gmail.com", true));
        listContacts.add(new Contact("Max", "max@gmail.com", true));
        listContacts.add(new Contact("Vlada", "vlada@gmail.com", false));
        listContacts.add(new Contact("Hari", "hari@gmail.com", true));
        listContacts.add(new Contact("Mira", "mir@gmail.com", false));
    }

    public void openMenu() {
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setOverflowIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_menu));
        toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.actoin_show) {
                    String type = changeLayoyRecicle();
                    menuItem.setTitle("Show as " + type);
                }
                return true;
            }

        });
    }

    public void listenr(View view) {
        changes.setOnClickListener(v -> {
            randomChange();
            concatsAdapter.notifyDataSetChanged();
            contactsRecView.smoothScrollToPosition(listContacts.size() - 1);
        });
    }

    public String changeLayoyRecicle() {
        if (gridLayoutManager.getSpanCount() == 1) {
            gridLayoutManager.setSpanCount(5);
            concatsAdapter.notifyItemRangeChanged(0, gridLayoutManager.getSpanCount());
            return "list";
        } else {
            gridLayoutManager.setSpanCount(1);
            concatsAdapter.notifyItemRangeChanged(0, gridLayoutManager.getSpanCount());
            return "gride";
        }

    }

    public void randomChange() {
        int position = (int) (Math.random() * 4);
        switch (position) {
            case 0:
                changeAcountStatus();
            case 1:
                changeName();
            case 2:
                dellRandomContact();
            case 3:
                addNewContact();

        }
    }

    public void changeAcountStatus() {
        int position = (int) (Math.random() * listContacts.size());
        if (listContacts.get(position).isAcountStatus()) {

        } else {
            listContacts.get(position).setAcountStatus(true);
        }
    }

    public void changeName() {
        int position = (int) (Math.random() * listContacts.size());
        listContacts.get(position).setName("Name" + position);
    }

    public void addNewContact() {
        int position = listContacts.size();
        listContacts.add(new Contact("Name" + position, "name@gmail.com", false));
    }

    public void dellRandomContact() {
        int position = (int) (Math.random() * listContacts.size());
        listContacts.remove(position);
    }

    public ContactListner getContactListner() {
        return contactListner;
    }

    public void setContactListner(ContactListner contactListner) {
        this.contactListner = contactListner;
    }
}