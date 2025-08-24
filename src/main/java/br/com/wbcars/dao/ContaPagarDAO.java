package br.com.wbcars.dao;

import br.com.wbcars.entity.ContaPagar;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContaPagarDAO extends GenericDAO<ContaPagar> {
    private static final Logger LOGGER = Logger.getLogger(ContaPagarDAO.class.getName());
    private static ContaPagarDAO instance;

    private ContaPagarDAO() {
        super(ContaPagar.class);
    }

    public static ContaPagarDAO getInstance() {
        if (instance == null) {
            synchronized (ContaPagarDAO.class) {
                if (instance == null) {
                    instance = new ContaPagarDAO();
                }
            }
        }
        return instance;
    }

    public List<ContaPagar> findByFornecedor(String nomeFornecedor) {
        try {
            TypedQuery<ContaPagar> query = em.createQuery(
                "SELECT c FROM ContaPagar c WHERE LOWER(c.fornecedor.nome) LIKE LOWER(:nome)", ContaPagar.class);
            query.setParameter("nome", "%" + nomeFornecedor + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por fornecedor: " + nomeFornecedor, e);
            return List.of();
        }
    }

    public List<ContaPagar> findByDataVencimentoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<ContaPagar> query = em.createQuery(
                "SELECT c FROM ContaPagar c WHERE c.dataVencimento BETWEEN :inicio AND :fim", ContaPagar.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por intervalo de data de vencimento", e);
            return List.of();
        }
    }
    
    /**
     * Sobrescreve o método da classe pai para manter compatibilidade
     */
    @Override
    public List<ContaPagar> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return super.findByDataCadastroRange(inicio, fim);
    }
}
