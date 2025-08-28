package br.com.wbcars.service;

import br.com.wbcars.dao.RelatorioFinanceiroDAO;
import br.com.wbcars.dto.RelatorioFinanceiroDTO;
import br.com.wbcars.entity.RelatorioFinanceiro;
import br.com.wbcars.mapper.RelatorioFinanceiroMapper;
import java.time.LocalDateTime;
import java.util.List;

public class RelatorioFinanceiroService extends GenericService<RelatorioFinanceiro, RelatorioFinanceiroDTO, Long> {
    private static RelatorioFinanceiroService instance;
    private final RelatorioFinanceiroDAO relatorioFinanceiroDAO = RelatorioFinanceiroDAO.getInstance();

    private RelatorioFinanceiroService() {}

    public static RelatorioFinanceiroService getInstance() {
        if (instance == null) {
            synchronized (RelatorioFinanceiroService.class) {
                if (instance == null) {
                    instance = new RelatorioFinanceiroService();
                }
            }
        }
        return instance;
    }

    @Override
    protected RelatorioFinanceiroDTO toDTO(RelatorioFinanceiro entity) {
        return RelatorioFinanceiroMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected RelatorioFinanceiro toEntity(RelatorioFinanceiroDTO dto) {
        return RelatorioFinanceiroMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public RelatorioFinanceiroDTO save(RelatorioFinanceiroDTO dto) {
        RelatorioFinanceiro entity = toEntity(dto);
        entity = relatorioFinanceiroDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public RelatorioFinanceiroDTO update(RelatorioFinanceiroDTO dto) {
        RelatorioFinanceiro entity = toEntity(dto);
        entity = relatorioFinanceiroDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        RelatorioFinanceiro entity = relatorioFinanceiroDAO.findById(id);
        if (entity != null) {
            relatorioFinanceiroDAO.delete(entity);
        }
    }

    @Override
    public RelatorioFinanceiroDTO findById(Long id) {
        RelatorioFinanceiro entity = relatorioFinanceiroDAO.findById(id);
        return entity != null ? toDTO(entity) : null;
    }

    @Override
    public List<RelatorioFinanceiroDTO> findAll() {
        List<RelatorioFinanceiro> entities = relatorioFinanceiroDAO.findAll();
        return toDTOList(entities);
    }

    public List<RelatorioFinanceiroDTO> findByPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        List<RelatorioFinanceiro> entities = relatorioFinanceiroDAO.findByPeriodo(inicio, fim);
        return toDTOList(entities);
    }
    
    public List<RelatorioFinanceiroDTO> findByTotalVendasRange(Double minimo, Double maximo) {
        List<RelatorioFinanceiro> entities = relatorioFinanceiroDAO.findByTotalVendasRange(minimo, maximo);
        return toDTOList(entities);
    }
    
    public List<RelatorioFinanceiroDTO> findByTotalOrcamentosRange(Double minimo, Double maximo) {
        List<RelatorioFinanceiro> entities = relatorioFinanceiroDAO.findByTotalOrcamentosRange(minimo, maximo);
        return toDTOList(entities);
    }
    
    public List<RelatorioFinanceiroDTO> findByTotalGastosRange(Double minimo, Double maximo) {
        List<RelatorioFinanceiro> entities = relatorioFinanceiroDAO.findByTotalGastosRange(minimo, maximo);
        return toDTOList(entities);
    }
    
    @Override
    public List<RelatorioFinanceiroDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<RelatorioFinanceiro> entities = relatorioFinanceiroDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<RelatorioFinanceiroDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<RelatorioFinanceiro> entities = relatorioFinanceiroDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }
}
