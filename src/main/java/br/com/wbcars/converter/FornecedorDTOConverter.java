package br.com.wbcars.converter;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import br.com.wbcars.dto.FornecedorDTO;

@FacesConverter(value = "fornecedorDTOConverter")
public class FornecedorDTOConverter implements Converter<Object> {
    @SuppressWarnings("unchecked")
	@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) return null;
        java.util.List<FornecedorDTO> fornecedores = null;
        // Tenta identificar o bean pelo contexto do formulário
        String beanName = null;
        UIComponent parent = component;
        while (parent != null && beanName == null) {
            if (parent instanceof jakarta.faces.component.UIForm) {
                String formId = parent.getId();
                if (formId != null) {
                    if (formId.toLowerCase().contains("produto")) beanName = "produtosBean";
                    else if (formId.toLowerCase().contains("fornecedor")) beanName = "fornecedoresBean";
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
                java.lang.reflect.Method method = bean.getClass().getMethod("getListaFornecedores");
                fornecedores = (java.util.List<FornecedorDTO>) method.invoke(bean);
            } catch (Exception e) {}
        }
        if (fornecedores == null || fornecedores.isEmpty()) {
            String[] beans = {"produtosBean", "fornecedoresBean"};
            for (String b : beans) {
                try {
                    Object bean = context.getApplication().evaluateExpressionGet(context, "#{"+b+"}", Object.class);
                    java.lang.reflect.Method method = bean.getClass().getMethod("getListaFornecedores");
                    fornecedores = (java.util.List<FornecedorDTO>) method.invoke(bean);
                    if (fornecedores != null && !fornecedores.isEmpty()) break;
                } catch (Exception e) {}
            }
        }
        if (fornecedores != null) {
            return fornecedores.stream()
                .filter(f -> String.valueOf(f.getId()).equals(value))
                .findFirst().orElse(null);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";
        if (value instanceof FornecedorDTO fornecedor) {
            return String.valueOf(fornecedor.getId());
        }
        return value.toString();
    }
}
