/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entidades.Gastos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ofcral
 */
@Stateless
public class GastosFacade extends AbstractFacade<Gastos> {
    @PersistenceContext(unitName = "ControlPresupuestarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GastosFacade() {
        super(Gastos.class);
    }
    
}
