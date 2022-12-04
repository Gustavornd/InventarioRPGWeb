/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.naum.inventariorpg.itemgeral;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fried
 */
@Stateless
public class ArmaduraBean implements ArmaduraBeanLocal {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Armadura localizarPorId(Long id) {
       return em.find(Armadura.class, id);    
    }

    @Override
    public void salvar(Armadura armadura) {
        em.merge(armadura);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
