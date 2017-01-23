package com.example.mboileau.gnome_city;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by mboileau on 23/01/17.
 */
//@RunWith(MockitoJUnitRunner.class)
public class ReadTest {
    ChargementReading readertest = new ChargementReading();
    ArrayList<Habitant> gnome = new ArrayList<>();
    ArrayList<Habitant> gnomes = new ArrayList<>();
    Habitant someone = new Habitant();
    String data="{\"Brastlewark\":[{\"id\":0,\"name\":\"Tobus Quickwhistle\"," +
            "\"thumbnail\":\"http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg\"," +
            "\"age\":306,\"weight\":39.065952,\"height\":107.75835,\"hair_color\":\"Pink\",\"professions\":[\"Metalworker\",\"Woodcarver\"," +
            "\"Stonecarver\",\" Tinker\",\"Tailor\",\"Potter\"],\"friends\":[\"Cogwitz Chillwidget\",\"Tinadette Chillbuster\"]}]}";

    @Before
    public void init(){
        gnomes.clear();
        someone.setId(0);
        someone.setName("Tobus Quickwhistle");
        someone.setAge(306);
        someone.setThumbnail("http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg");
        someone.setHeight(107.75835);
        someone.setWeight(39.065952);
        someone.setHaircolor("Pink");
        someone.setProfessions("Metalworker");
        someone.setProfessions("Woodcarver");
        someone.setProfessions("Stonecarver");
        someone.setProfessions(" Tinker");
        someone.setProfessions("Tailor");
        someone.setProfessions("Potter");
        someone.setFriends("Cogwitz Chillwidget");
        someone.setFriends("Tinadette Chillbuster");

        gnomes.add(someone);
    }

    @Test
    public void readmessageobjectTest () throws Exception {
        JSONObject object = new JSONObject(data);
        gnome.addAll( readertest.readMessagesArray(object));
        assertEquals(1,gnome.size());
    }

    @Test
    public void gnomeequaltoreadTest () throws Exception {
        JSONObject object = new JSONObject(data);
        gnome.addAll(readertest.readMessagesArray(object));
        assertEquals(gnome.get(0), gnomes.get(0));
    }
}

