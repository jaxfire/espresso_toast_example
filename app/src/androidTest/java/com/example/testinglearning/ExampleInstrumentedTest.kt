package com.example.testinglearning

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var decorView: View

    @Before
    fun setUp() {
        activityScenarioRule.scenario.onActivity { activity ->
            decorView = activity.window.decorView
        }
    }

    @Test
    fun useAppContext() {

        onView(withId(R.id.show_toast_button)).perform(click())

//        onView(withText(TOAST_TEXT))
//            .inRoot(withDecorView(not(decorView)))
//            .check(matches(isDisplayed()))
//
        onView(withText(TOAST_TEXT)).inRoot(ToastMatcher()).check(matches(isDisplayed()))
    }
}