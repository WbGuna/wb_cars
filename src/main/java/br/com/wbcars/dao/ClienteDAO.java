package br.com.wbcars.dao;

import br.com.wbcars.entity.Cliente;
import jakarta.persistence.TypedQuery;
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
    
    // findByDataCadastroRange removido pois foi movido para GenericDAO
}
