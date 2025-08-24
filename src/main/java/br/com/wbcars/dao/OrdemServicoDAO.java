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
     * Busca ordens de serviço por número
     * @param numero String contendo o número da ordem de serviço
     * @return Lista de ordens de serviço encontradas
     */
    public List<OrdemServico> findByNumero(String numero) {
        try {
            if (numero == null || numero.isEmpty()) {
                return List.of();
            }
            
            // Primeiro tenta buscar pelo campo numero
            jakarta.persistence.TypedQuery<OrdemServico> query = em.createQuery(
                "SELECT o FROM OrdemServico o WHERE o.numero = :numero", OrdemServico.class);
            query.setParameter("numero", numero);
            List<OrdemServico> result = query.getResultList();
            
            // Se não encontrou pelo campo numero, tenta buscar pelo ID
            if (result.isEmpty()) {
                try {
                    Long id = Long.parseLong(numero);
                    OrdemServico entity = findById(id);
                    if (entity != null) {
                        return List.of(entity);
                    }
                } catch (NumberFormatException e) {
                    // Ignora se não for um número válido
                }
            }
            
            return result;
        } catch (Exception e) {
            LOGGER.severe("Erro ao buscar ordem de serviço por número: " + e.getMessage());
            return List.of();
        }
    }
    
    // findByDataCadastroRange herdado de GenericDAO
}
