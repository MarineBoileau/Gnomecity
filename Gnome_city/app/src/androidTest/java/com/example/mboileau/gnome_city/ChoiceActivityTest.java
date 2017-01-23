package com.example.mboileau.gnome_city;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.intent.Intents.intended;



/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ChoiceActivityTest {

    private static final String PACKAGE_NAME = "com.example.mboileau.gnome_city";

    @Rule
    public IntentsTestRule<ChoiceActivity> mIntentsRule = new IntentsTestRule<>(ChoiceActivity.class);

    @Test
    public void goToTheGoodNextActivityList() throws Exception {
        onView(withId(R.id.button2)).perform(click());

        intended(hasComponent(hasShortClassName(".ListActivity")));
        intended(toPackage(PACKAGE_NAME));
    }

    @Test
    public void goToTheGoodNextActivityFilter() throws Exception {
        onView(withId(R.id.button3)).perform(click());

        intended(hasComponent(hasShortClassName(".FilterActivity")));
        intended(toPackage(PACKAGE_NAME));
    }
}
