/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dmidma
 */
public class Cours {
    
    private int code;
    private String nom = null, description = null, url = null, theme = null;

    public Cours() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getTheme() {
        return theme;
    }
    
    
    
    
}
