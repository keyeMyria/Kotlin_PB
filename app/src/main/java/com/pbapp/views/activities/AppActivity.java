package com.pbapp.views.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;
import com.pbapp.features.app_about.presentation.AppAboutView;
import com.pbapp.features.providers.presentation.ProviderSelectionView;
import com.pbapp.features.questions.presentation.QuestionsView;
import com.pbapp.features.tos.presentation.TosView;
import com.pbapp.features.trips.presentation.TripListView;
import com.pbapp.features.vehicles_list.presentation.VehicleListView;
import com.pbapp.features.vehicles_map.presentation.VehicleMapView;
import com.pbapp.utilities.navigation.AppNavigator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v4.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED;
import static android.support.v4.widget.DrawerLayout.LOCK_MODE_UNLOCKED;
import static com.pbapp.utilities.navigation.AppNavigator.ViewTag.ABOUT;
import static com.pbapp.utilities.navigation.AppNavigator.ViewTag.LEGAL;
import static com.pbapp.utilities.navigation.AppNavigator.ViewTag.MAP_VIEW;
import static com.pbapp.utilities.navigation.AppNavigator.ViewTag.PROVIDERS;
import static com.pbapp.utilities.navigation.AppNavigator.ViewTag.QUESTIONS;
import static com.pbapp.utilities.navigation.AppNavigator.ViewTag.TRIPS;
import static com.pbapp.utilities.navigation.AppNavigator.ViewTag.VEHICLE_LIST;


public class AppActivity extends AppCompatActivity implements AppActivityContract.View {

    @Inject
    AppActivityContract.Presenter presenter;

    @Inject
    AppNavigator navigator;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.tb_app)
    Toolbar tbApp;
    @BindView(R.id.img_tb_menu)
    ImageView imgTBMenu;

    private AppActivityComponent scopeGraph;

    @OnClick(R.id.img_tb_menu)
    public void onToolbarMenuItemClicked() {
        presenter.onToolbarMenuTapped();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mego);
        setupScopeGraph(App.get(this).getAppComponent());
        ButterKnife.bind(this);
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onBackPressed() {
        presenter.onBackTapped();
    }

    @Override
    public void addMapView() {
        navigator.addView(VehicleMapView.getInstance(), MAP_VIEW);
    }

    @Override
    public void openDrawer() {
        drawerLayout.openDrawer(navigationView);
    }

    @Override
    public void closeDrawer() {
        drawerLayout.closeDrawer(navigationView);
    }

    @Override
    public void lockDrawer() {
        drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void unlockDrawer() {
        drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED);
    }

    @Override
    public void goToVehicleList() {
        navigator.addView(VehicleListView.getInstance(), VEHICLE_LIST);
    }

    @Override
    public void goToTrips() {
        navigator.addView(TripListView.getInstance(), TRIPS);
    }

    @Override
    public void goToProviders() {
        navigator.addView(ProviderSelectionView.getInstance(), PROVIDERS);
    }

    @Override
    public void goToQuestions() {
        navigator.addView(QuestionsView.getInstance(), QUESTIONS);
    }

    @Override
    public void goToAbout() {
        navigator.addView(AppAboutView.getInstance(), ABOUT);
    }

    @Override
    public void goToLegal() {
        navigator.addView(TosView.getInstance(), LEGAL);
    }

    @Override
    public void goBack() {
        navigator.goBack();
        drawerLayout.setDrawerLockMode(LOCK_MODE_UNLOCKED);
    }

    @Override
    public void changeMenuIconToCross() {
        imgTBMenu.setImageDrawable(getResources().getDrawable(R.drawable.ic_close));
    }

    @Override
    public void quitApp() {
        finish();
    }

    @Override
    public void invokeSystemBack() {
        navigator.removeTopView();
        super.onBackPressed();
    }

    @Override
    public void showAppToolbar() {
        tbApp.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideAppToolbar() {
        tbApp.setVisibility(View.GONE);
    }

    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerAppActivityComponent.builder()
                .appComponent(appComponent)
                .appActivityModule(new AppActivityModule(this))
                .build();
        scopeGraph.inject(this);
    }

    private void initViews() {
        setSupportActionBar(tbApp);
        initNavigationDrawer();
    }


    private void initNavigationDrawer() {
        navigationView.setNavigationItemSelectedListener(drawerItem ->
                presenter.onDrawerItemTapped(drawerItem));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                presenter.onDrawerOpened();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                presenter.onDrawerClosed();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        drawerLayout.closeDrawer(navigationView);
    }
}
