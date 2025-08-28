package br.com.wbcars.dao;

import br.com.wbcars.entity.Cliente;
import br.com.wbcars.enuns.StatusGeral;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends GenericDAO<Cliente> {
    private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class.getName());
    private static ClienteDAO instance;

    private ClienteDAO() {
        super(Cliente.class);
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            synchronized (ClienteDAO.class) {
                if (instance == null) {
                    instance = new ClienteDAO();
                }
            }
        }
        return instance;
    }

    /**
     * Busca clientes cujo nome contenha o texto informado
     * @param nome Texto a ser buscado no nome
     * @return Lista de clientes que atendem ao critério
     */
    public List<Cliente> findAllByNome(String nome) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(:nome)", Cliente.class);
            query.setParameter("nome", "%" + nome + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por nome: " + nome, e);
            return List.of();
        }
    }

    /**
     * Busca cliente por CPF/CNPJ exato
     * @param cpfCnpj CPF ou CNPJ a ser buscado
     * @return Cliente encontrado ou null
     */
    public Cliente findByCpfCnpj(String cpfCnpj) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE c.cpfCnpj = :cpfCnpj", Cliente.class);
            query.setParameter("cpfCnpj", cpfCnpj);
            List<Cliente> result = query.getResultList();
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cliente por CPF/CNPJ: " + cpfCnpj, e);
            return null;
        }
    }
    
    /**
     * Busca clientes por email
     * @param email Email a ser buscado
     * @return Lista de clientes com o email informado
     */
    public List<Cliente> findByEmail(String email) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE LOWER(c.email) LIKE LOWER(:email)", Cliente.class);
            query.setParameter("email", "%" + email + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por email: " + email, e);
            return List.of();
        }
    }
    
    /**
     * Busca clientes por celular
     * @param celular Número de celular a ser buscado
     * @return Lista de clientes com o celular informado
     */
    public List<Cliente> findByCelular(String celular) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE c.celular LIKE :celular", Cliente.class);
            query.setParameter("celular", "%" + celular + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por celular: " + celular, e);
            return List.of();
        }
    }
    
    /**
     * Busca clientes por endereço (rua e bairro)
     * @param endereco Texto a ser buscado no endereço
     * @return Lista de clientes que atendem ao critério
     */
    public List<Cliente> findByEndereco(String endereco) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE LOWER(c.rua) LIKE LOWER(:endereco) OR LOWER(c.bairro) LIKE LOWER(:endereco)", 
                Cliente.class);
            query.setParameter("endereco", "%" + endereco + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por endereço: " + endereco, e);
            return List.of();
        }
    }
    
    /**
     * Busca clientes por cidade
     * @param cidadeId ID da cidade a ser buscada
     * @return Lista de clientes da cidade informada
     */
    public List<Cliente> findByCidade(Long cidadeId) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE c.cidade.id = :cidadeId", Cliente.class);
            query.setParameter("cidadeId", cidadeId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por cidade: " + cidadeId, e);
            return List.of();
        }
    }
    
    /**
     * Busca clientes por status
     * @param status Status a ser buscado
     * @return Lista de clientes com o status informado
     */
    public List<Cliente> findByStatus(StatusGeral status) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE c.status = :status", Cliente.class);
            query.setParameter("status", status);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por status: " + status, e);
            return List.of();
        }
    }
    
    /**
     * Busca clientes por data de nascimento em um intervalo
     * @param inicio Data inicial do intervalo
     * @param fim Data final do intervalo
     * @return Lista de clientes que atendem ao critério
     */
    public List<Cliente> findByDataNascimentoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            TypedQuery<Cliente> query = getEntityManager().createQuery(
                "SELECT c FROM Cliente c WHERE c.dataNascimento BETWEEN :inicio AND :fim", Cliente.class);
            query.setParameter("inicio", inicio);
            query.setParameter("fim", fim);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por intervalo de data de nascimento", e);
            return List.of();
        }
    }
}
