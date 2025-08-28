package br.com.wbcars.dao;

import br.com.wbcars.entity.Venda;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDAO extends GenericDAO<Venda> {
    private static final Logger LOGGER = Logger.getLogger(VendaDAO.class.getName());
    private static VendaDAO instance;

    private VendaDAO() {
        super(Venda.class);
    }

    public static VendaDAO getInstance() {
        if (instance == null) {
            synchronized (VendaDAO.class) {
                if (instance == null) {
                    instance = new VendaDAO();
                }
            }
        }
        return instance;
    }

    public List<Venda> findByCliente(String nomeCliente) {
        try {
            TypedQuery<Venda> query = em.createQuery(
                "SELECT v FROM Venda v WHERE LOWER(v.cliente.nome) LIKE LOWER(:nome)", Venda.class);
            query.setParameter("nome", "%" + nomeCliente + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por cliente: " + nomeCliente, e);
            return List.of();
        }
    }

    public List<Venda> findByDataVendaRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Venda> query = em.createQuery(
                "SELECT v FROM Venda v WHERE v.dataVenda BETWEEN :inicio AND :fim", Venda.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por intervalo de data", e);
            return List.of();
        }
    }
    
    public List<Venda> findByOrcamento(Long orcamentoId) {
        try {
            TypedQuery<Venda> query = em.createQuery(
                "SELECT v FROM Venda v WHERE v.orcamento.id = :orcamentoId", Venda.class);
            query.setParameter("orcamentoId", orcamentoId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por orçamento: " + orcamentoId, e);
            return List.of();
        }
    }
}
