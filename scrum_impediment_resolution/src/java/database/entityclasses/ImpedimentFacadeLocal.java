/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.Impediment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author dmidma
 */
@Local
public interface ImpedimentFacadeLocal {

    void create(Impediment impediment);

    void edit(Impediment impediment);

    void remove(Impediment impediment);

    Impediment find(Object id);

    List<Impediment> findAll();

    List<Impediment> findRange(int[] range);

    int count();
    
}
