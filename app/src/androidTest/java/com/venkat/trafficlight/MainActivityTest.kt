package com.venkat.trafficlight

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest() {

    @get:Rule
    var activityTestRule: ActivityTestRule<MainActivity> =
        ActivityTestRule(MainActivity::class.java)
    private lateinit var mainActivity: MainActivity
    @Before
    fun setUp() {
        mainActivity = activityTestRule.activity
    }
    @Test
    fun testViewsOnStartUp()
    {
        onView(withId(R.id.yellow)).check(matches(isDisplayed()))
        onView(withId(R.id.green)).check(matches(isDisplayed()))
        onView(withId(R.id.red)).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
    }
}