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

package io.github.naum.inventariorpg.personagem;

import java.io.Serializable;
import java.util.ArrayList;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/*
 * Entidade que representa um Personagem.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */

@Entity
public class Personagem implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = true)
    private String nome;
    @Column(nullable = true)
    private Double limPeso;
    @Column(nullable = true)
    private Double dinheiro;
    @Column(nullable = true)
    private Integer ca;
    

    //<editor-fold defaultstate="collapsed" desc=" Constructor ">
    public Personagem() {

    }

    public Personagem(String nome, Double limPeso, Double dinheiro, Integer ca, Integer inventario) {
        this.nome = nome;
        this.limPeso = limPeso;
        this.dinheiro = dinheiro;
        this.ca = ca;
        this.inventario = inventario;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getterss And Settters">
    public Double getLimPeso() {
        return limPeso;
    }

    public void setLimPeso(Double limPeso) {
        this.limPeso = limPeso;
    }

    public Double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(Double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public Integer getCa() {
        return ca;
    }

    public void setCa(Integer ca) {
        this.ca = ca;
    }

    public Integer getInventario() {
        return inventario;
    }

    public void setInventario(Integer inventario) {
        this.inventario = inventario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//</editor-fold>
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inventario", referencedColumnName = "Id")
    private Integer inventario;
    
    // Realiza o calculo do coeficiente de armadura atual
    /*
    public void calcCA() {
        Armadura ja = new Armadura();
        if (ja.getEquipado() == true) {
            this.ca += ja.getDefesa();
        }
        System.out.println(" CA Atual = " + this.ca);
    }
    
    */

    // Realiza o calculo do Peso, do limite do peso e o quanto falta para atingir esse limite.
    // Tambem verifica se o personagem ja ultrapassou ou esta perto de ultrapassar esse limite.
    /*
    public void calcPeso() {
        int peso = 0;
        Long L = Long.valueOf(this.inventario);
        PersonagemDAO perD = new PersonagemDAO();
        InventarioDAO invD = new InventarioDAO();
        int i = perD.localizarPorId(L).getInventario();
        ArrayList<InventarioDAO> inv = new ArrayList();
        
      
            for (int j = 0; j < inv.size(); j++) {
                peso += inv.get(j).localizarPorId(L).getListaItens().get(j).getPeso();
                if (this.limPeso < peso) {
                    System.out.println("Vocé está pesado!! Deslocamento e Velocidade do Personagem caiu Drásticamente");
                }
                if (this.limPeso == peso) {
                    System.out.println("Seu peso está quase ultrapassando o limite de peso!!");
                }
            }
        
        System.out.println("Peso Atual: " + peso + "\nLimite do Peso: " + this.limPeso + "\nFalta " + (this.limPeso - peso) + " para chegar ao limite");
    }

    //Realiza o calculo do dinheiro total, do gasto e a quantidade restante apos o gasto.
    public void calcMoney() {
        int money = 0;
        Long L = Long.valueOf(this.inventario);
        ArrayList<InventarioDAO> inv = new ArrayList();
        for (int i = 0; i < inv.size(); i++) {
            money += inv.get(i).localizarPorId(L).listaTrans.get(i).getValor();
        }
        System.out.println("Gasto Atual: " + money + "\nDinheiro Total: " + this.dinheiro + "\nDinheiro Total Agora " + (this.dinheiro - money));
    }
 */
    @Override
    public String toString() {
        return "Personagem{" + "limPeso=" + limPeso + ", dinheiro=" + dinheiro + ", ca=" + ca + ", inventario=" + inventario + ", nome=" + nome + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
