/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.Impediment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmidma
 */
@Stateless
public class ImpedimentFacade extends AbstractFacade<Impediment> implements ImpedimentFacadeLocal {

    @PersistenceContext(unitName = "scrum_impediment_resolutionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ImpedimentFacade() {
        super(Impediment.class);
    }
    
}
