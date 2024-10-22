/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaestacionamentoifsul.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 20231PF.CC0021
 */
public class PersistenciaJPA implements InterfaceDB{
    EntityManager entity;
    EntityManagerFactory factory;
    
    public PersistenciaJPA(){
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
        try{
        entity.getTransaction().begin();
        entity.persist(o);
        entity.getTransaction().commit();
        } catch (Exception e)
        {
            if(entity.getTransaction().isActive()){
                entity.getTransaction().rollback();
            }
        }
    }
    
    public EntityManager getEntityManager(){
        if (entity == null || !entity.isOpen())
        {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    @Override
    public void remover(Object o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
