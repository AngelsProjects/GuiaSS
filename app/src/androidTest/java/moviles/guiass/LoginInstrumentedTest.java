package moviles.guiass;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import moviles.guiass.ui.LoginActivity;
import moviles.guiass.ui.MainActivity;
import moviles.guiass.ui.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginInstrumentedTest {
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
    public void loginAction() {
        onView(withId(R.id.noControl)).perform(typeText("14490924"));
        onView(withId(R.id.password)).perform(typeText("Arci9611"));
        onView(withId(R.id.email_sign_in_button)).perform(click());
    }

}
