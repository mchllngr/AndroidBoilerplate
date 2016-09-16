package de.mchllngr.androidboilerplate.base;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * BaseDebug-class used for debug initializations.
 * <p>
 * Empty in Release-BuildVariant.
 *
 * @author Michael Langer (<a href="https://github.com/mchllngr" target="_blank">GitHub</a>)
 */
public abstract class DebugBaseActivity<V extends MvpView, P extends MvpBasePresenter<V>>
        extends MvpActivity<V, P> {
}
