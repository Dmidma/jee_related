/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import local.Cours;

/**
 *
 * @author dmidma
 */
@Stateless
public class CoursFacade extends AbstractFacade<Cours> implements CoursFacadeLocal {

    @PersistenceContext(unitName = "IssatsIntranets-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoursFacade() {
        super(Cours.class);
    }
    
}
