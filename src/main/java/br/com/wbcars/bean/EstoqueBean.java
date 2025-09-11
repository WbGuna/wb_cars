package br.com.wbcars.bean;

import java.io.Serializable;
import java.util.logging.Logger;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean responsável pela página de Estoque
 */
@Named
@ViewScoped
public class EstoqueBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(EstoqueBean.class.getName());
    
    @Inject
    private HeaderBean headerBean;
    
    /**
     * Inicialização da página
     */
    public void init() {
        LOGGER.info("Inicializando página de Estoque");
    }
    
    // Getter para acessar HeaderBean na página
    public HeaderBean getHeaderBean() {
        return headerBean;
    }
}
