package com.example.mboileau.gnome_city;

//all the import we need in this class
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This activity will download the Json File
 */

public class ChargementActivity extends AppCompatActivity {

    private final ChargementPresenter presenter = new ChargementPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargement);
        presenter.dlbegin();
    }

    /**
     * call the next activity
     */

    public void acceder() {
        Intent intent = new Intent(this, ChoiceActivity.class);
        startActivity(intent);
    }
}
