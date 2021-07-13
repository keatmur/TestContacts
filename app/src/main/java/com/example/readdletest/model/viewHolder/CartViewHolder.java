package com.example.readdletest.model.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.readdletest.R;
import com.example.readdletest.model.Contact;

public class CartViewHolder extends CartSmailViewHolder {

    TextView name;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.iv_avatar);
        status = itemView.findViewById(R.id.iv_status);
        name = itemView.findViewById(R.id.tv_name_cv);
    }

    public void bind(Contact contact) {
        name.setText(contact.getName());
        if (contact.isAccountStatus()) {
            status.setVisibility(View.VISIBLE);
        } else {
            status.setVisibility(View.INVISIBLE);
        }
        Glide.with(avatar).load(contact.getUrlBigAvatar()).into(avatar);
    }
}
