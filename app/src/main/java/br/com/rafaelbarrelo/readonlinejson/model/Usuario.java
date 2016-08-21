package br.com.rafaelbarrelo.readonlinejson.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rafaelbarrelo on 8/21/16.
 */
public class Usuario {

    private String id;
    private String name;
    @SerializedName("pwd")
    private String password;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
