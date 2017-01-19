package com.example.mboileau.gnome_city;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * Acivity for the Choice between the list and the filter
 */
public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        //just shown the activity

    }

    /**
     * acess to the filter thanks to the on click button
     * @param view
     */
    public void third(View view) {
        Intent intent = new Intent(this, FilterActivity.class);
        startActivity(intent);
    }

    /**
     * /acess to the list thanks to the on click button
     * @param view
     */
    public void second(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }
}
