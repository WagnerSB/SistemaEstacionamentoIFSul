/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Marca;
import static model.Marca.HONDA;
import model.Modelo;
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
        m.setDescricao("Focus");
        m.setMarca(Marca.FORD);
//        m.setId(1);
        
        try {
            jpa.persist(m);
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
