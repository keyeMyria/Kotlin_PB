package com.pbapp.features.app_launch.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Toast;

import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;
import com.pbapp.views.activities.AppActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends Activity implements SplashContract.View {

    @Inject
    SplashContract.Presenter presenter;

    @BindView(R.id.v_launch)
    View vLaunch;
    @BindView(R.id.tv_splash_mego)
    View tvSplashMego;
    @BindView(R.id.tv_no_provider_hint)
    View tvNoProviderHint;


    private SplashComponent scopeGraph;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectViews();
        setupScopeGraph(App.get(this).getAppComponent());
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void goToMainView(String city) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, tvSplashMego, "mego");
        startActivity(new Intent(this, AppActivity.class), options.toBundle());

    }

    @Override
    public void goToError() {
        Toast.makeText(this, "Sth bad happens, we will come back to you soon", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoService() {
        tvNoProviderHint.setVisibility(View.VISIBLE);
    }


    private void injectViews() {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
    }

    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .splashModule(new SplashModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
