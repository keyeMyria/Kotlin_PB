package com.pbapp.features.tos.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TosView extends Fragment implements TosContract.View {

    @Inject
    TosContract.Presenter presenter;

    @BindView(R.id.tv_tos)
    TextView tvTOS;

    private TosComponent scopeGraph;
    private Unbinder unbinder;

    public static TosView getInstance() {
        return new TosView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tos, container, false);
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
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDetached();
        unbinder.unbind();
    }


    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerTosComponent.builder()
                .appComponent(appComponent)
                .tosModule(new TosModule(this))
                .build();
        scopeGraph.inject(this);
    }

    @Override
    public void showTos(String tos) {
        tvTOS.setText(tos);
    }

    @Override
    public void showLoading() {
        // TODO: 20.05.17 implement me
        tvTOS.setText("loading data");
    }
}
