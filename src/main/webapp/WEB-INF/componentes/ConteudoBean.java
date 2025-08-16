package br.com.wbcars.componentes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component("conteudoBean")
@Scope("session")
public class ConteudoBean implements Serializable {
    private String pagina = "bemvindo.xhtml";

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public void navegar(String pagina) {
        this.pagina = pagina;
    }
}
