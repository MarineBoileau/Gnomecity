package com.example.mboileau.gnome_city;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by mboileau on 10/01/17.
 */

public class Habitant implements Parcelable {

    //attributs
    private int id;
    private String name;
    private String thumbnail;
    private int age;
    private double weight;
    private double height;
    private String haircolor;
    private ArrayList<String> professions;
    private ArrayList<String> friends;


    //constructor
    public Habitant ()
    {
        id=0;
        name ="";
        thumbnail ="";
        age=0;
        weight=0;
        height=0;
        haircolor="";
        professions=new ArrayList<>();
        friends =new ArrayList<>();
    }

    //methode : setter,setter
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail=thumbnail;
    }
    public String getThumbnail() {
        return thumbnail;
    }

    public void setAge(int age) {
        this.age=age;
    }
    public int getAge() {
        return age;
    }

    public void setWeight(double weight) {
        this.weight=weight;
    }
    public double getWeight() {
        return weight;
    }

    public void setHeight (double height) {
        this.height = height;
    }
    public double getHeight () {
        return height;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor =haircolor;
    }
    public String getHaircolor () {
        return haircolor;
    }

    public void setProfessions(String professions) {
        this.professions.add(professions);
    }
    public ArrayList<String> getProfessions () {
        return professions;
    }

    public void setFriends(String friends) {
        this.friends.add(friends);
    }
    public ArrayList<String> getFriends() {
        return friends;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.thumbnail);
        dest.writeInt(this.age);
        dest.writeDouble(this.weight);
        dest.writeDouble(this.height);
        dest.writeString(this.haircolor);
        dest.writeStringList(this.professions);
        dest.writeStringList(this.friends);
    }

    protected Habitant(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.thumbnail = in.readString();
        this.age = in.readInt();
        this.weight = in.readDouble();
        this.height = in.readDouble();
        this.haircolor = in.readString();
        this.professions = in.createStringArrayList();
        this.friends = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Habitant> CREATOR = new Parcelable.Creator<Habitant>() {
        @Override
        public Habitant createFromParcel(Parcel source) {
            return new Habitant(source);
        }

        @Override
        public Habitant[] newArray(int size) {
            return new Habitant[size];
        }
    };

}
