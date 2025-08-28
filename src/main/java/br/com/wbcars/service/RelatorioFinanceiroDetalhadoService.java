package br.com.wbcars.service;

import br.com.wbcars.dao.RelatorioFinanceiroDetalhadoDAO;
import br.com.wbcars.dto.RelatorioFinanceiroDetalhadoDTO;
import br.com.wbcars.entity.RelatorioFinanceiroDetalhado;
import br.com.wbcars.mapper.RelatorioFinanceiroDetalhadoMapper;
import java.time.LocalDateTime;
import java.util.List;

public class RelatorioFinanceiroDetalhadoService extends GenericService<RelatorioFinanceiroDetalhado, RelatorioFinanceiroDetalhadoDTO, Long> {
    private static RelatorioFinanceiroDetalhadoService instance;
    private final RelatorioFinanceiroDetalhadoDAO relatorioFinanceiroDetalhadoDAO = RelatorioFinanceiroDetalhadoDAO.getInstance();

    private RelatorioFinanceiroDetalhadoService() {}

    public static RelatorioFinanceiroDetalhadoService getInstance() {
        if (instance == null) {
            synchronized (RelatorioFinanceiroDetalhadoService.class) {
                if (instance == null) {
                    instance = new RelatorioFinanceiroDetalhadoService();
                }
            }
        }
        return instance;
    }

    @Override
    protected RelatorioFinanceiroDetalhadoDTO toDTO(RelatorioFinanceiroDetalhado entity) {
        return RelatorioFinanceiroDetalhadoMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected RelatorioFinanceiroDetalhado toEntity(RelatorioFinanceiroDetalhadoDTO dto) {
        return RelatorioFinanceiroDetalhadoMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public RelatorioFinanceiroDetalhadoDTO save(RelatorioFinanceiroDetalhadoDTO dto) {
        RelatorioFinanceiroDetalhado entity = toEntity(dto);
        entity = relatorioFinanceiroDetalhadoDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public RelatorioFinanceiroDetalhadoDTO update(RelatorioFinanceiroDetalhadoDTO dto) {
        RelatorioFinanceiroDetalhado entity = toEntity(dto);
        entity = relatorioFinanceiroDetalhadoDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        RelatorioFinanceiroDetalhado entity = relatorioFinanceiroDetalhadoDAO.findById(id);
        if (entity != null) {
            relatorioFinanceiroDetalhadoDAO.delete(entity);
        }
    }

    @Override
    public RelatorioFinanceiroDetalhadoDTO findById(Long id) {
        RelatorioFinanceiroDetalhado entity = relatorioFinanceiroDetalhadoDAO.findById(id);
        return entity != null ? toDTO(entity) : null;
    }

    @Override
    public List<RelatorioFinanceiroDetalhadoDTO> findAll() {
        List<RelatorioFinanceiroDetalhado> entities = relatorioFinanceiroDetalhadoDAO.findAll();
        return toDTOList(entities);
    }

    public List<RelatorioFinanceiroDetalhadoDTO> findByValorTotalEntrada(Double valor) {
        List<RelatorioFinanceiroDetalhado> entities = relatorioFinanceiroDetalhadoDAO.findByValorTotalEntrada(valor);
        return toDTOList(entities);
    }
    
    public List<RelatorioFinanceiroDetalhadoDTO> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<RelatorioFinanceiroDetalhado> entities = relatorioFinanceiroDetalhadoDAO.findByPeriodo(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<RelatorioFinanceiroDetalhadoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<RelatorioFinanceiroDetalhado> entities = relatorioFinanceiroDetalhadoDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<RelatorioFinanceiroDetalhadoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<RelatorioFinanceiroDetalhado> entities = relatorioFinanceiroDetalhadoDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }
}
