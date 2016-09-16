package de.mchllngr.androidboilerplate.module.main;

import de.mchllngr.androidboilerplate.base.BasePresenter;

/**
 * {@link com.hannesdorfmann.mosby.mvp.MvpPresenter} for the {@link MainActivity}
 *
 * @author Michael Langer (<a href="https://github.com/mchllngr" target="_blank">GitHub</a>)
 */
@SuppressWarnings("ConstantConditions")
public class MainPresenter extends BasePresenter<MainView> {

//    /**
//     * {@link Example}-class for an example for Dagger2-injection.
//     */
//    @Inject
//    Example exampleDependency;

    /**
     * Instances the {@link com.hannesdorfmann.mosby.mvp.MvpPresenter}.
     *
     * @param view {@link android.view.View} of the associated {@link android.app.Activity}
     */
    @Override
    public void attachView(MainView view) {
        super.attachView(view);
        getApplicationComponent().inject(this);
    }

    /**
     * Destroys resources used in the {@link com.hannesdorfmann.mosby.mvp.MvpPresenter}.
     *
     * @param retainInstance defining if the instance should be retained or not
     */
    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
