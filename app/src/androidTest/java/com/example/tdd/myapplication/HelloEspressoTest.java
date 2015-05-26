package com.example.tdd.myapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
public  class HelloEspressoTest {

    private final String celsius;
    private final String fahrenheit;
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Parameters
    public  static Iterable<Object[]>data(){
        return Arrays.asList(new Object[][]{
                {"0","32.0"}
        });
    }

    public HelloEspressoTest(String celsius, String fahrenheit){
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }
    @Test
    public void convert_temperator_from_0_celsius_should_32_fahrenheit(){
        onView(withId(R.id.txtCelsius)).perform(typeText(this.celsius));

        onView(withId(R.id.txtFah)).check(matches(withText(this.fahrenheit)));
    }

}
