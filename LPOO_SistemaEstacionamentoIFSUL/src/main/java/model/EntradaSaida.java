/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author 20231PF.CC0021
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veiculo_es", discriminatorType = DiscriminatorType.STRING)
@Table(name="tb_entradasaida")
public class EntradaSaida implements Serializable{
    @Id
    private int id;
    @Column(nullable = false)
    private Date data;
    
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    
    @ManyToOne
    @JoinColumn(name = "es_veiculo")
    private Veiculo veiculo;
    
    
    public EntradaSaida(TipoMovimentacao tipo, Veiculo veiculo) {
        tipoMovimentacao = tipo;
        this.veiculo = veiculo;
        this.veiculo.addMovimentacao(this);
        data = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public TipoMovimentacao gettipoMovimentacao() {
        return tipoMovimentacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
 
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public void settipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
}
