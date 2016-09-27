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
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by Karnaukh Roman on 08.07.2016.
 */
public class Tests {

    String packagePath = "ua.privatbank.ap24.beta.SplashActivity";

    @Rule
    public ActivityTestRule<?> mActivityRule = newActivityTestRule(packagePath);

    @NonNull
    private ActivityTestRule newActivityTestRule(String className) {
        return new ActivityTestRule(activityClass(className));
    }

    private static Class<? extends Activity> activityClass(String className) {
        try {
            return (Class<? extends Activity>) Class.forName(className);
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
        Context targetContext = mActivityRule.getActivity().getApplicationContext();
        String packageName = targetContext.getPackageName();
        int viewId = targetContext.getResources().getIdentifier(id, "id", packageName);
        return viewId;
    }

}
