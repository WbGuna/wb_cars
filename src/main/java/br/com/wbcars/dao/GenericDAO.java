package br.com.wbcars.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GenericDAO<T extends Serializable> {
    private static final Logger LOGGER = Logger.getLogger(GenericDAO.class.getName());
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    protected EntityManager em;
    private final Class<T> clazz;

    protected GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
        this.em = emf.createEntityManager();
    }
    
    /**
     * Fecha o EntityManager associado a este DAO.
     * Deve ser chamado quando o DAO não for mais necessário.
     */
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
    
    /**
     * Obtém um EntityManager novo se o atual estiver fechado.
     * @return EntityManager ativo
     */
    protected EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }
    
    /**
     * Encontra uma entidade pelo ID
     * @param id ID da entidade
     * @return Entidade encontrada ou null
     */
    public T findById(Long id) {
        try {
            return getEntityManager().find(clazz, id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar entidade por ID: " + id, e);
            return null;
        }
    }

    /**
     * Encontra todas as entidades
     * @return Lista de entidades
     */
    public List<T> findAll() {
        try {
            TypedQuery<T> query = getEntityManager().createQuery("FROM " + clazz.getSimpleName(), clazz);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todas as entidades", e);
            return List.of();
        }
    }
    
    /**
     * Encontra entidades por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de entidades no intervalo de datas
     */
    public List<T> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            String jpql = "SELECT e FROM " + clazz.getSimpleName() + " e WHERE e.dataCadastro BETWEEN :inicio AND :fim";
            TypedQuery<T> query = getEntityManager().createQuery(jpql, clazz);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar entidades por intervalo de data", e);
            return List.of();
        }
    }

    /**
     * Persiste uma nova entidade
     * @param entity Entidade a ser persistida
     * @return Entidade persistida ou null em caso de erro
     */
    public T save(T entity) {
        EntityTransaction tx = null;
        try {
            EntityManager entityManager = getEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(entity);
            tx.commit();
            return entity;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erro ao salvar entidade", e);
            return null;
        }
    }

    /**
     * Atualiza uma entidade existente
     * @param entity Entidade a ser atualizada
     * @return Entidade atualizada ou null em caso de erro
     */
    public T update(T entity) {
        EntityTransaction tx = null;
        try {
            EntityManager entityManager = getEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            T mergedEntity = entityManager.merge(entity);
            tx.commit();
            return mergedEntity;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erro ao atualizar entidade", e);
            return null;
        }
    }

    /**
     * Remove uma entidade
     * @param entity Entidade a ser removida
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean delete(T entity) {
        EntityTransaction tx = null;
        try {
            EntityManager entityManager = getEntityManager();
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erro ao excluir entidade", e);
            return false;
        }
    }
}
