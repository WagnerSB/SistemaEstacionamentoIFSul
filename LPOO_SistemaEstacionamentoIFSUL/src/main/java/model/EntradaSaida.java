/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author 20231PF.CC0021
 */
public class EntradaSaida {
    private int id;
    private Date data;
    private TipoMovimentacao tipoMovimentacao;
    
    private Veiculo veiculo;
    
    
    public EntradaSaida(TipoMovimentacao tipo, Veiculo veiculo) {
        tipoMovimentacao = tipo;
        this.veiculo = veiculo;
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
