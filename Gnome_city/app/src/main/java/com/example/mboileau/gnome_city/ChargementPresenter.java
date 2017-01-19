package com.example.mboileau.gnome_city;

/**
 * Created by mboileau on 17/01/17.
 */

public class ChargementPresenter {

    private final ChargementActivity activity;
    private final ChargementDL download =new ChargementDL(this);

    /**
     * @param activity
     */
    public ChargementPresenter(ChargementActivity activity) {
        this.activity=activity;
    }

    /**
     * call for the download to begin
     */
    public void dlbegin(){
        download.dlbegin();
    }

    /**
     * call for the next activity in the activity
     */
    public void dlend() {
        activity.acceder();
    }
}