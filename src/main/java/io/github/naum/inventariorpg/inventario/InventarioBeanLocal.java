/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.naum.inventariorpg.inventario;

import javax.ejb.Local;

/**
 *
 * @author fried
 */
@Local
public interface InventarioBeanLocal {
    Inventario localizarPorId(Long id);

    void salvar(Inventario personagem);
}
