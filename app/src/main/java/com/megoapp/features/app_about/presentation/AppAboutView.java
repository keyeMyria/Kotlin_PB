package com.megoapp.features.app_about.presentation;

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

public class AppAboutView extends Fragment implements AppAboutContract.View {

    @Inject
    AppAboutContract.Presenter presenter;

    private AppAboutComponent scopeGraph;
    private Unbinder unbinder;

    public static AppAboutView getInstance() {
        return new AppAboutView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
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
        scopeGraph = DaggerAppAboutComponent.builder()
                .appComponent(appComponent)
                .appAboutModule(new AppAboutModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
