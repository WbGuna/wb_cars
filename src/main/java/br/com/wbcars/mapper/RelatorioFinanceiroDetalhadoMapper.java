package br.com.wbcars.mapper;

import br.com.wbcars.dto.RelatorioFinanceiroDetalhadoDTO;
import br.com.wbcars.entity.RelatorioFinanceiroDetalhado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RelatorioFinanceiroDetalhadoMapper {
    RelatorioFinanceiroDetalhadoMapper INSTANCE = Mappers.getMapper(RelatorioFinanceiroDetalhadoMapper.class);
    
    RelatorioFinanceiroDetalhadoDTO toDTO(RelatorioFinanceiroDetalhado entity);
    
    RelatorioFinanceiroDetalhado toEntity(RelatorioFinanceiroDetalhadoDTO dto);
}
