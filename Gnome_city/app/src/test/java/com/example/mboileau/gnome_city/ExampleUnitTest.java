package com.example.mboileau.gnome_city;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{
    Habitant habitant1= new Habitant();;
    Habitant habitant2= new Habitant();;
    Habitant habitant3= new Habitant();;
    ArrayList<Habitant> population = new ArrayList<>();
    private static final String TAG = "Mon test";
    private String work;
    FilterFiltrage test = new FilterFiltrage();


    @Before
    public void before(){
        habitant1.setName("titi");
        habitant1.setProfessions("facteur");
        habitant1.setProfessions("fermier");

        habitant2.setName("toto");
        habitant2.setProfessions("facteur");
        habitant2.setProfessions("plombier");

        habitant3.setName("tata");
        habitant3.setProfessions("fermier");
        habitant3.setProfessions("plombier");

        population.add(habitant1);
        population.add(habitant2);
        population.add(habitant3);

        Singleton.getInstance().setGnomes(population);
    }

    @After
    public void after(){
        population = null;
        Singleton.getInstance().setGnomes(null);
        Singleton.getInstance().setGnomesfilter(null);
    }
    @Test
    public void theFilterListIsNotEmptyTest() throws Exception {
        work = "fermier";
        test.triArrayList(work);
        assertEquals(2,Singleton.getInstance().getGnomesall().size());
    }
}