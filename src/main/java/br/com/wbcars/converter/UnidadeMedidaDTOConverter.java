package br.com.wbcars.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import br.com.wbcars.dto.UnidadeMedidaDTO;

@FacesConverter(value = "unidadeMedidaDTOConverter")
public class UnidadeMedidaDTOConverter implements Converter<Object> {
    @SuppressWarnings("unchecked")
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        java.util.List<UnidadeMedidaDTO> unidades = null;
        String beanName = null;
        UIComponent parent = component;
        while (parent != null && beanName == null) {
            if (parent instanceof jakarta.faces.component.UIForm) {
                String formId = parent.getId();
                if (formId != null) {
                    if (formId.toLowerCase().contains("produto")) beanName = "produtosBean";
                }
            }
            parent = parent.getParent();
        }
        if (beanName == null) {
            String elBean = component.getValueExpression("value") != null ? component.getValueExpression("value").getExpressionString() : null;
            if (elBean != null && elBean.contains("Bean")) {
                int ini = elBean.indexOf("{") + 2;
                int fim = elBean.indexOf("Bean");
                beanName = elBean.substring(ini, fim+4);
            }
        }
        if (beanName != null) {
            try {
                Object bean = context.getApplication().evaluateExpressionGet(context, "#{"+beanName+"}", Object.class);
                java.lang.reflect.Method method = bean.getClass().getMethod("getListaUnidades");
                unidades = (java.util.List<UnidadeMedidaDTO>) method.invoke(bean);
            } catch (Exception e) {}
        }
        if (unidades == null || unidades.isEmpty()) {
            String[] beans = {"produtosBean"};
            for (String b : beans) {
                try {
                    Object bean = context.getApplication().evaluateExpressionGet(context, "#{"+b+"}", Object.class);
                    java.lang.reflect.Method method = bean.getClass().getMethod("getListaUnidades");
                    unidades = (java.util.List<UnidadeMedidaDTO>) method.invoke(bean);
                    if (unidades != null && !unidades.isEmpty()) break;
                } catch (Exception e) {}
            }
        }
        if (unidades != null) {
            return unidades.stream()
                .filter(u -> String.valueOf(u.getId()).equals(value))
                .findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";
        if (value instanceof UnidadeMedidaDTO unidade) {
            return String.valueOf(unidade.getId());
        }
        return value.toString();
    }
}
