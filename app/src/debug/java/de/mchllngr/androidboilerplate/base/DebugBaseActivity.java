package de.mchllngr.androidboilerplate.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;

import com.canelmas.let.AskPermission;
import com.canelmas.let.DeniedPermission;
import com.canelmas.let.Let;
import com.canelmas.let.RuntimePermissionListener;
import com.canelmas.let.RuntimePermissionRequest;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import de.mchllngr.androidboilerplate.R;
import de.mchllngr.androidboilerplate.util.debug.DebugDrawerHelper;
import io.palaima.debugdrawer.DebugDrawer;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

/**
 * BaseDebug-class used for initialization of the {@link DebugDrawer}.
 */
public abstract class DebugBaseActivity<V extends MvpView, P extends MvpBasePresenter<V>> extends MvpActivity<V, P> implements RuntimePermissionListener {

    /**
     * {@link DebugDrawerHelper} reference to use.
     */
    private DebugDrawerHelper debugDrawerHelper;

    /**
     * Overrides {@link android.support.v7.app.AppCompatActivity#setContentView(int)} to
     * allow setting the {@link DebugDrawer} when called.
     *
     * @param layoutResID {@link LayoutRes} used for setting the ContentView
     */
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setDebugDrawerIfLocationPermission();
    }

    /**
     * Overrides {@link android.support.v7.app.AppCompatActivity#setContentView(View)} to
     * allow setting the {@link DebugDrawer} when called.
     *
     * @param view {@link View} used for setting the ContentView
     */
    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        setDebugDrawerIfLocationPermission();
    }

    /**
     * Overrides {@link android.support.v7.app.AppCompatActivity#setContentView(View, ViewGroup.LayoutParams)}
     * to allow setting the {@link DebugDrawer} when called.
     *
     * @param view   {@link View} used for setting the ContentView
     * @param params {@link ViewGroup.LayoutParams} used for setting the ContentView
     */
    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        setDebugDrawerIfLocationPermission();
    }

    /**
     * Initialises the {@link DebugDrawer} and sets it if the location permission is granted.
     */
    @AskPermission(ACCESS_FINE_LOCATION)
    private void setDebugDrawerIfLocationPermission() {
        setDebugDrawer(true);
    }

    /**
     * Initialises the {@link DebugDrawer} and sets it.
     */
    private void setDebugDrawer(boolean withLocation) {
        if (debugDrawerHelper == null)
            debugDrawerHelper = new DebugDrawerHelper(this);
        debugDrawerHelper.initDebugDrawer(withLocation);
    }

    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    @Override
    protected void onStart() {
        super.onStart();
        if (debugDrawerHelper != null)
            debugDrawerHelper.onStart();
    }


    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (debugDrawerHelper != null)
            debugDrawerHelper.onResume();
    }


    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (debugDrawerHelper != null)
            debugDrawerHelper.onPause();
    }


    /**
     * Attach {@link DebugDrawer} to lifecycle.
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (debugDrawerHelper != null)
            debugDrawerHelper.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Let.handle(this, requestCode, permissions, grantResults);
    }

    @Override
    public void onShowPermissionRationale(List<String> permissionList, RuntimePermissionRequest permissionRequest) {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setMessage(R.string.debug_permission_location_rationale)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> permissionRequest.retry())
                .show();
    }

    @Override
    public void onPermissionDenied(List<DeniedPermission> deniedPermissionList) {
        for (DeniedPermission deniedPermission : deniedPermissionList) {
            if (deniedPermission.getPermission().equals(ACCESS_FINE_LOCATION) && !deniedPermission.isNeverAskAgainChecked()) {
                // init DebugDrawer without location
                setDebugDrawer(false);
                break;
            }
        }
    }
}
