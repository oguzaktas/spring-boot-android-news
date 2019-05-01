package com.oguz.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSON {

    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

}