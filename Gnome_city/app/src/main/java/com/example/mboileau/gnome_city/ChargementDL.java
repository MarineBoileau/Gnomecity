package com.example.mboileau.gnome_city;

import android.os.AsyncTask;
import android.util.Log;

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

/**
 * Created by mboileau on 17/01/17.
 */

public class ChargementDL {
    private final ChargementPresenter presenter;
    private final ChargementReading reader = new ChargementReading();
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

    public class Lect extends AsyncTask<Void, Integer, ArrayList<Habitant>> {

        //The function asynchronus.
        @Override
        protected ArrayList<Habitant> doInBackground(Void... params) {
            ArrayList<Habitant> nain =new ArrayList<>();
            if (Singleton.getInstance().getGnomes().isEmpty()) {
                try {
                    //we load the Json fic
                    String uri = "https://raw.githubusercontent.com/rrafols/mobile_test/master/data.json";
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    JSONObject object = new JSONObject(readInputStreamToString(con));
                    //we read the Json file
                    nain.addAll(reader.readMessagesArray(object));
                    reader.initialiseTheSingleton(nain);

                    //for exception
                } catch (MalformedURLException e) {
                    Log.e("ChargementDL", e.getMessage(), e);
                } catch (IOException e) {
                    Log.e("Chargement", e.getMessage(), e);
                } catch (JSONException e) {
                    Log.e("chargementJSON", e.getMessage(), e);
                    e.printStackTrace();
                }
            }
            return Singleton.getInstance().getGnomes();
        }

        //after the exectution of the asyncTask
        @Override
        protected void onPostExecute(ArrayList<Habitant> result) {
            presenter.dlend();

        }
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
        } finally {
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
}
