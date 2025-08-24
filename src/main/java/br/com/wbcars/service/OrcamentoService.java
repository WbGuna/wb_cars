package br.com.wbcars.service;

import br.com.wbcars.dao.OrcamentoDAO;
import br.com.wbcars.dto.OrcamentoDTO;
import br.com.wbcars.entity.Orcamento;
import br.com.wbcars.mapper.OrcamentoMapper;
import java.time.LocalDateTime;
import java.util.List;

public class OrcamentoService extends GenericService<Orcamento, OrcamentoDTO, Long> {
    private static OrcamentoService instance;
    private final OrcamentoDAO orcamentoDAO = OrcamentoDAO.getInstance();

    private OrcamentoService() {}

    public static OrcamentoService getInstance() {
        if (instance == null) {
            synchronized (OrcamentoService.class) {
                if (instance == null) {
                    instance = new OrcamentoService();
                }
            }
        }
        return instance;
    }

    @Override
    protected OrcamentoDTO toDTO(Orcamento entity) {
        return OrcamentoMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Orcamento toEntity(OrcamentoDTO dto) {
        return OrcamentoMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public OrcamentoDTO save(OrcamentoDTO dto) {
        Orcamento entity = toEntity(dto);
        entity = orcamentoDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public OrcamentoDTO update(OrcamentoDTO dto) {
        Orcamento entity = toEntity(dto);
        entity = orcamentoDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Orcamento entity = orcamentoDAO.findById(id);
        if (entity != null) {
            orcamentoDAO.delete(entity);
        }
    }

    @Override
    public OrcamentoDTO findById(Long id) {
        Orcamento entity = orcamentoDAO.findById(id);
        return entity != null ? toDTO(entity) : null;
    }

    @Override
    public List<OrcamentoDTO> findAll() {
        List<Orcamento> entities = orcamentoDAO.findAll();
        return toDTOList(entities);
    }

    public List<OrcamentoDTO> findByCliente(String nomeCliente) {
        List<Orcamento> entities = orcamentoDAO.findByCliente(nomeCliente);
        return toDTOList(entities);
    }

    public List<OrcamentoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Orcamento> entities = orcamentoDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
}
