package br.com.wbcars.dao;

import br.com.wbcars.entity.OrdemServico;
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

    // Método findByNumero removido pois o campo 'numero' não existe na entidade OrdemServico
    
    // findByDataCadastroRange removido pois foi movido para GenericDAO
}
