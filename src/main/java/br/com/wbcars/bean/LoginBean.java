package br.com.wbcars.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.wbcars.dto.FuncionarioDTO;
import br.com.wbcars.facade.WBCarsFacade;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Bean responsável pelo controle de autenticação do sistema WB Cars
 */
@Named
@SessionScoped
public class LoginBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());
    
    @Inject
    private WBCarsFacade facade;
    
    // Propriedades do formulário
    private String username;
    private String password;
    
    // Controle de sessão
    private FuncionarioDTO funcionarioLogado;
    private boolean logado = false;
    
    /**
     * Método de inicialização chamado ao carregar a página
     */
    public void init() {
        LOGGER.info("Inicializando página de login");
        
        // Verifica se já está logado e redireciona
        if (logado && funcionarioLogado != null) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("dashboard.xhtml");
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Erro ao redirecionar usuário já logado", e);
            }
        }
    }
    
    /**
     * Método principal de autenticação
     */
    public String login() {
        LOGGER.info("Tentativa de login para usuário: " + username);
        
        try {
            // Valida campos obrigatórios
            if (username == null || username.trim().isEmpty()) {
                adicionarMensagemErro("Usuário é obrigatório");
                return null;
            }
            
            if (password == null || password.trim().isEmpty()) {
                adicionarMensagemErro("Senha é obrigatória");
                return null;
            }
            
            // Chama o facade para autenticação
            FuncionarioDTO funcionario = facade.findFuncionarioByLoginAndSenha(username.trim(), password);
            
            if (funcionario != null) {
                // Login bem-sucedido
                funcionarioLogado = funcionario;
                logado = true;
                
                LOGGER.info("Login realizado com sucesso para: " + funcionario.getNome());
                
                adicionarMensagemSucesso("Bem-vindo, " + funcionario.getNome() + "!");
                
                // Limpa os campos do formulário
                limparCampos();
                
                // Redireciona para o dashboard
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("dashboard.xhtml");
                    return null;
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, "Erro ao redirecionar para dashboard", e);
                    return "dashboard?faces-redirect=true";
                }
                
            } else {
                // Login falhou
                LOGGER.warning("Tentativa de login falhada para usuário: " + username);
                adicionarMensagemErro("Usuário ou senha inválidos");
                
                // Limpa apenas a senha por segurança
                password = null;
                
                return null;
            }
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro durante processo de login", e);
            adicionarMensagemErro("Erro interno do sistema. Tente novamente em alguns instantes.");
            
            // Limpa os campos por segurança
            limparCampos();
            
            return null;
        }
    }
    
    /**
     * Método para fazer logout
     */
    public String logout() {
        LOGGER.info("Fazendo logout do usuário: " + (funcionarioLogado != null ? funcionarioLogado.getNome() : "desconhecido"));
        
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            
            // Limpa as informações da sessão ANTES de invalidar
            funcionarioLogado = null;
            logado = false;
            limparCampos();
            
            // Invalida a sessão completamente
            context.getExternalContext().invalidateSession();
            
            // Força headers para evitar cache
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            
            // Força redirecionamento imediato para nova sessão
            String contextPath = context.getExternalContext().getRequestContextPath();
            context.getExternalContext().redirect(contextPath + "/index.xhtml");
            context.responseComplete();
            
            LOGGER.info("Logout executado com sucesso - redirecionamento forçado");
            
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao redirecionar após logout", e);
            return "index?faces-redirect=true";
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Erro durante logout", e);
            return "index?faces-redirect=true";
        }
        
        return null; // Não retorna string pois já fez redirect
    }
    
    /**
     * Verifica se o usuário está logado
     */
    public boolean isLogado() {
        return logado && funcionarioLogado != null;
    }
    
    /**
     * Método para verificar login nas páginas protegidas
     * Se não estiver logado, redireciona para a página de login
     */
    public void verificarLogin() {
        try {
            if (!isLogado()) {
                LOGGER.warning("Acesso negado - usuário não autenticado");
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erro durante verificação de login", e);
        }
    }
    
    /**
     * Retorna o nome do funcionário logado
     */
    public String getNomeFuncionario() {
        return funcionarioLogado != null ? funcionarioLogado.getNome() : "Usuário não identificado";
    }
    
    /**
     * Retorna o perfil do funcionário logado
     */
    public String getPerfilFuncionario() {
        return funcionarioLogado != null && funcionarioLogado.getPerfil() != null 
            ? funcionarioLogado.getPerfil().getDescricao() 
            : "Perfil não definido";
    }
    
    /**
     * Adiciona mensagem de erro
     */
    private void adicionarMensagemErro(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", mensagem));
    }
    
    /**
     * Adiciona mensagem de sucesso
     */
    private void adicionarMensagemSucesso(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem));
    }
    
    /**
     * Adiciona mensagem informativa
     */
    private void adicionarMensagemInfo(String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", mensagem));
    }
    
    /**
     * Limpa os campos do formulário
     */
    private void limparCampos() {
        username = null;
        password = null;
    }
    
    // Getters e Setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public FuncionarioDTO getFuncionarioLogado() {
        return funcionarioLogado;
    }
    
    public void setFuncionarioLogado(FuncionarioDTO funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
    
    public WBCarsFacade getFacade() {
        return facade;
    }
    
    public void setFacade(WBCarsFacade facade) {
        this.facade = facade;
    }
}
