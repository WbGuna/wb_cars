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
        java.util.List<CidadeDTO> cidades = null;
        // Tenta identificar o bean pelo contexto do formulário
        String beanName = null;
        UIComponent parent = component;
        while (parent != null && beanName == null) {
            if (parent instanceof jakarta.faces.component.UIForm) {
                String formId = parent.getId();
                // Exemplo: formDados -> fornecedoresBean, clientesBean, etc
                if (formId != null) {
                    if (formId.toLowerCase().contains("fornecedor")) beanName = "fornecedoresBean";
                    else if (formId.toLowerCase().contains("cliente")) beanName = "clientesBean";
                    else if (formId.toLowerCase().contains("veiculo")) beanName = "veiculosBean";
                    // Adicione outros beans conforme necessário
                }
            }
            parent = parent.getParent();
        }
        // Se não encontrou pelo id do formulário, tenta pelo contexto do componente
        if (beanName == null) {
            // Tenta buscar pelo nome do bean no EL
            String elBean = component.getValueExpression("value") != null ? component.getValueExpression("value").getExpressionString() : null;
            if (elBean != null && elBean.contains("Bean")) {
                int ini = elBean.indexOf("{") + 2;
                int fim = elBean.indexOf("Bean");
                beanName = elBean.substring(ini, fim+4);
            }
        }
        // Tenta buscar o bean e o método getListaCidades
        if (beanName != null) {
            try {
                Object bean = context.getApplication().evaluateExpressionGet(context, "#{"+beanName+"}", Object.class);
                java.lang.reflect.Method method = bean.getClass().getMethod("getListaCidades");
                cidades = (java.util.List<CidadeDTO>) method.invoke(bean);
            } catch (Exception e) {
                // Ignora e tenta outros beans
            }
        }
        // Se não encontrou, tenta os beans mais comuns
        if (cidades == null || cidades.isEmpty()) {
            String[] beans = {"fornecedoresBean", "clientesBean", "veiculosBean"};
            for (String b : beans) {
                try {
                    Object bean = context.getApplication().evaluateExpressionGet(context, "#{"+b+"}", Object.class);
                    java.lang.reflect.Method method = bean.getClass().getMethod("getListaCidades");
                    cidades = (java.util.List<CidadeDTO>) method.invoke(bean);
                    if (cidades != null && !cidades.isEmpty()) break;
                } catch (Exception e) {
                    // Ignora
                }
            }
        }
        if (cidades != null) {
            return cidades.stream()
                .filter(c -> String.valueOf(c.getId()).equals(value))
                .findFirst().orElse(null);
        }
        return null;
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