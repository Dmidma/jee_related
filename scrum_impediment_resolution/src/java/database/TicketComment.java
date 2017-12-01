/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmidma
 */
@Entity
@Table(name = "ticket_comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketComment.findAll", query = "SELECT t FROM TicketComment t"),
    @NamedQuery(name = "TicketComment.findById", query = "SELECT t FROM TicketComment t WHERE t.id = :id")})
public class TicketComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_comment", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comment idComment;
    @JoinColumn(name = "id_member_ticket", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MemberTicket idMemberTicket;

    public TicketComment() {
    }

    public TicketComment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comment getIdComment() {
        return idComment;
    }

    public void setIdComment(Comment idComment) {
        this.idComment = idComment;
    }

    public MemberTicket getIdMemberTicket() {
        return idMemberTicket;
    }

    public void setIdMemberTicket(MemberTicket idMemberTicket) {
        this.idMemberTicket = idMemberTicket;
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
        if (!(object instanceof TicketComment)) {
            return false;
        }
        TicketComment other = (TicketComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.TicketComment[ id=" + id + " ]";
    }
    
}
