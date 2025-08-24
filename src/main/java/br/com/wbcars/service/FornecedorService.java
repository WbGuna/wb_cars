package br.com.wbcars.service;

import br.com.wbcars.dao.FornecedorDAO;
import br.com.wbcars.dto.FornecedorDTO;
import br.com.wbcars.entity.Fornecedor;
import br.com.wbcars.mapper.FornecedorMapper;
import java.time.LocalDateTime;
import java.util.List;

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

    public List<FornecedorDTO> findByNome(String nome) {
        List<Fornecedor> entities = fornecedorDAO.findByNome(nome);
        return toDTOList(entities);
    }

    public FornecedorDTO findByCpfCnpj(String cpfCnpj) {
        return toDTO(fornecedorDAO.findByCpfCnpj(cpfCnpj));
    }

    public List<FornecedorDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Fornecedor> entities = fornecedorDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
}
