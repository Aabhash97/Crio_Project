package com.crio.xmeme.dto;

public class XmemeDto {

    private String id;


    private String name;


    private String url;


    private String caption;


    public XmemeDto(String name, String caption,
                    String url) {
        this.name = name;
        this.caption = caption;
        this.url = url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
}
