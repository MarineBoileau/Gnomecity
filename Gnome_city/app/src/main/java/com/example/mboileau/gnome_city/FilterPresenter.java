package com.example.mboileau.gnome_city;

/**
 * Created by mboileau on 17/01/17.
 */

public class FilterPresenter {

    private final FilterPresenter.View activity;
    private final FilterFiltrage filtrer = new FilterFiltrage();

    /**
     * @param activity
     */
    public FilterPresenter (FilterPresenter.View activity) {
        this.activity=activity;
    }

    /**
     * Call for the sorting
     * @param work
     */
    public void tri (String work) {
        filtrer.triArrayList(work);
        activity.flitertolist();
    }

    /**
     *Creation of the interface view
     */
    public interface View {
        void flitertolist();
    }

}
