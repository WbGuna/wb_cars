package br.com.wbcars.controller;

import br.com.wbcars.dto.OrdemServicoDTO;
import br.com.wbcars.service.OrdemServicoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Ordens de Serviço.
 * Implementa todos os métodos disponíveis no OrdemServicoService.
 */
public class OrdemServicoController {
    private static final Logger LOGGER = Logger.getLogger(OrdemServicoController.class.getName());
    private static OrdemServicoController instance;
    private final OrdemServicoService ordemServicoService = OrdemServicoService.getInstance();

    private OrdemServicoController() {}

    public static OrdemServicoController getInstance() {
        if (instance == null) {
            synchronized (OrdemServicoController.class) {
                if (instance == null) {
                    instance = new OrdemServicoController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva uma nova ordem de serviço
     * @param dto DTO com dados da ordem de serviço
     * @return DTO da ordem de serviço salva
     */
    public OrdemServicoDTO save(OrdemServicoDTO dto) {
        try {
            return ordemServicoService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar ordem de serviço", e);
            throw e;
        }
    }

    /**
     * Atualiza uma ordem de serviço existente
     * @param dto DTO com novos dados da ordem de serviço
     * @return DTO da ordem de serviço atualizada
     */
    public OrdemServicoDTO update(OrdemServicoDTO dto) {
        try {
            return ordemServicoService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar ordem de serviço", e);
            throw e;
        }
    }

    /**
     * Exclui uma ordem de serviço por ID
     * @param id ID da ordem de serviço
     */
    public void delete(Long id) {
        try {
            ordemServicoService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir ordem de serviço", e);
            throw e;
        }
    }

    /**
     * Busca uma ordem de serviço por ID
     * @param id ID da ordem de serviço
     * @return DTO da ordem de serviço encontrada
     */
    public OrdemServicoDTO findById(Long id) {
        try {
            return ordemServicoService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordem de serviço por ID", e);
            throw e;
        }
    }

    /**
     * Busca todas as ordens de serviço
     * @return Lista de DTOs de todas as ordens de serviço
     */
    public List<OrdemServicoDTO> findAll() {
        try {
            return ordemServicoService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todas as ordens de serviço", e);
            throw e;
        }
    }

    /**
     * Busca ordens de serviço por atendente
     * @param atendenteId ID do funcionário atendente
     * @return Lista de DTOs de ordens de serviço do atendente
     */
    public List<OrdemServicoDTO> findByAtendente(Long atendenteId) {
        try {
            return ordemServicoService.findByAtendente(atendenteId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordens de serviço por atendente: " + atendenteId, e);
            throw e;
        }
    }

    /**
     * Busca ordens de serviço por cliente
     * @param clienteId ID do cliente
     * @return Lista de DTOs de ordens de serviço do cliente
     */
    public List<OrdemServicoDTO> findByCliente(Long clienteId) {
        try {
            return ordemServicoService.findByCliente(clienteId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordens de serviço por cliente: " + clienteId, e);
            throw e;
        }
    }

    /**
     * Busca ordens de serviço por descrição
     * @param descricao Texto a ser buscado na descrição
     * @return Lista de DTOs de ordens de serviço que contêm o texto na descrição
     */
    public List<OrdemServicoDTO> findByDescricao(String descricao) {
        try {
            return ordemServicoService.findByDescricao(descricao);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordens de serviço por descrição: " + descricao, e);
            throw e;
        }
    }

    /**
     * Busca ordens de serviço por faixa de valor
     * @param valorMinimo Valor mínimo
     * @param valorMaximo Valor máximo
     * @return Lista de DTOs de ordens de serviço com valores dentro da faixa
     */
    public List<OrdemServicoDTO> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            return ordemServicoService.findByValorRange(valorMinimo, valorMaximo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordens de serviço por faixa de valor", e);
            throw e;
        }
    }

    /**
     * Busca ordens de serviço que contenham uma determinada peça do controle de estoque
     * @param pecaId ID da peça no controle de estoque
     * @return Lista de DTOs de ordens de serviço que contêm a peça
     */
    public List<OrdemServicoDTO> findByPeca(Long pecaId) {
        try {
            return ordemServicoService.findByPeca(pecaId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordens de serviço por peça: " + pecaId, e);
            throw e;
        }
    }

    /**
     * Busca ordens de serviço por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs de ordens de serviço cadastradas no período
     */
    public List<OrdemServicoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return ordemServicoService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordens de serviço por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca ordens de serviço por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs de ordens de serviço alteradas no período
     */
    public List<OrdemServicoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return ordemServicoService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar ordens de serviço por intervalo de data de alteração", e);
            throw e;
        }
    }
}
