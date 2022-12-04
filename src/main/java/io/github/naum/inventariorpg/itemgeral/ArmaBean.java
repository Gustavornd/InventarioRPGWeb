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
public class ArmaBean implements ArmaBeanLocal {
    
    @PersistenceContext
    private EntityManager em;
    @Override
    public Arma localizarPorId(Long id) {
         return em.find(Arma.class, id);    
    }

    @Override
    public void salvar(Arma arma) {
        em.merge(arma);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
