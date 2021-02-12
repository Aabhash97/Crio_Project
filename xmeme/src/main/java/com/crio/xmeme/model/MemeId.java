package com.crio.xmeme.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemeId {
    @JsonProperty("id")
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
