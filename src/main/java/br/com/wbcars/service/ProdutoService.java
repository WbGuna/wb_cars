package br.com.wbcars.service;

import br.com.wbcars.dao.ProdutoDAO;
import br.com.wbcars.dto.ProdutoDTO;
import br.com.wbcars.entity.Produto;
import br.com.wbcars.mapper.ProdutoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoService extends GenericService<Produto, ProdutoDTO, Long> {
    private static ProdutoService instance;
    private final ProdutoDAO produtoDAO = ProdutoDAO.getInstance();

    private ProdutoService() {}

    public static ProdutoService getInstance() {
        if (instance == null) {
            synchronized (ProdutoService.class) {
                if (instance == null) {
                    instance = new ProdutoService();
                }
            }
        }
        return instance;
    }

    @Override
    protected ProdutoDTO toDTO(Produto entity) {
        return ProdutoMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Produto toEntity(ProdutoDTO dto) {
        return ProdutoMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public ProdutoDTO save(ProdutoDTO dto) {
        Produto entity = toEntity(dto);
        produtoDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public ProdutoDTO update(ProdutoDTO dto) {
        Produto entity = toEntity(dto);
        produtoDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Produto entity = produtoDAO.findById(id);
        if (entity != null) {
            produtoDAO.delete(entity);
        }
    }

    @Override
    public ProdutoDTO findById(Long id) {
        return toDTO(produtoDAO.findById(id));
    }

    @Override
    public List<ProdutoDTO> findAll() {
        return produtoDAO.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<ProdutoDTO> findByNome(String nome) {
        return produtoDAO.findAllByNome(nome).stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    public List<ProdutoDTO> findByFornecedor(Long fornecedorId) {
        return produtoDAO.findByFornecedor(fornecedorId).stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    public List<ProdutoDTO> findByUnidadeMedida(Long unidadeMedidaId) {
        return produtoDAO.findByUnidadeMedida(unidadeMedidaId).stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    @Override
    public List<ProdutoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        return produtoDAO.findByDataCadastroRange(inicio, fim).stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    @Override
    public List<ProdutoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        return produtoDAO.findByDataAlteracaoRange(inicio, fim).stream().map(this::toDTO).collect(Collectors.toList());
    }
}
