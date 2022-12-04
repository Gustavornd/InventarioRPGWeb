/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.naum.inventariorpg.inventario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fried
 */
@Stateless
public class InventarioBean implements InventarioBeanLocal {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Inventario localizarPorId(Long id) {
        return em.find(Inventario.class, id);  
    }

    @Override
    public void salvar(Inventario inventario) {
        em.merge(inventario);
    }

   
}
