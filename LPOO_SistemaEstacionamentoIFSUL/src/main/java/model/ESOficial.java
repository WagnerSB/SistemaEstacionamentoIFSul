/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author 20231PF.CC0021
 */
@Entity
@DiscriminatorValue("veiculo_oficial")
public class ESOficial extends EntradaSaida {
    private int kmRegistrado;
    
    @OneToOne
    @JoinColumn(name="")
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
