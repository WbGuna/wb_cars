package br.com.wbcars.dao;

import br.com.wbcars.entity.ControleEstoque;
import jakarta.persistence.TypedQuery;
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
    
    public List<ControleEstoque> findByQuantidadeRange(Integer quantidadeMinima, Integer quantidadeMaxima) {
        try {
            TypedQuery<ControleEstoque> query = em.createQuery(
                "SELECT c FROM ControleEstoque c WHERE c.quantidade BETWEEN :quantidadeMinima AND :quantidadeMaxima", 
                ControleEstoque.class);
            query.setParameter("quantidadeMinima", quantidadeMinima);
            query.setParameter("quantidadeMaxima", quantidadeMaxima);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar controle de estoque por faixa de quantidade", e);
            return List.of();
        }
    }
    
    public List<ControleEstoque> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            TypedQuery<ControleEstoque> query = em.createQuery(
                "SELECT c FROM ControleEstoque c WHERE c.valor BETWEEN :valorMinimo AND :valorMaximo", 
                ControleEstoque.class);
            query.setParameter("valorMinimo", valorMinimo);
            query.setParameter("valorMaximo", valorMaximo);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar controle de estoque por faixa de valor", e);
            return List.of();
        }
    }
    
    public List<ControleEstoque> findByFornecedor(Long fornecedorId) {
        try {
            TypedQuery<ControleEstoque> query = em.createQuery(
                "SELECT c FROM ControleEstoque c WHERE c.fornecedor.id = :fornecedorId", ControleEstoque.class);
            query.setParameter("fornecedorId", fornecedorId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar controle de estoque por fornecedor: " + fornecedorId, e);
            return List.of();
        }
    }
}
