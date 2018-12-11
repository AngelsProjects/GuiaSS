package moviles.guiass.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.action.ViewActions;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        System.out.println("Starting test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Finished test");
    }

    @Test
    public void accessAllButtonsMenu() {
        onView(withId(R.id.btn_req)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.btn_dss)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.btn_dh)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.btn_pp)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.btn_ps)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void checkStepsTabs(){
        onView(withId(R.id.btn_pp)).perform(click());
        onView(withId(R.id.nav_2)).perform(click());
        onView(withId(R.id.nav_3)).perform(click());
        onView(withId(R.id.nav_1)).perform(click());
        onView(withId(R.id.nav_3)).perform(click());
        onView(withId(R.id.btn_ss)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.btn_tc)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.btn_ca)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.btn_cc)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void checkLastSteps(){
        onView(withId(R.id.btn_ps)).perform(click());
        onView(withId(R.id.btnToWork)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
    }
}