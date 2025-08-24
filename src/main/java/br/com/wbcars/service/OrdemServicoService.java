package br.com.wbcars.service;

import br.com.wbcars.dao.OrdemServicoDAO;
import br.com.wbcars.dto.OrdemServicoDTO;
import br.com.wbcars.entity.OrdemServico;
import br.com.wbcars.mapper.OrdemServicoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrdemServicoService extends GenericService<OrdemServico, OrdemServicoDTO, Long> {
    private static OrdemServicoService instance;
    private final OrdemServicoDAO ordemServicoDAO = OrdemServicoDAO.getInstance();

    private OrdemServicoService() {}

    public static OrdemServicoService getInstance() {
        if (instance == null) {
            synchronized (OrdemServicoService.class) {
                if (instance == null) {
                    instance = new OrdemServicoService();
                }
            }
        }
        return instance;
    }

    @Override
    protected OrdemServicoDTO toDTO(OrdemServico entity) {
        return OrdemServicoMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected OrdemServico toEntity(OrdemServicoDTO dto) {
        return OrdemServicoMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public OrdemServicoDTO save(OrdemServicoDTO dto) {
        OrdemServico entity = toEntity(dto);
        ordemServicoDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public OrdemServicoDTO update(OrdemServicoDTO dto) {
        OrdemServico entity = toEntity(dto);
        ordemServicoDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        OrdemServico entity = ordemServicoDAO.findById(id);
        if (entity != null) {
            ordemServicoDAO.delete(entity);
        }
    }

    @Override
    public OrdemServicoDTO findById(Long id) {
        return toDTO(ordemServicoDAO.findById(id));
    }

    @Override
    public List<OrdemServicoDTO> findAll() {
        return ordemServicoDAO.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<OrdemServicoDTO> findByNumero(String numero) {
        List<OrdemServico> entities = ordemServicoDAO.findByNumero(numero);
        return toDTOList(entities);
    }

    public List<OrdemServicoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<OrdemServico> entities = ordemServicoDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
}
