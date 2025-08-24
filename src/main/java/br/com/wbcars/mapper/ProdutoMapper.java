package br.com.wbcars.mapper;

import br.com.wbcars.entity.Produto;
import br.com.wbcars.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);
    
    ProdutoDTO toDTO(Produto entity);
    
    Produto toEntity(ProdutoDTO dto);
}
