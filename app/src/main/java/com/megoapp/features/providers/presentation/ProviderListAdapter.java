package com.megoapp.features.providers.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.megoapp.R;
import com.megoapp.features.providers.models.ProvidersPresentationModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProviderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_PROVIDER_ITEM = 1;

    private final List<ProvidersPresentationModel> providers = new ArrayList<>();

    public ProviderListAdapter(List<ProvidersPresentationModel> providers) {
        this.providers.clear();
        this.providers.addAll(providers);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                viewHolder = new HeaderViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_provider_header, parent, false));
                break;

            case VIEW_TYPE_PROVIDER_ITEM:
                viewHolder = new ProviderViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_provider, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ProvidersPresentationModel providersPresentationModel = providers.get(position);
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).render(providersPresentationModel);
        } else if (holder instanceof ProviderViewHolder) {
            ((ProviderViewHolder) holder).render(providersPresentationModel);
        }

    }


    @Override
    public int getItemViewType(int position) {
        switch (providers.get(position).type) {
            case HEADER:
                return VIEW_TYPE_HEADER;
            case CAR_ITEM:
                return VIEW_TYPE_PROVIDER_ITEM;
            case SCOOTER_ITEM:
                return VIEW_TYPE_PROVIDER_ITEM;
        }
        return VIEW_TYPE_PROVIDER_ITEM;

    }

    @Override
    public int getItemCount() {
        return providers.size();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_item_header)
        TextView tvItemHeader;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void render(ProvidersPresentationModel providersPresentationModel) {
            tvItemHeader.setText(providersPresentationModel.label + "");
        }
    }

    class ProviderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item_provider)
        ImageView imgProviderIcon;
        @BindView(R.id.tv_item_provider_name)
        TextView tvProviderName;
        @BindView(R.id.chx_item_provider)
        CheckBox chx_provider;

        ProviderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void render(ProvidersPresentationModel providersPresentationModel) {
            tvProviderName.setText(providersPresentationModel.label + "");
            chx_provider.setChecked(false);
        }
    }
}
