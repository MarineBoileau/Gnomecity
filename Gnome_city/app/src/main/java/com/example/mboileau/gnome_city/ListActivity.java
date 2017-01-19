package com.example.mboileau.gnome_city;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Activity for the recycle view
 */
public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final RecyclerView list =(RecyclerView) findViewById(R.id.list);

        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new MyAdapter());

    }

    /**
     * In order to call the next activity with the details
     * @param gnome
     */
    public void nextactivity (Habitant gnome) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("Habitant",gnome);
        startActivity(intent);

    }

    /**
     * MyAdapter is for the recycle view
     */
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private final ArrayList<Habitant> gnomes = Singleton.getInstance().getGnomesall();

        @Override
        public int getItemCount() {

            return gnomes.size();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.list_cell, parent, false);
            return new MyViewHolder(view);
        }


        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.display(gnomes.get(position));
        }

        /**
         * MyViewHolder is for printing each cell in the recycle view
         */
        public class MyViewHolder extends RecyclerView.ViewHolder {

            private final TextView name;
            private final ImageView avatar;
            private Habitant currenthabitant;

            /**
             * Assign each parameters of the view
             * @param itemView
             */
            public MyViewHolder(final View itemView) {
                super(itemView);

                name = (TextView) itemView.findViewById(R.id.name);
                avatar = (ImageView)itemView.findViewById(R.id.avatar1);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nextactivity(currenthabitant);
                    }
                });
            }

            /**
             * For display each name and avatar for each gnome
             * @param gnome
             */
            public void display(Habitant gnome) {
                currenthabitant = gnome;
                name.setText(gnome.getName());
                Picasso.with(getBaseContext()).load(gnome.getThumbnail()).into(avatar);

            }
        }
    }
}


