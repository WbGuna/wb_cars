package br.com.wbcars.mapper;

import br.com.wbcars.entity.UnidadeMedida;
import br.com.wbcars.dto.UnidadeMedidaDTO;
import br.com.wbcars.utils.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.time.LocalDateTime;

@Mapper
public interface UnidadeMedidaMapper {
    
    UnidadeMedidaMapper INSTANCE = Mappers.getMapper(UnidadeMedidaMapper.class);
    
    @Mapping(target = "dataCadastroFormatada", expression = "java(formatarData(entity.getDataCadastro()))")
    @Mapping(target = "dataAlteracaoFormatada", expression = "java(formatarData(entity.getDataAlteracao()))")
    UnidadeMedidaDTO toDTO(UnidadeMedida entity);
    
    UnidadeMedida toEntity(UnidadeMedidaDTO dto);
    
    default String formatarData(LocalDateTime data) {
        return DateUtil.formatarDataHora(data);
    }
}