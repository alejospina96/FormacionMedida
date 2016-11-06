/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import EntityClasses.Tipocursoformacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author daniel
 */
@Stateless
public class TipocursoformacionFacade extends AbstractFacade<Tipocursoformacion> {

    @PersistenceContext(unitName = "FormacionMedPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipocursoformacionFacade() {
        super(Tipocursoformacion.class);
    }
    
}
