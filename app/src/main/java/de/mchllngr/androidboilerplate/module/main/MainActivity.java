package de.mchllngr.androidboilerplate.module.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.mchllngr.androidboilerplate.R;
import de.mchllngr.androidboilerplate.base.BaseActivity;
import timber.log.Timber;

/**
 * {@link android.app.Activity} for (TODO) doing something.
 *
 * @author Michael Langer (<a href="https://github.com/mchllngr" target="_blank">GitHub</a>)
 */
public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    /**
     * {@link Toolbar} for this {@link android.app.Activity}.
     */
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    /**
     * {@link android.support.design.widget.FloatingActionButton} for an example
     * with {@link ButterKnife}.
     */
    @BindView(R.id.fab)
    FloatingActionButton fab;

    /**
     * Static factory method that initializes and starts the {@link android.app.Activity}.
     */
    public static void start(@NonNull Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }

    /**
     * Creates the {@link MainPresenter} for this {@link android.app.Activity}.
     *
     * @return {@link MainPresenter} for this {@link android.app.Activity}
     */
    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    /**
     * Instances the {@link android.app.Activity}.
     *
     * @param savedInstanceState {@link Bundle}
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Gets the instance of the {@link android.app.Activity}.
     *
     * @return the {@link android.app.Activity}
     */
    @NonNull
    @Override
    public FragmentActivity getActivity() {
        return this;
    }
}
