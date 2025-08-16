package br.com.wbcars.controle;

import br.com.wbcars.dao.UsuarioDAO;
import javax.faces.bean.ManagedProperty;
import br.com.wbcars.modelo.Usuario;
import br.com.wbcars.util.CriptografiaUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.io.Serializable;

@Component("loginBean")
@Scope("session")
public class LoginBean implements Serializable {
    private String login;
    private String senha;

    @Autowired
    private UsuarioDAO usuarioDAO;

    public String entrar() {
        Usuario usuario = usuarioDAO.buscarPorLogin(login);
        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inexistente", null));
            return null;
        }
        String senhaCriptografada = CriptografiaUtil.sha256(senha);
        if (!senhaCriptografada.equals(usuario.getSenha())) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incorreta", null));
            return null;
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuario);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Getters e Setters
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
