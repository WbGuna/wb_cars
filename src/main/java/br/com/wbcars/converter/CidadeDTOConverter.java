package br.com.wbcars.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import br.com.wbcars.dto.CidadeDTO;
import br.com.wbcars.bean.ClientesBean;

@FacesConverter(value = "cidadeDTOConverter")
public class CidadeDTOConverter implements Converter<Object> {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        ClientesBean clientesBean = (ClientesBean) context.getApplication()
            .evaluateExpressionGet(context, "#{clientesBean}", ClientesBean.class);
        return clientesBean.getListaCidades().stream()
            .filter(c -> String.valueOf(c.getId()).equals(value))
            .findFirst().orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";
        if (value instanceof CidadeDTO cidade) {
            return String.valueOf(cidade.getId());
        }
        return value.toString();
    }
}