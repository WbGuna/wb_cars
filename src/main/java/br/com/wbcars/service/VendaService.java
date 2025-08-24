package br.com.wbcars.service;

import br.com.wbcars.dao.VendaDAO;
import br.com.wbcars.dto.VendaDTO;
import br.com.wbcars.entity.Venda;
import br.com.wbcars.mapper.VendaMapper;
import java.time.LocalDateTime;
import java.util.List;

public class VendaService extends GenericService<Venda, VendaDTO, Long> {
    private static VendaService instance;
    private final VendaDAO vendaDAO = VendaDAO.getInstance();

    private VendaService() {}

    public static VendaService getInstance() {
        if (instance == null) {
            synchronized (VendaService.class) {
                if (instance == null) {
                    instance = new VendaService();
                }
            }
        }
        return instance;
    }

    @Override
    protected VendaDTO toDTO(Venda entity) {
        return VendaMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Venda toEntity(VendaDTO dto) {
        return VendaMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public VendaDTO save(VendaDTO dto) {
        Venda entity = toEntity(dto);
        entity = vendaDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public VendaDTO update(VendaDTO dto) {
        Venda entity = toEntity(dto);
        entity = vendaDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Venda entity = vendaDAO.findById(id);
        if (entity != null) {
            vendaDAO.delete(entity);
        }
    }

    @Override
    public VendaDTO findById(Long id) {
        Venda entity = vendaDAO.findById(id);
        return entity != null ? toDTO(entity) : null;
    }

    @Override
    public List<VendaDTO> findAll() {
        List<Venda> entities = vendaDAO.findAll();
        return toDTOList(entities);
    }

    public List<VendaDTO> findByCliente(String nomeCliente) {
        List<Venda> entities = vendaDAO.findByCliente(nomeCliente);
        return toDTOList(entities);
    }

    public List<VendaDTO> findByDataVendaRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Venda> entities = vendaDAO.findByDataVendaRange(inicio, fim);
        return toDTOList(entities);
    }
    
    public List<VendaDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Venda> entities = vendaDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
}
