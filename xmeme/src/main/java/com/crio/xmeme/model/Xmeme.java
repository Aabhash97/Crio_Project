package com.crio.xmeme.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is Xmeme POJO class for Xmeme Application
 * Act as a Light Weight Object to transfer data
 */
@Entity
@Table(name = "xmeme")
public class Xmeme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "id")
    private int id;

    @NotNull
    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @NotNull
    @JsonProperty("url")
    @Column(name = "url")
    private String url;

    @JsonProperty("caption")
    @Column(name = "caption")
    private String caption;


    public Xmeme(String name, String caption,
                 String url) {
        this.name = name;
        this.caption = caption;
        this.url = url;
    }

    public Xmeme() {
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

    @Override
    public String toString() {
        return "Xmeme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", caption='" + caption + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

}
