package br.com.wbcars.service;

import br.com.wbcars.dao.FornecedorDAO;
import br.com.wbcars.dto.FornecedorDTO;
import br.com.wbcars.entity.Fornecedor;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoFornecimento;
import br.com.wbcars.mapper.FornecedorMapper;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Serviço para operações relacionadas a Fornecedores.
 * Implementa a conversão entre entidades e DTOs e delega as operações para a DAO.
 */
public class FornecedorService extends GenericService<Fornecedor, FornecedorDTO, Long> {
    private static FornecedorService instance;
    private final FornecedorDAO fornecedorDAO = FornecedorDAO.getInstance();

    private FornecedorService() {}

    public static FornecedorService getInstance() {
        if (instance == null) {
            synchronized (FornecedorService.class) {
                if (instance == null) {
                    instance = new FornecedorService();
                }
            }
        }
        return instance;
    }

    @Override
    protected FornecedorDTO toDTO(Fornecedor entity) {
        return FornecedorMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Fornecedor toEntity(FornecedorDTO dto) {
        return FornecedorMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public FornecedorDTO save(FornecedorDTO dto) {
        Fornecedor entity = toEntity(dto);
        fornecedorDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public FornecedorDTO update(FornecedorDTO dto) {
        Fornecedor entity = toEntity(dto);
        fornecedorDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Fornecedor entity = fornecedorDAO.findById(id);
        if (entity != null) {
            fornecedorDAO.delete(entity);
        }
    }

    @Override
    public FornecedorDTO findById(Long id) {
        return toDTO(fornecedorDAO.findById(id));
    }

    @Override
    public List<FornecedorDTO> findAll() {
        List<Fornecedor> entities = fornecedorDAO.findAll();
        return toDTOList(entities);
    }
    
    @Override
    public List<FornecedorDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Fornecedor> entities = fornecedorDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<FornecedorDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Fornecedor> entities = fornecedorDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }

    /**
     * Busca fornecedores por nome
     * @param nome Nome a ser buscado
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByNome(String nome) {
        List<Fornecedor> entities = fornecedorDAO.findByNome(nome);
        return toDTOList(entities);
    }

    /**
     * Busca fornecedor por CPF/CNPJ
     * @param cpfCnpj CPF ou CNPJ a ser buscado
     * @return DTO do fornecedor encontrado
     */
    public FornecedorDTO findByCpfCnpj(String cpfCnpj) {
        return toDTO(fornecedorDAO.findByCpfCnpj(cpfCnpj));
    }
    
    /**
     * Busca fornecedores por telefone
     * @param telefone Telefone a ser buscado
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByTelefone(String telefone) {
        List<Fornecedor> entities = fornecedorDAO.findByTelefone(telefone);
        return toDTOList(entities);
    }
    
    /**
     * Busca fornecedores por email
     * @param email Email a ser buscado
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByEmail(String email) {
        List<Fornecedor> entities = fornecedorDAO.findByEmail(email);
        return toDTOList(entities);
    }
    
    /**
     * Busca fornecedores por tipo de fornecimento
     * @param tipoFornecimento Tipo de fornecimento
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByTipoFornecimento(TipoFornecimento tipoFornecimento) {
        List<Fornecedor> entities = fornecedorDAO.findByTipoFornecimento(tipoFornecimento);
        return toDTOList(entities);
    }
    
    /**
     * Busca fornecedores por status
     * @param status Status do fornecedor
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByStatus(StatusGeral status) {
        List<Fornecedor> entities = fornecedorDAO.findByStatus(status);
        return toDTOList(entities);
    }
    
    /**
     * Busca fornecedores por endereço (rua ou bairro)
     * @param endereco Texto a ser buscado no endereço
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByEndereco(String endereco) {
        List<Fornecedor> entities = fornecedorDAO.findByEndereco(endereco);
        return toDTOList(entities);
    }
    
    /**
     * Busca fornecedores por cidade
     * @param cidadeId ID da cidade
     * @return Lista de DTOs dos fornecedores encontrados
     */
    public List<FornecedorDTO> findByCidade(Long cidadeId) {
        List<Fornecedor> entities = fornecedorDAO.findByCidade(cidadeId);
        return toDTOList(entities);
    }
}
