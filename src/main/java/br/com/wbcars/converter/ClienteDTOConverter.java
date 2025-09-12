package br.com.wbcars.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import br.com.wbcars.dto.ClienteDTO;
import br.com.wbcars.bean.VeiculosBean;

@FacesConverter(value = "clienteDTOConverter")
public class ClienteDTOConverter implements Converter<Object> {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        VeiculosBean veiculosBean = (VeiculosBean) context.getApplication()
            .evaluateExpressionGet(context, "#{veiculosBean}", VeiculosBean.class);
        return veiculosBean.getClientes().stream()
            .filter(c -> String.valueOf(c.getId()).equals(value))
            .findFirst().orElse(null);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";
        if (value instanceof ClienteDTO cliente) {
            return String.valueOf(cliente.getId());
        }
        return value.toString();
    }
}
