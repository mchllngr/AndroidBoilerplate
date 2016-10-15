package de.mchllngr.androidboilerplate.injection;

import javax.inject.Singleton;

import dagger.Component;
import de.mchllngr.androidboilerplate.module.main.MainPresenter;

/**
 * Dagger2-component for the whole application.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainPresenter presenter);
}
