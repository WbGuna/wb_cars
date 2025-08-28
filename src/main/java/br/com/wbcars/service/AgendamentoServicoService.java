package br.com.wbcars.service;

import br.com.wbcars.dao.AgendamentoServicoDAO;
import br.com.wbcars.dto.AgendamentoServicoDTO;
import br.com.wbcars.entity.AgendamentoServico;
import br.com.wbcars.mapper.AgendamentoServicoMapper;
import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoServicoService extends GenericService<AgendamentoServico, AgendamentoServicoDTO, Long> {
    private static AgendamentoServicoService instance;
    private final AgendamentoServicoDAO agendamentoServicoDAO = AgendamentoServicoDAO.getInstance();

    private AgendamentoServicoService() {}

    public static AgendamentoServicoService getInstance() {
        if (instance == null) {
            synchronized (AgendamentoServicoService.class) {
                if (instance == null) {
                    instance = new AgendamentoServicoService();
                }
            }
        }
        return instance;
    }

    @Override
    protected AgendamentoServicoDTO toDTO(AgendamentoServico entity) {
        return AgendamentoServicoMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected AgendamentoServico toEntity(AgendamentoServicoDTO dto) {
        return AgendamentoServicoMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public AgendamentoServicoDTO save(AgendamentoServicoDTO dto) {
        AgendamentoServico entity = toEntity(dto);
        entity = agendamentoServicoDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public AgendamentoServicoDTO update(AgendamentoServicoDTO dto) {
        AgendamentoServico entity = toEntity(dto);
        entity = agendamentoServicoDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        AgendamentoServico entity = agendamentoServicoDAO.findById(id);
        if (entity != null) {
            agendamentoServicoDAO.delete(entity);
        }
    }

    @Override
    public AgendamentoServicoDTO findById(Long id) {
        AgendamentoServico entity = agendamentoServicoDAO.findById(id);
        return entity != null ? toDTO(entity) : null;
    }

    @Override
    public List<AgendamentoServicoDTO> findAll() {
        List<AgendamentoServico> entities = agendamentoServicoDAO.findAll();
        return toDTOList(entities);
    }

    public List<AgendamentoServicoDTO> findByCliente(String nomeCliente) {
        List<AgendamentoServico> entities = agendamentoServicoDAO.findByCliente(nomeCliente);
        return toDTOList(entities);
    }
    
    public List<AgendamentoServicoDTO> findByClienteId(Long clienteId) {
        List<AgendamentoServico> entities = agendamentoServicoDAO.findByClienteId(clienteId);
        return toDTOList(entities);
    }

    public List<AgendamentoServicoDTO> findByDataAgendadaRange(LocalDateTime inicio, LocalDateTime fim) {
        List<AgendamentoServico> entities = agendamentoServicoDAO.findByDataAgendadaRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<AgendamentoServicoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<AgendamentoServico> entities = agendamentoServicoDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
    
    @Override
    public List<AgendamentoServicoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<AgendamentoServico> entities = agendamentoServicoDAO.findByDataAlteracaoRange(inicio, fim);
        return toDTOList(entities);
    }
}
