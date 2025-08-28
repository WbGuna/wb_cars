package br.com.wbcars.service;

import br.com.wbcars.dao.OrdemServicoDAO;
import br.com.wbcars.dto.OrdemServicoDTO;
import br.com.wbcars.entity.OrdemServico;
import br.com.wbcars.mapper.OrdemServicoMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço para operações relacionadas a Ordens de Serviço.
 * Implementa a conversão entre entidades e DTOs e delega as operações para a DAO.
 */
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
    
    /**
     * Busca ordens de serviço por atendente
     * @param atendenteId ID do funcionário atendente
     * @return Lista de DTOs de ordens de serviço do atendente
     */
    public List<OrdemServicoDTO> findByAtendente(Long atendenteId) {
        List<OrdemServico> entities = ordemServicoDAO.findByAtendente(atendenteId);
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    /**
     * Busca ordens de serviço por cliente
     * @param clienteId ID do cliente
     * @return Lista de DTOs de ordens de serviço do cliente
     */
    public List<OrdemServicoDTO> findByCliente(Long clienteId) {
        List<OrdemServico> entities = ordemServicoDAO.findByCliente(clienteId);
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    /**
     * Busca ordens de serviço por descrição
     * @param descricao Texto a ser buscado na descrição
     * @return Lista de DTOs de ordens de serviço que contêm o texto na descrição
     */
    public List<OrdemServicoDTO> findByDescricao(String descricao) {
        List<OrdemServico> entities = ordemServicoDAO.findByDescricao(descricao);
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    /**
     * Busca ordens de serviço por faixa de valor
     * @param valorMinimo Valor mínimo
     * @param valorMaximo Valor máximo
     * @return Lista de DTOs de ordens de serviço com valores dentro da faixa
     */
    public List<OrdemServicoDTO> findByValorRange(Double valorMinimo, Double valorMaximo) {
        List<OrdemServico> entities = ordemServicoDAO.findByValorRange(valorMinimo, valorMaximo);
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    /**
     * Busca ordens de serviço que contenham uma determinada peça do controle de estoque
     * @param pecaId ID da peça no controle de estoque
     * @return Lista de DTOs de ordens de serviço que contêm a peça
     */
    public List<OrdemServicoDTO> findByPeca(Long pecaId) {
        List<OrdemServico> entities = ordemServicoDAO.findByPeca(pecaId);
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    /**
     * Busca ordens de serviço por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs de ordens de serviço cadastradas no período
     */
    @Override
    public List<OrdemServicoDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<OrdemServico> entities = ordemServicoDAO.findByDataCadastroRange(inicio, fim);
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
    
    /**
     * Busca ordens de serviço por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs de ordens de serviço alteradas no período
     */
    @Override
    public List<OrdemServicoDTO> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim) {
        List<OrdemServico> entities = ordemServicoDAO.findByDataAlteracaoRange(inicio, fim);
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
