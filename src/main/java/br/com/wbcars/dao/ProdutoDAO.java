package br.com.wbcars.dao;

import br.com.wbcars.entity.Produto;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO extends GenericDAO<Produto> {
    private static final Logger LOGGER = Logger.getLogger(ProdutoDAO.class.getName());
    private static ProdutoDAO instance;

    private ProdutoDAO() {
        super(Produto.class);
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            synchronized (ProdutoDAO.class) {
                if (instance == null) {
                    instance = new ProdutoDAO();
                }
            }
        }
        return instance;
    }

    public List<Produto> findAllByNome(String nome) {
        try {
            TypedQuery<Produto> query = getEntityManager().createQuery(
                "SELECT p FROM Produto p WHERE LOWER(p.nome) LIKE LOWER(:nome)", Produto.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por nome: " + nome, e);
            return List.of();
        }
    }
    
    public List<Produto> findByFornecedor(Long fornecedorId) {
        try {
            TypedQuery<Produto> query = getEntityManager().createQuery(
                "SELECT p FROM Produto p WHERE p.fornecedor.id = :fornecedorId", Produto.class);
            query.setParameter("fornecedorId", fornecedorId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por fornecedor: " + fornecedorId, e);
            return List.of();
        }
    }
    
    public List<Produto> findByUnidadeMedida(Long unidadeMedidaId) {
        try {
            TypedQuery<Produto> query = getEntityManager().createQuery(
                "SELECT p FROM Produto p WHERE p.unidadeMedida.id = :unidadeMedidaId", Produto.class);
            query.setParameter("unidadeMedidaId", unidadeMedidaId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar produtos por unidade de medida: " + unidadeMedidaId, e);
            return List.of();
        }
    }
}
