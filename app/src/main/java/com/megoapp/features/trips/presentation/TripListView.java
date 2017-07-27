package com.megoapp.features.trips.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.megoapp.App;
import com.megoapp.AppComponent;
import com.megoapp.R;
import com.megoapp.features.providers.presentation.DaggerProviderSelectionComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TripListView extends Fragment implements TripListContract.View {

    @Inject
    TripListContract.Presenter presenter;

    private TripListComponent scopeGraph;
    private Unbinder unbinder;

    public static TripListView getInstance() {
        return new TripListView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trips, container, false);
        setupScopeGraph(App.get(getActivity()).getAppComponent());
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onAttached();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDetached();
        unbinder.unbind();
    }


    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerTripListComponent.builder()
                .appComponent(appComponent)
                .tripListModule(new TripListModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
