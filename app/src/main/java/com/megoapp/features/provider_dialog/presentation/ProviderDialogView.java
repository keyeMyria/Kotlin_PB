package com.megoapp.features.provider_dialog.presentation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.megoapp.App;
import com.megoapp.AppComponent;
import com.megoapp.R;
import com.megoapp.features.filter_dialog.presentation.DaggerFilterDialogComponent;
import com.megoapp.features.provider_dialog.models.ProviderPresentationModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProviderDialogView extends LinearLayout implements ProviderDialogContract.View {

    @Inject
    ProviderDialogContract.Presenter presenter;

    @BindView(R.id.ls_dialog_providers)
    RecyclerView lsProviders;

    private ProviderDialogComponent scopeGraph;
    private Unbinder unbinder;


    public ProviderDialogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void loadProviders(List<ProviderPresentationModel> filters) {
        ProviderListAdapter adapter = new ProviderListAdapter(filters);
        lsProviders.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode()) return;
        setupScopeGraph(App.get(getContext()).getAppComponent());
        unbinder = ButterKnife.bind(this);
        initViews();
        presenter.onAttached();
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        presenter.onDetached();
        unbinder.unbind();
    }


    private void initViews() {
        lsProviders.setLayoutManager(new LinearLayoutManager(getContext()));
        lsProviders.setHasFixedSize(true);
    }

    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerProviderDialogComponent.builder()
                .appComponent(appComponent)
                .providerDialogModule(new ProviderDialogModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
