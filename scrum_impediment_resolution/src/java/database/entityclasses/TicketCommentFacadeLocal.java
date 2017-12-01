/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.TicketComment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dmidma
 */
@Local
public interface TicketCommentFacadeLocal {

    void create(TicketComment ticketComment);

    void edit(TicketComment ticketComment);

    void remove(TicketComment ticketComment);

    TicketComment find(Object id);

    List<TicketComment> findAll();

    List<TicketComment> findRange(int[] range);

    int count();
    
}
