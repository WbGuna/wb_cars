package br.com.wbcars.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericService<E, D, ID extends Serializable> {
    protected abstract D toDTO(E entity);
    protected abstract E toEntity(D dto);

    public abstract D save(D dto);
    public abstract D update(D dto);
    public abstract void delete(ID id);
    public abstract D findById(ID id);
    public abstract List<D> findAll();

    protected List<D> toDTOList(List<E> entities) {
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
