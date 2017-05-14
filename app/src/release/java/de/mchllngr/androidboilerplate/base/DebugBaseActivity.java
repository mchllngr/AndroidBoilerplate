package de.mchllngr.androidboilerplate.base;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * BaseDebug-class used for debug initializations.
 * <p>
 * Empty in Release-BuildVariant.
 */
public abstract class DebugBaseActivity<V extends MvpView, P extends MvpBasePresenter<V>>
        extends MvpActivity<V, P> {
}
