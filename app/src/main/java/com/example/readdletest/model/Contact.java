package com.example.readdletest.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import com.example.readdletest.util.MD5Util;

public class Contact implements Parcelable {
    String name;
    String email;
    boolean accountStatus;

    public Contact(String name, String email, boolean acountStatus) {
        this.name = name;
        this.email = email;
        this.accountStatus = acountStatus;
    }

    public Contact() {
    }

    protected Contact(Parcel in) {
        name = in.readString();
        email = in.readString();
        accountStatus = in.readByte() != 0;
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getUrlBigAvatar() {
        String hash = MD5Util.md5Hex(email);
        return "https://www.gravatar.com/avatar/" + hash + "?s=200&d=retro";
    }

    public String getUrlAvatar() {
        String hash = MD5Util.md5Hex(email);
        return "https://www.gravatar.com/avatar/" + hash + "?s=48&d=retro";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return accountStatus == contact.accountStatus &&
                Objects.equals(name, contact.name) &&
                Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, accountStatus);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeByte((byte) (accountStatus ? 1 : 0));
    }
}
