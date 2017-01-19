package com.example.mboileau.gnome_city;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Activity for the sorting of the arraylist
 */
public class FilterActivity extends AppCompatActivity implements  FilterPresenter.View {

    private final FilterPresenter presenter = new FilterPresenter(this);

    private ListView mListView;
    private final String[] professions = {"Metalworker", "Woodcarver", "Stonecarver", " Tinker", "Tailor", "Potter",
            "Brewer", "Medic", "Prospector", "Gemcutter", "Mason", "Cook", "Baker", "Miner", "Carpenter",
            "Farmer", "Tax inspector", "Smelter", "Butcher", "Sculptor", "Blacksmith", "Mechanic", "Leatherworker",
            "Marble Carver"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        afficherchoix();

    }

    /**
     * the show the list of the professions
     */
    public void afficherchoix() {
        mListView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FilterActivity.this,
                android.R.layout.simple_list_item_1, professions);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String work = ((TextView) view).getText().toString();
                presenter.tri(work);
            }
        });

    }

    /**
     * Start the new activity.
     */
    public void flitertolist() {

        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

}
