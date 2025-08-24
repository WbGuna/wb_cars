package br.com.wbcars.service;

import br.com.wbcars.dao.ControleEstoqueDAO;
import br.com.wbcars.dto.ControleEstoqueDTO;
import br.com.wbcars.entity.ControleEstoque;
import br.com.wbcars.mapper.ControleEstoqueMapper;
import java.time.LocalDateTime;
import java.util.List;

public class ControleEstoqueService extends GenericService<ControleEstoque, ControleEstoqueDTO, Long> {
    private static ControleEstoqueService instance;
    private final ControleEstoqueDAO controleEstoqueDAO = ControleEstoqueDAO.getInstance();

    private ControleEstoqueService() {}

    public static ControleEstoqueService getInstance() {
        if (instance == null) {
            synchronized (ControleEstoqueService.class) {
                if (instance == null) {
                    instance = new ControleEstoqueService();
                }
            }
        }
        return instance;
    }

    @Override
    protected ControleEstoqueDTO toDTO(ControleEstoque entity) {
        return ControleEstoqueMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected ControleEstoque toEntity(ControleEstoqueDTO dto) {
        return ControleEstoqueMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public ControleEstoqueDTO save(ControleEstoqueDTO dto) {
        ControleEstoque entity = toEntity(dto);
        entity = controleEstoqueDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public ControleEstoqueDTO update(ControleEstoqueDTO dto) {
        ControleEstoque entity = toEntity(dto);
        entity = controleEstoqueDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        ControleEstoque entity = controleEstoqueDAO.findById(id);
        if (entity != null) {
            controleEstoqueDAO.delete(entity);
        }
    }

    @Override
    public ControleEstoqueDTO findById(Long id) {
        ControleEstoque entity = controleEstoqueDAO.findById(id);
        return entity != null ? toDTO(entity) : null;
    }

    @Override
    public List<ControleEstoqueDTO> findAll() {
        List<ControleEstoque> entities = controleEstoqueDAO.findAll();
        return toDTOList(entities);
    }

    public List<ControleEstoqueDTO> findByProduto(String nomeProduto) {
        List<ControleEstoque> entities = controleEstoqueDAO.findByProduto(nomeProduto);
        return toDTOList(entities);
    }

    public List<ControleEstoqueDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<ControleEstoque> entities = controleEstoqueDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
}
