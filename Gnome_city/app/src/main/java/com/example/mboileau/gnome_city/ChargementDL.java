package com.example.mboileau.gnome_city;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mboileau on 17/01/17.
 *
 */

public class ChargementDL {
    private final ChargementPresenter presenter;
    /**
     * Initialize all the values
     * @param presenter for the MVP pattern
     */
    public ChargementDL(ChargementPresenter presenter) {
        this.presenter=presenter;
    }

    /**
     *Call the asynctask methode
     */
    public void dlbegin() {
        ChargementDL.Lect lec= new ChargementDL.Lect();
        lec.execute();
    }

    private class Lect extends AsyncTask<Void, Integer, ArrayList<Habitant>> {

        //The function asynchronus.
        @Override
        protected ArrayList<Habitant> doInBackground(Void... params) {
            ArrayList<Habitant> nain =new ArrayList<>();
            try {
                //we load the Json fic
                String uri = "https://raw.githubusercontent.com/rrafols/mobile_test/master/data.json";
                URL url = new URL(uri);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                JSONObject object= new JSONObject(readInputStreamToString(con));
                //we read the Json file
                nain=(ArrayList)readMessagesArray(object);
                initialiseTheSingleton(nain);

                //for exception
            } catch (MalformedURLException e) {
                Log.e("ChargementDL", e.getMessage(), e);
                return null;
            } catch (IOException e) {
                Log.e("Chargement", e.getMessage(), e);
                return null;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return nain;
        }

        //after the exectution of the asyncTask
        @Override
        protected void onPostExecute(ArrayList<Habitant> result) {
            presenter.dlend();

        }
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

    /**
     * Convert the HttpURLConnection into a string in order to have a JSONObject
     * @param connection need the HttpURLConnection
     * @return return the string
     */
    private String readInputStreamToString(HttpURLConnection connection) {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream is = null;

        try {
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        }catch (Exception e) {
            Log.e("ChargementDLBuffer", e.getMessage(), e);
            result = null;
        }

        finally {
            if (is != null) {
                try {
                    is.close();
                }catch (IOException e) {
                    Log.e("ChargementDLBuffer", e.getMessage(), e);
                }
            }
        }

        return result;
    }

    /**
     * Methode in order to initialize the singleton in the background
     * @param gnomes Arraylist of all our population
     */
    public void initialiseTheSingleton (ArrayList<Habitant> gnomes){
        Singleton.getInstance().setGnomes(gnomes);
        Singleton.getInstance().setGnomesfilter(Singleton.getInstance().getGnomes());
    }
}
