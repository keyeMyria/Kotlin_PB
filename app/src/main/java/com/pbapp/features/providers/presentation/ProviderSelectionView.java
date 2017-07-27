package com.pbapp.features.providers.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;
import com.pbapp.features.providers.models.ProvidersPresentationModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProviderSelectionView extends Fragment implements ProviderSelectionContract.View {

    @Inject
    ProviderSelectionContract.Presenter presenter;

    @BindView(R.id.ls_providers)
    RecyclerView lsProviders;

    private ProviderSelectionComponent scopeGraph;
    private Unbinder unbinder;

    public static ProviderSelectionView getInstance() {
        return new ProviderSelectionView();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_providers, container, false);
        setupScopeGraph(App.get(getActivity()).getAppComponent());
        unbinder = ButterKnife.bind(this, view);
        initViews();
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

    @Override
    public void loadProviderData(List<ProvidersPresentationModel> providers) {
        ProviderListAdapter adapter = new ProviderListAdapter(providers);
        lsProviders.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initViews() {
        lsProviders.setLayoutManager(new LinearLayoutManager(getActivity()));
        lsProviders.setHasFixedSize(true);
    }


    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerProviderSelectionComponent.builder()
                .appComponent(appComponent)
                .providerSelectionModule(new ProviderSelectionModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
