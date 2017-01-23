package com.example.mboileau.gnome_city;

import java.util.ArrayList;

/**
 * Created by mboileau on 17/01/17.
 */

public class FilterFiltrage {

    /**
     * methode for the sorting
     * @param work
     */
    public void triArrayList(String work) {
        ArrayList<Habitant> nain=new ArrayList<>();
        ArrayList<Habitant> gnomes = Singleton.getInstance().getGnomes();
        int size =gnomes.size();
        for (int  i=0; i < size; i++) {
            if (gnomes.get(i).getProfessions().contains(work)) {
                nain.add(gnomes.get(i));
            }
        }
        Singleton.getInstance().setGnomesfilter(nain);
    }
}
