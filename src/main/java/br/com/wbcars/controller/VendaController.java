package br.com.wbcars.controller;

import br.com.wbcars.dto.VendaDTO;
import br.com.wbcars.service.VendaService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Vendas.
 * Implementa todos os métodos disponíveis no VendaService.
 */
public class VendaController {
    private static final Logger LOGGER = Logger.getLogger(VendaController.class.getName());
    private static VendaController instance;
    private final VendaService vendaService = VendaService.getInstance();

    private VendaController() {}

    public static VendaController getInstance() {
        if (instance == null) {
            synchronized (VendaController.class) {
                if (instance == null) {
                    instance = new VendaController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva uma nova venda
     * @param dto DTO com dados da venda
     * @return DTO da venda salva
     */
    public VendaDTO save(VendaDTO dto) {
        try {
            return vendaService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar venda", e);
            throw e;
        }
    }

    /**
     * Atualiza uma venda existente
     * @param dto DTO com novos dados da venda
     * @return DTO da venda atualizada
     */
    public VendaDTO update(VendaDTO dto) {
        try {
            return vendaService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar venda", e);
            throw e;
        }
    }

    /**
     * Exclui uma venda por ID
     * @param id ID da venda
     */
    public void delete(Long id) {
        try {
            vendaService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir venda", e);
            throw e;
        }
    }

    /**
     * Busca uma venda por ID
     * @param id ID da venda
     * @return DTO da venda encontrada
     */
    public VendaDTO findById(Long id) {
        try {
            return vendaService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar venda por ID", e);
            throw e;
        }
    }

    /**
     * Busca todas as vendas
     * @return Lista de DTOs de todas as vendas
     */
    public List<VendaDTO> findAll() {
        try {
            return vendaService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todas as vendas", e);
            throw e;
        }
    }

    /**
     * Busca vendas por cliente
     * @param nomeCliente Nome do cliente (ou parte dele)
     * @return Lista de DTOs das vendas encontradas
     */
    public List<VendaDTO> findByCliente(String nomeCliente) {
        try {
            return vendaService.findByCliente(nomeCliente);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por cliente: " + nomeCliente, e);
            throw e;
        }
    }

    /**
     * Busca vendas por intervalo de data da venda
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das vendas encontradas
     */
    public List<VendaDTO> findByDataVendaRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return vendaService.findByDataVendaRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por intervalo de data da venda", e);
            throw e;
        }
    }

    /**
     * Busca vendas por orçamento
     * @param orcamentoId ID do orçamento
     * @return Lista de DTOs das vendas encontradas
     */
    public List<VendaDTO> findByOrcamento(Long orcamentoId) {
        try {
            return vendaService.findByOrcamento(orcamentoId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por orçamento: " + orcamentoId, e);
            throw e;
        }
    }

    /**
     * Busca vendas por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das vendas encontradas
     */
    public List<VendaDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return vendaService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca vendas por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das vendas encontradas
     */
    public List<VendaDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return vendaService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar vendas por intervalo de data de alteração", e);
            throw e;
        }
    }
}
