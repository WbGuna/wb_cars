package br.com.wbcars.mapper;

import br.com.wbcars.dto.OrcamentoDTO;
import br.com.wbcars.entity.Orcamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrcamentoMapper {
    OrcamentoMapper INSTANCE = Mappers.getMapper(OrcamentoMapper.class);
    
    OrcamentoDTO toDTO(Orcamento entity);
    
    Orcamento toEntity(OrcamentoDTO dto);
}
