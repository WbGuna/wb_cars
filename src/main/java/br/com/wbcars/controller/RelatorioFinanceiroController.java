package br.com.wbcars.controller;

import br.com.wbcars.dto.RelatorioFinanceiroDTO;
import br.com.wbcars.service.RelatorioFinanceiroService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Relatórios Financeiros.
 * Implementa todos os métodos disponíveis no RelatorioFinanceiroService.
 */
public class RelatorioFinanceiroController {
    private static final Logger LOGGER = Logger.getLogger(RelatorioFinanceiroController.class.getName());
    private static RelatorioFinanceiroController instance;
    private final RelatorioFinanceiroService relatorioFinanceiroService = RelatorioFinanceiroService.getInstance();

    private RelatorioFinanceiroController() {}

    public static RelatorioFinanceiroController getInstance() {
        if (instance == null) {
            synchronized (RelatorioFinanceiroController.class) {
                if (instance == null) {
                    instance = new RelatorioFinanceiroController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo relatório financeiro
     * @param dto DTO com dados do relatório
     * @return DTO do relatório salvo
     */
    public RelatorioFinanceiroDTO save(RelatorioFinanceiroDTO dto) {
        try {
            return relatorioFinanceiroService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar relatório financeiro", e);
            throw e;
        }
    }

    /**
     * Atualiza um relatório financeiro existente
     * @param dto DTO com novos dados do relatório
     * @return DTO do relatório atualizado
     */
    public RelatorioFinanceiroDTO update(RelatorioFinanceiroDTO dto) {
        try {
            return relatorioFinanceiroService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar relatório financeiro", e);
            throw e;
        }
    }

    /**
     * Exclui um relatório financeiro por ID
     * @param id ID do relatório
     */
    public void delete(Long id) {
        try {
            relatorioFinanceiroService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir relatório financeiro", e);
            throw e;
        }
    }

    /**
     * Busca um relatório financeiro por ID
     * @param id ID do relatório
     * @return DTO do relatório encontrado
     */
    public RelatorioFinanceiroDTO findById(Long id) {
        try {
            return relatorioFinanceiroService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatório financeiro por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os relatórios financeiros
     * @return Lista de DTOs de todos os relatórios
     */
    public List<RelatorioFinanceiroDTO> findAll() {
        try {
            return relatorioFinanceiroService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os relatórios financeiros", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por período
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDTO> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return relatorioFinanceiroService.findByPeriodo(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por período", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por faixa de valor total de vendas
     * @param minimo Valor mínimo
     * @param maximo Valor máximo
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDTO> findByTotalVendasRange(Double minimo, Double maximo) {
        try {
            return relatorioFinanceiroService.findByTotalVendasRange(minimo, maximo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por faixa de valor total de vendas", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por faixa de valor total de orçamentos
     * @param minimo Valor mínimo
     * @param maximo Valor máximo
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDTO> findByTotalOrcamentosRange(Double minimo, Double maximo) {
        try {
            return relatorioFinanceiroService.findByTotalOrcamentosRange(minimo, maximo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por faixa de valor total de orçamentos", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por faixa de valor total de gastos
     * @param minimo Valor mínimo
     * @param maximo Valor máximo
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDTO> findByTotalGastosRange(Double minimo, Double maximo) {
        try {
            return relatorioFinanceiroService.findByTotalGastosRange(minimo, maximo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por faixa de valor total de gastos", e);
            throw e;
        }
    }

    /**
     * Busca relatórios por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos relatórios encontrados
     */
    public List<RelatorioFinanceiroDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return relatorioFinanceiroService.findByDataCadastroRange(inicio, fim);
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
    public List<RelatorioFinanceiroDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return relatorioFinanceiroService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar relatórios por intervalo de data de alteração", e);
            throw e;
        }
    }
}
