/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_veiculo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "veiculo", discriminatorType = DiscriminatorType.STRING)
public class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String placa;
    private String cor;
    
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipoVeiculo;
    
    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;
    
    @OneToMany(mappedBy = "veiculo")
    List<EntradaSaida> listaMovimentacoes;

    @ManyToOne
    @JoinColumn(name = "veiculo_proprietario")
    private Pessoa proprietario;
    
    
    public Veiculo(){
        listaMovimentacoes = new ArrayList<>();
    }

    public Veiculo(String placa, TipoVeiculo tipoVeiculo) {
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
        listaMovimentacoes = new ArrayList<>();
    }
    
    
    
//    Getters
    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }
    
    
//    Setters
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
    
     public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }
    
    
//    Methods
    public void addMovimentacao(EntradaSaida movimentacao)
    {
        listaMovimentacoes.add(movimentacao);
    }

}
