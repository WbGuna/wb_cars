package br.com.wbcars.dao;

import br.com.wbcars.entity.Fornecedor;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
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

    public List<Fornecedor> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Fornecedor> query = em.createQuery(
                "SELECT f FROM Fornecedor f WHERE f.dataCadastro BETWEEN :inicio AND :fim", Fornecedor.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por intervalo de data", e);
            return List.of();
        }
    }
}
