package br.com.wbcars.mapper;

import br.com.wbcars.entity.Fornecedor;
import br.com.wbcars.dto.FornecedorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FornecedorMapper {
	
    FornecedorMapper INSTANCE = Mappers.getMapper(FornecedorMapper.class);
    
    FornecedorDTO toDTO(Fornecedor entity);
    
    Fornecedor toEntity(FornecedorDTO dto);
}
