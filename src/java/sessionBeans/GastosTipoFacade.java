/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entidades.GastosTipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ofcral
 */
@Stateless
public class GastosTipoFacade extends AbstractFacade<GastosTipo> {
    @PersistenceContext(unitName = "ControlPresupuestarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GastosTipoFacade() {
        super(GastosTipo.class);
    }
    
}
