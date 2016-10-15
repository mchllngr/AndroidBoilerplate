package de.mchllngr.androidboilerplate.base;

import android.app.Application;

import de.mchllngr.androidboilerplate.util.timber.ReleaseTree;
import timber.log.Timber;

/**
 * Base-class used for initialising {@link Timber}.
 */
public class BaseApp extends Application {

    @Override
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
