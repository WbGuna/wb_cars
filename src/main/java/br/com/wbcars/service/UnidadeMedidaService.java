package br.com.wbcars.service;

import br.com.wbcars.dao.UnidadeMedidaDAO;
import br.com.wbcars.dto.UnidadeMedidaDTO;
import br.com.wbcars.entity.UnidadeMedida;
import br.com.wbcars.enuns.TipoUnidadeMedida;
import br.com.wbcars.mapper.UnidadeMedidaMapper;
import java.time.LocalDateTime;
import java.util.List;

public class UnidadeMedidaService extends GenericService<UnidadeMedida, UnidadeMedidaDTO, Long> {
    private static UnidadeMedidaService instance;
    private final UnidadeMedidaDAO unidadeMedidaDAO = UnidadeMedidaDAO.getInstance();

    private UnidadeMedidaService() {}

    public static UnidadeMedidaService getInstance() {
        if (instance == null) {
            synchronized (UnidadeMedidaService.class) {
                if (instance == null) {
                    instance = new UnidadeMedidaService();
                }
            }
        }
        return instance;
    }

    @Override
    protected UnidadeMedidaDTO toDTO(UnidadeMedida entity) {
        return UnidadeMedidaMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected UnidadeMedida toEntity(UnidadeMedidaDTO dto) {
        return UnidadeMedidaMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public UnidadeMedidaDTO save(UnidadeMedidaDTO dto) {
        UnidadeMedida entity = toEntity(dto);
        unidadeMedidaDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public UnidadeMedidaDTO update(UnidadeMedidaDTO dto) {
        UnidadeMedida entity = toEntity(dto);
        unidadeMedidaDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        UnidadeMedida entity = unidadeMedidaDAO.findById(id);
        if (entity != null) {
            unidadeMedidaDAO.delete(entity);
        }
    }

    @Override
    public UnidadeMedidaDTO findById(Long id) {
        return toDTO(unidadeMedidaDAO.findById(id));
    }

    @Override
    public List<UnidadeMedidaDTO> findAll() {
        List<UnidadeMedida> entities = unidadeMedidaDAO.findAll();
        return toDTOList(entities);
    }

    public List<UnidadeMedidaDTO> findByNome(String nome) {
        List<UnidadeMedida> entities = unidadeMedidaDAO.findByNome(nome);
        return toDTOList(entities);
    }

    public UnidadeMedidaDTO findBySigla(String sigla) {
        return toDTO(unidadeMedidaDAO.findBySigla(sigla));
    }
    
    public List<UnidadeMedidaDTO> findByTipo(TipoUnidadeMedida tipo) {
        List<UnidadeMedida> entities = unidadeMedidaDAO.findByTipo(tipo);
        return toDTOList(entities);
    }

    @Override
    public List<UnidadeMedidaDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<UnidadeMedida> entities = unidadeMedidaDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<UnidadeMedidaDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<UnidadeMedida> entities = unidadeMedidaDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }
}
