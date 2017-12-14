package fr.iut.iem.comics;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.widget.ProgressBar;

import com.facebook.testing.screenshot.Screenshot;
import com.facebook.testing.screenshot.ViewHelpers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import fr.iut.iem.comics.presentation.activity.ComicsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by louis on 14/12/2017.
 */

public class ScreenshotTest {

    @Rule
    public ActivityTestRule<ComicsActivity> activity =
            new ActivityTestRule<>(ComicsActivity.class, false, false);

    @Before
    public void init() {
        activity.launchActivity(null);
    }

    @Test
    public void comicsListScreenshot() {
        SystemClock.sleep(3000);

        final ProgressBar progressBar = new ProgressBar(activity.getActivity());
        progressBar.setProgress(0);
        ViewHelpers.setupView(progressBar)
                .setExactHeightDp(16)
                .setExactWidthDp(240)
                .layout();
        Screenshot.snap(progressBar)
                .setName("ok")
                .record();

        Screenshot.snapActivity(activity.getActivity()).record();

    }

    @Test
    public void comicsDetailScreenshot() {
        onView(withId(R.id.recycler_view_comics_list)).perform(click());

        SystemClock.sleep(3000);

        Screenshot.snapActivity(activity.getActivity()).record();
    }
}
