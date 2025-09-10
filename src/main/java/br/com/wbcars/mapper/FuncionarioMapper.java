package br.com.wbcars.mapper;

import br.com.wbcars.entity.Funcionario;
import br.com.wbcars.dto.FuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FuncionarioMapper {
    
    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);
    
    FuncionarioDTO toDTO(Funcionario entity);
    
    Funcionario toEntity(FuncionarioDTO dto);
}