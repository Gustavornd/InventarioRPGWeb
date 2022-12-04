/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.naum.inventariorpg.personagem;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fried
 */


@Stateless
@LocalBean
public class PersonagemBean implements PersonagemBeanLocal{

    @PersistenceContext
    private EntityManager em;
    @Override
    public Personagem localizarPorId(Long id) {
        return em.find(Personagem.class, id);    
    }

    @Override
    public void salvar(Personagem personagem) {
         em.merge(personagem);
    }

    
    
}
