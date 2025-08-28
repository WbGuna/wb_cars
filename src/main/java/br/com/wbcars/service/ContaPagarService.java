package br.com.wbcars.service;

import br.com.wbcars.dao.ContaPagarDAO;
import br.com.wbcars.dto.ContaPagarDTO;
import br.com.wbcars.entity.ContaPagar;
import br.com.wbcars.enuns.StatusGeral;
import br.com.wbcars.enuns.TipoContaPagar;
import br.com.wbcars.mapper.ContaPagarMapper;
import java.time.LocalDateTime;
import java.util.List;

public class ContaPagarService extends GenericService<ContaPagar, ContaPagarDTO, Long> {
    private static ContaPagarService instance;
    private final ContaPagarDAO contaPagarDAO = ContaPagarDAO.getInstance();

    private ContaPagarService() {}

    public static ContaPagarService getInstance() {
        if (instance == null) {
            synchronized (ContaPagarService.class) {
                if (instance == null) {
                    instance = new ContaPagarService();
                }
            }
        }
        return instance;
    }

    @Override
    protected ContaPagarDTO toDTO(ContaPagar entity) {
        return ContaPagarMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected ContaPagar toEntity(ContaPagarDTO dto) {
        return ContaPagarMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public ContaPagarDTO save(ContaPagarDTO dto) {
        ContaPagar entity = toEntity(dto);
        entity = contaPagarDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public ContaPagarDTO update(ContaPagarDTO dto) {
        ContaPagar entity = toEntity(dto);
        entity = contaPagarDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        ContaPagar entity = contaPagarDAO.findById(id);
        if (entity != null) {
            contaPagarDAO.delete(entity);
        }
    }

    @Override
    public ContaPagarDTO findById(Long id) {
        ContaPagar entity = contaPagarDAO.findById(id);
        return entity != null ? toDTO(entity) : null;
    }

    @Override
    public List<ContaPagarDTO> findAll() {
        List<ContaPagar> entities = contaPagarDAO.findAll();
        return toDTOList(entities);
    }

    public List<ContaPagarDTO> findByFornecedor(String nomeFornecedor) {
        List<ContaPagar> entities = contaPagarDAO.findByFornecedor(nomeFornecedor);
        return toDTOList(entities);
    }

    public List<ContaPagarDTO> findByDataVencimentoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<ContaPagar> entities = contaPagarDAO.findByDataVencimentoRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<ContaPagarDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<ContaPagar> entities = contaPagarDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<ContaPagarDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<ContaPagar> entities = contaPagarDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }
    
    public List<ContaPagarDTO> findByTipo(TipoContaPagar tipo) {
        List<ContaPagar> entities = contaPagarDAO.findByTipo(tipo);
        return toDTOList(entities);
    }
    
    public List<ContaPagarDTO> findByPrazoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<ContaPagar> entities = contaPagarDAO.findByPrazoRange(inicio, fim);
        return toDTOList(entities);
    }
    
    public List<ContaPagarDTO> findByStatus(StatusGeral status) {
        List<ContaPagar> entities = contaPagarDAO.findByStatus(status);
        return toDTOList(entities);
    }
    
    public List<ContaPagarDTO> findByValorRange(Double valorMinimo, Double valorMaximo) {
        List<ContaPagar> entities = contaPagarDAO.findByValorRange(valorMinimo, valorMaximo);
        return toDTOList(entities);
    }
}
