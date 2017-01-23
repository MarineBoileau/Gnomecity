package com.example.mboileau.gnome_city;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mboileau on 23/01/17.
 */

public class ChargementReading {

    /**
     * Methode in order to initialize the singleton in the background
     * @param gnomes Arraylist of all our population
     */
    public void initialiseTheSingleton (ArrayList<Habitant> gnomes){
        Singleton.getInstance().setGnomes(gnomes);
        Singleton.getInstance().setGnomesfilter(Singleton.getInstance().getGnomes());
    }

    /**
     * lecture of the Json file
     * @param object the inputsreader
     * @return return an arraylist of Habitant
     * @throws IOException throws exeptions
     */
    public List<Habitant> readMessagesArray(JSONObject object) throws IOException {
        List<Habitant> nain = new ArrayList<>();

        try {
            JSONArray gnomes = object.getJSONArray("Brastlewark");
            for ( int i = 0; i < gnomes.length() ; i++) {
                JSONObject gnome=gnomes.getJSONObject(i);
                nain.add(readMessage(gnome));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
        return nain;
    }

    public Habitant readMessage(JSONObject object) throws IOException {

        Habitant gnome = new Habitant();
        try {
            gnome.setId((int) object.get("id"));
            gnome.setName((String) object.get("name"));
            gnome.setThumbnail((String) object.get("thumbnail"));
            gnome.setAge((int) object.get("age"));
            gnome.setWeight((double) object.get("weight"));
            gnome.setHeight((double) object.get("height"));
            gnome.setHaircolor((String) object.get("hair_color"));

            JSONArray professions = object.getJSONArray("professions");
            for ( int i = 0; i < professions.length() ; i++) {
                gnome.setProfessions(professions.getString(i));

            }
            JSONArray friends = object.getJSONArray("friends");
            for ( int i = 0; i < friends.length() ; i++) {
                gnome.setFriends(friends.getString(i));

            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return gnome;
    }
}
