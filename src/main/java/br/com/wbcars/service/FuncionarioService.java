package br.com.wbcars.service;

import br.com.wbcars.dao.FuncionarioDAO;
import br.com.wbcars.dto.FuncionarioDTO;
import br.com.wbcars.entity.Funcionario;
import br.com.wbcars.enuns.SetorFuncionario;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoUsuario;
import br.com.wbcars.mapper.FuncionarioMapper;
import java.time.LocalDateTime;
import java.util.List;

public class FuncionarioService extends GenericService<Funcionario, FuncionarioDTO, Long> {
    private static FuncionarioService instance;
    private final FuncionarioDAO funcionarioDAO = FuncionarioDAO.getInstance();

    private FuncionarioService() {}

    public static FuncionarioService getInstance() {
        if (instance == null) {
            synchronized (FuncionarioService.class) {
                if (instance == null) {
                    instance = new FuncionarioService();
                }
            }
        }
        return instance;
    }

    @Override
    protected FuncionarioDTO toDTO(Funcionario entity) {
        return FuncionarioMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Funcionario toEntity(FuncionarioDTO dto) {
        return FuncionarioMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public FuncionarioDTO save(FuncionarioDTO dto) {
        Funcionario entity = toEntity(dto);
        funcionarioDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public FuncionarioDTO update(FuncionarioDTO dto) {
        Funcionario entity = toEntity(dto);
        funcionarioDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Funcionario entity = funcionarioDAO.findById(id);
        if (entity != null) {
            funcionarioDAO.delete(entity);
        }
    }

    @Override
    public FuncionarioDTO findById(Long id) {
        return toDTO(funcionarioDAO.findById(id));
    }

    @Override
    public List<FuncionarioDTO> findAll() {
        List<Funcionario> entities = funcionarioDAO.findAll();
        return toDTOList(entities);
    }

    public List<FuncionarioDTO> findByNome(String nome) {
        List<Funcionario> entities = funcionarioDAO.findByNome(nome);
        return toDTOList(entities);
    }

    public FuncionarioDTO findByLogin(String login) {
        return toDTO(funcionarioDAO.findByLogin(login));
    }

    @Override
    public List<FuncionarioDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Funcionario> entities = funcionarioDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<FuncionarioDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Funcionario> entities = funcionarioDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findBySetor(SetorFuncionario setor) {
        List<Funcionario> entities = funcionarioDAO.findBySetor(setor);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findByDataRegistroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Funcionario> entities = funcionarioDAO.findByDataRegistroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findByFuncao(String funcao) {
        List<Funcionario> entities = funcionarioDAO.findByFuncao(funcao);
        return toDTOList(entities);
    }
    
    public FuncionarioDTO findByCpfCnpj(String cpfCnpj) {
        return toDTO(funcionarioDAO.findByCpfCnpj(cpfCnpj));
    }
    
    public List<FuncionarioDTO> findByTelefone(String telefone) {
        List<Funcionario> entities = funcionarioDAO.findByTelefone(telefone);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findByEmail(String email) {
        List<Funcionario> entities = funcionarioDAO.findByEmail(email);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findByEndereco(String endereco) {
        List<Funcionario> entities = funcionarioDAO.findByEndereco(endereco);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findByCidade(Long cidadeId) {
        List<Funcionario> entities = funcionarioDAO.findByCidade(cidadeId);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findByStatus(StatusGeral status) {
        List<Funcionario> entities = funcionarioDAO.findByStatus(status);
        return toDTOList(entities);
    }
    
    public List<FuncionarioDTO> findByPerfil(TipoUsuario perfil) {
        List<Funcionario> entities = funcionarioDAO.findByPerfil(perfil);
        return toDTOList(entities);
    }
    
    public FuncionarioDTO findByLoginAndSenha(String login, String senha) {
        return toDTO(funcionarioDAO.findByLoginAndSenha(login, senha));
    }
}
