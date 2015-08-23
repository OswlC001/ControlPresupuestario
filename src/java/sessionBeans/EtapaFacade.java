/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entidades.Etapa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ofcral
 */
@Stateless
public class EtapaFacade extends AbstractFacade<Etapa> {
    @PersistenceContext(unitName = "ControlPresupuestarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtapaFacade() {
        super(Etapa.class);
    }
    
}
