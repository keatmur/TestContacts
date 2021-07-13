package com.example.readdletest.fragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.readdletest.R;
import com.example.readdletest.model.Contact;

import java.util.Objects;


public class DetailedInfokFragment extends Fragment {
    TextView name;
    TextView email;
    TextView status;
    ImageView avatar;
    Toolbar toolbar;
    Contact contact;

    public DetailedInfokFragment() {

    }

    public static DetailedInfokFragment newInstance(Contact contact) {
        Bundle args = new Bundle();
        DetailedInfokFragment fragment = new DetailedInfokFragment();
        args.putParcelable("CONTACT", contact);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed_infok, container, false);
        inflateView(view);
        contact = Objects.requireNonNull(getArguments()).getParcelable("CONTACT");
        showInf(contact);
        initToolbarWithNavigation();
        return view;
    }

    public void initToolbarWithNavigation() {
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(v -> {
            getActivity().getSupportFragmentManager().popBackStack();
            toolbar.setTitle(getString(R.string.app_name));

        });

    }
    public void inflateView(View view) {
        name = view.findViewById(R.id.tv_name);
        status = view.findViewById(R.id.tv_status);
        email = view.findViewById(R.id.tv_email);
        avatar = view.findViewById(R.id.iv_avatar);
        toolbar = view.findViewById(R.id.toolbar);
    }

    public void showInf(Contact contact) {
        name.setText(contact.getName());
        email.setText(contact.getEmail());
        if (contact.isAccountStatus()) {
            status.setText(R.string.online);
        } else {
            status.setText(R.string.offline);
        }
        Glide.with(avatar).load(contact.getUrlBigAvatar()).into(avatar);
    }
}