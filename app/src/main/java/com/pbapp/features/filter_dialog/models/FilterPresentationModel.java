package com.pbapp.features.filter_dialog.models;


public class FilterPresentationModel {

    public final String name;
    public final boolean isSelected;
    public final ContentType contentType;

    public FilterPresentationModel(String name, boolean isSelected, ContentType contentType) {
        this.name = name;
        this.isSelected = isSelected;
        this.contentType = contentType;
    }

    public enum ContentType {
        SECTION_HEADER,
        ITEM_CONTENT,
    }
}
