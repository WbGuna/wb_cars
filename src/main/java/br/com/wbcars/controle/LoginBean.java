// ...existing code...
package br.com.wbcars.controle;

import br.com.wbcars.dao.UsuarioDAO;
import javax.faces.bean.ManagedProperty;
import javax.servlet.http.HttpServletRequest;
import br.com.wbcars.modelo.Usuario;
import br.com.wbcars.util.CriptografiaUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

@Component("loginBean")
@Scope("session")
public class LoginBean implements Serializable {
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static final int MAX_TENTATIVAS = 5;
    private static final int BLOQUEIO_MINUTOS = 5;
    private int tentativas = 0;
    private LocalDateTime bloqueadoAte = null;
    private String login;
    private String senha;

    @Autowired
    private UsuarioDAO usuarioDAO;

    public String entrar() {
    String ip = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
    System.out.println("Tentativa de login: usuário=" + login + ", IP=" + ip);
        if (bloqueadoAte != null && LocalDateTime.now().isBefore(bloqueadoAte)) {
            System.out.println("Login BLOQUEADO para usuário=" + login + " até " + bloqueadoAte);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário bloqueado por tentativas inválidas. Tente novamente após " + BLOQUEIO_MINUTOS + " minutos.", null));
            return null;
        }
    // Proteção contra session fixation: invalida a sessão antes de logar
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        Usuario usuario = usuarioDAO.buscarPorLogin(login);
        if (usuario == null) {
            System.out.println("Login FALHOU: usuário inexistente=" + login);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inexistente", null));
            tentativas++;
            if (tentativas >= MAX_TENTATIVAS) {
                System.out.println("Usuário BLOQUEADO por tentativas inválidas: " + login);
                bloqueadoAte = LocalDateTime.now().plusMinutes(BLOQUEIO_MINUTOS);
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário bloqueado por tentativas inválidas. Tente novamente após " + BLOQUEIO_MINUTOS + " minutos.", null));
            }
            return null;
        }
        if (!CriptografiaUtil.verificarSenha(senha, usuario.getSenha())) {
            System.out.println("Login FALHOU: senha incorreta para usuário=" + login);
            tentativas++;
            if (tentativas >= MAX_TENTATIVAS) {
                bloqueadoAte = LocalDateTime.now().plusMinutes(BLOQUEIO_MINUTOS);
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário bloqueado por tentativas inválidas. Tente novamente após " + BLOQUEIO_MINUTOS + " minutos.", null));
                return null;
            }
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incorreta", null));
            return null;
        }
        // Login bem-sucedido: zera tentativas e bloqueio
    System.out.println("Login SUCESSO: usuário=" + login);
        tentativas = 0;
        bloqueadoAte = null;
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
