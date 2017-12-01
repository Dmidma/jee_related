/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dmidma
 */
@Embeddable
public class MemberRolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_member")
    private int idMember;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_role")
    private int idRole;

    public MemberRolePK() {
    }

    public MemberRolePK(int idMember, int idRole) {
        this.idMember = idMember;
        this.idRole = idRole;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMember;
        hash += (int) idRole;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberRolePK)) {
            return false;
        }
        MemberRolePK other = (MemberRolePK) object;
        if (this.idMember != other.idMember) {
            return false;
        }
        if (this.idRole != other.idRole) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.MemberRolePK[ idMember=" + idMember + ", idRole=" + idRole + " ]";
    }
    
}
