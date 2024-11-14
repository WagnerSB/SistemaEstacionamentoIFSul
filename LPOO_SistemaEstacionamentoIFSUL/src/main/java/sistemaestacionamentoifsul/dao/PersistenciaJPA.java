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
import model.Pessoa;
import model.VinculoPessoa;

/**
 *
 * @author 20231PF.CC0021
 */
public class PersistenciaJPA implements InterfaceDB {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("db_lpoo_estacionamento");

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
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

//    Funções para listar dados
    public List<Pessoa> getPessoas() {
        entity = getEntityManager();
        try {
            TypedQuery<Pessoa> query = entity.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao buscar Pessoa: " + e);
            return null;
        }
    }
    
    public List<Pessoa> getPessoasPorNomeEVinculo(String nome, VinculoPessoa vinculo) {
    EntityManager em = getEntityManager();
    if (vinculo!=null){
    String query = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome AND p.vinculoPessoa = :vinculo";
    return em.createQuery(query, Pessoa.class)
             .setParameter("nome", "%" + nome + "%")
             .setParameter("vinculo", vinculo)
             .getResultList();
    } else{
        String query = "SELECT p FROM Pessoa p WHERE p.nome LIKE :nome";
        return em.createQuery(query, Pessoa.class)
                 .setParameter("nome", "%" + nome + "%")
                 .getResultList();
    }
    }

}
