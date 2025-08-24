package br.com.wbcars.service;

import br.com.wbcars.dao.CidadeDAO;
import br.com.wbcars.dto.CidadeDTO;
import br.com.wbcars.entity.Cidade;
import br.com.wbcars.mapper.CidadeMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CidadeService extends GenericService<Cidade, CidadeDTO, Long> {
    private static CidadeService instance;
    private final CidadeDAO cidadeDAO = CidadeDAO.getInstance();

    private CidadeService() {}

    public static CidadeService getInstance() {
        if (instance == null) {
            synchronized (CidadeService.class) {
                if (instance == null) {
                    instance = new CidadeService();
                }
            }
        }
        return instance;
    }

    @Override
    protected CidadeDTO toDTO(Cidade entity) {
        return CidadeMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Cidade toEntity(CidadeDTO dto) {
        return CidadeMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public CidadeDTO save(CidadeDTO dto) {
        Cidade entity = toEntity(dto);
        cidadeDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public CidadeDTO update(CidadeDTO dto) {
        Cidade entity = toEntity(dto);
        cidadeDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Cidade entity = cidadeDAO.findById(id);
        if (entity != null) {
            cidadeDAO.delete(entity);
        }
    }

    @Override
    public CidadeDTO findById(Long id) {
        return toDTO(cidadeDAO.findById(id));
    }

    @Override
    public List<CidadeDTO> findAll() {
        return cidadeDAO.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<CidadeDTO> findByNome(String nome) {
        return cidadeDAO.findByNome(nome).stream().map(this::toDTO).collect(Collectors.toList());
    }
}
