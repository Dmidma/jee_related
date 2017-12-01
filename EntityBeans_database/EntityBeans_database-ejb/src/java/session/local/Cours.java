/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.local;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmidma
 */
@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByCode", query = "SELECT c FROM Cours c WHERE c.code = :code"),
    @NamedQuery(name = "Cours.findByNom", query = "SELECT c FROM Cours c WHERE c.nom = :nom"),
    @NamedQuery(name = "Cours.findByDescription", query = "SELECT c FROM Cours c WHERE c.description = :description"),
    @NamedQuery(name = "Cours.findByTheme", query = "SELECT c FROM Cours c WHERE c.theme = :theme")})
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "url")
    private String url;
    @Size(max = 30)
    @Column(name = "theme")
    private String theme;

    public Cours() {
    }

    public Cours(Integer code) {
        this.code = code;
    }

    public Cours(Integer code, String nom, String description) {
        this.code = code;
        this.nom = nom;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "session.local.Cours[ code=" + code + " ]";
    }
    
}
