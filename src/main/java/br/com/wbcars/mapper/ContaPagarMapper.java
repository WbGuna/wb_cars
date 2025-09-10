package br.com.wbcars.mapper;

import br.com.wbcars.entity.ContaPagar;
import br.com.wbcars.dto.ContaPagarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContaPagarMapper {
    
    ContaPagarMapper INSTANCE = Mappers.getMapper(ContaPagarMapper.class);    ContaPagarDTO toDTO(ContaPagar entity);
    
    ContaPagar toEntity(ContaPagarDTO dto);
}
