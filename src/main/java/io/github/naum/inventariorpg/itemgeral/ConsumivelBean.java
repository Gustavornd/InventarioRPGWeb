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
public class ConsumivelBean implements ConsumivelBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Consumivel localizarPorId(Long id) {
       return em.find(Consumivel.class, id);    
    }

    @Override
    public void salvar(Consumivel consumivel) {
        em.merge(consumivel);
    }

    
}
