/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.persistence.Table;


@Entity
@Table(name = "tb_veiculo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_veiculo", discriminatorType = DiscriminatorType.STRING)
public class Veiculo implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;
    
    @Column(nullable = false, length = 7)
    private String placa;
    
    @Column(length = 20)
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
    
    @Override
    public String toString()
    {
        String tipo = "Normal";  // Valor padrão, se não for oficial

        if (this instanceof VeiculoOficial) {
            tipo = "Oficial";
        }
        return "Placa: " + placa + ", Proprietário: " + (proprietario != null ? proprietario.getNome() : "Desconhecido") + ", Tipo: " + tipo;
        
    }
    
    
    
//    Getters
    public int getId() {
        return id;
    }
    
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
    
    public Pessoa getProprietario() {
        return proprietario;
    }
    
      
//    Setters
    public void setId(int id) {
        this.id = id;
    }
    
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
    
    public List<EntradaSaida> getListaMovimentacoes() {
        return listaMovimentacoes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.placa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veiculo other = (Veiculo) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.placa, other.placa);
    }
    
    

}
