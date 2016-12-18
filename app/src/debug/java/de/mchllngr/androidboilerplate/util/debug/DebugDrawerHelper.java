package de.mchllngr.androidboilerplate.util.debug;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindString;
import butterknife.ButterKnife;
import de.mchllngr.androidboilerplate.R;
import io.palaima.debugdrawer.DebugDrawer;
import io.palaima.debugdrawer.actions.ActionsModule;
import io.palaima.debugdrawer.actions.SpinnerAction;
import io.palaima.debugdrawer.base.DebugModule;
import io.palaima.debugdrawer.commons.BuildModule;
import io.palaima.debugdrawer.commons.DeviceModule;
import io.palaima.debugdrawer.commons.NetworkModule;
import io.palaima.debugdrawer.commons.SettingsModule;
import io.palaima.debugdrawer.fps.FpsModule;
import io.palaima.debugdrawer.location.LocationModule;
import io.palaima.debugdrawer.scalpel.ScalpelModule;
import jp.wasabeef.takt.Takt;

/**
 * Helper-class for easier use with {@link DebugDrawer}.
 */
public class DebugDrawerHelper {

    /**
     * {@link AppCompatActivity} used for initialising.
     */
    private final AppCompatActivity activity;
    /**
     * {@link String} used for initialising the NightMode-{@link ActionsModule}.
     */
    @BindString(R.string.debug_night_mode_select)
    String debugNightModeSelect;
    /**
     * {@link String} used for initialising the NightMode-{@link ActionsModule}.
     */
    @BindString(R.string.debug_night_mode_yes)
    String debugNightModeYes;
    /**
     * {@link String} used for initialising the NightMode-{@link ActionsModule}.
     */
    @BindString(R.string.debug_night_mode_no)
    String debugNightModeNo;
    /**
     * {@link String} used for initialising the NightMode-{@link ActionsModule}.
     */
    @BindString(R.string.debug_night_mode_auto)
    String debugNightModeAuto;
    /**
     * {@link String} used for initialising the NightMode-{@link ActionsModule}.
     */
    @BindString(R.string.debug_night_mode_follow_system)
    String debugNightModeFollowSystem;
    /**
     * {@link DebugDrawer} reference to use.
     */
    private DebugDrawer debugDrawer;

    /**
     * Constructor with {@link AppCompatActivity} used for initialising.
     *
     * @param activity {@link AppCompatActivity} used for initialising
     */
    public DebugDrawerHelper(@NonNull AppCompatActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
    }

    /**
     * Initialises the {@link DebugDrawer}.
     */
    public void initDebugDrawer(boolean withLocation) {
        ArrayList<DebugModule> modules = new ArrayList<>();

        modules.add(new ActionsModule(getNightModeActionsModule()));
        modules.add(new ScalpelModule(activity));
        if (withLocation) modules.add(new LocationModule(activity));
        modules.add(new NetworkModule(activity));
        modules.add(new FpsModule(Takt.stock(activity.getApplication())));
        modules.add(new BuildModule(activity));
        modules.add(new DeviceModule(activity));
        modules.add(new SettingsModule(activity));

        debugDrawer = new DebugDrawer.Builder(activity)
                .modules(modules.toArray(new DebugModule[modules.size()]))
                .build();
    }

    /**
     * Returns the {@link ActionsModule} for selecting the
     * {@link android.support.v7.app.AppCompatDelegate.NightMode}
     */
    private SpinnerAction getNightModeActionsModule() {
        return new SpinnerAction<>(
                Arrays.asList(
                        debugNightModeSelect,
                        debugNightModeYes,
                        debugNightModeNo,
                        debugNightModeAuto,
                        debugNightModeFollowSystem
                ),
                value -> {
                    int selectedMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;

                    if (value.equals(debugNightModeYes))
                        selectedMode = AppCompatDelegate.MODE_NIGHT_YES;
                    else if (value.equals(debugNightModeNo))
                        selectedMode = AppCompatDelegate.MODE_NIGHT_NO;
                    else if (value.equals(debugNightModeAuto))
                        selectedMode = AppCompatDelegate.MODE_NIGHT_AUTO;

                    activity.getDelegate().setLocalNightMode(selectedMode);
                    activity.recreate();
                }
        );
    }

    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    public void onStart() {
        debugDrawer.onStart();
    }

    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    public void onResume() {
        debugDrawer.onResume();
    }

    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    public void onPause() {
        debugDrawer.onPause();
    }


    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    public void onStop() {
        debugDrawer.onStop();
    }
}
