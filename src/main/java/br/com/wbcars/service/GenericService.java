package br.com.wbcars.service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;

/**
 * Serviço genérico que fornece operações básicas para todos os serviços específicos.
 * @param <E> Tipo da entidade
 * @param <D> Tipo do DTO
 * @param <ID> Tipo do identificador (normalmente Long)
 */
public abstract class GenericService<E, D, ID extends Serializable> {
    @SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(GenericService.class.getName());
    
    /**
     * Converte uma entidade para DTO
     * @param entity Entidade a ser convertida
     * @return DTO correspondente
     */
    protected abstract D toDTO(E entity);
    
    /**
     * Converte um DTO para entidade
     * @param dto DTO a ser convertido
     * @return Entidade correspondente
     */
    protected abstract E toEntity(D dto);
    
    /**
     * Salva uma entidade a partir de um DTO
     * @param dto DTO com os dados da entidade
     * @return DTO da entidade salva
     */
    public abstract D save(D dto);
    
    /**
     * Atualiza uma entidade a partir de um DTO
     * @param dto DTO com os novos dados
     * @return DTO da entidade atualizada
     */
    public abstract D update(D dto);
    
    /**
     * Exclui uma entidade por ID
     * @param id ID da entidade a ser excluída
     */
    public abstract void delete(ID id);
    
    /**
     * Busca uma entidade por ID
     * @param id ID da entidade
     * @return DTO da entidade encontrada
     */
    public abstract D findById(ID id);
    
    /**
     * Busca todas as entidades
     * @return Lista de DTOs de todas as entidades
     */
    public abstract List<D> findAll();
    
    /**
     * Busca entidades por intervalo de data de cadastro
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das entidades encontradas
     */
    public abstract List<D> findByDataCadastroRange(LocalDateTime inicio, LocalDateTime fim);
    
    /**
     * Busca entidades por intervalo de data de alteração
     * @param inicio Data inicial
     * @param fim Data final
     * @return Lista de DTOs das entidades encontradas
     */
    public abstract List<D> findByDataAlteracaoRange(LocalDateTime inicio, LocalDateTime fim);
    
    /**
     * Converte uma lista de entidades para lista de DTOs
     * @param entities Lista de entidades
     * @return Lista de DTOs
     */
    protected List<D> toDTOList(List<E> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
