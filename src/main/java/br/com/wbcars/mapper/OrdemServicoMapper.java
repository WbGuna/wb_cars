package br.com.wbcars.mapper;

import br.com.wbcars.dto.OrdemServicoDTO;
import br.com.wbcars.entity.OrdemServico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrdemServicoMapper {
    OrdemServicoMapper INSTANCE = Mappers.getMapper(OrdemServicoMapper.class);

    @Mapping(target = "atendente", source = "atendente")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "pecas", source = "pecas")
    OrdemServicoDTO toDTO(OrdemServico entity);

    @Mapping(target = "atendente", source = "atendente")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "pecas", source = "pecas")
    OrdemServico toEntity(OrdemServicoDTO dto);
}
