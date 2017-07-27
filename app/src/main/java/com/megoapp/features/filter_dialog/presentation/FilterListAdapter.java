package com.megoapp.features.filter_dialog.presentation;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.megoapp.R;
import com.megoapp.features.filter_dialog.models.FilterPresentationModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_CONTENT_ITEM = 1;

    private final List<FilterPresentationModel> filters = new ArrayList<>();

    public FilterListAdapter(List<FilterPresentationModel> filters) {
        this.filters.clear();
        this.filters.addAll(filters);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                viewHolder = new FilterListAdapter.FilterHeaderViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_dialog_filter_header, parent, false));
                break;

            case VIEW_TYPE_CONTENT_ITEM:
                viewHolder = new FilterListAdapter.FilterViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_list_dialog_filter, parent, false));
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FilterPresentationModel filter = filters.get(position);
        if (holder instanceof FilterHeaderViewHolder) {
            ((FilterHeaderViewHolder) holder).render(filter);
        } else if (holder instanceof FilterViewHolder) {
            ((FilterViewHolder) holder).render(filter);
        }


    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (filters.get(position).contentType) {
            case SECTION_HEADER:
                return VIEW_TYPE_HEADER;
            case ITEM_CONTENT:
                return VIEW_TYPE_CONTENT_ITEM;
        }
        return VIEW_TYPE_CONTENT_ITEM;

    }


    class FilterViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.tv_item_filter_name)
        TextView tvFilterName;
        @BindView(R.id.chx_item_filter)
        CheckBox chxFilter;

        FilterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void render(FilterPresentationModel filter) {
            tvFilterName.setText(filter.name + "");
            chxFilter.setChecked(filter.isSelected);
        }
    }

    class FilterHeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_header)
        TextView tvItemHeader;

        public FilterHeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void render(FilterPresentationModel filter) {
            tvItemHeader.setText(filter.name + "");
        }
    }
}
