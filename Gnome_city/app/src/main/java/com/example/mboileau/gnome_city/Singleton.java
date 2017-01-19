package com.example.mboileau.gnome_city;

import java.util.ArrayList;

/**
 * Created by mboileau on 13/01/17.
 */

public class Singleton {

    private static Singleton mInstance = null;

    private ArrayList<Habitant> gnomes;
    private ArrayList<Habitant> gnomesfilter;

    private Singleton(){
        gnomes= new ArrayList<>();
        gnomesfilter=new ArrayList<>();

    }

    public static Singleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new Singleton();
        }
        return mInstance;
    }

    public ArrayList<Habitant> getGnomes(){
        return this.gnomes;
    }

    public void setGnomes(ArrayList<Habitant> gnomes){
        this.gnomes=gnomes;
    }
    public ArrayList<Habitant> getGnomesall(){
        return this.gnomesfilter;
    }

    public void setGnomesfilter(ArrayList<Habitant> gnomes) {
        this.gnomesfilter=gnomes;
    }
}