
package io.github.naum.inventariorpg.transacao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entidade que representa uma Transacao.
 *
 * @author Gustavo Rafael Nunes Durães
 * @author Lucas Flávio Gabrich Marinho
 * @author Friedrich Naum Espindola Loiola Costa
 */
@Entity
public class Transacao implements Serializable{
    @Id
    private Long id;
    @Column(nullable = true)
    private Double valor;
    @Column(length = 255,nullable = true)
    private String descricao;
    
//<editor-fold defaultstate="collapsed" desc="Contructors">

    public Transacao() {
    }

    public Transacao(Double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
//</editor-fold>

    @Override
    public String toString() {
        return " Valor = " + valor
                + "\n Descricao = " + descricao;
    }
}
