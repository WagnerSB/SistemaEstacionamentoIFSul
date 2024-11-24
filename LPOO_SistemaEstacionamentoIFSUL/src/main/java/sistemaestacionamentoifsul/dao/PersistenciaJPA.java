/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaestacionamentoifsul.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Modelo;
import model.Pessoa;
import model.Veiculo;
import model.VinculoPessoa;
import sistemaestacionamentoifsul.dao.InterfaceBD;

/**
 *
 * @author vanessalagomachado
 */
public class PersistenciaJPA implements InterfaceBD {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory
                = Persistence.createEntityManagerFactory("db_lpoo_estacionamento");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {

        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void persist(Object o) throws Exception {

        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {;
                o = entity.merge(o);
            } else {
                entity.persist(o);
            }
//            if (hasValidId(o)) {
//                entity.merge(o);
//                System.out.println("Objeto existente atualizado com merge");
//            } else {
//                entity.persist(o);
//                System.out.println("Novo objeto persistido");
//            }
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao persistir: "+e);
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    private boolean hasValidId(Object o) {
        try {
            Long id = (Long) o.getClass().getMethod("getId").invoke(o);
            return id != null && id != 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        System.out.println("Object: "+o);
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.flush();
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover item: " + e);
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    /*
    Todos os métodos agora chamam getEntityManager() 
    para garantir que o EntityManager esteja sempre aberto e 
    pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    // funções para listar dados 
    public List<Veiculo> getVeiculos() {
        entity = getEntityManager();

        try {
            TypedQuery<Veiculo> query
                    = entity.createQuery("Select v from Veiculo v", Veiculo.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Veiculos: " + e);
            return null;
        }

    }

    public List<Veiculo> getVeiculos(String placa) {
        entity = getEntityManager();

        try {
            TypedQuery<Veiculo> query
                    = entity.createQuery("Select v from Veiculo v where lower(v.placa) LIKE :p",
                            Veiculo.class);
            query.setParameter("p", "%" + placa.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Veiculos: " + e);
            return null;
        }
    }

    public List<Veiculo> getVeiculos(boolean oficial) {
        entity = getEntityManager();

        try {
            String jpql = "Select v from Veiculo v ";
            if (oficial) {
                jpql += "where tipo_veiculo = 'OFICIAL'";
            }
            TypedQuery<Veiculo> query
                    = entity.createQuery(jpql, Veiculo.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }
    }

    public List<Pessoa> getPessoas() {
        entity = getEntityManager();

        try {
            TypedQuery<Pessoa> query
                    = entity.createQuery("Select p from Pessoa p", Pessoa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }

    public List<Pessoa> getPessoas(VinculoPessoa vinculoSelecionado) {
        entity = getEntityManager();

        try {
            TypedQuery<Pessoa> query
                    = entity.createQuery("Select p from Pessoa p where p.vinculoPessoa = '"
                            + vinculoSelecionado + "'",
                            Pessoa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }

    public List<Pessoa> getPessoas(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Pessoa> query
                    = entity.createQuery("Select p from Pessoa p where lower(p.nome) LIKE :n",
                            Pessoa.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }

    public List<Modelo> getModelos() {
        entity = getEntityManager();

        try {
            TypedQuery<Modelo> query
                    = entity.createQuery("Select m from Modelo m", Modelo.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }
}
