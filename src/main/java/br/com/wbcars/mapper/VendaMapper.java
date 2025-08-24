package br.com.wbcars.mapper;

import br.com.wbcars.dto.VendaDTO;
import br.com.wbcars.entity.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendaMapper {
    VendaMapper INSTANCE = Mappers.getMapper(VendaMapper.class);
    
    VendaDTO toDTO(Venda entity);
    
    Venda toEntity(VendaDTO dto);
}
