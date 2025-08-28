package br.com.wbcars.dao;

import br.com.wbcars.entity.RelatorioFinanceiroDetalhado;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelatorioFinanceiroDetalhadoDAO extends GenericDAO<RelatorioFinanceiroDetalhado> {
    private static final Logger LOGGER = Logger.getLogger(RelatorioFinanceiroDetalhadoDAO.class.getName());
    private static RelatorioFinanceiroDetalhadoDAO instance;

    private RelatorioFinanceiroDetalhadoDAO() {
        super(RelatorioFinanceiroDetalhado.class);
    }

    public static RelatorioFinanceiroDetalhadoDAO getInstance() {
        if (instance == null) {
            synchronized (RelatorioFinanceiroDetalhadoDAO.class) {
                if (instance == null) {
                    instance = new RelatorioFinanceiroDetalhadoDAO();
                }
            }
        }
        return instance;
    }

    public List<RelatorioFinanceiroDetalhado> findByValorTotalEntrada(Double valor) {
        try {
            TypedQuery<RelatorioFinanceiroDetalhado> query = em.createQuery(
                "SELECT r FROM RelatorioFinanceiroDetalhado r WHERE r.valorTotalEntrada = :valor", RelatorioFinanceiroDetalhado.class);
            query.setParameter("valor", valor);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios financeiros detalhados por valor total de entrada", e);
            return List.of();
        }
    }
    
    public List<RelatorioFinanceiroDetalhado> findByPeriodo(java.time.LocalDateTime inicio, java.time.LocalDateTime fim) {
        try {
            TypedQuery<RelatorioFinanceiroDetalhado> query = em.createQuery(
                "SELECT r FROM RelatorioFinanceiroDetalhado r WHERE r.periodo BETWEEN :inicio AND :fim", 
                RelatorioFinanceiroDetalhado.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios financeiros detalhados por período", e);
            return List.of();
        }
    }
}
