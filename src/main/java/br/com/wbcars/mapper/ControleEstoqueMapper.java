package br.com.wbcars.mapper;

import br.com.wbcars.entity.ControleEstoque;
import br.com.wbcars.dto.ControleEstoqueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProdutoMapper.class})
public interface ControleEstoqueMapper {
    
    ControleEstoqueMapper INSTANCE = Mappers.getMapper(ControleEstoqueMapper.class);    ControleEstoqueDTO toDTO(ControleEstoque entity);
    
    ControleEstoque toEntity(ControleEstoqueDTO dto);
}
