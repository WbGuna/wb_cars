package br.com.wbcars.dao;

import br.com.wbcars.entity.Orcamento;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrcamentoDAO extends GenericDAO<Orcamento> {
    private static final Logger LOGGER = Logger.getLogger(OrcamentoDAO.class.getName());
    private static OrcamentoDAO instance;

    private OrcamentoDAO() {
        super(Orcamento.class);
    }

    public static OrcamentoDAO getInstance() {
        if (instance == null) {
            synchronized (OrcamentoDAO.class) {
                if (instance == null) {
                    instance = new OrcamentoDAO();
                }
            }
        }
        return instance;
    }

    public List<Orcamento> findByCliente(String nomeCliente) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE LOWER(o.cliente.nome) LIKE LOWER(:nome)", Orcamento.class);
            query.setParameter("nome", "%" + nomeCliente + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por cliente: " + nomeCliente, e);
            return List.of();
        }
    }

    public List<Orcamento> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.dataCadastro BETWEEN :inicio AND :fim", Orcamento.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por intervalo de data", e);
            return List.of();
        }
    }
}
