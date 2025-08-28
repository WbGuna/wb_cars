package br.com.wbcars.service;

import br.com.wbcars.dao.VeiculoDAO;
import br.com.wbcars.dto.VeiculoDTO;
import br.com.wbcars.entity.Veiculo;
import br.com.wbcars.mapper.VeiculoMapper;
import java.time.LocalDateTime;
import java.util.List;

public class VeiculoService extends GenericService<Veiculo, VeiculoDTO, Long> {
    private static VeiculoService instance;
    private final VeiculoDAO veiculoDAO = VeiculoDAO.getInstance();

    private VeiculoService() {}

    public static VeiculoService getInstance() {
        if (instance == null) {
            synchronized (VeiculoService.class) {
                if (instance == null) {
                    instance = new VeiculoService();
                }
            }
        }
        return instance;
    }

    @Override
    protected VeiculoDTO toDTO(Veiculo entity) {
        return VeiculoMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Veiculo toEntity(VeiculoDTO dto) {
        return VeiculoMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public VeiculoDTO save(VeiculoDTO dto) {
        Veiculo entity = toEntity(dto);
        veiculoDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public VeiculoDTO update(VeiculoDTO dto) {
        Veiculo entity = toEntity(dto);
        veiculoDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Veiculo entity = veiculoDAO.findById(id);
        if (entity != null) {
            veiculoDAO.delete(entity);
        }
    }

    @Override
    public VeiculoDTO findById(Long id) {
        return toDTO(veiculoDAO.findById(id));
    }

    @Override
    public List<VeiculoDTO> findAll() {
        List<Veiculo> entities = veiculoDAO.findAll();
        return toDTOList(entities);
    }

    public List<VeiculoDTO> findByPlaca(String placa) {
        List<Veiculo> entities = veiculoDAO.findByPlaca(placa);
        return toDTOList(entities);
    }

    public List<VeiculoDTO> findByModelo(String modelo) {
        List<Veiculo> entities = veiculoDAO.findByModelo(modelo);
        return toDTOList(entities);
    }
    
    public List<VeiculoDTO> findByMarca(String marca) {
        List<Veiculo> entities = veiculoDAO.findByMarca(marca);
        return toDTOList(entities);
    }
    
    public List<VeiculoDTO> findByKilometragemRange(Integer minKm, Integer maxKm) {
        List<Veiculo> entities = veiculoDAO.findByKilometragemRange(minKm, maxKm);
        return toDTOList(entities);
    }
    
    public List<VeiculoDTO> findByCliente(Long clienteId) {
        List<Veiculo> entities = veiculoDAO.findByCliente(clienteId);
        return toDTOList(entities);
    }
    
    public List<VeiculoDTO> findByObservacao(String observacao) {
        List<Veiculo> entities = veiculoDAO.findByObservacao(observacao);
        return toDTOList(entities);
    }

    @Override
    public List<VeiculoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Veiculo> entities = veiculoDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<VeiculoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Veiculo> entities = veiculoDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }
}
