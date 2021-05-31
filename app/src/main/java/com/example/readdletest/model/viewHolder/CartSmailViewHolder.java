package com.example.readdletest.model.viewHolder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.readdletest.R;
import com.example.readdletest.model.Contact;

public class CartSmailViewHolder extends RecyclerView.ViewHolder {
    ImageView avatar;
    ImageView status;

    public CartSmailViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.iv_avatar);
        status = itemView.findViewById(R.id.iv_status);
    }

    public void bind(Contact contact) {
        if (contact.isAcountStatus()) {
            status.setVisibility(View.VISIBLE);
        } else {
            status.setVisibility(View.INVISIBLE);
        }
        Glide.with(avatar).load(contact.getUrlBigAvatar()).into(avatar);
    }
}
