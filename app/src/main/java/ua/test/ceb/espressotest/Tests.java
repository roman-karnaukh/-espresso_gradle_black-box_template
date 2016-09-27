package ua.test.ceb.espressotest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


/**
 * Created by Karnaukh Roman on 08.07.2016.
 */
public class Tests {

    String packagePath = "your.package.Activity";

    @Rule
    public ActivityTestRule<?> mActivityRule = myActivityTestRule("your.package.Activity");

    @NonNull
    private ActivityTestRule myActivityTestRule(String className) {
        try {
            return new ActivityTestRule(Class.forName(className));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void mytest() throws Exception{
        Thread.sleep(7000);
//        onView(withText("Hello world!")).check(matches(isDisplayed()));
        onView(withId(getId("editPass"))).check(matches(isDisplayed()));

    }

    public int getId(String id){

        Context targetContext = InstrumentationRegistry.getContext();
        String packageName = targetContext.getPackageName();
        int viewId = targetContext.getResources().getIdentifier(id, "id", packageName);
        return viewId;
    }

}
