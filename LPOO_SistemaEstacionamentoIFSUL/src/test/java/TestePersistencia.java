
import model.EntradaSaida;
import model.Marca;
import model.Modelo;
import model.Pessoa;
import model.TipoMovimentacao;
import model.TipoVeiculo;
import model.Veiculo;
import model.VinculoPessoa;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sistemaestacionamentoifsul.dao.PersistenciaJPA;

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testePersistencia() {
        Modelo m = new Modelo();
        m.setDescricao("fox");
        m.setMarca(Marca.FORD);
        
        Veiculo t = new Veiculo();
        t.setModelo(m);
        t.setCor("PRATA");
        t.setPlaca("ABC4T67");
        t.setTipoVeiculo(TipoVeiculo.CARRO);
        
        EntradaSaida es = new EntradaSaida(TipoMovimentacao.SAIDA, t);
        
        Pessoa p = new Pessoa();
        p.setNome("Juka");
        p.setVinculoPessoa(VinculoPessoa.VISITANTE);
        
        t.setProprietario(p);
        System.out.println("VEICULO: "+t);
        
        try{
            jpa.persist(p); 
            jpa.persist(m);
            jpa.persist(t);
            jpa.persist(es); 
            
            jpa.remover(p);
            
        } catch(Exception e){
            System.err.println("Erro ao persistir modelo: "+m);
        }
    }}