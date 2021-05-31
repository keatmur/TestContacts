package com.example.readdletest.util.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.readdletest.R;
import com.example.readdletest.model.Contact;
import com.example.readdletest.model.viewHolder.CartSmailViewHolder;
import com.example.readdletest.model.viewHolder.CartViewHolder;
import com.example.readdletest.util.listner.OnContactClickListner;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Contact> contacts = new ArrayList<>();
    GridLayoutManager gridLayoutManager = null;
    OnContactClickListner clickListner;

    public ContactsAdapter(ArrayList<Contact> contacts, GridLayoutManager gridLayoutManager) {
        this.contacts = contacts;
        this.gridLayoutManager = gridLayoutManager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (gridLayoutManager.getSpanCount() == 1) {
            return new CartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view, parent, false));
        } else {
            return new CartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (gridLayoutManager.getSpanCount() == 1) {
            CartViewHolder cartViewHolder = (CartViewHolder) holder;
            cartViewHolder.bind(contacts.get(position));
        } else {
            CartSmailViewHolder cartSmailViewHolder = (CartSmailViewHolder) holder;
            cartSmailViewHolder.bind(contacts.get(position));
        }

        holder.itemView.setOnClickListener(v -> {
            if (clickListner != null) {
                clickListner.onItemClick(contacts.get(holder.getLayoutPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public OnContactClickListner getClickListner() {
        return clickListner;
    }

    public void setClickListner(OnContactClickListner clickListner) {
        this.clickListner = clickListner;
    }

}

