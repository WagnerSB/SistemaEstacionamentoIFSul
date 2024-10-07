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
public class ESOficial extends EntradaSaida {
    private int kmRegistrado;
    private Pessoa motorista;

    public ESOficial(Pessoa motorista, TipoMovimentacao tipo, Veiculo veiculo) {
        super(tipo, veiculo);
        this.motorista = motorista;
    }
    

    public int getKmRegistrado() {
        return kmRegistrado;
    }

    public Pessoa getMotorista() {
        return motorista;
    }
    
    

    public void setKmRegistrado(int kmRegistrado) {
        this.kmRegistrado = kmRegistrado;
    }
    
    public void setMotorista(Pessoa motorista) {
        this.motorista = motorista;
    }
    
    
}
