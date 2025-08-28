package br.com.wbcars.controller;

import br.com.wbcars.dto.FuncionarioDTO;
import br.com.wbcars.enuns.SetorFuncionario;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoUsuario;
import br.com.wbcars.service.FuncionarioService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller para operações relacionadas a Funcionários.
 * Implementa todos os métodos disponíveis no FuncionarioService.
 */
public class FuncionarioController {
    private static final Logger LOGGER = Logger.getLogger(FuncionarioController.class.getName());
    private static FuncionarioController instance;
    private final FuncionarioService funcionarioService = FuncionarioService.getInstance();

    private FuncionarioController() {}

    public static FuncionarioController getInstance() {
        if (instance == null) {
            synchronized (FuncionarioController.class) {
                if (instance == null) {
                    instance = new FuncionarioController();
                }
            }
        }
        return instance;
    }

    /**
     * Salva um novo funcionário
     * @param dto DTO com dados do funcionário
     * @return DTO do funcionário salvo
     */
    public FuncionarioDTO save(FuncionarioDTO dto) {
        try {
            return funcionarioService.save(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao salvar funcionário", e);
            throw e;
        }
    }

    /**
     * Atualiza um funcionário existente
     * @param dto DTO com novos dados do funcionário
     * @return DTO do funcionário atualizado
     */
    public FuncionarioDTO update(FuncionarioDTO dto) {
        try {
            return funcionarioService.update(dto);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar funcionário", e);
            throw e;
        }
    }

    /**
     * Exclui um funcionário por ID
     * @param id ID do funcionário
     */
    public void delete(Long id) {
        try {
            funcionarioService.delete(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao excluir funcionário", e);
            throw e;
        }
    }

    /**
     * Busca um funcionário por ID
     * @param id ID do funcionário
     * @return DTO do funcionário encontrado
     */
    public FuncionarioDTO findById(Long id) {
        try {
            return funcionarioService.findById(id);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por ID", e);
            throw e;
        }
    }

    /**
     * Busca todos os funcionários
     * @return Lista de DTOs de todos os funcionários
     */
    public List<FuncionarioDTO> findAll() {
        try {
            return funcionarioService.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar todos os funcionários", e);
            throw e;
        }
    }

    /**
     * Busca funcionários por nome
     * @param nome Nome do funcionário (ou parte dele)
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByNome(String nome) {
        try {
            return funcionarioService.findByNome(nome);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por nome: " + nome, e);
            throw e;
        }
    }

    /**
     * Busca funcionário por login
     * @param login Login do funcionário
     * @return DTO do funcionário encontrado
     */
    public FuncionarioDTO findByLogin(String login) {
        try {
            return funcionarioService.findByLogin(login);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por login: " + login, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por setor
     * @param setor Setor do funcionário
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findBySetor(SetorFuncionario setor) {
        try {
            return funcionarioService.findBySetor(setor);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por setor: " + setor, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por intervalo de data de registro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByDataRegistroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return funcionarioService.findByDataRegistroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por intervalo de data de registro", e);
            throw e;
        }
    }

    /**
     * Busca funcionários por função
     * @param funcao Função do funcionário
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByFuncao(String funcao) {
        try {
            return funcionarioService.findByFuncao(funcao);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por função: " + funcao, e);
            throw e;
        }
    }

    /**
     * Busca funcionário por CPF/CNPJ
     * @param cpfCnpj CPF ou CNPJ do funcionário
     * @return DTO do funcionário encontrado
     */
    public FuncionarioDTO findByCpfCnpj(String cpfCnpj) {
        try {
            return funcionarioService.findByCpfCnpj(cpfCnpj);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por CPF/CNPJ: " + cpfCnpj, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por telefone
     * @param telefone Telefone do funcionário (ou parte dele)
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByTelefone(String telefone) {
        try {
            return funcionarioService.findByTelefone(telefone);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por telefone: " + telefone, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por e-mail
     * @param email E-mail do funcionário (ou parte dele)
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByEmail(String email) {
        try {
            return funcionarioService.findByEmail(email);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por e-mail: " + email, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por endereço
     * @param endereco Endereço do funcionário (ou parte dele)
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByEndereco(String endereco) {
        try {
            return funcionarioService.findByEndereco(endereco);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por endereço: " + endereco, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por cidade
     * @param cidadeId ID da cidade
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByCidade(Long cidadeId) {
        try {
            return funcionarioService.findByCidade(cidadeId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por cidade: " + cidadeId, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por status
     * @param status Status do funcionário
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByStatus(StatusGeral status) {
        try {
            return funcionarioService.findByStatus(status);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por status: " + status, e);
            throw e;
        }
    }

    /**
     * Busca funcionários por perfil
     * @param perfil Perfil do funcionário
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByPerfil(TipoUsuario perfil) {
        try {
            return funcionarioService.findByPerfil(perfil);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por perfil: " + perfil, e);
            throw e;
        }
    }

    /**
     * Busca funcionário por login e senha
     * @param login Login do funcionário
     * @param senha Senha do funcionário
     * @return DTO do funcionário encontrado
     */
    public FuncionarioDTO findByLoginAndSenha(String login, String senha) {
        try {
            return funcionarioService.findByLoginAndSenha(login, senha);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionário por login e senha", e);
            throw e;
        }
    }

    /**
     * Busca funcionários por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return funcionarioService.findByDataCadastroRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por intervalo de data de cadastro", e);
            throw e;
        }
    }

    /**
     * Busca funcionários por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs dos funcionários encontrados
     */
    public List<FuncionarioDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        try {
            return funcionarioService.findByDataAlteracaoRange(inicio, fim);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar funcionários por intervalo de data de alteração", e);
            throw e;
        }
    }
}
