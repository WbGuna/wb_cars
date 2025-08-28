package br.com.wbcars.dao;

import br.com.wbcars.entity.OrdemServico;
import java.util.List;
import java.util.logging.Logger;

public class OrdemServicoDAO extends GenericDAO<OrdemServico> {
    private static final Logger LOGGER = Logger.getLogger(OrdemServicoDAO.class.getName());
    private static OrdemServicoDAO instance;

    private OrdemServicoDAO() {
        super(OrdemServico.class);
    }

    public static OrdemServicoDAO getInstance() {
        if (instance == null) {
            synchronized (OrdemServicoDAO.class) {
                if (instance == null) {
                    instance = new OrdemServicoDAO();
                }
            }
        }
        return instance;
    }


    
    /**
     * Busca ordens de serviço por atendente
     * @param atendenteId ID do funcionário atendente
     * @return Lista de ordens de serviço do atendente
     */
    public List<OrdemServico> findByAtendente(Long atendenteId) {
        try {
            jakarta.persistence.TypedQuery<OrdemServico> query = em.createQuery(
                "SELECT o FROM OrdemServico o WHERE o.atendente.id = :atendenteId", OrdemServico.class);
            query.setParameter("atendenteId", atendenteId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("Erro ao buscar ordens de serviço por atendente: " + e.getMessage());
            return List.of();
        }
    }
    
    /**
     * Busca ordens de serviço por cliente
     * @param clienteId ID do cliente
     * @return Lista de ordens de serviço do cliente
     */
    public List<OrdemServico> findByCliente(Long clienteId) {
        try {
            jakarta.persistence.TypedQuery<OrdemServico> query = em.createQuery(
                "SELECT o FROM OrdemServico o WHERE o.cliente.id = :clienteId", OrdemServico.class);
            query.setParameter("clienteId", clienteId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("Erro ao buscar ordens de serviço por cliente: " + e.getMessage());
            return List.of();
        }
    }
    
    /**
     * Busca ordens de serviço por descrição
     * @param descricao Texto a ser buscado na descrição
     * @return Lista de ordens de serviço que contêm o texto na descrição
     */
    public List<OrdemServico> findByDescricao(String descricao) {
        try {
            jakarta.persistence.TypedQuery<OrdemServico> query = em.createQuery(
                "SELECT o FROM OrdemServico o WHERE LOWER(o.descricao) LIKE LOWER(:descricao)", OrdemServico.class);
            query.setParameter("descricao", "%" + descricao + "%");
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("Erro ao buscar ordens de serviço por descrição: " + e.getMessage());
            return List.of();
        }
    }
    
    /**
     * Busca ordens de serviço por faixa de valor
     * @param valorMinimo Valor mínimo
     * @param valorMaximo Valor máximo
     * @return Lista de ordens de serviço com valores dentro da faixa
     */
    public List<OrdemServico> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            jakarta.persistence.TypedQuery<OrdemServico> query = em.createQuery(
                "SELECT o FROM OrdemServico o WHERE o.valor BETWEEN :valorMinimo AND :valorMaximo", OrdemServico.class);
            query.setParameter("valorMinimo", valorMinimo);
            query.setParameter("valorMaximo", valorMaximo);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("Erro ao buscar ordens de serviço por faixa de valor: " + e.getMessage());
            return List.of();
        }
    }
    
    /**
     * Busca ordens de serviço que contenham uma determinada peça do controle de estoque.
     * Este método utiliza o relacionamento ManyToMany entre OrdemServico e ControleEstoque,
     * permitindo encontrar todas as ordens que utilizaram uma peça específica.
     * 
     * @param pecaId ID da peça no controle de estoque
     * @return Lista de ordens de serviço que contêm a peça
     */
    public List<OrdemServico> findByPeca(Long pecaId) {
        try {
            jakarta.persistence.TypedQuery<OrdemServico> query = em.createQuery(
                "SELECT o FROM OrdemServico o JOIN o.pecas p WHERE p.id = :pecaId", OrdemServico.class);
            query.setParameter("pecaId", pecaId);
            return query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("Erro ao buscar ordens de serviço por peça: " + e.getMessage());
            return List.of();
        }
    }
}
