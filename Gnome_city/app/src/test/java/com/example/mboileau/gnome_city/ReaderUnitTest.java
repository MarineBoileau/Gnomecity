package com.example.mboileau.gnome_city;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by mboileau on 23/01/17.
 */

public class ReaderUnitTest {
    ChargementReading readertest = new ChargementReading();
    ArrayList<Habitant> gnome = new ArrayList<>();
    ArrayList<Habitant> gnomes = new ArrayList<>();
    Habitant someone = new Habitant();
    String data="{\"Brastlewark\":[{\"id\":0,\"name\":\"Tobus Quickwhistle\"," +
            "\"thumbnail\":\"http://www.publicdomainpictures.net/pictures/10000/nahled/thinking-monkey-11282237747K8xB.jpg\"," +
            "\"age\":306,\"weight\":39.065952,\"height\":107.75835,\"hair_color\":\"Pink\",\"professions\":[\"Metalworker\",\"Woodcarver\"," +
            "\"Stonecarver\",\" Tinker\",\"Tailor\",\"Potter\"],\"friends\":[\"Cogwitz Chillwidget\",\"Tinadette Chillbuster\"]},{\"id\":1,\"name\":\"Fizkin Voidbuster\",\"thumbnail\":\"http://www.publicdomainpictures.net/pictures/120000/nahled/white-hen.jpg\",\"age\":288,\"weight\":35.279167,\"height\":110.43628,\"hair_color\":\"Green\",\"professions\":[\"Brewer\",\"Medic\",\"Prospector\",\"Gemcutter\",\"Mason\",\"Tailor\"],\"friends\":[]},{\"id\":2,\"name\":\"Malbin Chromerocket\",\"thumbnail\":\"http://www.publicdomainpictures.net/pictures/30000/nahled/maple-leaves-background.jpg\",\"age\":166,\"weight\":35.88665,\"height\":106.14395,\"hair_color\":\"Red\",\"professions\":[\"Cook\",\"Baker\",\"Miner\"],\"friends\":[\"Fizwood Voidtossle\"]},{\"id\":3,\"name\":\"Midwig Gyroslicer\",\"thumbnail\":\"http://www.publicdomainpictures.net/pictures/10000/nahled/1-1275919724d1Oh.jpg\",\"age\":240,\"weight\":40.97596,\"height\":127.88554,\"hair_color\":\"Red\",\"professions\":[\"Carpenter\",\"Farmer\",\"Stonecarver\",\"Brewer\",\"Tax inspector\",\"Prospector\"],\"friends\":[\"Sarabink Tinkbuster\",\"Tinadette Wrongslicer\"]}]}";

    
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
        assertEquals(4,gnome.size());
    }

    @Test
    public void gnomeequaltoreadTest () throws Exception {
        JSONObject object = new JSONObject(data);
        gnome.addAll(readertest.readMessagesArray(object));
        assertEquals(gnome.get(0), gnomes.get(0));
    }
}
