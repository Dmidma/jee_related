/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmidma
 */
@Entity
@Table(name = "impediment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impediment.findAll", query = "SELECT i FROM Impediment i"),
    @NamedQuery(name = "Impediment.findById", query = "SELECT i FROM Impediment i WHERE i.id = :id"),
    @NamedQuery(name = "Impediment.findBySubject", query = "SELECT i FROM Impediment i WHERE i.subject = :subject"),
    @NamedQuery(name = "Impediment.findByDescription", query = "SELECT i FROM Impediment i WHERE i.description = :description"),
    @NamedQuery(name = "Impediment.findByPriority", query = "SELECT i FROM Impediment i WHERE i.priority = :priority"),
    @NamedQuery(name = "Impediment.findByStatus", query = "SELECT i FROM Impediment i WHERE i.status = :status")})
public class Impediment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idImpediment")
    private Collection<MemberTicket> memberTicketCollection;

    public Impediment() {
    }

    public Impediment(Integer id) {
        this.id = id;
    }

    public Impediment(Integer id, String subject, String description, String priority, String status) {
        this.id = id;
        this.subject = subject;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<MemberTicket> getMemberTicketCollection() {
        return memberTicketCollection;
    }

    public void setMemberTicketCollection(Collection<MemberTicket> memberTicketCollection) {
        this.memberTicketCollection = memberTicketCollection;
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
        if (!(object instanceof Impediment)) {
            return false;
        }
        Impediment other = (Impediment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Impediment[ id=" + id + " ]";
    }
    
}
