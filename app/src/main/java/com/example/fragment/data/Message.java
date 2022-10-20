package com.example.fragment.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Clase POJO que contiene un mensaje y el tamaño del mensaje
 */
public class Message implements Serializable, Parcelable {
    public static final String KEY = "message";
    private String text;
    private int size;

    public Message(String text, int size) {
        this.text = text;
        this.size = size;
    }

    public Message() {

    }

    protected Message(Parcel in) {
        text = in.readString();
        size = in.readInt();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", size=" + size +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeInt(size);
    }
}
