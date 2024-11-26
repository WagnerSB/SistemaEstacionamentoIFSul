/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("OFICIAL")
public class VeiculoOficial extends Veiculo{
    private String renavan;
    private String chassi;

    public String getRenavan() {
        return renavan;
    }

    public String getChassi() {
        return chassi;
    }
    
    
    
    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    
    
}
