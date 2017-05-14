package de.mchllngr.androidboilerplate.base;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import de.mchllngr.androidboilerplate.R;

/**
 * Base-class for work concerning every {@link android.app.Activity}.
 *
 * @param <V> view-interface for this activity
 * @param <P> presenter for this activity
 */
public abstract class BaseActivity<V extends MvpView, P extends MvpBasePresenter<V>>
        extends DebugBaseActivity<V, P> {

    /**
     * Overrides {@link android.support.v7.app.AppCompatActivity#setSupportActionBar(Toolbar)} to
     * allow setting the default title when called.
     *
     * @param toolbar toolbar to set
     */
    @Override
    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        super.setSupportActionBar(toolbar);
        setDefaultActionBarTitle();
    }

    /**
     * Sets the default title for the {@link android.support.v7.app.ActionBar}.
     */
    private void setDefaultActionBarTitle() {
        setActionBarTitle(R.string.app_name);
    }

    /**
     * Sets the title for the {@link android.support.v7.app.ActionBar}.
     *
     * @param titleResId {@link StringRes} for the title
     */
    public void setActionBarTitle(@StringRes int titleResId) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(titleResId);
    }

    /**
     * Sets the visibility of the home-button (up-arrow).
     */
    public void setShowHomeButton(boolean showHomeButton) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeButton);
            getSupportActionBar().setDisplayShowHomeEnabled(showHomeButton);
        }
    }
}
