package br.com.wbcars.dao;

import br.com.wbcars.entity.Orcamento;
import br.com.wbcars.enuns.StatusOrcamento;
import br.com.wbcars.enuns.TipoOrcamento;
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

    public List<Orcamento> findByTipo(TipoOrcamento tipo) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.tipo = :tipo", Orcamento.class);
            query.setParameter("tipo", tipo);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por tipo: " + tipo, e);
            return List.of();
        }
    }
    
    public List<Orcamento> findByProduto(Long produtoId) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.produto.id = :produtoId", Orcamento.class);
            query.setParameter("produtoId", produtoId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por produto: " + produtoId, e);
            return List.of();
        }
    }
    
    public List<Orcamento> findByFuncionario(Long funcionarioId) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.funcionario.id = :funcionarioId", Orcamento.class);
            query.setParameter("funcionarioId", funcionarioId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por funcionário: " + funcionarioId, e);
            return List.of();
        }
    }
    
    public List<Orcamento> findByClienteId(Long clienteId) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.cliente.id = :clienteId", Orcamento.class);
            query.setParameter("clienteId", clienteId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por cliente ID: " + clienteId, e);
            return List.of();
        }
    }
    
    public List<Orcamento> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.valorTotal BETWEEN :valorMinimo AND :valorMaximo", 
                Orcamento.class);
            query.setParameter("valorMinimo", valorMinimo);
            query.setParameter("valorMaximo", valorMaximo);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por faixa de valor", e);
            return List.of();
        }
    }
    
    public List<Orcamento> findByDataInicialRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.dataInicial BETWEEN :inicio AND :fim", Orcamento.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por intervalo de data inicial", e);
            return List.of();
        }
    }
    
    public List<Orcamento> findByDataEntregaRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.dataEntrega BETWEEN :inicio AND :fim", Orcamento.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por intervalo de data de entrega", e);
            return List.of();
        }
    }
    
    public List<Orcamento> findByStatus(StatusOrcamento status) {
        try {
            TypedQuery<Orcamento> query = em.createQuery(
                "SELECT o FROM Orcamento o WHERE o.status = :status", Orcamento.class);
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por status: " + status, e);
            return List.of();
        }
    }
}
