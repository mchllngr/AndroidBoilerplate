package de.mchllngr.androidboilerplate;

import android.support.v7.app.AppCompatDelegate;

import de.mchllngr.androidboilerplate.base.BaseApp;
import de.mchllngr.androidboilerplate.injection.ApplicationComponent;
import de.mchllngr.androidboilerplate.injection.ApplicationModule;
import de.mchllngr.androidboilerplate.injection.DaggerApplicationComponent;

/**
 * {@link App} for the {@link android.app.Application}
 *
 * @author Michael Langer (<a href="https://github.com/mchllngr" target="_blank">GitHub</a>)
 */
public class App extends BaseApp {

    /**
     * Sets the default night mode to auto.
     */
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    /**
     * Dagger2-component used for injection.
     */
    private ApplicationComponent applicationComponent;

    /**
     * Instances the {@link android.app.Application}.
     */
    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    /**
     * Gets the Dagger2-component for the whole application.
     *
     * @return Dagger2-component for the whole application
     */
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
