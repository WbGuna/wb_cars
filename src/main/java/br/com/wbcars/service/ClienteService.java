package br.com.wbcars.service;

import br.com.wbcars.dao.ClienteDAO;
import br.com.wbcars.dto.ClienteDTO;
import br.com.wbcars.entity.Cliente;
import br.com.wbcars.mapper.ClienteMapper;
import java.time.LocalDateTime;
import java.util.List;

public class ClienteService extends GenericService<Cliente, ClienteDTO, Long> {
    private static ClienteService instance;
    private final ClienteDAO clienteDAO = ClienteDAO.getInstance();

    private ClienteService() {}

    public static ClienteService getInstance() {
        if (instance == null) {
            synchronized (ClienteService.class) {
                if (instance == null) {
                    instance = new ClienteService();
                }
            }
        }
        return instance;
    }

    @Override
    protected ClienteDTO toDTO(Cliente entity) {
        return ClienteMapper.INSTANCE.toDTO(entity);
    }

    @Override
    protected Cliente toEntity(ClienteDTO dto) {
        return ClienteMapper.INSTANCE.toEntity(dto);
    }

    @Override
    public ClienteDTO save(ClienteDTO dto) {
        Cliente entity = toEntity(dto);
        clienteDAO.save(entity);
        return toDTO(entity);
    }

    @Override
    public ClienteDTO update(ClienteDTO dto) {
        Cliente entity = toEntity(dto);
        clienteDAO.update(entity);
        return toDTO(entity);
    }

    @Override
    public void delete(Long id) {
        Cliente entity = clienteDAO.findById(id);
        if (entity != null) {
            clienteDAO.delete(entity);
        }
    }

    @Override
    public ClienteDTO findById(Long id) {
        Cliente entity = clienteDAO.findById(id);
        return toDTO(entity);
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<Cliente> entities = clienteDAO.findAll();
        return toDTOList(entities);
    }

    public List<ClienteDTO> findByNome(String nome) {
        List<Cliente> entities = clienteDAO.findAllByNome(nome);
        return toDTOList(entities);
    }

    public ClienteDTO findByCpfCnpj(String cpfCnpj) {
        Cliente entity = clienteDAO.findByCpfCnpj(cpfCnpj);
        return toDTO(entity);
    }

    public List<ClienteDTO> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim) {
        List<Cliente> entities = clienteDAO.findByDataCadastroRange(inicio, fim);
        return toDTOList(entities);
    }
}
