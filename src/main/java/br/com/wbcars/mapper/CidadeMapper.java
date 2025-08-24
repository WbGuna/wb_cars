package br.com.wbcars.mapper;

import br.com.wbcars.dto.CidadeDTO;
import br.com.wbcars.entity.Cidade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CidadeMapper {
    CidadeMapper INSTANCE = Mappers.getMapper(CidadeMapper.class);
    
    CidadeDTO toDTO(Cidade entity);
    
    Cidade toEntity(CidadeDTO dto);
}
