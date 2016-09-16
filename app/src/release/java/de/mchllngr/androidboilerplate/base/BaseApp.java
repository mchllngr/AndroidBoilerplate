package de.mchllngr.androidboilerplate.base;

import android.app.Application;

import de.mchllngr.androidboilerplate.util.timber.ReleaseTree;
import timber.log.Timber;

/**
 * Base-class used for initialising {@link Timber}.
 *
 * @author Michael Langer (<a href="https://github.com/mchllngr" target="_blank">GitHub</a>)
 */
public class BaseApp extends Application {

    /**
     * Initialises the {@link android.app.Application}.
     */
    public void onCreate() {
        super.onCreate();

        initTimber();
    }

    /**
     * Initialises {@link Timber} with release configuration
     */
    private void initTimber() {
        Timber.plant(new ReleaseTree());
    }
}
