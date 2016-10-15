package de.mchllngr.androidboilerplate.base;

import android.support.annotation.StringRes;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpView;

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
     * {@link android.app.Activity} via the given {@link StringRes}.
     *
     * @param titleResId {@link StringRes} for the title
     */
    public void setTitle(@StringRes int titleResId) {
        ((BaseActivity) getActivity()).setActionBarTitle(titleResId);
    }
}
