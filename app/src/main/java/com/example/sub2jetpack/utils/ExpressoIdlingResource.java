package com.example.sub2jetpack.utils;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class ExpressoIdlingResource {
    private static final String RESOURCE = "GLOBAL";
    private static final CountingIdlingResource idlingResource = new CountingIdlingResource(RESOURCE);

    public static void increment(){
        idlingResource.increment();
    }

    public static void decrement(){
        idlingResource.decrement();
    }

    public static IdlingResource getExpressoIdlingResource(){
        return idlingResource;
    }
}
