package br.com.wbcars.controller;

import br.com.wbcars.dto.ContaPagarDTO;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoContaPagar;
import br.com.wbcars.service.ContaPagarService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Contas a Pagar.
 * Implementa todos os métodos disponíveis no ContaPagarService.
 */
public class ContaPagarController {
    private static final Logger LOGGER = Logger.getLogger(ContaPagarController.class.getName());
    private static ContaPagarController instance;
    private final ContaPagarService contaPagarService = ContaPagarService.getInstance();

    private ContaPagarController() {}

    public static ContaPagarController getInstance() {
        if (instance == null) {
            synchronized (ContaPagarController.class) {
                if (instance == null) {
                    instance = new ContaPagarController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva uma nova conta a pagar
     * @param dto DTO com dados da conta
     * @return DTO da conta salva
     */
    public ContaPagarDTO save(ContaPagarDTO dto) {
        try {
            return contaPagarService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar conta a pagar", e);
            throw e;
        }
    }

    /**
     * Atualiza uma conta a pagar existente
     * @param dto DTO com novos dados da conta
     * @return DTO da conta atualizada
     */
    public ContaPagarDTO update(ContaPagarDTO dto) {
        try {
            return contaPagarService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar conta a pagar", e);
            throw e;
        }
    }

    /**
     * Exclui uma conta a pagar por ID
     * @param id ID da conta
     */
    public void delete(Long id) {
        try {
            contaPagarService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir conta a pagar", e);
            throw e;
        }
    }

    /**
     * Busca uma conta a pagar por ID
     * @param id ID da conta
     * @return DTO da conta encontrada
     */
    public ContaPagarDTO findById(Long id) {
        try {
            return contaPagarService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar conta a pagar por ID", e);
            throw e;
        }
    }

    /**
     * Busca todas as contas a pagar
     * @return Lista de DTOs de todas as contas
     */
    public List<ContaPagarDTO> findAll() {
        try {
            return contaPagarService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todas as contas a pagar", e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por fornecedor
     * @param nomeFornecedor Nome do fornecedor (ou parte dele)
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByFornecedor(String nomeFornecedor) {
        try {
            return contaPagarService.findByFornecedor(nomeFornecedor);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por fornecedor: " + nomeFornecedor, e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por intervalo de data de vencimento
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByDataVencimentoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return contaPagarService.findByDataVencimentoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por intervalo de data de vencimento", e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por tipo
     * @param tipo Tipo da conta
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByTipo(TipoContaPagar tipo) {
        try {
            return contaPagarService.findByTipo(tipo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por tipo: " + tipo, e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por intervalo de prazo
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByPrazoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return contaPagarService.findByPrazoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por intervalo de prazo", e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por status
     * @param status Status da conta
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByStatus(StatusGeral status) {
        try {
            return contaPagarService.findByStatus(status);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por status: " + status, e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por faixa de valor
     * @param valorMinimo Valor mínimo
     * @param valorMaximo Valor máximo
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByValorRange(Double valorMinimo, Double valorMaximo) {
        try {
            return contaPagarService.findByValorRange(valorMinimo, valorMaximo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por faixa de valor", e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return contaPagarService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca contas a pagar por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das contas encontradas
     */
    public List<ContaPagarDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return contaPagarService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar contas a pagar por intervalo de data de alteração", e);
            throw e;
        }
    }
}
