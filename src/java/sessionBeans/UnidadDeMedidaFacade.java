/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entidades.UnidadDeMedida;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ofcral
 */
@Stateless
public class UnidadDeMedidaFacade extends AbstractFacade<UnidadDeMedida> {
    @PersistenceContext(unitName = "ControlPresupuestarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UnidadDeMedidaFacade() {
        super(UnidadDeMedida.class);
    }
    
}
