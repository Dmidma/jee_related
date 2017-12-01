/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.entityclasses;

import database.Project;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmidma
 */
@Stateless
public class ProjectFacade extends AbstractFacade<Project> implements ProjectFacadeLocal {

    @PersistenceContext(unitName = "scrum_impediment_resolutionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectFacade() {
        super(Project.class);
    }
    
}
