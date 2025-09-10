package br.com.wbcars.mapper;

import br.com.wbcars.entity.Cliente;
import br.com.wbcars.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    
    ClienteDTO toDTO(Cliente entity);
    
    Cliente toEntity(ClienteDTO dto);
}