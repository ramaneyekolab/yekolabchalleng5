package challege5.challege5;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by hp on 06/04/2018.
 */

@RunWith(AndroidJUnit4.class)
public class Test1Test {
    @Rule
    public ActivityTestRule<LoginActivity> monLoginActivityTestRule=new ActivityTestRule<>(LoginActivity.class);
    @Test
    public void mail_passe_vide(){
        onView(withId(R.id.tv_email)).perform(clearText());
        onView(withText("CONNEXION")).perform(click());
        onView(withId(android.R.id.message)).inRoot(withDecorView(not(is(monLoginActivityTestRule.getActivity().getWindow().
                getDecorView())))).check(matches(withText("Votre email ou votre mot de passe est vide !!!")));
    }
    @Test
    public void passe_vide(){
        onView(withId(R.id.tv_email)).perform(typeText("ghost@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.tv_password)).perform(clearText());
        onView(withText("CONNEXION")).perform(click());
        onView(withId(android.R.id.message)).inRoot(withDecorView(not(is(monLoginActivityTestRule.getActivity().getWindow().
                getDecorView())))).check(matches(withText("Votre email ou votre mot de passe est vide !!!")));
    }

    @Test
    public void mail_vide() {
        onView(withId(R.id.tv_password)).perform(typeText("ghost123"), closeSoftKeyboard());
        onView(withId(R.id.tv_email)).perform(clearText());
        onView(withText("CONNEXION")).perform(click());
        onView(withId(android.R.id.message)).inRoot(withDecorView(not(is(monLoginActivityTestRule.getActivity().getWindow().
                getDecorView())))).check(matches(withText("Votre email ou votre mot de passe est vide !!!")));
    }
}
