package br.com.wbcars.dao;

import br.com.wbcars.entity.Fornecedor;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoFornecimento;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FornecedorDAO extends GenericDAO<Fornecedor> {
    private static final Logger LOGGER = Logger.getLogger(FornecedorDAO.class.getName());
    private static FornecedorDAO instance;

    private FornecedorDAO() {
        super(Fornecedor.class);
    }

    public static FornecedorDAO getInstance() {
        if (instance == null) {
            synchronized (FornecedorDAO.class) {
                if (instance == null) {
                    instance = new FornecedorDAO();
                }
            }
        }
        return instance;
    }

    public List<Fornecedor> findByNome(String nome) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE LOWER(f.nome) LIKE LOWER(:nome)", Fornecedor.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por nome: " + nome, e);
            return List.of();
        }
    }

    public Fornecedor findByCpfCnpj(String cpfCnpj) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE f.cpfCnpj = :cpfCnpj", Fornecedor.class);
            query.setParameter("cpfCnpj", cpfCnpj);
            List<Fornecedor> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedor por CPF/CNPJ: " + cpfCnpj, e);
            return null;
        }
    }

    public List<Fornecedor> findByTelefone(String telefone) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE f.telefone LIKE :telefone", Fornecedor.class);
            query.setParameter("telefone", "%" + telefone + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por telefone: " + telefone, e);
            return List.of();
        }
    }
    
    public List<Fornecedor> findByEmail(String email) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE LOWER(f.email) LIKE LOWER(:email)", Fornecedor.class);
            query.setParameter("email", "%" + email + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por email: " + email, e);
            return List.of();
        }
    }
    
    public List<Fornecedor> findByTipoFornecimento(TipoFornecimento tipoFornecimento) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE f.tipoFornecimento = :tipoFornecimento", Fornecedor.class);
            query.setParameter("tipoFornecimento", tipoFornecimento);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por tipo de fornecimento: " + tipoFornecimento, e);
            return List.of();
        }
    }
    
    public List<Fornecedor> findByStatus(StatusGeral status) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE f.status = :status", Fornecedor.class);
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por status: " + status, e);
            return List.of();
        }
    }
    
    public List<Fornecedor> findByEndereco(String endereco) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE LOWER(f.rua) LIKE LOWER(:endereco) OR LOWER(f.bairro) LIKE LOWER(:endereco)", 
                Fornecedor.class);
            query.setParameter("endereco", "%" + endereco + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por endereço: " + endereco, e);
            return List.of();
        }
    }
    
    public List<Fornecedor> findByCidade(Long cidadeId) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE f.cidade.id = :cidadeId", Fornecedor.class);
            query.setParameter("cidadeId", cidadeId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por cidade: " + cidadeId, e);
            return List.of();
        }
    }
}
