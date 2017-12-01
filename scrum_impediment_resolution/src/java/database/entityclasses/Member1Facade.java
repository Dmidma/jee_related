/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.Member1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmidma
 */
@Stateless
public class Member1Facade extends AbstractFacade<Member1> implements Member1FacadeLocal {

    @PersistenceContext(unitName = "scrum_impediment_resolutionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Member1Facade() {
        super(Member1.class);
    }
    
}
