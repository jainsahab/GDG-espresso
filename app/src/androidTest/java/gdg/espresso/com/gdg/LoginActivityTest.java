package gdg.espresso.com.gdg;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class, false, false);

    @Test
    public void loginWithValidCredentials() throws Exception {
        activityTestRule.launchActivity(new Intent());

        onView(withId(R.id.email)).perform(typeText("user@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("Hello123"));

        onView(withId(R.id.email_sign_in_button)).perform(click());

        onView(withId(R.id.login_result)).check(matches(withText("Login Successful")));
        onView(withId(R.id.login_result)).check(matches(withTextColor(android.R.color.holo_green_dark)));
    }

    @Test
    public void loginWithInvalidCredentials() throws Exception {
        activityTestRule.launchActivity(new Intent());

        onView(withId(R.id.email)).perform(typeText("invalid-email@gmail.com"));
        onView(withId(R.id.password)).perform(typeText("random-password"));

        onView(withId(R.id.email_sign_in_button)).perform(click());

        onView(withId(R.id.login_result)).check(matches(withText("Login Failed")));
        onView(withId(R.id.login_result)).check(matches(withTextColor(android.R.color.holo_red_dark)));
    }

    private Matcher<? super View> withTextColor(final int colorResourceId) {
        return new CustomTypeSafeMatcher<View>("color with" + colorResourceId) {
            @Override
            protected boolean matchesSafely(View view) {
                if (!(view instanceof TextView)) {
                    return false;
                }
                TextView textView = (TextView) view;
                ColorStateList expectedColorStateList = ColorStateList.valueOf(activityTestRule.getActivity().getResources().getColor(colorResourceId));
                return textView.getTextColors().getDefaultColor() == expectedColorStateList.getDefaultColor();
            }
        };
    }
}