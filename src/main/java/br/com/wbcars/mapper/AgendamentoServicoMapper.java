package br.com.wbcars.mapper;

import br.com.wbcars.entity.AgendamentoServico;
import br.com.wbcars.dto.AgendamentoServicoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ClienteMapper.class})
public interface AgendamentoServicoMapper {
    
    AgendamentoServicoMapper INSTANCE = Mappers.getMapper(AgendamentoServicoMapper.class);    AgendamentoServicoDTO toDTO(AgendamentoServico entity);
    
    AgendamentoServico toEntity(AgendamentoServicoDTO dto);
}
