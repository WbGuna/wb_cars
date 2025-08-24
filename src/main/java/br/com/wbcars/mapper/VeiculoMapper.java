package br.com.wbcars.mapper;

import br.com.wbcars.entity.Veiculo;
import br.com.wbcars.dto.VeiculoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {
	
    VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);
    
    VeiculoDTO toDTO(Veiculo entity);
    
    Veiculo toEntity(VeiculoDTO dto);
}
