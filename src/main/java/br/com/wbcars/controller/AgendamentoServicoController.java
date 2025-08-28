package br.com.wbcars.controller;

import br.com.wbcars.dto.AgendamentoServicoDTO;
import br.com.wbcars.service.AgendamentoServicoService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Agendamentos de Serviços.
 * Implementa todos os métodos disponíveis no AgendamentoServicoService.
 */
public class AgendamentoServicoController {
    private static final Logger LOGGER = Logger.getLogger(AgendamentoServicoController.class.getName());
    private static AgendamentoServicoController instance;
    private final AgendamentoServicoService agendamentoServicoService = AgendamentoServicoService.getInstance();

    private AgendamentoServicoController() {}

    public static AgendamentoServicoController getInstance() {
        if (instance == null) {
            synchronized (AgendamentoServicoController.class) {
                if (instance == null) {
                    instance = new AgendamentoServicoController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo agendamento de serviço
     * @param dto DTO com dados do agendamento
     * @return DTO do agendamento salvo
     */
    public AgendamentoServicoDTO save(AgendamentoServicoDTO dto) {
        try {
            return agendamentoServicoService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar agendamento de serviço", e);
            throw e;
        }
    }

    /**
     * Atualiza um agendamento de serviço existente
     * @param dto DTO com novos dados do agendamento
     * @return DTO do agendamento atualizado
     */
    public AgendamentoServicoDTO update(AgendamentoServicoDTO dto) {
        try {
            return agendamentoServicoService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar agendamento de serviço", e);
            throw e;
        }
    }

    /**
     * Exclui um agendamento de serviço por ID
     * @param id ID do agendamento
     */
    public void delete(Long id) {
        try {
            agendamentoServicoService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir agendamento de serviço", e);
            throw e;
        }
    }

    /**
     * Busca um agendamento de serviço por ID
     * @param id ID do agendamento
     * @return DTO do agendamento encontrado
     */
    public AgendamentoServicoDTO findById(Long id) {
        try {
            return agendamentoServicoService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamento de serviço por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os agendamentos de serviço
     * @return Lista de DTOs de todos os agendamentos
     */
    public List<AgendamentoServicoDTO> findAll() {
        try {
            return agendamentoServicoService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os agendamentos de serviço", e);
            throw e;
        }
    }

    /**
     * Busca agendamentos por nome do cliente
     * @param nomeCliente Nome do cliente (ou parte dele)
     * @return Lista de DTOs dos agendamentos encontrados
     */
    public List<AgendamentoServicoDTO> findByCliente(String nomeCliente) {
        try {
            return agendamentoServicoService.findByCliente(nomeCliente);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamentos por cliente: " + nomeCliente, e);
            throw e;
        }
    }

    /**
     * Busca agendamentos por ID do cliente
     * @param clienteId ID do cliente
     * @return Lista de DTOs dos agendamentos encontrados
     */
    public List<AgendamentoServicoDTO> findByClienteId(Long clienteId) {
        try {
            return agendamentoServicoService.findByClienteId(clienteId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamentos por ID do cliente: " + clienteId, e);
            throw e;
        }
    }

    /**
     * Busca agendamentos por intervalo de data agendada
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos agendamentos encontrados
     */
    public List<AgendamentoServicoDTO> findByDataAgendadaRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return agendamentoServicoService.findByDataAgendadaRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamentos por intervalo de data agendada", e);
            throw e;
        }
    }

    /**
     * Busca agendamentos por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos agendamentos encontrados
     */
    public List<AgendamentoServicoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return agendamentoServicoService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamentos por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca agendamentos por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos agendamentos encontrados
     */
    public List<AgendamentoServicoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return agendamentoServicoService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar agendamentos por intervalo de data de alteração", e);
            throw e;
        }
    }
}
