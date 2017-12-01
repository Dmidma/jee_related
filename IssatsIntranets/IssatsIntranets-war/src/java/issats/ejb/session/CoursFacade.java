/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package issats.ejb.session;

import issats.ejb.session.local.Cours;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmidma
 */
@Stateless
public class CoursFacade extends AbstractFacade<Cours> {

    @PersistenceContext(unitName = "IssatsIntranets-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoursFacade() {
        super(Cours.class);
    }
    
}
