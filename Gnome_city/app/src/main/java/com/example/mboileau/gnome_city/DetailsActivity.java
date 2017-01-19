package com.example.mboileau.gnome_city;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Activity : show the detail of 1 gnome
 */
public class DetailsActivity extends AppCompatActivity {

    private Habitant gnome =new Habitant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //we receive the Habitant from the last activity we want his details
        Bundle bundle = getIntent().getExtras();
        gnome = bundle.getParcelable("Habitant");

        StringBuilder allprofessions = new StringBuilder();
        String profession;
        StringBuilder allfriends = new StringBuilder();
        String friend;
        int j=gnome.getProfessions().size();
        for (int i=0;i<j;i++) {
            allprofessions.append(gnome.getProfessions().get(i) +getString(R.string.virgule_label));
        }
        profession=allprofessions.toString();
        j=gnome.getFriends().size();
        for (int i=0;i<j;i++) {
            allfriends.append(gnome.getFriends().get(i)+getString(R.string.virgule_label));
        }
        friend =allfriends.toString();

        //we show all the elements
        final TextView name = (TextView) findViewById(R.id.name);
        final TextView age = (TextView) findViewById(R.id.age);
        final TextView weight = (TextView) findViewById(R.id.weight);
        final TextView height = (TextView) findViewById(R.id.height);
        final TextView hair_color = (TextView) findViewById(R.id.hair_color);
        final TextView professions = (TextView) findViewById(R.id.professions);
        final TextView friends = (TextView) findViewById(R.id.friends);
        final ImageView avatar = (ImageView)findViewById(R.id.avatar);
        name.setText(gnome.getName());
        age.setText(String.format(getString(R.string.age_label), String.valueOf(gnome.getAge())));
        weight.setText(String.format(getString(R.string.weight_label), Double.toString(gnome.getWeight())));
        height.setText(String.format(getString(R.string.height_label), Double.toString(gnome.getHeight())));
        hair_color.setText(String.format(getString(R.string.hair_color_label),gnome.getHaircolor()));
        professions.setText(String.format(getString(R.string.professions_label), profession));
        friends.setText(String.format(getString(R.string.friends_label),friend));
        Picasso.with(getBaseContext()).load(gnome.getThumbnail()).into(avatar);

    }
}
