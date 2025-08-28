package br.com.wbcars.controller;

import br.com.wbcars.dto.ClienteDTO;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.service.ClienteService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Clientes.
 * Implementa todos os métodos disponíveis no ClienteService.
 */
public class ClienteController {
    private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());
    private static ClienteController instance;
    private final ClienteService clienteService = ClienteService.getInstance();

    private ClienteController() {}

    public static ClienteController getInstance() {
        if (instance == null) {
            synchronized (ClienteController.class) {
                if (instance == null) {
                    instance = new ClienteController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo cliente
     * @param dto DTO com dados do cliente
     * @return DTO do cliente salvo
     */
    public ClienteDTO save(ClienteDTO dto) {
        try {
            return clienteService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar cliente", e);
            throw e;
        }
    }

    /**
     * Atualiza um cliente existente
     * @param dto DTO com novos dados do cliente
     * @return DTO do cliente atualizado
     */
    public ClienteDTO update(ClienteDTO dto) {
        try {
            return clienteService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar cliente", e);
            throw e;
        }
    }

    /**
     * Exclui um cliente por ID
     * @param id ID do cliente
     */
    public void delete(Long id) {
        try {
            clienteService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir cliente", e);
            throw e;
        }
    }

    /**
     * Busca um cliente por ID
     * @param id ID do cliente
     * @return DTO do cliente encontrado
     */
    public ClienteDTO findById(Long id) {
        try {
            return clienteService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cliente por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os clientes
     * @return Lista de DTOs de todos os clientes
     */
    public List<ClienteDTO> findAll() {
        try {
            return clienteService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os clientes", e);
            throw e;
        }
    }

    /**
     * Busca clientes por nome
     * @param nome Nome do cliente (ou parte dele)
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByNome(String nome) {
        try {
            return clienteService.findByNome(nome);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por nome: " + nome, e);
            throw e;
        }
    }

    /**
     * Busca cliente por CPF/CNPJ
     * @param cpfCnpj CPF ou CNPJ do cliente
     * @return DTO do cliente encontrado
     */
    public ClienteDTO findByCpfCnpj(String cpfCnpj) {
        try {
            return clienteService.findByCpfCnpj(cpfCnpj);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar cliente por CPF/CNPJ: " + cpfCnpj, e);
            throw e;
        }
    }

    /**
     * Busca clientes por email
     * @param email Email do cliente (ou parte dele)
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByEmail(String email) {
        try {
            return clienteService.findByEmail(email);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por email: " + email, e);
            throw e;
        }
    }

    /**
     * Busca clientes por celular
     * @param celular Número de celular do cliente (ou parte dele)
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByCelular(String celular) {
        try {
            return clienteService.findByCelular(celular);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por celular: " + celular, e);
            throw e;
        }
    }

    /**
     * Busca clientes por endereço
     * @param endereco Texto a ser buscado no endereço
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByEndereco(String endereco) {
        try {
            return clienteService.findByEndereco(endereco);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por endereço: " + endereco, e);
            throw e;
        }
    }

    /**
     * Busca clientes por cidade
     * @param cidadeId ID da cidade
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByCidade(Long cidadeId) {
        try {
            return clienteService.findByCidade(cidadeId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por cidade: " + cidadeId, e);
            throw e;
        }
    }

    /**
     * Busca clientes por status
     * @param status Status do cliente
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByStatus(StatusGeral status) {
        try {
            return clienteService.findByStatus(status);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por status: " + status, e);
            throw e;
        }
    }

    /**
     * Busca clientes por intervalo de data de nascimento
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByDataNascimentoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return clienteService.findByDataNascimentoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por intervalo de data de nascimento", e);
            throw e;
        }
    }

    /**
     * Busca clientes por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return clienteService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca clientes por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos clientes encontrados
     */
    public List<ClienteDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return clienteService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar clientes por intervalo de data de alteração", e);
            throw e;
        }
    }
}
