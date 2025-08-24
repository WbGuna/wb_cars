package br.com.wbcars.dao;

import br.com.wbcars.entity.Funcionario;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    private static final Logger LOGGER = Logger.getLogger(FuncionarioDAO.class.getName());
    private static FuncionarioDAO instance;

    private FuncionarioDAO() {
        super(Funcionario.class);
    }

    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            synchronized (FuncionarioDAO.class) {
                if (instance == null) {
                    instance = new FuncionarioDAO();
                }
            }
        }
        return instance;
    }

    public List<Funcionario> findByNome(String nome) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE LOWER(f.nome) LIKE LOWER(:nome)", Funcionario.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por nome: " + nome, e);
            return List.of();
        }
    }

    public Funcionario findByLogin(String login) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.login = :login", Funcionario.class);
            query.setParameter("login", login);
            List<Funcionario> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por login: " + login, e);
            return null;
        }
    }

    public List<Funcionario> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.dataCadastro BETWEEN :inicio AND :fim", Funcionario.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por intervalo de data", e);
            return List.of();
        }
    }
}
