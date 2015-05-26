package com.example.tdd.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import javax.annotation.security.PermitAll;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Pongrapee.P on 25/05/2015.
 */

@RunWith(Parameterized.class)
@LargeTest
public class HelloEspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Parameters
    public static Iterable
    @Test public void convert_temperator_from_0_celsius_should_32_fahrenheit(){
        onView(withId(R.id.txtCelsius)).perform(typeText("0"));

        onView(withId(R.id.txtFah)).check(matches(withText("32.0")));
    }

}
