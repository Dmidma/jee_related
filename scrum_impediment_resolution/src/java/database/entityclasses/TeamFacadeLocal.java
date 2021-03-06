/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.Team;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dmidma
 */
@Local
public interface TeamFacadeLocal {

    void create(Team team);

    void edit(Team team);

    void remove(Team team);

    Team find(Object id);

    List<Team> findAll();

    List<Team> findRange(int[] range);

    int count();
    
}
