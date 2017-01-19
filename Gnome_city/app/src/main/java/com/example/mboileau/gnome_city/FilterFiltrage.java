package com.example.mboileau.gnome_city;

import java.util.ArrayList;

/**
 * Created by mboileau on 17/01/17.
 */

public class FilterFiltrage {
    private final FilterPresenter presenter;

    /**
     * Initialize the presenter
     * @param presenter
     */
    public FilterFiltrage (FilterPresenter presenter) {
        this.presenter=presenter;
    }

    /**
     * methode for the sorting
     * @param work
     */
    public void triArrayList(String work) {
        ArrayList<Habitant> nain=new ArrayList<>();
        ArrayList<Habitant> gnomesAux = Singleton.getInstance().getGnomes();
        int size =gnomesAux.size();
        for (int  i=0; i < size; i++) {
            if (gnomesAux.get(i).getProfessions().contains(work)) {
                nain.add(gnomesAux.get(i));
            }
        }
        Singleton.getInstance().setGnomesfilter(nain);
    }
}
