package com.example.mboileau.gnome_city;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * This class is the MainActivity
 * Show a button and wait for a clik in order to begin the next activity
 */
public class MainActivity extends AppCompatActivity {


    /**
     * wait for a click from the user
     */
    private View.OnClickListener click = new View.OnClickListener(){

        @Override
        public  void onClick (View v){
            nextactivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button =(Button) findViewById(R.id.button);
        button.setOnClickListener(click);
    }
    /**
     * Start the next activity
     */
    public void nextactivity() {
        Intent intent = new Intent(this, ChargementActivity.class);
        startActivity(intent);
    }
}
