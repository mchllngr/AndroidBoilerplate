package de.mchllngr.androidboilerplate.base;

import android.support.annotation.StringRes;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Base-class for work concerning every {@link android.support.v4.app.Fragment}.
 *
 * @param <V> view-interface for this fragment
 * @param <P> presenter for this fragment
 */
public abstract class BaseFragment<V extends MvpView, P extends MvpBasePresenter<V>>
        extends MvpFragment<V, P> {

    /**
     * Sets the title for the {@link android.support.v7.app.ActionBar} in the
     * {@link android.app.Activity} via the given {@link StringRes} if the
     * {@link android.app.Activity} is a subclass from {@link BaseActivity}.
     *
     * @param titleResId {@link StringRes} for the title
     */
    public void setActionBarTitle(@StringRes int titleResId) {
        if (getActivity() instanceof BaseActivity)
            ((BaseActivity) getActivity()).setActionBarTitle(titleResId);
    }
}
