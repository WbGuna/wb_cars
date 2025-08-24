package br.com.wbcars.dao;

import br.com.wbcars.entity.RelatorioFinanceiro;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelatorioFinanceiroDAO extends GenericDAO<RelatorioFinanceiro> {
    private static final Logger LOGGER = Logger.getLogger(RelatorioFinanceiroDAO.class.getName());
    private static RelatorioFinanceiroDAO instance;

    private RelatorioFinanceiroDAO() {
        super(RelatorioFinanceiro.class);
    }

    public static RelatorioFinanceiroDAO getInstance() {
        if (instance == null) {
            synchronized (RelatorioFinanceiroDAO.class) {
                if (instance == null) {
                    instance = new RelatorioFinanceiroDAO();
                }
            }
        }
        return instance;
    }

    public List<RelatorioFinanceiro> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<RelatorioFinanceiro> query = em.createQuery(
                "SELECT r FROM RelatorioFinanceiro r WHERE r.dataCadastro BETWEEN :inicio AND :fim", RelatorioFinanceiro.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios financeiros por período", e);
            return List.of();
        }
    }
    
    /**
     * Sobrescreve o método da classe pai para manter compatibilidade
     */
    @Override
    public List<RelatorioFinanceiro> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return findByPeriodo(inicio, fim);
    }
}
