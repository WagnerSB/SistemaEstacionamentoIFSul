/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String placa;
    private String cor;
    private TipoVeiculo tipoVeiculo;
    
    
    private Modelo modelo;
    List<EntradaSaida> listaMovimentacoes;
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
    
    
//    Methods
    public void addMovimentacao(EntradaSaida movimentacao)
    {
        listaMovimentacoes.add(movimentacao);
    }
}
