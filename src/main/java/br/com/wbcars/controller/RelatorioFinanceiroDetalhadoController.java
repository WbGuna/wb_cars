package br.com.wbcars.controller;

import br.com.wbcars.dto.RelatorioFinanceiroDetalhadoDTO;
import br.com.wbcars.service.RelatorioFinanceiroDetalhadoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Relatórios Financeiros Detalhados.
 * Implementa todos os métodos disponíveis no RelatorioFinanceiroDetalhadoService.
 */
public class RelatorioFinanceiroDetalhadoController {
    private static final Logger LOGGER = Logger.getLogger(RelatorioFinanceiroDetalhadoController.class.getName());
    private static RelatorioFinanceiroDetalhadoController instance;
    private final RelatorioFinanceiroDetalhadoService relatorioFinanceiroDetalhadoService = RelatorioFinanceiroDetalhadoService.getInstance();

    private RelatorioFinanceiroDetalhadoController() {}

    public static RelatorioFinanceiroDetalhadoController getInstance() {
        if (instance == null) {
            synchronized (RelatorioFinanceiroDetalhadoController.class) {
                if (instance == null) {
                    instance = new RelatorioFinanceiroDetalhadoController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo relatório financeiro detalhado
     * @param dto DTO com dados do relatório
     * @return DTO do relatório salvo
     */
    public RelatorioFinanceiroDetalhadoDTO save(RelatorioFinanceiroDetalhadoDTO dto) {
        try {
            return relatorioFinanceiroDetalhadoService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar relatório financeiro detalhado", e);
            throw e;
        }
    }

    /**
     * Atualiza um relatório financeiro detalhado existente
     * @param dto DTO com novos dados do relatório
     * @return DTO do relatório atualizado
     */
    public RelatorioFinanceiroDetalhadoDTO update(RelatorioFinanceiroDetalhadoDTO dto) {
        try {
            return relatorioFinanceiroDetalhadoService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar relatório financeiro detalhado", e);
            throw e;
        }
    }

    /**
     * Exclui um relatório financeiro detalhado por ID
     * @param id ID do relatório
     */
    public void delete(Long id) {
        try {
            relatorioFinanceiroDetalhadoService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir relatório financeiro detalhado", e);
            throw e;
        }
    }

    /**
     * Busca um relatório financeiro detalhado por ID
     * @param id ID do relatório
     * @return DTO do relatório encontrado
     */
    public RelatorioFinanceiroDetalhadoDTO findById(Long id) {
        try {
            return relatorioFinanceiroDetalhadoService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatório financeiro detalhado por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os relatórios financeiros detalhados
     * @return Lista de DTOs de todos os relatórios
     */
    public List<RelatorioFinanceiroDetalhadoDTO> findAll() {
        try {
            return relatorioFinanceiroDetalhadoService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os relatórios financeiros detalhados", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por valor total de entrada
     * @param valor Valor total de entrada
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDetalhadoDTO> findByValorTotalEntrada(Double valor) {
        try {
            return relatorioFinanceiroDetalhadoService.findByValorTotalEntrada(valor);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por valor total de entrada: " + valor, e);
            throw e;
        }
    }

    /**
     * Busca relatórios por período
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDetalhadoDTO> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return relatorioFinanceiroDetalhadoService.findByPeriodo(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por período", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDetalhadoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return relatorioFinanceiroDetalhadoService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDetalhadoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return relatorioFinanceiroDetalhadoService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por intervalo de data de alteração", e);
            throw e;
        }
    }
}
