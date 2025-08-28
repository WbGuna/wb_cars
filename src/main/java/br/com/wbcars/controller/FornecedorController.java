package br.com.wbcars.controller;

import br.com.wbcars.dto.FornecedorDTO;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoFornecimento;
import br.com.wbcars.service.FornecedorService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Fornecedores.
 * Implementa todos os métodos disponíveis no FornecedorService.
 */
public class FornecedorController {
    private static final Logger LOGGER = Logger.getLogger(FornecedorController.class.getName());
    private static FornecedorController instance;
    private final FornecedorService fornecedorService = FornecedorService.getInstance();

    private FornecedorController() {}

    public static FornecedorController getInstance() {
        if (instance == null) {
            synchronized (FornecedorController.class) {
                if (instance == null) {
                    instance = new FornecedorController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo fornecedor
     * @param dto DTO com dados do fornecedor
     * @return DTO do fornecedor salvo
     */
    public FornecedorDTO save(FornecedorDTO dto) {
        try {
            return fornecedorService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar fornecedor", e);
            throw e;
        }
    }

    /**
     * Atualiza um fornecedor existente
     * @param dto DTO com novos dados do fornecedor
     * @return DTO do fornecedor atualizado
     */
    public FornecedorDTO update(FornecedorDTO dto) {
        try {
            return fornecedorService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar fornecedor", e);
            throw e;
        }
    }

    /**
     * Exclui um fornecedor por ID
     * @param id ID do fornecedor
     */
    public void delete(Long id) {
        try {
            fornecedorService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir fornecedor", e);
            throw e;
        }
    }

    /**
     * Busca um fornecedor por ID
     * @param id ID do fornecedor
     * @return DTO do fornecedor encontrado
     */
    public FornecedorDTO findById(Long id) {
        try {
            return fornecedorService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedor por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os fornecedores
     * @return Lista de DTOs de todos os fornecedores
     */
    public List<FornecedorDTO> findAll() {
        try {
            return fornecedorService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os fornecedores", e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por nome
     * @param nome Nome do fornecedor (ou parte dele)
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByNome(String nome) {
        try {
            return fornecedorService.findByNome(nome);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por nome: " + nome, e);
            throw e;
        }
    }

    /**
     * Busca fornecedor por CPF/CNPJ
     * @param cpfCnpj CPF ou CNPJ do fornecedor
     * @return DTO do fornecedor encontrado
     */
    public FornecedorDTO findByCpfCnpj(String cpfCnpj) {
        try {
            return fornecedorService.findByCpfCnpj(cpfCnpj);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedor por CPF/CNPJ: " + cpfCnpj, e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por telefone
     * @param telefone Telefone do fornecedor (ou parte dele)
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByTelefone(String telefone) {
        try {
            return fornecedorService.findByTelefone(telefone);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por telefone: " + telefone, e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por email
     * @param email Email do fornecedor (ou parte dele)
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByEmail(String email) {
        try {
            return fornecedorService.findByEmail(email);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por email: " + email, e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por tipo de fornecimento
     * @param tipoFornecimento Tipo de fornecimento
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByTipoFornecimento(TipoFornecimento tipoFornecimento) {
        try {
            return fornecedorService.findByTipoFornecimento(tipoFornecimento);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por tipo de fornecimento: " + tipoFornecimento, e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por status
     * @param status Status do fornecedor
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByStatus(StatusGeral status) {
        try {
            return fornecedorService.findByStatus(status);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por status: " + status, e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por endereço
     * @param endereco Texto a ser buscado no endereço
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByEndereco(String endereco) {
        try {
            return fornecedorService.findByEndereco(endereco);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por endereço: " + endereco, e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por cidade
     * @param cidadeId ID da cidade
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByCidade(Long cidadeId) {
        try {
            return fornecedorService.findByCidade(cidadeId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por cidade: " + cidadeId, e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return fornecedorService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca fornecedores por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return fornecedorService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar fornecedores por intervalo de data de alteração", e);
            throw e;
        }
    }
}
