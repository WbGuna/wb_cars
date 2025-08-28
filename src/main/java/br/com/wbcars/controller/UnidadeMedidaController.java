package br.com.wbcars.controller;

import br.com.wbcars.dto.UnidadeMedidaDTO;
import br.com.wbcars.enuns.TipoUnidadeMedida;
import br.com.wbcars.service.UnidadeMedidaService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Unidades de Medida.
 * Implementa todos os métodos disponíveis no UnidadeMedidaService.
 */
public class UnidadeMedidaController {
    private static final Logger LOGGER = Logger.getLogger(UnidadeMedidaController.class.getName());
    private static UnidadeMedidaController instance;
    private final UnidadeMedidaService unidadeMedidaService = UnidadeMedidaService.getInstance();

    private UnidadeMedidaController() {}

    public static UnidadeMedidaController getInstance() {
        if (instance == null) {
            synchronized (UnidadeMedidaController.class) {
                if (instance == null) {
                    instance = new UnidadeMedidaController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva uma nova unidade de medida
     * @param dto DTO com dados da unidade de medida
     * @return DTO da unidade de medida salva
     */
    public UnidadeMedidaDTO save(UnidadeMedidaDTO dto) {
        try {
            return unidadeMedidaService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar unidade de medida", e);
            throw e;
        }
    }

    /**
     * Atualiza uma unidade de medida existente
     * @param dto DTO com novos dados da unidade de medida
     * @return DTO da unidade de medida atualizada
     */
    public UnidadeMedidaDTO update(UnidadeMedidaDTO dto) {
        try {
            return unidadeMedidaService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar unidade de medida", e);
            throw e;
        }
    }

    /**
     * Exclui uma unidade de medida por ID
     * @param id ID da unidade de medida
     */
    public void delete(Long id) {
        try {
            unidadeMedidaService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir unidade de medida", e);
            throw e;
        }
    }

    /**
     * Busca uma unidade de medida por ID
     * @param id ID da unidade de medida
     * @return DTO da unidade de medida encontrada
     */
    public UnidadeMedidaDTO findById(Long id) {
        try {
            return unidadeMedidaService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidade de medida por ID", e);
            throw e;
        }
    }

    /**
     * Busca todas as unidades de medida
     * @return Lista de DTOs de todas as unidades de medida
     */
    public List<UnidadeMedidaDTO> findAll() {
        try {
            return unidadeMedidaService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todas as unidades de medida", e);
            throw e;
        }
    }

    /**
     * Busca unidades de medida por nome
     * @param nome Nome da unidade de medida (ou parte dele)
     * @return Lista de DTOs das unidades de medida encontradas
     */
    public List<UnidadeMedidaDTO> findByNome(String nome) {
        try {
            return unidadeMedidaService.findByNome(nome);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidades de medida por nome: " + nome, e);
            throw e;
        }
    }

    /**
     * Busca unidade de medida por sigla
     * @param sigla Sigla da unidade de medida
     * @return DTO da unidade de medida encontrada
     */
    public UnidadeMedidaDTO findBySigla(String sigla) {
        try {
            return unidadeMedidaService.findBySigla(sigla);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidade de medida por sigla: " + sigla, e);
            throw e;
        }
    }

    /**
     * Busca unidades de medida por tipo
     * @param tipo Tipo de unidade de medida
     * @return Lista de DTOs das unidades de medida encontradas
     */
    public List<UnidadeMedidaDTO> findByTipo(TipoUnidadeMedida tipo) {
        try {
            return unidadeMedidaService.findByTipo(tipo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidades de medida por tipo: " + tipo, e);
            throw e;
        }
    }

    /**
     * Busca unidades de medida por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das unidades de medida encontradas
     */
    public List<UnidadeMedidaDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return unidadeMedidaService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidades de medida por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca unidades de medida por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das unidades de medida encontradas
     */
    public List<UnidadeMedidaDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return unidadeMedidaService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar unidades de medida por intervalo de data de alteração", e);
            throw e;
        }
    }
}
