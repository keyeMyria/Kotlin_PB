package com.pbapp.features.filter_dialog.presentation;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;
import com.pbapp.features.filter_dialog.models.FilterPresentationModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FilterDialogView extends LinearLayout implements FilterDialogContract.View {

    @Inject
    FilterDialogContract.Presenter presenter;

    @BindView(R.id.ls_dialog_filters)
    RecyclerView lsFilters;

    private FilterDialogComponent scopeGraph;
    private Unbinder unbinder;


    public FilterDialogView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void loadFilters(List<FilterPresentationModel> filters) {
        FilterListAdapter adapter = new FilterListAdapter(filters);
        lsFilters.setAdapter(adapter);
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
        lsFilters.setLayoutManager(new LinearLayoutManager(getContext()));
        lsFilters.setHasFixedSize(true);
    }

    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerFilterDialogComponent.builder()
                .appComponent(appComponent)
                .filterDialogModule(new FilterDialogModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
