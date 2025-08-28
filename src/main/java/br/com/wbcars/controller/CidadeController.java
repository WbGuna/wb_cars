package br.com.wbcars.controller;

import br.com.wbcars.dto.CidadeDTO;
import br.com.wbcars.enuns.EstadoBrasil;
import br.com.wbcars.service.CidadeService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Cidades.
 * Implementa todos os métodos disponíveis no CidadeService.
 */
public class CidadeController {
    private static final Logger LOGGER = Logger.getLogger(CidadeController.class.getName());
    private static CidadeController instance;
    private final CidadeService cidadeService = CidadeService.getInstance();

    private CidadeController() {}

    public static CidadeController getInstance() {
        if (instance == null) {
            synchronized (CidadeController.class) {
                if (instance == null) {
                    instance = new CidadeController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva uma nova cidade
     * @param dto DTO com dados da cidade
     * @return DTO da cidade salva
     */
    public CidadeDTO save(CidadeDTO dto) {
        try {
            return cidadeService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar cidade", e);
            throw e;
        }
    }

    /**
     * Atualiza uma cidade existente
     * @param dto DTO com novos dados da cidade
     * @return DTO da cidade atualizada
     */
    public CidadeDTO update(CidadeDTO dto) {
        try {
            return cidadeService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar cidade", e);
            throw e;
        }
    }

    /**
     * Exclui uma cidade por ID
     * @param id ID da cidade
     */
    public void delete(Long id) {
        try {
            cidadeService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir cidade", e);
            throw e;
        }
    }

    /**
     * Busca uma cidade por ID
     * @param id ID da cidade
     * @return DTO da cidade encontrada
     */
    public CidadeDTO findById(Long id) {
        try {
            return cidadeService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidade por ID", e);
            throw e;
        }
    }

    /**
     * Busca todas as cidades
     * @return Lista de DTOs de todas as cidades
     */
    public List<CidadeDTO> findAll() {
        try {
            return cidadeService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todas as cidades", e);
            throw e;
        }
    }

    /**
     * Busca cidades por nome
     * @param nome Nome da cidade (ou parte dele)
     * @return Lista de DTOs das cidades encontradas
     */
    public List<CidadeDTO> findByNome(String nome) {
        try {
            return cidadeService.findByNome(nome);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por nome: " + nome, e);
            throw e;
        }
    }

    /**
     * Busca cidades por estado
     * @param estado Estado brasileiro
     * @return Lista de DTOs das cidades encontradas
     */
    public List<CidadeDTO> findByEstado(EstadoBrasil estado) {
        try {
            return cidadeService.findByEstado(estado);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por estado: " + estado, e);
            throw e;
        }
    }

    /**
     * Busca cidades por país
     * @param pais Nome do país
     * @return Lista de DTOs das cidades encontradas
     */
    public List<CidadeDTO> findByPais(String pais) {
        try {
            return cidadeService.findByPais(pais);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por país: " + pais, e);
            throw e;
        }
    }

    /**
     * Busca cidades por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das cidades encontradas
     */
    public List<CidadeDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return cidadeService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca cidades por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das cidades encontradas
     */
    public List<CidadeDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return cidadeService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cidades por intervalo de data de alteração", e);
            throw e;
        }
    }
}
