/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Marca;
import static model.Marca.HONDA;
import model.Modelo;
import model.Pessoa;
import model.TipoVeiculo;
import model.Veiculo;
import model.VinculoPessoa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sistemaestacionamentoifsul.dao.PersistenciaJPA;

/**
 *
 * @author 20231PF.CC0021
 */
public class TestePersistencia {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistencia() {
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    
    @Test
    public void testePersistencia(){
        Modelo m = new Modelo();
        Pessoa p = new Pessoa();
        Veiculo v = new Veiculo();
        p.setNome("Jorge dos Santos");
        p.setFone("54999999999");
        p.setEmail("jorge@teste.com");
        p.setVinculoPessoa(VinculoPessoa.ALUNO);
        m.setDescricao("Focus");
        m.setMarca(Marca.FORD);
        v.setPlaca("AAA1A11");
        v.setCor("Branco");
        v.setModelo(m);
        v.setTipoVeiculo(TipoVeiculo.CARRO);
        v.setProprietario(p);
//        m.setId(1);
        
        try {
            jpa.persist(m);
            jpa.persist(p);
            jpa.persist(v);
        } catch (Exception e) {
            System.err.println("Erro ao persistir modelo: "+m);
        }
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
