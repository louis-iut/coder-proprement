package fr.iut.iem.comics;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;

import com.facebook.testing.screenshot.ScreenshotRunner;

/**
 * Created by louis on 14/12/2017.
 */

public class ScreenshotTestRunner extends AndroidJUnitRunner {
    @Override
    public void onCreate(Bundle arguments) {
        ScreenshotRunner.onCreate(this, arguments);
        super.onCreate(arguments);
    }

    @Override
    public void finish(int resultCode, Bundle results) {
        ScreenshotRunner.onDestroy();
        super.finish(resultCode, results);
    }
}
