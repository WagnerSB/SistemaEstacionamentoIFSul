/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(nullable = false)
    private String nome;
    
    private String fone;
    
    private String email;

    @Enumerated(EnumType.STRING)
    private VinculoPessoa vinculoPessoa;
   

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private List<Veiculo> listaVeiculos;
    
    
    public Pessoa()
    {
        listaVeiculos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getFone() {
        return fone;
    }

    public String getEmail() {
        return email;
    }

    public VinculoPessoa getVinculoPessoa() {
        return vinculoPessoa;
    }
    
    
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVinculoPessoa(VinculoPessoa vinculoPessoa) {
        this.vinculoPessoa = vinculoPessoa;
    }
    
    public void setFone(String fone) {
        this.fone = fone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nome +" - "+vinculoPessoa;
    }
    
    
    
        
//    Methods
    public void addVeiculo(Veiculo veiculo)
    {
        listaVeiculos.add(veiculo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nome);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }
    
    
    
    
}
