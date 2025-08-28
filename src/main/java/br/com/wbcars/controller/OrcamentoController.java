package br.com.wbcars.controller;

import br.com.wbcars.dto.OrcamentoDTO;
import br.com.wbcars.enuns.StatusOrcamento;
import br.com.wbcars.enuns.TipoOrcamento;
import br.com.wbcars.service.OrcamentoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Orçamentos.
 * Implementa todos os métodos disponíveis no OrcamentoService.
 */
public class OrcamentoController {
    private static final Logger LOGGER = Logger.getLogger(OrcamentoController.class.getName());
    private static OrcamentoController instance;
    private final OrcamentoService orcamentoService = OrcamentoService.getInstance();

    private OrcamentoController() {}

    public static OrcamentoController getInstance() {
        if (instance == null) {
            synchronized (OrcamentoController.class) {
                if (instance == null) {
                    instance = new OrcamentoController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo orçamento
     * @param dto DTO com dados do orçamento
     * @return DTO do orçamento salvo
     */
    public OrcamentoDTO save(OrcamentoDTO dto) {
        try {
            return orcamentoService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar orçamento", e);
            throw e;
        }
    }

    /**
     * Atualiza um orçamento existente
     * @param dto DTO com novos dados do orçamento
     * @return DTO do orçamento atualizado
     */
    public OrcamentoDTO update(OrcamentoDTO dto) {
        try {
            return orcamentoService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar orçamento", e);
            throw e;
        }
    }

    /**
     * Exclui um orçamento por ID
     * @param id ID do orçamento
     */
    public void delete(Long id) {
        try {
            orcamentoService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir orçamento", e);
            throw e;
        }
    }

    /**
     * Busca um orçamento por ID
     * @param id ID do orçamento
     * @return DTO do orçamento encontrado
     */
    public OrcamentoDTO findById(Long id) {
        try {
            return orcamentoService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamento por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os orçamentos
     * @return Lista de DTOs de todos os orçamentos
     */
    public List<OrcamentoDTO> findAll() {
        try {
            return orcamentoService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os orçamentos", e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por cliente
     * @param nomeCliente Nome do cliente (ou parte dele)
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByCliente(String nomeCliente) {
        try {
            return orcamentoService.findByCliente(nomeCliente);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por cliente: " + nomeCliente, e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por tipo
     * @param tipo Tipo do orçamento
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByTipo(TipoOrcamento tipo) {
        try {
            return orcamentoService.findByTipo(tipo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por tipo: " + tipo, e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por produto
     * @param produtoId ID do produto
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByProduto(Long produtoId) {
        try {
            return orcamentoService.findByProduto(produtoId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por produto: " + produtoId, e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por funcionário
     * @param funcionarioId ID do funcionário
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByFuncionario(Long funcionarioId) {
        try {
            return orcamentoService.findByFuncionario(funcionarioId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por funcionário: " + funcionarioId, e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por ID do cliente
     * @param clienteId ID do cliente
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByClienteId(Long clienteId) {
        try {
            return orcamentoService.findByClienteId(clienteId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por ID do cliente: " + clienteId, e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por faixa de valor
     * @param valorMinimo Valor mínimo
     * @param valorMaximo Valor máximo
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            return orcamentoService.findByValorRange(valorMinimo, valorMaximo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por faixa de valor", e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por intervalo de data inicial
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByDataInicialRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return orcamentoService.findByDataInicialRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por intervalo de data inicial", e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por intervalo de data de entrega
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByDataEntregaRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return orcamentoService.findByDataEntregaRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por intervalo de data de entrega", e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por status
     * @param status Status do orçamento
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByStatus(StatusOrcamento status) {
        try {
            return orcamentoService.findByStatus(status);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por status: " + status, e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return orcamentoService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca orçamentos por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos orçamentos encontrados
     */
    public List<OrcamentoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return orcamentoService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar orçamentos por intervalo de data de alteração", e);
            throw e;
        }
    }
}
