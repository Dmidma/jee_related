/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.MemberTicket;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dmidma
 */
@Local
public interface MemberTicketFacadeLocal {

    void create(MemberTicket memberTicket);

    void edit(MemberTicket memberTicket);

    void remove(MemberTicket memberTicket);

    MemberTicket find(Object id);

    List<MemberTicket> findAll();

    List<MemberTicket> findRange(int[] range);

    int count();
    
}
