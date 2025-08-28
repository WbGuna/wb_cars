package br.com.wbcars.dao;

import br.com.wbcars.entity.ContaPagar;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoContaPagar;
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
    
    public List<ContaPagar> findByTipo(TipoContaPagar tipo) {
        try {
            TypedQuery<ContaPagar> query = em.createQuery(
                "SELECT c FROM ContaPagar c WHERE c.tipo = :tipo", ContaPagar.class);
            query.setParameter("tipo", tipo);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por tipo: " + tipo, e);
            return List.of();
        }
    }
    
    public List<ContaPagar> findByPrazoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<ContaPagar> query = em.createQuery(
                "SELECT c FROM ContaPagar c WHERE c.prazo BETWEEN :inicio AND :fim", ContaPagar.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por intervalo de prazo", e);
            return List.of();
        }
    }
    
    public List<ContaPagar> findByStatus(StatusGeral status) {
        try {
            TypedQuery<ContaPagar> query = em.createQuery(
                "SELECT c FROM ContaPagar c WHERE c.status = :status", ContaPagar.class);
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por status: " + status, e);
            return List.of();
        }
    }
    
    public List<ContaPagar> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            TypedQuery<ContaPagar> query = em.createQuery(
                "SELECT c FROM ContaPagar c WHERE c.valor BETWEEN :valorMinimo AND :valorMaximo", ContaPagar.class);
            query.setParameter("valorMinimo", valorMinimo);
            query.setParameter("valorMaximo", valorMaximo);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por faixa de valor", e);
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
