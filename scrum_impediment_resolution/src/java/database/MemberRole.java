/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmidma
 */
@Entity
@Table(name = "member_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberRole.findAll", query = "SELECT m FROM MemberRole m"),
    @NamedQuery(name = "MemberRole.findByIdMember", query = "SELECT m FROM MemberRole m WHERE m.memberRolePK.idMember = :idMember"),
    @NamedQuery(name = "MemberRole.findByIdRole", query = "SELECT m FROM MemberRole m WHERE m.memberRolePK.idRole = :idRole")})
public class MemberRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MemberRolePK memberRolePK;
    @JoinColumn(name = "id_member", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Member1 member1;
    @JoinColumn(name = "id_role", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public MemberRole() {
    }

    public MemberRole(MemberRolePK memberRolePK) {
        this.memberRolePK = memberRolePK;
    }

    public MemberRole(int idMember, int idRole) {
        this.memberRolePK = new MemberRolePK(idMember, idRole);
    }

    public MemberRolePK getMemberRolePK() {
        return memberRolePK;
    }

    public void setMemberRolePK(MemberRolePK memberRolePK) {
        this.memberRolePK = memberRolePK;
    }

    public Member1 getMember1() {
        return member1;
    }

    public void setMember1(Member1 member1) {
        this.member1 = member1;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberRolePK != null ? memberRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberRole)) {
            return false;
        }
        MemberRole other = (MemberRole) object;
        if ((this.memberRolePK == null && other.memberRolePK != null) || (this.memberRolePK != null && !this.memberRolePK.equals(other.memberRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.MemberRole[ memberRolePK=" + memberRolePK + " ]";
    }
    
}
