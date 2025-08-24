package br.com.wbcars.mapper;

import br.com.wbcars.entity.UnidadeMedida;
import br.com.wbcars.dto.UnidadeMedidaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UnidadeMedidaMapper {
	
    UnidadeMedidaMapper INSTANCE = Mappers.getMapper(UnidadeMedidaMapper.class);
    
    UnidadeMedidaDTO toDTO(UnidadeMedida entity);
    
    UnidadeMedida toEntity(UnidadeMedidaDTO dto);
}
