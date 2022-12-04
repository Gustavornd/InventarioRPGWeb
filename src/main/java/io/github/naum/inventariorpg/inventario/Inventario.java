/*
 * Copyright (C) 2022 gusta
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.naum.inventariorpg.inventario;

import java.util.ArrayList;
import javax.persistence.Entity;
import io.github.naum.inventariorpg.transacao.Transacao;
import io.github.naum.inventariorpg.itemgeral.ItemGeral;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


/**
 * Entidade que representa um Inventario.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
@Entity
public class Inventario implements Serializable{

    @Id
    private Long Id;
    
    @Column(nullable = true)
    private Integer totalitens;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "Id"),
            inverseJoinColumns = @JoinColumn(name = "transacao_id")
    )
    ArrayList<Transacao> listaTrans = new ArrayList<Transacao>();
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "Id"),
            inverseJoinColumns = @JoinColumn(name = "itemgeral_id")
    )
    ArrayList<ItemGeral> listaItens = new ArrayList<ItemGeral>();

    //<editor-fold defaultstate="collapsed" desc="Contrutores">
    public Inventario() {

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Inventario(Integer totalitens) {
        this.totalitens = totalitens;
    }

    public Integer getTotalitems() {
        return totalitens;
    }

    public void setTotalitems(Integer totalitens) {
        this.totalitens = totalitens;
    }

    public ArrayList<Transacao> getListaTrans() {
        return listaTrans;
    }

    public void setListaTrans(ArrayList<Transacao> listaTrans) {
        this.listaTrans = listaTrans;
    }

    public void setListaItens(ArrayList<ItemGeral> listaItens) {
        this.listaItens = listaItens;
    }

    //</editor-fold>
    // Adiciona uma transacao
    public void addTrans(Transacao aux) {
        this.listaTrans.add(aux);
    }

    public ArrayList<ItemGeral> getListaItens() {
        return listaItens;
    }

    // Adiciona um ItemGeral
    public void addItens(ItemGeral aux) {
        this.listaItens.add(aux);
        this.totalitens = this.listaItens.size();
    }

    // Lista as Transacoes
    public String listarTrans() {
        for (int i = 0; i < listaTrans.size(); i++) {
            System.out.println(listaTrans.get(i).toString());
        }
        return null;
    }

    // Lista os ItensGerais
    public String listarItens() {
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println(listaItens.get(i).toString());
        }
        return null;
    }
    // Realiza a busca de um ItemGeral

    public ItemGeral buscarItem(String a) {
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getNome().equals(a)) {
                return listaItens.get(i);
            }
        }
        System.out.println("Item nao encontrado.");
        return null;
    }
    // Remove um ItemGeral 

    public void removeItem(String a) {
        listaItens.remove(buscarItem(a));

    }

    @Override
    public String toString() {
        return "Inventario{" + "totalitens=" + totalitens + '}';
    }

}
