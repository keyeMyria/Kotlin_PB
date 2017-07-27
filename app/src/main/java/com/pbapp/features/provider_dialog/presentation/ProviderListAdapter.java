package com.pbapp.features.provider_dialog.presentation;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pbapp.R;
import com.pbapp.features.provider_dialog.models.ProviderPresentationModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProviderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final List<ProviderPresentationModel> providers = new ArrayList<>();

    public ProviderListAdapter(List<ProviderPresentationModel> providers) {
        this.providers.clear();
        this.providers.addAll(providers);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = new ProviderListAdapter.ProviderViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_dialog_provider, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProviderPresentationModel filter = providers.get(position);
        ((ProviderViewHolder) holder).render(filter);
    }

    @Override
    public int getItemCount() {
        return providers.size();
    }


    class ProviderViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_item_provider_name)
        TextView tvProviderName;
        @BindView(R.id.chx_item_provider)
        CheckBox chxProviderStatus;

        ProviderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void render(ProviderPresentationModel provider) {
            tvProviderName.setText(provider.name + "");
            chxProviderStatus.setChecked(provider.isSelected);
        }
    }


}
