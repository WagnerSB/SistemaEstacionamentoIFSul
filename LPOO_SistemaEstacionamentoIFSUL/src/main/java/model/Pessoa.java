/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private int id;
    private String nome;
    private String fone;
    private String email;
    private VinculoPessoa vinculoPessoa;
    
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
    
    
    
        
//    Methods
    public void addVeiculo(Veiculo veiculo)
    {
        listaVeiculos.add(veiculo);
    }
    
    
}
