/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import EntityClasses.Tipopersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class TipopersonaFacade extends AbstractFacade<Tipopersona> {

    @PersistenceContext(unitName = "FormacionMedPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipopersonaFacade() {
        super(Tipopersona.class);
    }
    
}
