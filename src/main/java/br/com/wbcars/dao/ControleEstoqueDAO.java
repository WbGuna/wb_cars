package br.com.wbcars.dao;

import br.com.wbcars.entity.ControleEstoque;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleEstoqueDAO extends GenericDAO<ControleEstoque> {
    private static final Logger LOGGER = Logger.getLogger(ControleEstoqueDAO.class.getName());
    private static ControleEstoqueDAO instance;

    private ControleEstoqueDAO() {
        super(ControleEstoque.class);
    }

    public static ControleEstoqueDAO getInstance() {
        if (instance == null) {
            synchronized (ControleEstoqueDAO.class) {
                if (instance == null) {
                    instance = new ControleEstoqueDAO();
                }
            }
        }
        return instance;
    }

    public List<ControleEstoque> findByProduto(String nomeProduto) {
        try {
            TypedQuery<ControleEstoque> query = em.createQuery(
                "SELECT c FROM ControleEstoque c WHERE LOWER(c.produto.nome) LIKE LOWER(:nome)", ControleEstoque.class);
            query.setParameter("nome", "%" + nomeProduto + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar controle de estoque por produto: " + nomeProduto, e);
            return List.of();
        }
    }

    public List<ControleEstoque> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<ControleEstoque> query = em.createQuery(
                "SELECT c FROM ControleEstoque c WHERE c.dataCadastro BETWEEN :inicio AND :fim", ControleEstoque.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar controle de estoque por intervalo de data", e);
            return List.of();
        }
    }
}
