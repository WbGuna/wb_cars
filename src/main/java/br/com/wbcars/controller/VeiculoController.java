package br.com.wbcars.controller;

import br.com.wbcars.dto.VeiculoDTO;
import br.com.wbcars.service.VeiculoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Veículos.
 * Implementa todos os métodos disponíveis no VeiculoService.
 */
public class VeiculoController {
    private static final Logger LOGGER = Logger.getLogger(VeiculoController.class.getName());
    private static VeiculoController instance;
    private final VeiculoService veiculoService = VeiculoService.getInstance();

    private VeiculoController() {}

    public static VeiculoController getInstance() {
        if (instance == null) {
            synchronized (VeiculoController.class) {
                if (instance == null) {
                    instance = new VeiculoController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo veículo
     * @param dto DTO com dados do veículo
     * @return DTO do veículo salvo
     */
    public VeiculoDTO save(VeiculoDTO dto) {
        try {
            return veiculoService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar veículo", e);
            throw e;
        }
    }

    /**
     * Atualiza um veículo existente
     * @param dto DTO com novos dados do veículo
     * @return DTO do veículo atualizado
     */
    public VeiculoDTO update(VeiculoDTO dto) {
        try {
            return veiculoService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar veículo", e);
            throw e;
        }
    }

    /**
     * Exclui um veículo por ID
     * @param id ID do veículo
     */
    public void delete(Long id) {
        try {
            veiculoService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir veículo", e);
            throw e;
        }
    }

    /**
     * Busca um veículo por ID
     * @param id ID do veículo
     * @return DTO do veículo encontrado
     */
    public VeiculoDTO findById(Long id) {
        try {
            return veiculoService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículo por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os veículos
     * @return Lista de DTOs de todos os veículos
     */
    public List<VeiculoDTO> findAll() {
        try {
            return veiculoService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os veículos", e);
            throw e;
        }
    }

    /**
     * Busca veículos por placa
     * @param placa Placa do veículo (ou parte dela)
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByPlaca(String placa) {
        try {
            return veiculoService.findByPlaca(placa);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por placa: " + placa, e);
            throw e;
        }
    }

    /**
     * Busca veículos por modelo
     * @param modelo Modelo do veículo (ou parte dele)
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByModelo(String modelo) {
        try {
            return veiculoService.findByModelo(modelo);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por modelo: " + modelo, e);
            throw e;
        }
    }

    /**
     * Busca veículos por marca
     * @param marca Marca do veículo (ou parte dela)
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByMarca(String marca) {
        try {
            return veiculoService.findByMarca(marca);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por marca: " + marca, e);
            throw e;
        }
    }

    /**
     * Busca veículos por faixa de kilometragem
     * @param minKm Kilometragem mínima
     * @param maxKm Kilometragem máxima
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByKilometragemRange(Integer minKm, Integer maxKm) {
        try {
            return veiculoService.findByKilometragemRange(minKm, maxKm);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por faixa de kilometragem", e);
            throw e;
        }
    }

    /**
     * Busca veículos por cliente
     * @param clienteId ID do cliente
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByCliente(Long clienteId) {
        try {
            return veiculoService.findByCliente(clienteId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por cliente: " + clienteId, e);
            throw e;
        }
    }

    /**
     * Busca veículos por observação
     * @param observacao Texto a ser buscado na observação
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByObservacao(String observacao) {
        try {
            return veiculoService.findByObservacao(observacao);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por observação: " + observacao, e);
            throw e;
        }
    }

    /**
     * Busca veículos por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return veiculoService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca veículos por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos veículos encontrados
     */
    public List<VeiculoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return veiculoService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículos por intervalo de data de alteração", e);
            throw e;
        }
    }
}
