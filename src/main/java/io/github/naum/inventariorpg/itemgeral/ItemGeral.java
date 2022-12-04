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
package io.github.naum.inventariorpg.itemgeral;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entidade que representa um item geral a ser adicionando no inventario.
 * 
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
@Entity
public class ItemGeral implements Serializable {

    @Id
    @Column(nullable = false)
    private Long Id;
    @Column(nullable = true)
    private Double peso;
    @Column(nullable = true)
    private Double preco;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(nullable = true)
    private Integer quantidade;
    @Column(length = 255, nullable = false)
    private String descricao;
    
    private Boolean equipado;
    //<editor-fold defaultstate="collapsed" desc="Contructors">

    public ItemGeral() {
        this.peso = 0.0;
        this.preco = 0.0;
        this.quantidade = 0;
        this.descricao = null;
        this.nome = null;
    }

    public ItemGeral(Double peso, Double preco, Integer quantidade, String descricao, String nome, Boolean equipado) {
        this.peso = peso;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.nome = nome;
        this.equipado = equipado;
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getEquipado() {
        return equipado;
    }

    public void setEquipado(Boolean equipado) {
        this.equipado = equipado;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "Peso: " + peso + "\n"
                + "Preco: " + preco + "\n"
                + "Quantidade: " + quantidade + "\n"
                + "Descricao: " + descricao + "\n"
                + "Nome: " + nome + "\n"
                + "Equipado: " + equipado + "\n";
    }

}
