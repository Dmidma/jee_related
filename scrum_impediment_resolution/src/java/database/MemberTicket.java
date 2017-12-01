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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmidma
 */
@Entity
@Table(name = "member_ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberTicket.findAll", query = "SELECT m FROM MemberTicket m"),
    @NamedQuery(name = "MemberTicket.findById", query = "SELECT m FROM MemberTicket m WHERE m.id = :id"),
    @NamedQuery(name = "MemberTicket.findByCreationDate", query = "SELECT m FROM MemberTicket m WHERE m.creationDate = :creationDate"),
    @NamedQuery(name = "MemberTicket.findByResolvedDate", query = "SELECT m FROM MemberTicket m WHERE m.resolvedDate = :resolvedDate")})
public class MemberTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "resolved_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resolvedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMemberTicket")
    private Collection<TicketComment> ticketCommentCollection;
    @JoinColumn(name = "id_member", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member1 idMember;
    @JoinColumn(name = "id_impediment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Impediment idImpediment;

    public MemberTicket() {
    }

    public MemberTicket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    @XmlTransient
    public Collection<TicketComment> getTicketCommentCollection() {
        return ticketCommentCollection;
    }

    public void setTicketCommentCollection(Collection<TicketComment> ticketCommentCollection) {
        this.ticketCommentCollection = ticketCommentCollection;
    }

    public Member1 getIdMember() {
        return idMember;
    }

    public void setIdMember(Member1 idMember) {
        this.idMember = idMember;
    }

    public Impediment getIdImpediment() {
        return idImpediment;
    }

    public void setIdImpediment(Impediment idImpediment) {
        this.idImpediment = idImpediment;
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
        if (!(object instanceof MemberTicket)) {
            return false;
        }
        MemberTicket other = (MemberTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.MemberTicket[ id=" + id + " ]";
    }
    
}
