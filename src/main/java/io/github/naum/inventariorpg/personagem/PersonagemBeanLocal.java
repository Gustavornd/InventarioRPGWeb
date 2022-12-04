/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.naum.inventariorpg.personagem;

import javax.ejb.Local;

/**
 *
 * @author fried
 */
@Local
public interface PersonagemBeanLocal{

   Personagem localizarPorId(Long id);

    void salvar(Personagem personagem);
}
