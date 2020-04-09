package com.example.sub2jetpack;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.example.sub2jetpack.ui.MainActivity;
import com.example.sub2jetpack.utils.ExpressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
        IdlingRegistry.getInstance().register(ExpressoIdlingResource.getExpressoIdlingResource());
    }

    @After
    public void tearDown() throws Exception {
        IdlingRegistry.getInstance().unregister(ExpressoIdlingResource.getExpressoIdlingResource());
    }

    @Test
    public void loadUpcomingMovies(){
        onView(withId(R.id.rv_upcoming)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_upcoming)).perform(RecyclerViewActions.scrollToPosition(10));
    }

    @Test
    public void loadNewsMovies(){
        onView(withId(R.id.rv_news)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_news)).perform(RecyclerViewActions.scrollToPosition(10));
    }

    @Test
    public void loadDetailUpComingMovies(){
        onView(withId(R.id.rv_upcoming)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_upcoming)).perform(RecyclerViewActions.actionOnItemAtPosition(1,click()));
        onView(withId(R.id.constraint_detail_title_container)).check(matches(isDisplayed()));
        onView(withId(R.id.constraint_detail_title_container)).perform(ViewActions.swipeUp());
    }

    @Test
    public void loadDetailPlayingMovies(){
        onView(withId(R.id.rv_news)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_news)).perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
        onView(withId(R.id.constraint_detail_title_container)).check(matches(isDisplayed()));
        onView(withId(R.id.constraint_detail_title_container)).perform(ViewActions.swipeUp());
    }

    @Test
    public void loadTvShow(){
        onView(withId(R.id.bottom_navbar)).check(matches(isDisplayed()));
        onView(withId(R.id.tvShow)).perform(click());
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition(12));
    }

    @Test
    public void loadDetailTvShow(){
        onView(withId(R.id.bottom_navbar)).check(matches(isDisplayed()));
        onView(withId(R.id.tvShow)).perform(click());
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(2,click()));
        onView(withId(R.id.constraint_detail_title_container)).check(matches(isDisplayed()));
        onView(withId(R.id.constraint_detail_title_container)).perform(ViewActions.swipeUp());
    }
}