package de.mchllngr.androidboilerplate.base;

import android.support.v4.app.FragmentActivity;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Base-interface for every view.
 */
public interface BaseView extends MvpView {

    /**
     * Allows the {@link BasePresenter} to get the associated Activity.
     *
     * @return {@link FragmentActivity}
     * @see BasePresenter
     */
    FragmentActivity getActivity();
}
