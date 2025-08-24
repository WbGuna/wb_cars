package br.com.wbcars.dao;

import br.com.wbcars.entity.UnidadeMedida;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnidadeMedidaDAO extends GenericDAO<UnidadeMedida> {
    private static final Logger LOGGER = Logger.getLogger(UnidadeMedidaDAO.class.getName());
    private static UnidadeMedidaDAO instance;

    private UnidadeMedidaDAO() {
        super(UnidadeMedida.class);
    }

    public static UnidadeMedidaDAO getInstance() {
        if (instance == null) {
            synchronized (UnidadeMedidaDAO.class) {
                if (instance == null) {
                    instance = new UnidadeMedidaDAO();
                }
            }
        }
        return instance;
    }

    public List<UnidadeMedida> findByNome(String nome) {
        try {
            TypedQuery<UnidadeMedida> query = em.createQuery(
                "SELECT u FROM UnidadeMedida u WHERE LOWER(u.nome) LIKE LOWER(:nome)", UnidadeMedida.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidades de medida por nome: " + nome, e);
            return List.of();
        }
    }

    public UnidadeMedida findBySigla(String sigla) {
        try {
            TypedQuery<UnidadeMedida> query = em.createQuery(
                "SELECT u FROM UnidadeMedida u WHERE u.sigla = :sigla", UnidadeMedida.class);
            query.setParameter("sigla", sigla);
            List<UnidadeMedida> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidade de medida por sigla: " + sigla, e);
            return null;
        }
    }

    public List<UnidadeMedida> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<UnidadeMedida> query = em.createQuery(
                "SELECT u FROM UnidadeMedida u WHERE u.dataCadastro BETWEEN :inicio AND :fim", UnidadeMedida.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidades de medida por intervalo de data", e);
            return List.of();
        }
    }
}
