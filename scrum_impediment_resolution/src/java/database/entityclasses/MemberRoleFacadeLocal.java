/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.MemberRole;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dmidma
 */
@Local
public interface MemberRoleFacadeLocal {

    void create(MemberRole memberRole);

    void edit(MemberRole memberRole);

    void remove(MemberRole memberRole);

    MemberRole find(Object id);

    List<MemberRole> findAll();

    List<MemberRole> findRange(int[] range);

    int count();
    
}
