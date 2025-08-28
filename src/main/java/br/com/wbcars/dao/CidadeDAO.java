package br.com.wbcars.dao;

import br.com.wbcars.entity.Cidade;
import br.com.wbcars.enuns.EstadoBrasil;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CidadeDAO extends GenericDAO<Cidade> {
    private static final Logger LOGGER = Logger.getLogger(CidadeDAO.class.getName());
    private static CidadeDAO instance;

    private CidadeDAO() {
        super(Cidade.class);
    }

    public static CidadeDAO getInstance() {
        if (instance == null) {
            synchronized (CidadeDAO.class) {
                if (instance == null) {
                    instance = new CidadeDAO();
                }
            }
        }
        return instance;
    }

    public List<Cidade> findByNome(String nome) {
        try {
            TypedQuery<Cidade> query = em.createQuery(
                "SELECT c FROM Cidade c WHERE LOWER(c.nome) LIKE LOWER(:nome)", Cidade.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por nome: " + nome, e);
            return List.of();
        }
    }
    
    public List<Cidade> findByEstado(EstadoBrasil estado) {
        try {
            TypedQuery<Cidade> query = em.createQuery(
                "SELECT c FROM Cidade c WHERE c.estado = :estado", Cidade.class);
            query.setParameter("estado", estado);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por estado: " + estado, e);
            return List.of();
        }
    }
    
    public List<Cidade> findByPais(String pais) {
        try {
            TypedQuery<Cidade> query = em.createQuery(
                "SELECT c FROM Cidade c WHERE LOWER(c.pais) LIKE LOWER(:pais)", Cidade.class);
            query.setParameter("pais", "%" + pais + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por país: " + pais, e);
            return List.of();
        }
    }
}
