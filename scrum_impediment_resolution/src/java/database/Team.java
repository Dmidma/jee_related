/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmidma
 */
@Entity
@Table(name = "team")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t"),
    @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id"),
    @NamedQuery(name = "Team.findByName", query = "SELECT t FROM Team t WHERE t.name = :name"),
    @NamedQuery(name = "Team.findByCreationDate", query = "SELECT t FROM Team t WHERE t.creationDate = :creationDate"),
    @NamedQuery(name = "Team.findByNumberMembers", query = "SELECT t FROM Team t WHERE t.numberMembers = :numberMembers")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "number_members")
    private Short numberMembers;
    @JoinTable(name = "team_members", joinColumns = {
        @JoinColumn(name = "id_team", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_member", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Member1> member1Collection;
    @OneToMany(mappedBy = "idTeam")
    private Collection<Project> projectCollection;

    public Team() {
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Short getNumberMembers() {
        return numberMembers;
    }

    public void setNumberMembers(Short numberMembers) {
        this.numberMembers = numberMembers;
    }

    @XmlTransient
    public Collection<Member1> getMember1Collection() {
        return member1Collection;
    }

    public void setMember1Collection(Collection<Member1> member1Collection) {
        this.member1Collection = member1Collection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Team[ id=" + id + " ]";
    }
    
}
