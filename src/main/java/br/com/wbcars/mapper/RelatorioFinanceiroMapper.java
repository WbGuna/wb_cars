package br.com.wbcars.mapper;

import br.com.wbcars.dto.RelatorioFinanceiroDTO;
import br.com.wbcars.entity.RelatorioFinanceiro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RelatorioFinanceiroMapper {
    RelatorioFinanceiroMapper INSTANCE = Mappers.getMapper(RelatorioFinanceiroMapper.class);
    
    RelatorioFinanceiroDTO toDTO(RelatorioFinanceiro entity);
    
    RelatorioFinanceiro toEntity(RelatorioFinanceiroDTO dto);
}
